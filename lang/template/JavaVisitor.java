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

    private STGroup groupTemplate;
    private ST type, stmt, expr, variavel;
    private ST template; // Armazena todo o código do programa
    private List<ST> funcs, params, datas, declarations;
    private String fileName;
    private int loopAtual = 0;

    SemanticTypeEnv<LocalEnv<SemanticType>> env;

    private HashMap<String, DataAttr> datasAttrib;

    private ArrayList<Func> functionsAST;

    private HashMap<String, Data> datasAST;

    private LocalEnv<SemanticType> funcaoAtualObservada;
    private int idRetorno = 0;

    public JavaVisitor(String fileName, SemanticTypeEnv<LocalEnv<SemanticType>> env,
            HashMap<String, DataAttr> datasAttrib) {
        groupTemplate = new STGroupFile("./lang/template/java.stg");
        this.fileName = fileName;
        this.env = env;
        this.datasAttrib = datasAttrib;
        functionsAST = new ArrayList<Func>();
        datasAST = new HashMap<String, Data>();
    }

    public String getTemplate() {
        return template.render();
    }

    // Retorna o ambiente de geração de código
    public SemanticTypeEnv<LocalEnv<SemanticType>> getEnv() {
        return env;
    }

    // https://www.techiedelight.com/get-current-line-number-java/
    // Retorna a linha do código fonte ao passar pela instrução
    public int getLineNumber() {
        // return new Throwable().getStackTrace()[0].getLineNumber();
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    @Override
    public void visit(Prog p) {
        template = groupTemplate.getInstanceOf("program").add("name", fileName);

        // Inicializa e processa os tipos Data
        datas = new ArrayList<ST>();
        p.getDatas().forEach(d -> {
            datasAST.put(d.getId(), d);
            d.accept(this);
        });
        template.add("datas", datas); // Adiciona datas processados ao template

        // Inicializa e processa as funções
        funcs = new ArrayList<ST>();
        p.getFunctions().forEach(f -> {
            functionsAST.add(f);
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
        ST fun = groupTemplate.getInstanceOf("func");
        fun.add("name", func.getId());

        // Pega todas as funções que têm o mesmo nome
        ArrayList<LocalEnv> funcFinded = (ArrayList) env.findFunctions(func.getId());

        // Função correta encontrada (por padrão, a primeira)
        LocalEnv<SemanticType> local = (LocalEnv<SemanticType>) funcFinded.get(0);

        // Verifica se há sobrecarga de função (mais de uma função com o mesmo nome)
        if (funcFinded.size() > 1) {
            for (int i = 0; i < funcFinded.size(); i++) {
                LocalEnv<SemanticType> funcaoBase = funcFinded.get(i);
                SemanticTypeFunc funcaoBaseTipo = (SemanticTypeFunc) funcaoBase.getFuncType();

                // Verifica se o número de parâmetros da função coincide com a função observada
                if (funcaoBaseTipo.getParamTypes().length == func.getParams().size()) {
                    boolean matchingParams = true;

                    // Verifica se os tipos dos parâmetros coincidem
                    for (int j = 0; j < funcaoBaseTipo.getParamTypes().length; j++) {
                        if (!funcaoBaseTipo.getParamTypes()[j].toString().equals(
                                ((Type) func.getParams().getSingleType(j)).toString())) {
                            matchingParams = false;
                            break;
                        }
                    }

                    // Se todos os parâmetros coincidem, esta é a função correta
                    if (matchingParams) {
                        local = (LocalEnv<SemanticType>) funcFinded.get(i);
                        break;
                    }
                }
            }
        }

        // Variavel que armazena qual função está sendo observada para poder verificar
        // tipos e valores
        funcaoAtualObservada = local;

        if (func.getReturnTypes().size() < 2) {
            if (func.getReturnTypes().size() == 0) { // void => 0 retornos
                if (func.getId().equals("main")) { // Função 'main' pra C++ tem retornar valor inteiro
                    fun.add("type", "int");
                } else {
                    fun.add("type", "void");
                }
            } else if (func.getReturnTypes().size() == 1) { // 1 retorno somente
                // A função mesmo com somente 1 retorno terá seu nome alterado
                fun = groupTemplate.getInstanceOf("func");
                String nomeFuncao = func.getId() + "_retorno_00";
                fun.add("name", nomeFuncao);
                func.getReturnTypes().get(0).accept(this); // Empilha o único tipo de retorno que será o tipo da função
                fun.add("type", type);
            }

            // Declaração das variaveis que são usadas no corpo da função
            Set<String> keys = local.getKeys();

            // Instancia a lista que vai armazenar os comandos da função
            params = new ArrayList<ST>();

            if (func.getParams() != null) {

                Param paramsList = func.getParams();

                // Adiciona as variaveis do parametro no escopo local
                for (int i = 0; i < paramsList.size(); i++) {
                    SemanticType t = ((SemanticTypeFunc) local.getFuncType()).getParamTypes()[i]; // Pega o tipo do
                    ST p = groupTemplate.getInstanceOf("param");
                    String nomeParametro = paramsList.getSingleId(i);
                    p.add("name", nomeParametro);
                    if (t instanceof SemanticArrayType) {
                        adjustSemanticArrayType((SemanticArrayType) t);
                    } else {
                        processSemanticType(t);
                    }
                    p.add("type", type);
                    params.add(p);

                    // Remove o parametro da função da lista de variaveis do corpo da função
                    keys.remove(nomeParametro);
                }
            }
            fun.add("params", params);

            // Instancia as variaveis antes de usar nas operações presente no corpo da
            // função
            for (String key : keys) {
                SemanticType t = local.get(key);
                // if(!(t instanceof SemanticArrayType)){ // Se nao for array declara
                // normalmente
                ST decl = groupTemplate.getInstanceOf("param");
                decl.add("name", key);
                if (t instanceof SemanticArrayType) {
                    adjustSemanticArrayType((SemanticArrayType) t);
                } else {
                    processSemanticType(t);
                }
                decl.add("type", type);
                fun.add("decl", decl);
                // }
            }

            for (int i = 0; i < func.getCommands().size(); i++) {
                Cmd command = func.getCommands().get(i);
                command.accept(this);
                fun.add("stmt", stmt);
            }

            // Adiciona o 'return 0;' na função main do código em C++
            if (func.getId().equals("main")) {
                stmt = groupTemplate.getInstanceOf("return");
                stmt.add("expr", 0); // 'return 0;'
                fun.add("stmt", stmt);
            }

            funcs.add(fun);

        } else { // 2 retornos
            /**
             * Vai adicionar duas funções da seguinte forma:
             * Exemplo:
             * -- Em lang ==> tipo float e int
             * soma(n :: int, n1 :: int): float, int{
             * -- Em C++
             * float soma_retorno_01(int n, int n1) ||| int soma_retorno_02(int n, int n1)
             */
            idRetorno = 0;
            // Para cada tipo de retorno, será criada uma função diferente
            for (int j = 0; j < func.getReturnTypes().size(); j++) {
                fun = groupTemplate.getInstanceOf("func");
                String nomeFuncao = func.getId() + "_retorno_0" + idRetorno;
                fun.add("name", nomeFuncao);

                // Empilha o tipo de retorno da função
                func.getReturnTypes().get(idRetorno).accept(this);
                fun.add("type", type);

                // Declaração das variaveis que são usadas no corpo da função
                Set<String> keys = local.getKeys();

                // Instancia a lista que vai armazenar os comandos da função
                params = new ArrayList<ST>();

                if (func.getParams() != null) {

                    Param paramsList = func.getParams();

                    // Adiciona as variaveis do parametro no escopo local
                    for (int i = 0; i < paramsList.size(); i++) {
                        SemanticType t = ((SemanticTypeFunc) local.getFuncType()).getParamTypes()[i]; // Pega o tipo do
                        // parametro
                        ST p = groupTemplate.getInstanceOf("param");
                        String nomeParametro = paramsList.getSingleId(i);
                        p.add("name", nomeParametro);
                        if (t instanceof SemanticArrayType) {
                            adjustSemanticArrayType((SemanticArrayType) t);
                        } else {
                            processSemanticType(t);
                        }
                        p.add("type", type);
                        params.add(p);

                        // Remove o parametro da função da lista de variaveis do corpo da função
                        keys.remove(nomeParametro);
                    }
                }
                fun.add("params", params);

                // Instancia as variaveis antes de usar nas operações presente no corpo da
                // função
                for (String key : keys) {
                    SemanticType t = local.get(key);
                    // if(!(t instanceof SemanticArrayType)){ // Se nao for array declara
                    // normalmente
                    ST decl = groupTemplate.getInstanceOf("param");
                    decl.add("name", key);
                    if (t instanceof SemanticArrayType) {
                        adjustSemanticArrayType((SemanticArrayType) t);
                    } else {
                        processSemanticType(t);
                    }
                    decl.add("type", type);
                    fun.add("decl", decl);
                    // }
                }

                for (int i = 0; i < func.getCommands().size(); i++) {
                    Cmd command = func.getCommands().get(i);
                    command.accept(this);
                    fun.add("stmt", stmt);
                }

                funcs.add(fun);
                idRetorno++;
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
        ST auxTemplate = groupTemplate.getInstanceOf("functionCall");
        auxTemplate.add("name", funcCallCMD.getId());

        // Verifica se há valores atribuídos (retorno de função com valores)
        if (!funcCallCMD.getLValues().isEmpty()) {
            // Processa o primeiro valor atribuído
            funcCallCMD.getLValues().get(0).accept(this);
            auxTemplate.add("var1", expr);

            // Processa o segundo valor, se existir (caso de múltiplos retornos)
            if (funcCallCMD.getLValues().size() > 1) {
                funcCallCMD.getLValues().get(1).accept(this);
                auxTemplate.add("var2", expr);
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

        // Verifica se o comando é um bloco de comandos ou um único comando
        Cmd comando = if1.getCmd();
        if (comando instanceof BlockCmd) {
            // Trata uma lista de comandos em um bloco
            List<Cmd> comandosBloco = ((BlockCmd) comando).getCmds();
            for (Cmd cmd : comandosBloco) {
                cmd.accept(this);
                ifTemplate.add("cmd", stmt);
            }
        } else {
            // Trata um único comando
            comando.accept(this);
            ifTemplate.add("cmd", stmt);
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
            for (Cmd cmd : comandosIfBloco) {
                cmd.accept(this);
                ifElseTemplate.add("cmd", stmt);
            }
        } else {
            comandoIf.accept(this);
            ifElseTemplate.add("cmd", stmt);
        }

        // Processa os comandos do bloco 'else'
        Cmd comandoElse = ifElse.getElseCmd();
        if (comandoElse instanceof BlockCmd) {
            List<Cmd> comandosElseBloco = ((BlockCmd) comandoElse).getCmds();
            for (Cmd cmd : comandosElseBloco) {
                cmd.accept(this);
                ifElseTemplate.add("els", stmt);
            }
        } else {
            comandoElse.accept(this);
            ifElseTemplate.add("els", stmt);
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
        loopAtual++;
        iterateTemplate.add("loopAtual", String.valueOf(loopAtual));

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

        // Decrementa o índice do loop atual
        loopAtual--;

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
        stmt = groupTemplate.getInstanceOf("attribution");

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
        stmt = groupTemplate.getInstanceOf("read");

        // Obtém as variáveis no escopo da função
        Set<String> variaveisEscopo = funcaoAtualObservada.getKeys();
        SemanticType tipoVariavel = null;

        // Encontra o tipo da variável
        for (String variavel : variaveisEscopo) {
            if (variavel.equals(read.getlValue().toString())) {
                tipoVariavel = funcaoAtualObservada.get(variavel);
                break;
            }
        }

        // Determina a conversão com base no tipo da variável
        if (tipoVariavel instanceof SemanticTypeInt) {
            stmt.add("converteTipo", "Integer.parseInt(__Scanner.nextLine())");
        } else if (tipoVariavel instanceof SemanticTypeFloat) {
            stmt.add("converteTipo", "Float.parseFloat(__Scanner.nextLine())");
        } else if (tipoVariavel instanceof SemanticTypeChar) {
            stmt.add("converteTipo", "__Scanner.nextLine().charAt(0)");
        }

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
            return1.getExps().get(idRetorno).accept(this);
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
    public void visit(Dot dor) {
        expr = groupTemplate.getInstanceOf("lvalue");
        expr.add("name", dor.toString());
    }

    @Override
    public void visit(FuncCall funcCall) {
        ST funcReturnTemplate = groupTemplate.getInstanceOf("functionReturn");

        // Adiciona o nome da função
        funcReturnTemplate.add("name", funcCall.getId());

        // Processa o índice de retorno
        funcCall.getExpIndex().accept(this);
        funcReturnTemplate.add("expr", expr);

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
        ST aux = groupTemplate.getInstanceOf("typeInstanciate");

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
    public void visit(Data d) {
        ST dataTemplate = groupTemplate.getInstanceOf("data");
        dataTemplate.add("name", d.getId()); // Adiciona o nome do tipo data

        // Inicializa a lista de declarações
        declarations = new ArrayList<>();

        // Obtém os atributos do tipo Data
        DataAttr dataAttributes = datasAttrib.get(d.getId());
        List<Decl> declsList = d.getDecls();

        // Processa cada declaração de variável do tipo Data
        int tipoIndex = 0;
        for (Decl decl : declsList) {
            ST declTemplate = groupTemplate.getInstanceOf("declaration");
            SemanticType tipo = dataAttributes.getDataTypes().get(tipoIndex);

            // Adiciona o nome da variável e processa o tipo
            declTemplate.add("name", decl.getId());
            if (tipo instanceof SemanticArrayType) {
                adjustSemanticArrayType((SemanticArrayType) tipo);
            } else {
                processSemanticType(tipo);
            }
            declTemplate.add("type", type);
            declarations.add(declTemplate);

            tipoIndex++;
        }

        // Adiciona as declarações
        dataTemplate.add("decl", declarations);

        // Adiciona o template final
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

    private void adjustSemanticArrayType(SemanticArrayType t) {
        List<ST> array = new ArrayList<ST>(); // Lista dos arrays
        SemanticType tipoArray = t; // Utiliza uma cópia de t, pois será atualizado
        // Adiciona os tipos array em uma lista
        // Exemplo: mat[][] => adiciona mat[]'[]' => depois mat'[]'[]
        while (tipoArray instanceof SemanticArrayType) {
            type = groupTemplate.getInstanceOf("array_type");
            array.add(type);
            tipoArray = ((SemanticArrayType) tipoArray).getArg();
        }
        // Pega do elemento mais externo para o mais interno que será o tipo do array
        for (int i = 1; i < array.size(); i++) { // Ajusta o tipo caso tenha array de array
            ST aux = array.get(i);
            aux.add("type", array.get(i - 1));
        }
        processSemanticType(tipoArray); // Passa o tipo do array ou matriz || Exemplo: Ponto, Char, Int, Float
        array.get(0).add("type", type); // Adiciona o tipo do array no elemento mais interno
        type = array.get(array.size() - 1); // O tipo completo será o da ultima posição da lista
    }

}
