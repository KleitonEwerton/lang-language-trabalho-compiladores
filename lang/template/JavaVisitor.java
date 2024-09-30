/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.template;

import lang.ast.*;
import lang.visitors.*;
import lang.semantic.*;
import lang.semantic.types.*;
import java.util.*;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class JavaVisitor extends Visitor {

    // template
    private STGroup groupTemplate;
    private ST type, stmt, expr, template;
    private List<ST> funcs, params, datas, decls;

    private String fileName;

    private int loop = 0; // Loop
    private int ret = 0; // Retorno

    SemanticTypeEnv<LocalEnv<SemanticType>> env;

    private HashMap<String, DataAttr> datasAttr;
    private LocalEnv<SemanticType> funcObs;

    public JavaVisitor(String fileName, SemanticTypeEnv<LocalEnv<SemanticType>> env,
            HashMap<String, DataAttr> datasAttr) {
        groupTemplate = new STGroupFile("./lang/template/java.stg");
        this.fileName = fileName;
        this.env = env;
        this.datasAttr = datasAttr;
    }

    @Override
    public void visit(Prog prog) {
        template = groupTemplate.getInstanceOf("program").add("name", fileName);

        // Inicializa e processa os tipos Data
        HashMap<String, Data> data = new HashMap<String, Data>();
        datas = new ArrayList<ST>();
        prog.getDatas().forEach(d -> {
            data.put(d.getId(), d);
            d.accept(this);
        });
        template.add("datas", datas); // Adiciona datas processados ao template

        // Inicializa e processa as funções
        ArrayList<Func> func = new ArrayList<Func>();
        funcs = new ArrayList<ST>();
        prog.getFunctions().forEach(f -> {
            func.add(f);
            f.accept(this);
        });

        template.add("funcs", funcs); // Adiciona as funções processadas ao template
    }

    /*
     * Tipos Aritméticos
     */

    @Override
    public void visit(Add add) {
        ST aux = groupTemplate.getInstanceOf("add_expr");
        add.getLeft().accept(this);
        aux.add("left_expr", expr);
        add.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Sub sub) {
        ST aux = groupTemplate.getInstanceOf("sub_expr");
        sub.getLeft().accept(this);
        aux.add("left_expr", expr);
        sub.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Mul mul) {
        ST aux = groupTemplate.getInstanceOf("mul_expr");
        mul.getLeft().accept(this);
        aux.add("left_expr", expr);
        mul.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Div div) {
        ST aux = groupTemplate.getInstanceOf("div_expr");
        div.getLeft().accept(this);
        aux.add("left_expr", expr);
        div.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Mod mod) {
        ST aux = groupTemplate.getInstanceOf("mod_expr");
        mod.getLeft().accept(this);
        aux.add("left_expr", expr);
        mod.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Param p) {
    }

    @Override
    public void visit(Cmd cmd) {
        cmd.accept(this);
    }

    @Override
    public void visit(Func func) {
        // Cria uma instância da função a partir do template
        ST functionTemplate = groupTemplate.getInstanceOf("func");
        functionTemplate.add("name", func.getId());

        // Lista todas as funções encontradas com o mesmo nome
        ArrayList<LocalEnv> foundFunctions = (ArrayList) env.findFunctions(func.getId());

        // Inicializa a função correta com a primeira da lista
        LocalEnv<SemanticType> currentFunctionEnv = foundFunctions.get(0);

        // Se houver mais de uma função com o mesmo nome (sobrecarga)
        if (foundFunctions.size() > 1) {
            for (int i = 0; i < foundFunctions.size(); i++) {
                LocalEnv<SemanticType> candidateFunction = foundFunctions.get(i);
                SemanticTypeFunc candidateFuncType = (SemanticTypeFunc) candidateFunction.getFuncType();

                // Verifica se o número de parâmetros coincide
                if (candidateFuncType.getParamTypes().length == func.getParams().size()) {
                    boolean paramsMatch = true;

                    // Verifica se os tipos dos parâmetros são os mesmos
                    for (int j = 0; j < candidateFuncType.getParamTypes().length; j++) {
                        if (!candidateFuncType.getParamTypes()[j].toString().equals(
                                ((Type) func.getParams().getSingleType(j)).toString())) {
                            paramsMatch = false;
                            break;
                        }
                    }

                    // Se todos os parâmetros forem compatíveis, seleciona esta função
                    if (paramsMatch) {
                        currentFunctionEnv = foundFunctions.get(i);
                        break;
                    }
                }
            }
        }

        // Armazena a função observada
        funcObs = currentFunctionEnv;

        // Tratamento para funções com um ou nenhum retorno
        if (func.getReturnTypes().size() < 2) {
            // Função sem retorno (void)
            if (func.getReturnTypes().isEmpty()) {
                if (func.getId().equals("main")) {
                    functionTemplate.add("type", "int"); // Função 'main' deve retornar int em C++
                } else {
                    functionTemplate.add("type", "void"); // Outras funções sem retorno
                }
            }
            // Função com um único retorno
            else if (func.getReturnTypes().size() == 1) {
                functionTemplate = groupTemplate.getInstanceOf("func");
                String functionName = func.getId() + "_0"; // Nome da função modificado
                functionTemplate.add("name", functionName);
                func.getReturnTypes().get(0).accept(this); // Obtém o tipo de retorno
                functionTemplate.add("type", type); // Adiciona o tipo ao template
            }

            // Declaração de variáveis locais
            Set<String> localVars = currentFunctionEnv.getKeys();
            params = new ArrayList<ST>();

            // Processamento dos parâmetros da função
            if (func.getParams() != null) {
                Param paramList = func.getParams();
                for (int i = 0; i < paramList.size(); i++) {
                    SemanticType paramType = ((SemanticTypeFunc) currentFunctionEnv.getFuncType()).getParamTypes()[i];
                    ST paramTemplate = groupTemplate.getInstanceOf("param");
                    String paramName = paramList.getSingleId(i);
                    paramTemplate.add("name", paramName);

                    // Verifica se o tipo do parâmetro é um array
                    if (paramType instanceof SemanticArrayType) {
                        List<ST> arrayTemplates = new ArrayList<ST>();
                        SemanticType innerType = paramType;

                        // Criação da lista de arrays
                        while (innerType instanceof SemanticArrayType) {
                            ST arrayTemplate = groupTemplate.getInstanceOf("array_type");
                            arrayTemplates.add(arrayTemplate);
                            innerType = ((SemanticArrayType) innerType).getArg();
                        }

                        // Processamento do tipo mais interno
                        processSemanticType(innerType);
                        arrayTemplates.get(0).add("type", type);

                        // Ajuste dos tipos mais externos
                        for (int j = 1; j < arrayTemplates.size(); j++) {
                            ST previousArray = arrayTemplates.get(j - 1);
                            ST currentArray = arrayTemplates.get(j);
                            currentArray.add("type", previousArray);
                        }

                        type = arrayTemplates.get(arrayTemplates.size() - 1);
                    } else {
                        processSemanticType(paramType);
                    }

                    paramTemplate.add("type", type);
                    params.add(paramTemplate);
                    localVars.remove(paramName); // Remove o parâmetro da lista de variáveis locais
                }
            }
            functionTemplate.add("params", params);

            // Declaração de variáveis restantes
            for (String varName : localVars) {
                SemanticType varType = currentFunctionEnv.get(varName);
                ST varDeclTemplate = groupTemplate.getInstanceOf("param");
                varDeclTemplate.add("name", varName);

                if (varType instanceof SemanticArrayType) {
                    List<ST> arrayTemplates = new ArrayList<ST>();
                    SemanticType innerType = varType;

                    while (innerType instanceof SemanticArrayType) {
                        ST arrayTemplate = groupTemplate.getInstanceOf("array_type");
                        arrayTemplates.add(arrayTemplate);
                        innerType = ((SemanticArrayType) innerType).getArg();
                    }

                    processSemanticType(innerType);
                    arrayTemplates.get(0).add("type", type);

                    for (int j = 1; j < arrayTemplates.size(); j++) {
                        ST previousArray = arrayTemplates.get(j - 1);
                        ST currentArray = arrayTemplates.get(j);
                        currentArray.add("type", previousArray);
                    }

                    type = arrayTemplates.get(arrayTemplates.size() - 1);
                } else {
                    processSemanticType(varType);
                }

                varDeclTemplate.add("type", type);
                functionTemplate.add("decl", varDeclTemplate);
            }

            // Processamento dos comandos da função
            for (Cmd command : func.getCommands()) {
                command.accept(this);
                functionTemplate.add("stmt", stmt);
            }

            // Adiciona 'return 0;' no final da função 'main'
            if (func.getId().equals("main")) {
                ST returnStmt = groupTemplate.getInstanceOf("return");
                returnStmt.add("expr", 0);
                functionTemplate.add("stmt", returnStmt);
            }

            funcs.add(functionTemplate);

        }
        // Tratamento para funções com múltiplos retornos
        else {
            ret = 0;

            for (int j = 0; j < func.getReturnTypes().size(); j++) {
                functionTemplate = groupTemplate.getInstanceOf("func");
                String functionName = func.getId() + "_" + ret;
                functionTemplate.add("name", functionName);

                func.getReturnTypes().get(ret).accept(this); // Obtém o tipo de retorno
                functionTemplate.add("type", type);

                // Processa os parâmetros e variáveis da mesma forma que funções com um retorno
                Set<String> localVars = currentFunctionEnv.getKeys();
                params = new ArrayList<ST>();

                if (func.getParams() != null) {
                    Param paramList = func.getParams();
                    for (int i = 0; i < paramList.size(); i++) {
                        SemanticType paramType = ((SemanticTypeFunc) currentFunctionEnv.getFuncType())
                                .getParamTypes()[i];
                        ST paramTemplate = groupTemplate.getInstanceOf("param");
                        String paramName = paramList.getSingleId(i);
                        paramTemplate.add("name", paramName);

                        if (paramType instanceof SemanticArrayType) {
                            List<ST> arrayTemplates = new ArrayList<ST>();
                            SemanticType innerType = paramType;

                            while (innerType instanceof SemanticArrayType) {
                                ST arrayTemplate = groupTemplate.getInstanceOf("array_type");
                                arrayTemplates.add(arrayTemplate);
                                innerType = ((SemanticArrayType) innerType).getArg();
                            }

                            processSemanticType(innerType);
                            arrayTemplates.get(0).add("type", type);

                            for (int k = 1; k < arrayTemplates.size(); k++) {
                                ST previousArray = arrayTemplates.get(k - 1);
                                ST currentArray = arrayTemplates.get(k);
                                currentArray.add("type", previousArray);
                            }

                            type = arrayTemplates.get(arrayTemplates.size() - 1);
                        } else {
                            processSemanticType(paramType);
                        }

                        paramTemplate.add("type", type);
                        params.add(paramTemplate);
                        localVars.remove(paramName);
                    }
                }
                functionTemplate.add("params", params);

                for (String varName : localVars) {
                    SemanticType varType = currentFunctionEnv.get(varName);
                    ST varDeclTemplate = groupTemplate.getInstanceOf("param");
                    varDeclTemplate.add("name", varName);

                    if (varType instanceof SemanticArrayType) {
                        List<ST> arrayTemplates = new ArrayList<ST>();
                        SemanticType innerType = varType;

                        while (innerType instanceof SemanticArrayType) {
                            ST arrayTemplate = groupTemplate.getInstanceOf("array_type");
                            arrayTemplates.add(arrayTemplate);
                            innerType = ((SemanticArrayType) innerType).getArg();
                        }

                        processSemanticType(innerType);
                        arrayTemplates.get(0).add("type", type);

                        for (int k = 1; k < arrayTemplates.size(); k++) {
                            ST previousArray = arrayTemplates.get(k - 1);
                            ST currentArray = arrayTemplates.get(k);
                            currentArray.add("type", previousArray);
                        }

                        type = arrayTemplates.get(arrayTemplates.size() - 1);
                    } else {
                        processSemanticType(varType);
                    }

                    varDeclTemplate.add("type", type);
                    functionTemplate.add("decl", varDeclTemplate);
                }

                for (Cmd command : func.getCommands()) {
                    command.accept(this);
                    functionTemplate.add("stmt", stmt);
                }

                funcs.add(functionTemplate);
                ret++;
            }
        }
    }

    @Override
    public void visit(And and) {
        ST aux = groupTemplate.getInstanceOf("and_expr");
        and.getLeft().accept(this);
        aux.add("left_expr", expr);
        and.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(ArrayType arrayType) {
        ST aux = groupTemplate.getInstanceOf("array_type");
        arrayType.getBaseType().accept(this);
        aux.add("type", type);
        type = aux;
    }

    @Override
    public void visit(BlockCmd blockCmd) {
        // Itera e executa cada comando do bloco
        for (Cmd command : blockCmd.getCmds()) {
            command.accept(this);
        }
    }

    @Override
    public void visit(CharDexp charDexp) {
        expr = groupTemplate.getInstanceOf("char_expr");
        expr.add("value", charDexp.getOriginalValue());
    }

    @Override
    public void visit(Equals equals) {
        ST aux = groupTemplate.getInstanceOf("equals_expr");
        equals.getLeft().accept(this);
        aux.add("left_expr", expr);
        equals.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(FloatDexp floatDexp) {
        expr = groupTemplate.getInstanceOf("float_expr");
        expr.add("value", floatDexp.getValue());
    }

    @Override
    public void visit(FuncCallCMD funcCallCMD) {
        ST auxTemplate = groupTemplate.getInstanceOf("funcCallCMD");
        auxTemplate.add("name", funcCallCMD.getId());

        // Verifica se há valores atribuídos (retorno de função com valores)
        if (!funcCallCMD.getLValues().isEmpty()) {
            // Processa o primeiro valor atribuído
            funcCallCMD.getLValues().get(0).accept(this);
            auxTemplate.add("ret1", expr);

            // Processa o segundo valor, se existir (caso de múltiplos retornos)
            if (funcCallCMD.getLValues().size() > 1) {
                funcCallCMD.getLValues().get(1).accept(this);
                auxTemplate.add("ret2", expr);
            }
        } else {
            // Caso sem valores retornados, muda o template para uma chamada simples
            auxTemplate = groupTemplate.getInstanceOf("call");
            auxTemplate.add("name", funcCallCMD.getId());
        }

        // Processa os argumentos passados para a função
        List<Expr> argumentos = funcCallCMD.getFFuncArgss().getExps();
        for (Expr argumento : argumentos) {
            argumento.accept(this);
            auxTemplate.add("args", expr);
        }

        // Atribui o template final ao statement
        stmt = auxTemplate;
    }

    @Override
    public void visit(If if1) {
        ST ifTemplate = groupTemplate.getInstanceOf("if");

        // Processa a expressão condicional
        if1.getExpr().accept(this);
        ifTemplate.add("expr", expr);

        // Processa o comando do bloco 'if'
        Cmd comandoIf = if1.getCmd();
        if (comandoIf instanceof BlockCmd) {
            List<Cmd> comandosBloco = ((BlockCmd) comandoIf).getCmds();
            List<String> cmdsIf = new ArrayList<>();
            for (Cmd cmd : comandosBloco) {
                cmd.accept(this);
                cmdsIf.add(stmt.render());
            }
            ifTemplate.add("cmd_if", cmdsIf);
        } else {
            comandoIf.accept(this);
            ifTemplate.add("cmd_if", stmt.render());
        }

        // Atribui o template
        stmt = ifTemplate;
    }

    @Override
    public void visit(IfElse ifElse) {
        ST ifElseTemplate = groupTemplate.getInstanceOf("if_else");

        // Processa a expressão condicional do if
        ifElse.getExpr().accept(this);
        ifElseTemplate.add("expr", expr);

        // Processa os comandos do bloco 'if'
        Cmd comandoIf = ifElse.getCmd();
        if (comandoIf instanceof BlockCmd) {
            List<Cmd> comandosIfBloco = ((BlockCmd) comandoIf).getCmds();
            List<String> cmdsIf = new ArrayList<>();
            for (Cmd cmd : comandosIfBloco) {
                cmd.accept(this);
                cmdsIf.add(stmt.render());
            }
            ifElseTemplate.add("cmd_if", cmdsIf);
        } else {
            comandoIf.accept(this);
            ifElseTemplate.add("cmd_if", stmt.render());
        }

        // Processa os comandos do bloco 'else'
        Cmd comandoElse = ifElse.getElseCmd();
        if (comandoElse != null) {
            if (comandoElse instanceof BlockCmd) {
                List<Cmd> comandosElseBloco = ((BlockCmd) comandoElse).getCmds();
                List<String> cmdsElse = new ArrayList<>();
                for (Cmd cmd : comandosElseBloco) {
                    cmd.accept(this);
                    cmdsElse.add(stmt.render());
                }
                ifElseTemplate.add("cmd_else", cmdsElse);
            } else {
                comandoElse.accept(this);
                ifElseTemplate.add("cmd_else", stmt.render());
            }
        } else {
            ifElseTemplate.add("cmd_else", "// nao ha comando");
        }

        // Atribui o template final
        stmt = ifElseTemplate;
    }

    @Override
    public void visit(IntDexp intDexp) {
        expr = groupTemplate.getInstanceOf("int_expr");
        expr.add("value", intDexp.getValue());
    }

    @Override
    public void visit(Iterate iterate) {
        ST iterateTemplate = groupTemplate.getInstanceOf("iterate");
        // Processa a expressão condicional do loop
        iterate.getExpr().accept(this);
        iterateTemplate.add("expr", expr);

        // Atualiza o índice do loop atual
        loop++;

        iterateTemplate.add("loopAtual", String.valueOf(loop));

        // Processa os comandos do corpo do loop
        Cmd comandoLoop = iterate.getCmd();
        if (comandoLoop instanceof BlockCmd) {
            List<Cmd> comandosLoop = ((BlockCmd) comandoLoop).getCmds();
            for (Cmd cmd : comandosLoop) {
                cmd.accept(this);
                iterateTemplate.add("cmd", stmt);
            }
        } else {
            comandoLoop.accept(this);
            iterateTemplate.add("cmd", stmt);
        }

        // Atribui o template final
        stmt = iterateTemplate;
    }

    @Override
    public void visit(LessThan lessThan) {
        ST aux = groupTemplate.getInstanceOf("lt_expr");
        lessThan.getLeft().accept(this);
        aux.add("left_expr", expr);
        lessThan.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(LValue l) {
    }

    @Override
    public void visit(LvalueCmd lvalueCmd) {
        stmt = groupTemplate.getInstanceOf("attr");

        // Processa a variável que receberá o valor atribuído
        LValue lvalue = lvalueCmd.getlValue();
        lvalue.accept(this);

        // Verifica o tipo para determinar a atribuição
        if (lvalue instanceof IdLValue) {
            // Variável simples
            stmt.add("var", expr);
            lvalueCmd.getExpr().accept(this); // Processa a expressão a ser atribuída
            stmt.add("expr", expr);

        } else if (lvalue instanceof ArrayLValue) {
            // Caso seja um Array
            if (lvalue != null && ((ArrayLValue) lvalue).getlValue() instanceof ArrayLValue) {
                // Matriz
                stmt.add("var", expr);
                lvalueCmd.getExpr().accept(this);
                stmt.add("expr", expr);
            } else {
                // Array comum
                stmt.add("var", expr);
                lvalueCmd.getExpr().accept(this);
                stmt.add("expr", expr);
            }

        } else if (lvalue instanceof Dot) {
            stmt.add("var", expr);
            lvalueCmd.getExpr().accept(this);
            stmt.add("expr", expr);
        }

        // Verifica se é uma instância com valor nulo
        if (expr == null && lvalueCmd.getExpr() instanceof NewExp) {
            stmt = null;
        }
    }

    @Override
    public void visit(NameType nameType) { // Data
        type = groupTemplate.getInstanceOf("data_type");
        type.add("data", nameType.getID());
    }

    @Override
    public void visit(Neg neg) {
        ST aux = groupTemplate.getInstanceOf("neg_expr");
        neg.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Not not) {
        ST aux = groupTemplate.getInstanceOf("not_expr");
        not.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(NotEquals notEquals) {
        ST aux = groupTemplate.getInstanceOf("not_equals_expr");
        notEquals.getLeft().accept(this);
        aux.add("left_expr", expr);
        notEquals.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Null null1) {
        expr = groupTemplate.getInstanceOf("null_type");
        expr.add("value", null1.getValue());
    }

    @Override
    public void visit(Print print) {
        stmt = groupTemplate.getInstanceOf("print");
        print.getExpression().accept(this);
        stmt.add("expr", expr);
    }

    @Override
    public void visit(Read read) {
        // Obtém o template para o comando read
        stmt = groupTemplate.getInstanceOf("read");

        // Obtém as variáveis no escopo da função
        Set<String> variaveisEscopo = funcObs.getKeys();
        SemanticType tipoVariavel = null;

        // Encontra o tipo da variável
        for (String variavel : variaveisEscopo) {
            if (variavel.equals(read.getlValue().toString())) {
                tipoVariavel = funcObs.get(variavel);
                break;
            }
        }

        // Determina as flags de tipo com base no tipo da variável
        stmt.add("isInt", tipoVariavel instanceof SemanticTypeInt);
        stmt.add("isFloat", tipoVariavel instanceof SemanticTypeFloat);
        stmt.add("isChar", tipoVariavel instanceof SemanticTypeChar);

        // Processa a expressão e adiciona ao template
        read.getlValue().accept(this);
        stmt.add("expr", expr);
    }

    @Override
    public void visit(Return return1) {
        stmt = groupTemplate.getInstanceOf("return");

        // Verifica se há um ou mais valores de retorno
        if (return1.getExps().size() == 1) {
            // Processa a única expressão de retorno
            return1.getExps().get(0).accept(this);
        } else {
            // Processa a expressão correspondente ao índice de retorno
            return1.getExps().get(ret).accept(this);
        }

        // Adiciona a expressão ao template
        stmt.add("expr", expr);
    }

    @Override
    public void visit(TyBool t) {
        type = groupTemplate.getInstanceOf("boolean_type");
    }

    @Override
    public void visit(TyFloat t) {
        type = groupTemplate.getInstanceOf("float_type");
    }

    @Override
    public void visit(TyChar t) {
        type = groupTemplate.getInstanceOf("char_type");
    }

    @Override
    public void visit(TyInt t) {
        type = groupTemplate.getInstanceOf("int_type");
    }

    @Override
    public void visit(Type t) {
    }

    @Override
    public void visit(ArrayLValue arrayLValue) {
        expr = groupTemplate.getInstanceOf("lvalue");
        expr.add("name", arrayLValue.toString());
    }

    @Override
    public void visit(Dot dot) {
        expr = groupTemplate.getInstanceOf("lvalue");
        expr.add("name", dot.toString());
    }

    @Override
    public void visit(FuncCall funcCall) {
        ST funcReturnTemplate = groupTemplate.getInstanceOf("funcCall");

        // Adiciona o nome da função
        funcReturnTemplate.add("name", funcCall.getId());

        // Processa o índice de retorno
        funcCall.getExpIndex().accept(this);
        funcReturnTemplate.add("returnExpr", expr);

        // Processa os parâmetros da chamada da função
        List<Expr> parametros = funcCall.getFFuncArgss().getExps();
        for (Expr param : parametros) {
            param.accept(this);
            funcReturnTemplate.add("args", expr);
        }

        // Atribui o template final à expressão
        expr = funcReturnTemplate;
    }

    @Override
    public void visit(IdLValue idLValue) {
        expr = groupTemplate.getInstanceOf("lvalue");
        expr.add("name", idLValue.getId());
    }

    @Override
    public void visit(NewExp newExp) {
        ST aux = groupTemplate.getInstanceOf("newExp");

        // Verifica se há um tipo associado à expressão
        if (newExp.getTipo() != null) {
            // Para arrays
            if (newExp.getExpr() != null) {
                if (newExp.getTipo() instanceof ArrayType) {
                    // Caso seja uma matriz, ajusta a criação
                    ArrayType arrayType = (ArrayType) newExp.getTipo();
                    ST lvalue = groupTemplate.getInstanceOf("lvalue");

                    // Converte o tipo base do array
                    arrayType.getBaseType().accept(this);
                    lvalue.add("name", type);

                    // Configura o acesso ao array
                    ST arrayAccess = groupTemplate.getInstanceOf("array_access");
                    newExp.getExpr().accept(this);
                    arrayAccess.add("expr", expr);

                    lvalue.add("array", arrayAccess);
                    aux.add("type", lvalue);

                    // Adiciona colchetes para indicar as colunas
                    aux.add("expr", "");
                } else {
                    // Para arrays simples
                    newExp.getTipo().accept(this);
                    aux.add("type", type);

                    // Adiciona a expressão do tamanho do array
                    newExp.getExpr().accept(this);
                    aux.add("expr", expr);
                }
            } else {
                // Para tipos simples
                if (newExp.getTipo() instanceof NameType) {
                    newExp.getTipo().accept(this);
                    aux.add("type", type);
                } else {
                    aux = null;
                }
            }
        }

        // Caso o tipo seja nulo
        if (newExp.getTipo() == null && newExp.getDataName() != null) {
            aux.add("type", newExp.getDataName());
        }

        // Atribui o template final
        expr = aux;
    }

    @Override
    public void visit(FuncArgs funcArgs) {
        // Processa cada expressão
        for (Expr expr : funcArgs.getExps()) {
            expr.accept(this);
        }
    }

    @Override
    public void visit(Data data) {
        ST dataTemplate = groupTemplate.getInstanceOf("data");
        dataTemplate.add("name", data.getId()); // Adiciona o nome do tipo data

        // Inicializa a lista de declarações
        decls = new ArrayList<>();

        // Obtém os atributos do tipo Data

        DataAttr dataAttributes = datasAttr.get(data.getId());
        List<Decl> declsList = data.getDecls();

        // Processa cada declaração de variável do tipo Data
        int tipoIndex = 0;
        for (Decl decl : declsList) {
            ST declTemplate = groupTemplate.getInstanceOf("decl");
            SemanticType tipo = dataAttributes.getDataTypes().get(tipoIndex);

            // Adiciona o nome da variável e processa o tipo
            declTemplate.add("name", decl.getId());

            // Processamento do tipo, incluindo arrays
            if (tipo instanceof SemanticArrayType) {
                List<ST> arrayTemplates = new ArrayList<>();
                SemanticType innerType = tipo;

                // Criação da lista de templates de arrays
                while (innerType instanceof SemanticArrayType) {
                    ST arrayTemplate = groupTemplate.getInstanceOf("array_type");
                    arrayTemplates.add(arrayTemplate);
                    innerType = ((SemanticArrayType) innerType).getArg();
                }

                // Processamento do tipo base (mais interno)
                processSemanticType(innerType);
                arrayTemplates.get(0).add("type", type); // O tipo base é adicionado ao array mais interno

                // Ajuste dos tipos mais externos para arrays multidimensionais
                for (int j = 1; j < arrayTemplates.size(); j++) {
                    ST previousArray = arrayTemplates.get(j - 1);
                    ST currentArray = arrayTemplates.get(j);
                    currentArray.add("type", previousArray);
                }

                // O tipo completo é atribuído como o tipo do array final
                type = arrayTemplates.get(arrayTemplates.size() - 1);
            } else {
                // Processa tipos não array
                processSemanticType(tipo);
            }

            // Adiciona o tipo da declaração ao template
            declTemplate.add("type", type);
            decls.add(declTemplate);

            tipoIndex++;
        }

        // Adiciona as declarações processadas ao template
        dataTemplate.add("decl", decls);

        // Adiciona o template final à lista de datas
        datas.add(dataTemplate);
    }

    @Override
    public void visit(Decl d) {
    }

    @Override
    public void visit(BoolDexp b) {
        expr = groupTemplate.getInstanceOf("boolean_expr");
        expr.add("value", b.getValue());
    }

    @Override
    public void visit(ID i) {
    }

    /*
     * Funções Auxiliares
     */

    private void processSemanticType(SemanticType semanticType) {
        if (semanticType instanceof SemanticTypeInt)
            type = groupTemplate.getInstanceOf("int_type");
        else if (semanticType instanceof SemanticTypeBool)
            type = groupTemplate.getInstanceOf("boolean_type");
        else if (semanticType instanceof SemanticTypeFloat)
            type = groupTemplate.getInstanceOf("float_type");
        else if (semanticType instanceof SemanticTypeChar)
            type = groupTemplate.getInstanceOf("char_type");
        else if (semanticType instanceof SemanticTypeData) {
            type = groupTemplate.getInstanceOf("data_type");
            type.add("data", ((SemanticTypeData) semanticType).getDataName());
        }
    }

    public String getTemplate() {
        return template.render();
    }
}
