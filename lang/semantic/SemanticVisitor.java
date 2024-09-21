package lang.semantic;

import java.util.*;

import lang.ast.*;
import lang.semantic.types.*;
import lang.visitors.*;

public class SemanticVisitor extends Visitor {

    // tipos iniciais
    private STyInt tyInt = STyInt.newSTyInt();
    private STyFloat tyFloat = STyFloat.newSTyFloat();
    private STyBool tyBool = STyBool.newSTyBool();
    private STyErr tyErr = STyErr.newSTyErr();
    private STyChar tyChar = STyChar.newSTyCharacter();
    private STyNull tyNull = STyNull.newSTyNull();

    private ArrayList<String> logError; // gravar todos os erros encontrados

    // tabelas
    private STyEnv<LocalEnv<SType>> env; // escopo das funções
    private LocalEnv<SType> temp; // local env temporario
    private Stack<SType> types; // pilha de tipos

    private ArrayList<Func> funcs; // funções
    private HashMap<String, DataAttr> datas; // tipo data

    private boolean ret; // verificar se houve retorno de função

    // private Object positionReturnFunction;

    public SemanticVisitor() {
        types = new Stack<SType>();
        env = new STyEnv<LocalEnv<SType>>();
        logError = new ArrayList<String>();
        datas = new HashMap<String, DataAttr>();
        funcs = new ArrayList<Func>();
    }

    @Override
    public void visit(Prog prog) {
        Node main = null;

        // Aceita os tipos data para fazer a verificação de tipo
        for (Data d : prog.getDatas()) {
            d.accept(this);
        }

        // Verifica e adiciona funções, incluindo a validação direta das funções
        for (Func f : prog.getFunctions()) {
            if (f.getId().equals("main") && env.getFuncoes(f.getId()).size() > 0) {
                logError.add(prog.getLine() + ", " + prog.getColumn()
                        + ": A função 'main' deve ser única e não pode ser sobrecarregada");
                types.push(tyErr);
                continue;
            }

            SType[] paramTypes = (f.getParams() != null) ? new SType[f.getParams().size()] : new SType[0];
            String[] paramNames = (f.getParams() != null) ? new String[f.getParams().size()] : new String[0];

            for (int i = 0; i < paramTypes.length; i++) {
                f.getParams().getSingleType(i).accept(this);
                paramTypes[i] = types.pop();
                paramNames[i] = f.getParams().getSingleId(i);

                // Confere se há repetição de nomes de parâmetros
                for (int j = 0; j < i; j++) {
                    if (paramNames[i].equals(paramNames[j])) {
                        logError.add(prog.getLine() + ", " + prog.getColumn()
                                + ": Parâmetros " + paramNames[i] + " e " + paramNames[j]
                                + " possuem nomes duplicados");
                        types.push(tyErr);
                        break;
                    }
                }
            }

            SType[] returnTypes = (f.getReturnTypes() != null) ? new SType[f.getReturnTypes().size()] : new SType[0];
            for (int i = 0; i < returnTypes.length; i++) {
                f.getReturnTypes().get(i).accept(this);
                returnTypes[i] = types.pop();
            }

            LocalEnv<SType> newFunc = new LocalEnv<>(f.getId(),
                    new STyFunc(paramTypes, returnTypes, paramNames, f.getId()));
            ArrayList<LocalEnv<SType>> existingFuncs = env.getFuncoes(f.getId());

            boolean isAmbiguous = false;

            if (existingFuncs != null) {
                for (LocalEnv<SType> existingFunc : existingFuncs) {
                    STyFunc baseFuncType = (STyFunc) existingFunc.getFuncType();
                    STyFunc newFuncType = (STyFunc) newFunc.getFuncType();

                    // Verifica se há conflito de tipos de parâmetros
                    if (baseFuncType.getTypes().length == newFuncType.getTypes().length) {
                        boolean typesMatch = true;

                        for (int i = 0; i < baseFuncType.getTypes().length; i++) {
                            if (!baseFuncType.getTypes()[i].match(newFuncType.getTypes()[i])) {
                                typesMatch = false;
                                break;
                            }
                        }

                        if (typesMatch) {
                            logError.add(prog.getLine() + ", " + prog.getColumn() + ": Ambiguidade na função "
                                    + f.getId()
                                    + ", pois já existe uma função com o mesmo número de parâmetros e tipos correspondentes");
                            ;
                            types.push(tyErr);
                            isAmbiguous = true;
                            break;
                        }
                    }
                }
            }

            // Adiciona a função ao ambiente se não houver ambiguidade
            if (!isAmbiguous) {
                env.add(newFunc);
                funcs.add(f);
            }
        }

        // Validação de presença e conformidade da função main
        for (Func f : prog.getFunctions()) {
            f.accept(this);
            if (f.getId().equals("main")) {
                if (f.getParams() != null && f.getParams().getType().size() != 0) {
                    logError.add(
                            prog.getLine() + ", " + prog.getColumn() + ": A função 'main' não pode ter parâmetros!");
                    types.push(tyErr);
                }
                main = f;
            }
        }

        if (main == null) {
            logError.add(prog.getLine() + ", " + prog.getColumn() + ": Não há função chamada 'main'");
            types.push(tyErr);
        }
    }

    /*
     * Tipos Aritméticos
     */

    @Override
    public void visit(Add add) {
        add.getLeft().accept(this);
        add.getRight().accept(this);
        typeArithmeticBinOp(add, "+");
    }

    @Override
    public void visit(Sub sub) {
        sub.getLeft().accept(this);
        sub.getRight().accept(this);
        typeArithmeticBinOp(sub, "-");
    }

    @Override
    public void visit(Mul mul) {
        mul.getLeft().accept(this);
        mul.getRight().accept(this);
        typeArithmeticBinOp(mul, "*");
    }

    @Override
    public void visit(Div div) {
        div.getLeft().accept(this);
        div.getRight().accept(this);
        typeArithmeticBinOp(div, "/");
    }

    @Override
    public void visit(Mod mod) {
        // Avalia as expressões do lado esquerdo e direito
        mod.getLeft().accept(this);
        mod.getRight().accept(this);

        // Recupera os tipos das expressões avaliadas
        SType rightType = types.pop();
        SType leftType = types.pop();

        // Verifica se ambos os tipos são inteiros
        if (rightType.match(tyInt) && leftType.match(tyInt)) {
            // Empilha o tipo inteiro no caso de operação válida
            types.push(tyInt);
        } else {
            logError.add(mod.getLine() + ", " + mod.getColumn() + ": Operador % não se aplica aos tipos "
                    + leftType.toString() + " e " + rightType.toString());
            types.push(tyErr);
        }
    }

    @Override
    public void visit(Param p) {
    }

    @Override
    public void visit(Cmd cmd) {
        // Executa o comando chamando o método accept
        cmd.accept(this);
    }

    @Override
    public void visit(Func func) {
        ret = false;
        // Recupera o ambiente da função
        List<LocalEnv<SType>> funcoesDisponiveis = env.getFuncoes(func.getId());

        // Procura a função correta, levando em conta a sobrecarga
        for (LocalEnv<SType> funcaoCandidata : funcoesDisponiveis) {
            STyFunc tipoFuncao = (STyFunc) funcaoCandidata.getFuncType();
            if (tipoFuncao.getTypes().length == func.getParams().getType().size()) {
                boolean todosTiposCorrespondem = true;
                for (int i = 0; i < tipoFuncao.getTypes().length; i++) {
                    if (!tipoFuncao.getTypes()[i].toString().equals(
                            func.getParams().getSingleType(i).toString())) {
                        todosTiposCorrespondem = false;
                        break;
                    }
                }
                if (todosTiposCorrespondem) {
                    temp = funcaoCandidata;
                    break;
                }
            }
        }

        // Processa os parâmetros da função, adicionando-os ao ambiente local
        if (func.getParams() != null) {
            Param parametros = func.getParams();
            for (int i = 0; i < parametros.size(); i++) {
                parametros.getSingleType(i).accept(this);
                temp.set(parametros.getSingleId(i), types.pop());
            }
        }

        // Itera pelos comandos da função
        boolean ultimoComandoEhIf = false;
        for (int i = 0; i < func.getCommands().size(); i++) {
            Cmd comando = func.getCommands().get(i);
            comando.accept(this);
            if (comando instanceof If && i == func.getCommands().size() - 1) {
                ultimoComandoEhIf = true;
            }
        }

        // Verifica os tipos de retorno
        SType[] retornoEsperado = new SType[0];
        if (temp.getFuncType() instanceof STyFunc) {
            retornoEsperado = ((STyFunc) temp.getFuncType()).getReturnTypes();
        }

        if (!ret && retornoEsperado.length > 0) {
            if (ultimoComandoEhIf) {
                logError.add(func.getLine() + ", " + func.getColumn() + ": Função " + func.getId()
                        + " falta uma declaração de retorno depois do último comando");

                types.push(tyErr);
            } else {
                logError.add(func.getLine() + ", " + func.getColumn() + ": A função " + func.getId()
                        + " deve retornar um valor");
                types.push(tyErr);
            }
        }
    }

    @Override
    public void visit(And and) {
        // Avalia a expressão do lado esquerdo
        and.getLeft().accept(this);
        // Avalia a expressão do lado direito
        and.getRight().accept(this);

        // Obtém os tipos resultantes das duas expressões
        SType rightType = types.pop();
        SType leftType = types.pop();

        // Verifica se ambos os tipos são booleanos
        if (rightType.match(tyBool) && leftType.match(tyBool)) {
            // Se forem, empurra o tipo booleano para a pilha
            types.push(tyBool);
        } else {
            // Caso contrário, registra o erro com detalhes da linha e coluna
            logError.add(and.getLine() + ", " + and.getColumn() + ": Operador & não se aplica aos tipos "
                    + leftType.toString() + " e " + rightType.toString());
            // Empurra um tipo de erro na pilha
            types.push(tyErr);
        }
    }

    @Override
    public void visit(ArrayType arrayType) {
        SType tipoBase;

        // Verifica se o tipo base é um NameType e se o tipo correspondente existe no
        // contexto 'datas'
        if (arrayType.getBaseType() instanceof NameType) {
            String tipoNome = ((NameType) arrayType.getBaseType()).getID();

            if (datas.get(tipoNome) == null) {
                // O tipo Data não foi encontrado
                logError.add(arrayType.getLine() + ", " + arrayType.getColumn() + ": O tipo Data " + tipoNome
                        + " não existe para a criação de um array");
                types.push(tyErr);
                return; // Sai da função após registrar o erro
            }
        }

        // Processa o tipo base
        arrayType.getBaseType().accept(this);
        tipoBase = types.pop(); // Desempilha o tipo processado

        // Verifica o tipo resultante do processamento
        if (tipoBase instanceof STyData) {
            // Verifica se o tipo STyData existe no contexto
            String nomeTipoData = ((STyData) tipoBase).getName();

            if (datas.get(nomeTipoData) != null) {
                // O tipo Data foi encontrado, cria o tipo array
                types.push(new STyArray(tipoBase));
            } else {
                logError.add(arrayType.getLine() + ", " + arrayType.getColumn() + ": O tipo Data " + nomeTipoData
                        + " não existe para a criação de um array");
                types.push(tyErr);
            }
        } else if (tipoBase instanceof STyErr) {
            // Se o tipo base for inválido, registra o erro
            logError.add(arrayType.getLine() + ", " + arrayType.getColumn() + ": O tipo base " + arrayType.getBaseType()
                    + " não é válido para a criação de um array");
            types.push(tyErr);
        } else {
            // Caso o tipo base seja válido, cria o array com esse tipo
            types.push(new STyArray(tipoBase));
        }
    }

    @Override
    public void visit(BlockCmd blockCmd) {
        // Itera e executa cada comando do bloco
        for (Cmd cmd : blockCmd.getCmds()) {
            cmd.accept(this);
        }
    }

    @Override
    public void visit(CharDexp charDexp) {
        // Empilha o tipo caractere na pilha de tipos
        types.push(tyChar);
    }

    @Override
    public void visit(Equals equals) {
        // Avalia as expressões do lado esquerdo e direito
        equals.getLeft().accept(this);
        equals.getRight().accept(this);

        // Recupera os tipos das expressões após avaliação
        SType rightType = types.pop();
        SType leftType = types.pop();

        // Verifica se ambos os tipos são compatíveis (inteiro ou flutuante)
        if ((rightType.match(tyInt) || rightType.match(tyFloat))
                && (leftType.match(tyInt) || leftType.match(tyFloat))) {
            // Empilha tipo booleano para operações válidas
            types.push(tyBool);

            // Verifica se ambos os tipos são caracteres
        } else if (leftType.match(tyChar) && rightType.match(tyChar)) {
            types.push(tyBool);

            // Caso contrário, registra erro para tipos incompatíveis
        } else {
            logError.add(equals.getLine() + ", " + equals.getColumn() + ": Operador = não se aplica aos tipos "
                    + leftType.toString() + " e " + rightType.toString());
            types.push(tyErr);
        }
    }

    @Override
    public void visit(FloatDexp p) {
        // Empilha o tipo float na pilha de tipos
        types.push(tyFloat);
    }

    @Override
    public void visit(FuncCallCMD funcCallCMD) {
        String nomeFuncao = funcCallCMD.getId();
        List<Expr> argumentosPassados = (funcCallCMD.getFFuncArgss() != null) ? funcCallCMD.getFFuncArgss().getExps()
                : new ArrayList<>();

        // Obtenção do ambiente da função correspondente
        LocalEnv<SType> funcaoSelecionada = null;
        ArrayList<LocalEnv> funcaoAmbiente = (ArrayList) env.getFuncoes(nomeFuncao);

        if (funcaoAmbiente.size() == 1) {
            // Sem sobrecarga, uma função encontrada
            funcaoSelecionada = (LocalEnv<SType>) funcaoAmbiente.get(0);
        } else {
            // Tratamento para múltiplas funções com sobrecarga (diferentes assinaturas)
            for (LocalEnv<SType> funcaoCandidata : funcaoAmbiente) {
                STyFunc tipoFuncao = (STyFunc) funcaoCandidata.getFuncType();

                // Verifica se o número de parâmetros passados coincide com o número esperado
                if (tipoFuncao.getTypes().length == argumentosPassados.size()) {
                    boolean parametrosCorretos = true;

                    // Comparação dos tipos dos parâmetros
                    for (int i = 0; i < argumentosPassados.size(); i++) {
                        Expr parametro = argumentosPassados.get(i);
                        parametro.accept(this);

                        SType tipoEsperado = tipoFuncao.getTypes()[i];
                        SType tipoPassado = types.pop();

                        // Verifica compatibilidade entre tipos
                        if (!tipoEsperado.toString().equals(tipoPassado.toString())) {
                            parametrosCorretos = false;
                            break;
                        }
                    }

                    if (parametrosCorretos) {
                        funcaoSelecionada = funcaoCandidata;
                        break;
                    }
                }
            }
        }

        if (funcaoSelecionada == null) {
            logError.add(funcCallCMD.getLine() + ", " + funcCallCMD.getColumn() + ": Função " + nomeFuncao
                    + " não encontrada com a assinatura correta");
            types.push(tyErr);
            return;
        }

        // Processamento dos parâmetros da função
        STyFunc tipoFuncaoSelecionada = (STyFunc) funcaoSelecionada.getFuncType();
        for (int i = 0; i < argumentosPassados.size(); i++) {
            Expr parametro = argumentosPassados.get(i);
            parametro.accept(this);
            SType tipoParametroEsperado = tipoFuncaoSelecionada.getTypes()[i];
            SType tipoParametroPassado = types.pop();

            if (!tipoParametroEsperado.match(tipoParametroPassado)) {
                logError.add(funcCallCMD.getLine() + ", " + funcCallCMD.getColumn() + ": Tipo do argumento " + (i + 1)
                        + " não corresponde ao esperado na função "
                        + nomeFuncao + ". Esperado: " + tipoParametroEsperado + ", Passado: " + tipoParametroPassado);
                types.push(tyErr);
                return;
            }
        }

        // Verificação dos valores de retorno da função
        List<LValue> valoresDeRetorno = funcCallCMD.getLValues();
        if (valoresDeRetorno != null && tipoFuncaoSelecionada.getReturnTypes() != null) {
            if (valoresDeRetorno.size() != tipoFuncaoSelecionada.getReturnTypes().length) {
                logError.add(funcCallCMD.getLine() + ", " + funcCallCMD.getColumn()
                        + ": Número de retornos esperado não corresponde ao solicitado na função "
                        + nomeFuncao);
                types.push(tyErr);
                return;
            }

            // Verificação dos tipos dos retornos
            for (int i = 0; i < valoresDeRetorno.size(); i++) {
                LValue retorno = valoresDeRetorno.get(i);
                SType tipoEsperado = tipoFuncaoSelecionada.getReturnTypes()[i];
                SType tipoRetorno = temp.get(retorno.getId());

                if (tipoRetorno != null && !tipoRetorno.match(tipoEsperado)) {

                    logError.add(
                            funcCallCMD.getLine() + ", " + funcCallCMD.getColumn()
                                    + ": Retorno incompatível para a variável " + retorno.getId()
                                    + ". Esperado: " + tipoEsperado + ", Obtido: " + tipoRetorno);
                    types.push(tyErr);
                } else {
                    temp.set(retorno.getId(), tipoEsperado);
                }
            }
        }
    }

    @Override
    public void visit(If if1) {
        // Avalia a expressão condicional do If
        if1.getExpr().accept(this);
        SType conditionType = types.pop();

        // Verifica se o tipo da expressão é booleano
        if (conditionType.match(tyBool)) {
            // Define a variável de controle de retorno como falsa até encontrar um comando
            // de retorno
            ret = false;

            // Avalia o bloco de comandos do If
            if1.getCmd().accept(this);
        } else {
            // Registra um erro se a condição não for booleana
            logError.add(if1.getLine() + ", " + if1.getColumn() + ": Expressão de teste do IF deve ser do tipo Bool");
            types.push(tyErr);
        }
    }

    @Override
    public void visit(IfElse ifElse) {
        // Variáveis para controlar o retorno de funções no If e Else
        boolean ifReturnStatus;
        boolean elseReturnStatus = true;

        // Avalia a expressão condicional do If
        ifElse.getExpr().accept(this);
        SType conditionType = types.pop();

        // Verifica se a expressão condicional é do tipo booleano
        if (conditionType.match(tyBool)) {
            // Define o status de retorno como falso até encontrar um comando de retorno
            ret = false;
            ifElse.getCmd().accept(this); // Avalia os comandos do bloco If
            ifReturnStatus = ret; // Armazena o resultado do bloco If em relação ao retorno

            // Se existir bloco Else, avalia os comandos desse bloco
            if (ifElse.getElseCmd() != null) {
                ret = false;
                ifElse.getElseCmd().accept(this); // Avalia os comandos do bloco Else
                elseReturnStatus = ret; // Armazena o resultado do bloco Else em relação ao retorno
            }

            // Atualiza o status de retorno, garantindo que ambos os blocos (If e Else)
            // tenham retorno
            ret = ifReturnStatus && elseReturnStatus;
        } else {
            // Registra erro caso a condição não seja do tipo booleano
            logError.add(
                    ifElse.getLine() + ", " + ifElse.getColumn() + ": Expressão de teste do IF deve ser do tipo Bool");
            types.push(tyErr);
        }
    }

    @Override
    public void visit(IntDexp i) {
        // Usa uma verificação condicional direta para determinar o tipo
        if (i != null) {
            types.push(tyInt); // Sem uso de variáveis temporárias
        }
    }

    @Override
    public void visit(Iterate iterate) {
        // Avalia a expressão de teste do laço Iterate
        iterate.getExpr().accept(this);
        SType exprType = types.pop();

        // Verifica se a expressão é do tipo booleano ou inteiro
        if (exprType.match(tyBool) || exprType.match(tyInt)) {
            // Se a expressão for válida, executa os comandos do bloco
            iterate.getCmd().accept(this);
        } else {
            // Registra um erro caso a expressão não seja dos tipos esperados
            logError.add(iterate.getLine() + ", " + iterate.getColumn()
                    + ": Expressão de teste do Iterate deve ser do tipo Bool ou Int");
            types.push(tyErr);
        }
    }

    @Override
    public void visit(LessThan lessThan) {
        // Avalia a expressão à esquerda
        lessThan.getLeft().accept(this);
        // Avalia a expressão à direita
        lessThan.getRight().accept(this);

        // Obtém os tipos resultantes das duas expressões
        SType rightType = types.pop();
        SType leftType = types.pop();

        // Verifica se ambos os tipos são inteiros ou float
        if ((rightType.match(tyInt) || rightType.match(tyFloat)) &&
                (leftType.match(tyInt) || leftType.match(tyFloat))) {
            // Empurra o tipo booleano se forem compatíveis
            types.push(tyBool);
        } else {
            // Caso contrário, registra o erro detalhando a linha e coluna
            logError.add(lessThan.getLine() + ", " + lessThan.getColumn() + ": Operador < não se aplica aos tipos "
                    + leftType.toString() + " e " + rightType.toString());
            // Empurra um tipo de erro na pilha
            types.push(tyErr);
        }
    }

    @Override
    public void visit(LValue l) {
    }

    @Override
    public void visit(LvalueCmd lvalueCmd) {
        LValue lvalue = lvalueCmd.getlValue();

        if (lvalue instanceof IdLValue) {
            // Processa a expressão que será atribuída
            lvalueCmd.getExpr().accept(this);
            SType tipoExpressao = types.pop();

            // Verifica se o tipo da expressão é um tipo de dado
            if (tipoExpressao instanceof STyData) {
                String nomeData = ((STyData) tipoExpressao).getName();

                // Se a variável não foi declarada, verifica se o tipo Data existe
                if (temp.get(lvalue.getId()) == null) {
                    if (datas.get(nomeData) == null) {
                        logError.add(lvalueCmd.getLine() + ", " + lvalueCmd.getColumn() + ": O tipo Data " + nomeData
                                + " não foi declarado");
                    } else {
                        temp.set(lvalue.getId(), tipoExpressao); // Declara a nova variável
                    }
                } else { // Se a variável já foi declarada, verifica a compatibilidade de tipos
                    SType tipoVar = temp.get(lvalue.getId());
                    if (!tipoExpressao.match(tipoVar)) {
                        logError.add(lvalueCmd.getLine() + ", " + lvalueCmd.getColumn()
                                + ": Tipos incompatíveis na atribuição "
                                + tipoExpressao);
                        types.push(tyErr);
                    }
                }
            } else { // Não é tipo Data
                if (temp.get(lvalue.getId()) == null) {
                    temp.set(lvalue.getId(), tipoExpressao); // Declara a variável com o tipo da expressão
                } else { // Verifica se o tipo da expressão casa com o tipo da variável
                    SType tipoVar = temp.get(lvalue.getId());
                    if (!tipoExpressao.match(tipoVar)) {
                        logError.add(lvalueCmd.getLine() + ", " + lvalueCmd.getColumn()
                                + ": Tipos incompatíveis na atribuição "
                                + tipoExpressao + " -> " + tipoVar);
                        types.push(tyErr);
                    }
                }
            }
        }
        // Caso o LValue seja um ArrayLValue (array ou matriz)
        else if (lvalue instanceof ArrayLValue) {
            lvalue.accept(this); // Processa o LValue do array para empilhar o tipo

            // Se a variável não foi declarada
            if (temp.get(lvalue.getId()) == null) {
                lvalueCmd.getExpr().accept(this);
                SType tipoExpressao = types.pop();
                STyArray novoArray = new STyArray(tipoExpressao); // Cria um novo array com o tipo da expressão
                temp.set(lvalue.getId(), novoArray); // Declara o array
            } else { // Se o array já foi declarado, verifica compatibilidade de tipos
                lvalueCmd.getExpr().accept(this);
                SType tipoExpressao = types.pop();
                SType tipoArray = types.pop();

                if (!tipoArray.match(tipoExpressao)) {
                    logError.add(lvalueCmd.getLine() + ", " + lvalueCmd.getColumn()
                            + ": Tipos incompatíveis na atribuição ao array "
                            + tipoExpressao + " -> " + tipoArray);
                    types.push(tyErr);
                }
            }
        }
        // Caso o LValue seja um Dot (acesso a atributo de uma estrutura)
        else if (lvalue instanceof Dot) {
            lvalueCmd.getExpr().accept(this); // Processa a expressão a ser atribuída
            lvalue.accept(this); // Processa o LValue (atributo ou dado)

            SType tipoAtributo = types.pop();
            SType tipoExpressao = types.pop();

            if (!tipoExpressao.match(tipoAtributo)) {
                Dot d = (Dot) lvalue;
                logError.add(lvalueCmd.getLine() + ", " + lvalueCmd.getColumn()
                        + ": Tipos incompatíveis na atribuição no atributo "
                        + d.getId() + " de " + d.getDataId());
                types.push(tyErr);
            }
        }
    }

    @Override
    public void visit(NameType nameType) {

        // Verifica se o tipo Data existe
        if (datas.get(nameType.getID()) != null) {
            // Empilha o tipo Data
            STyData dataType = new STyData(nameType.getID());
            types.push(dataType);
        } else {
            // Registra um erro se o tipo Data não existir
            logError.add(nameType.getLine() + ", " + nameType.getColumn()
                    + ": O tipo Data passado como parâmetro não existe: \'" + nameType.getID() + "\'.");
            types.push(tyErr);
        }
    }

    @Override
    public void visit(Neg neg) {
        // Avalia a expressão associada ao operador de negação
        neg.getExpr().accept(this);
        SType exprType = types.pop();

        // Verifica se o tipo é inteiro ou flutuante
        if (exprType.match(tyInt)) {
            types.push(tyInt);
        } else if (exprType.match(tyFloat)) {
            types.push(tyFloat);
        } else {
            // Registra um erro se o operador '-' não puder ser aplicado ao tipo
            logError.add(neg.getLine() + ", " + neg.getColumn() + "): O operador - não pode ser aplicado ao tipo "
                    + exprType.toString());
            types.push(tyErr);
        }
    }

    @Override
    public void visit(Not not) {
        // Avalia a expressão associada ao operador '!'
        not.getExpr().accept(this);

        // Recupera o tipo da expressão avaliada
        SType exprType = types.pop();

        // Verifica se o tipo é booleano
        if (exprType.match(tyBool)) {
            // Empilha o tipo booleano se for válido
            types.push(tyBool);
        } else {
            // Registra um erro se o tipo não for booleano
            logError.add(not.getLine() + ", " + not.getColumn() + ": Operador ! não se aplica ao tipo "
                    + exprType.toString());
            types.push(tyErr);
        }
    }

    @Override
    public void visit(NotEquals notEquals) {
        // Avalia as expressões do lado esquerdo e direito
        notEquals.getLeft().accept(this);
        notEquals.getRight().accept(this);

        // Recupera os tipos das expressões avaliadas
        SType rightType = types.pop();
        SType leftType = types.pop();

        // Verifica se ambos os tipos são compatíveis para a comparação
        if ((leftType.match(tyInt) && rightType.match(tyInt)) ||
                (leftType.match(tyFloat) && rightType.match(tyFloat))) {
            // Inteiros ou floats podem ser comparados
            types.push(tyBool);
        } else if (leftType.match(tyChar) && rightType.match(tyChar)) {
            // Comparação entre caracteres
            types.push(tyBool);
        } else {
            // Erro se os tipos não forem compatíveis com '!='
            logError.add(notEquals.getLine() + ", " + notEquals.getColumn()
                    + "): O operador != não pode ser aplicado aos tipos "
                    + leftType.toString() + " e " + rightType.toString());
            types.push(tyErr);
        }
    }

    @Override
    public void visit(Null n) {
        // Empilha o tipo nulo na pilha de tipos
        types.push(tyNull);
    }

    @Override
    public void visit(Print print) {
        // Avalia a expressão a ser impressa
        print.getExpression().accept(this);

        // Verifica se há elementos na pilha antes de remover
        if (!types.isEmpty()) {
            types.pop(); // Remove o tipo da expressão da pilha
        }
    }

    @Override
    public void visit(Read read) {
        // Avalia o valor associado à operação de leitura
        read.getlValue().accept(this);
    }

    @Override
    public void visit(Return return1) {
        // Inicializa uma lista para armazenar os tipos de retorno processados
        List<SType> tiposRetornados = new ArrayList<>();

        // Processa cada expressão de retorno
        for (Expr exp : return1.getExps()) {
            exp.accept(this); // Avalia a expressão e empilha seu tipo em 'types'
            tiposRetornados.add(types.pop()); // Remove o tipo da pilha e o armazena
        }

        // Verifica se o tipo da função é uma função esperada
        if (temp.getFuncType() instanceof STyFunc) {
            STyFunc funcType = (STyFunc) temp.getFuncType();
            SType[] tiposEsperados = funcType.getReturnTypes();

            // Verifica se a quantidade de retornos corresponde ao esperado
            if (tiposRetornados.size() != tiposEsperados.length) {
                logError.add(
                        return1.getLine() + ", " + return1.getColumn() + ": A função espera " + tiposEsperados.length +
                                " retorno(s), mas recebeu " + tiposRetornados.size());
                types.push(tyErr); // Empilha um erro se houver divergência
                return;
            }

            // Verifica se os tipos de retorno correspondem aos tipos esperados
            for (int i = 0; i < tiposEsperados.length; i++) {
                SType tipoRetornado = tiposRetornados.get(i);
                SType tipoEsperado = tiposEsperados[i];

                if (!tipoRetornado.match(tipoEsperado)) {

                    logError.add(return1.getLine() + ", " + return1.getColumn() + ": Tipo de retorno " + tipoRetornado
                            + "não corresponde ao tipo esperado" + tipoEsperado);
                    types.push(tyErr); // Empilha um erro se houver incompatibilidade
                    return;
                }
            }
        } else {
            // Se o tipo de retorno não for uma função, faz a correspondência diretamente
            if (!types.pop().match(temp.getFuncType())) {
                logError.add(return1.getLine() + ", " + return1.getColumn()
                        + ": O tipo de retorno não corresponde ao tipo da função");
                types.push(tyErr);
            }
        }
        ret = true; // Marca que a função retornou
    }

    @Override
    public void visit(TyBool t) {
        types.push(tyBool);
    }

    @Override
    public void visit(TyFloat t) {
        types.push(tyFloat);
    }

    @Override
    public void visit(TyChar t) {
        types.push(tyChar);
    }

    @Override
    public void visit(TyInt t) {
        types.push(tyInt);
    }

    @Override
    public void visit(Type t) {
    }

    @Override
    public void visit(ArrayLValue arrayLValue) {
        // Processa a LValue que pode ser uma variável ou uma matriz
        LValue lval = arrayLValue.getlValue();

        // Verifica se a LValue é uma variável simples (IdLValue)
        if (lval instanceof IdLValue) {
            String varId = ((IdLValue) lval).getId();
            SType tipoVar = temp.get(varId); // Busca o tipo da variável no contexto

            if (tipoVar != null && tipoVar instanceof STyArray) {
                types.push(((STyArray) tipoVar).getArg()); // Empilha o tipo do array
            } else {
                // Variável não encontrada ou não é um array
                logError.add(
                        arrayLValue.getLine() + ", " + arrayLValue.getColumn() + "A variável " + varId
                                + " não existe ou não é um array");
                types.push(tyErr); // Empilha um erro
            }
        }
        // Verifica se a LValue é uma matriz (ArrayLValue)
        else if (lval instanceof ArrayLValue) {
            processaMatriz((ArrayLValue) lval, arrayLValue); // Chama método auxiliar para tratar matrizes
        }

        // Verifica se o índice do array/matriz foi passado corretamente
        arrayLValue.getExpr().accept(this);
        SType tipoIndice = types.pop();

        // O índice deve ser um valor inteiro
        if (!tipoIndice.match(tyInt)) {
            logError.add(arrayLValue.getLine() + ", " + arrayLValue.getColumn()
                    + "O índice do array deve ser um número inteiro, não "
                    + tipoIndice);
            types.push(tyErr);
        }
    }

    @Override
    public void visit(Dot dot) {

        // Obtém o objeto do tipo de dado associado ao identificador do Dot
        Object dataObj = temp.get(dot.getDataId());

        // Verifica se o objeto é do tipo STyData
        if (dataObj instanceof STyData) {
            STyData dataType = (STyData) dataObj; // Faz o cast para STyData
            DataAttr dataAttr = datas.get(dataType.getName()); // Obtém os atributos do tipo de dado

            // Se não houver tipo de dado correspondente, adiciona um erro
            if (dataAttr == null) {

                logError.add(dot.getLine() + ", " + dot.getColumn() + ": Acesso a um tipo de data inexistente "
                        + dataType.getName());
                types.push(tyErr); // Empilha o tipo de erro na pilha de tipos
            } else {
                // Verifica se o identificador do Dot é um dos atributos do tipo de dado
                int idx = dataAttr.getVariaveis().indexOf(dot.getId());
                if (idx != -1) {
                    // Se encontrado, empilha o tipo correspondente na pilha de tipos
                    types.push(dataAttr.getTipos().get(idx));
                } else {
                    // Caso o atributo não exista, adiciona um erro
                    logError.add(dot.getLine() + ", " + dot.getColumn() + ": Atributo "
                            + dot.getId() + " eh inexistente em " + dataType.getName());
                    types.push(tyErr); // Empilha o tipo de erro
                }
            }
        }
        // Caso o tipo de dado seja encontrado diretamente na base de dados
        else if (datas.get(dot.getDataId()) != null) {
            // Obtém as variáveis e seus tipos associados ao tipo de dado
            ArrayList<String> variaveis = datas.get(dot.getDataId()).getVariaveis();
            ArrayList<SType> dataTypes = datas.get(dot.getDataId()).getTipos();
            int idx = variaveis.indexOf(dot.getId()); // Encontra o índice do atributo

            // Verifica se a variável existe dentro do tipo de dado
            if (idx != -1) {
                // Verifica se o tipo da variável é compatível com o tipo da expressão no topo
                // da pilha
                if (!types.pop().match(dataTypes.get(idx))) {
                    // Se o tipo for incompatível, adiciona um erro
                    logError.add(dot.getLine() + ", " + dot.getColumn()
                            + ": Erro de tipo no acesso a um data. Verifique o tipo do atributo "
                            + dot.getId() + " do data " + dot.getDataId());
                    types.push(tyErr); // Empilha o tipo de erro
                }
            } else {
                // Caso a variável não exista no tipo de dado, adiciona um erro
                logError.add(dot.getLine() + ", " + dot.getColumn() + ": Atributo inexistente no objeto "
                        + dot.getDataId());
                types.push(tyErr); // Empilha o tipo de erro
            }

        }
        // Caso o valor associado ao identificador seja um array de tipos de dados
        else if (temp.get(dot.getlValue().getId()) instanceof STyArray) {
            dot.getlValue().accept(this); // Aceita o visitante para verificar o array
            STyData arrayDataType = (STyData) types.pop(); // Retira o tipo de dado do array
            DataAttr dataAttr = datas.get(arrayDataType.getName()); // Obtém os atributos associados ao tipo de dado do
                                                                    // array

            // Verifica se o identificador do Dot está entre os atributos do tipo de dado
            int idx = dataAttr.getVariaveis().indexOf(dot.getId());

            if (idx != -1) {
                // Se encontrado, empilha o tipo do atributo
                types.push(dataAttr.getTipos().get(idx));
            } else {
                // Caso o atributo não exista no objeto, adiciona um erro
                logError.add(dot.getLine() + ", " + dot.getColumn() + ": Atributo inexistente no objeto "
                        + dot.getDataId());
                types.push(tyErr); // Empilha o tipo de erro
            }

        } else {
            // Se o identificador não existir, adiciona um erro informando que não pode ter
            // atributos
            logError.add(dot.getLine() + ", " + dot.getColumn() + ": A variavel "
                    + dot.getDataId() + " não existe e portanto nao pode ter atributos");
            types.push(tyErr); // Empilha o tipo de erro
        }
    }

    @Override
    public void visit(FuncCall funcCall) {
        // Determina a quantidade de parâmetros passados de forma direta
        int tamanhoParametros = (funcCall.getFFuncArgss() != null) ? funcCall.getFFuncArgss().getExps().size() : 0;

        // Pega o nome da função e a encontra diretamente
        String nomeFuncao = funcCall.getId();
        ArrayList<LocalEnv> funcFinded = (ArrayList) env.getFuncoes(nomeFuncao);
        LocalEnv<SType> function = (LocalEnv<SType>) funcFinded.stream()
                .filter(f -> ((STyFunc) f.getFuncType()).getTypes().length == tamanhoParametros)
                .findFirst().orElse(null);

        // Caso exista sobrecarga de funções, realiza a comparação dos parâmetros
        if (function == null && funcFinded.size() > 1) {
            function = funcFinded.stream()
                    .filter(f -> {
                        STyFunc funcaoBaseTipo = (STyFunc) f.getFuncType();
                        return funcaoBaseTipo.getTypes().length == tamanhoParametros &&
                                funcCall.getFFuncArgss().getExps().stream()
                                        .allMatch(exp -> {
                                            exp.accept(this);
                                            SType parametroPassado = types.pop();
                                            int index = funcCall.getFFuncArgss().getExps().indexOf(exp);
                                            return funcaoBaseTipo.getTypes()[index].toString()
                                                    .equals(parametroPassado.toString());
                                        });
                    }).findFirst().orElse(null);
        }

        if (function != null) {
            STyFunc tipoFuncao = (STyFunc) function.getFuncType();
            if (funcCall.getFFuncArgss() != null) {
                if (tamanhoParametros == tipoFuncao.getTypes().length) {
                    // Valida os tipos dos parâmetros diretamente
                    for (Expr exp : funcCall.getFFuncArgss().getExps()) {
                        exp.accept(this);
                        SType tipoParametro = tipoFuncao.getTypes()[funcCall.getFFuncArgss().getExps().indexOf(exp)];
                        SType parametroPassado = types.pop();
                        if (!tipoParametro.match(parametroPassado)) {
                            logError.add(funcCall.getLine() + ", " + funcCall.getColumn() +
                                    ": Argumentos com tipos incompatíveis. O parâmetro " + tipoFuncao.getTypesName()[0]
                                    +
                                    " deve ser do tipo " + tipoParametro + ", mas foi passado " + parametroPassado);
                            types.push(tyErr);
                        }
                    }
                } else {
                    logError.add(funcCall.getLine() + ", " + funcCall.getColumn() +
                            ": Quantidade incorreta de argumentos. Esperado " + tipoFuncao.getTypes().length +
                            ", mas recebido " + funcCall.getFFuncArgss().getExps().size());
                    types.push(tyErr);
                }
            } else if (tipoFuncao.getTypes().length > 0) {
                logError.add(funcCall.getLine() + ", " + funcCall.getColumn() +
                        ": A função " + funcCall.getId() +
                        " espera " + tipoFuncao.getTypes().length + " argumentos, mas nenhum foi passado");
                types.push(tyErr);
            }

            // Verifica se o índice da chamada da função é um IdLValue
            funcCall.getExpIndex().accept(this);
            SType tipoPosicaoRetorno = types.pop();
            if (!tipoPosicaoRetorno.match(tyInt)) {
                logError.add(funcCall.getLine() + ", " + funcCall.getColumn() +
                        ": O retorno da função só pode ser acessado com um valor inteiro, mas foi passado "
                        + tipoPosicaoRetorno);
                types.push(tyErr);
            }

            // Certifica que o valor da posição de retorno existe e é um inteiro
            if (!(funcCall.getExpIndex() instanceof IdLValue)) {
                if (funcCall.getExpIndex() instanceof IntDexp) {
                    IntDexp posicao = (IntDexp) funcCall.getExpIndex(); // Usa diretamente o ExpIndex
                    types.push(tipoFuncao.getReturnTypes()[posicao.getValue()]);
                }
            } else {
                // Empilha os dois retornos (ou múltiplos) caso seja uma variável
                for (SType returnType : tipoFuncao.getReturnTypes()) {
                    types.push(returnType);
                }
            }
        }
    }

    @Override
    public void visit(IdLValue idLValue) {
        // Verifica se a variável existe no ambiente atual
        if (temp.get(idLValue.getId()) == null) {
            // Registra um erro se a variável não foi declarada
            logError.add(idLValue.getLine() + ", " + idLValue.getColumn() + ": A variável \'" + idLValue.getId()
                    + "\' não existe!");
            types.push(tyErr);
        } else {
            // Empilha o tipo da variável encontrada
            types.push(temp.get(idLValue.getId()));
        }
    }

    @Override
    public void visit(NewExp newExp) {
        // Inicialização de variáveis auxiliares
        boolean isDataArray = newExp.getExpr() != null && newExp.getType() == null;
        boolean isSimpleArray = newExp.getExpr() != null && newExp.getType() != null;

        if (isSimpleArray) { // Caso seja um array com tipo primitivo
            // Processa o tipo base do array
            newExp.getType().accept(this);
            // Avalia o tamanho do array
            newExp.getExpr().accept(this);
            SType arraySize = types.pop();

            // Verifica se o tamanho do array é do tipo int
            if (!arraySize.match(tyInt)) {
                logError.add(newExp.getLine() + ", " + newExp.getColumn()
                        + ": Tamanho de um array deve ser int, encontrado " + arraySize);
                types.push(tyErr);
                return;
            }

            // Obtém o tipo base e cria o tipo do array
            SType arrayBaseType = types.pop();
            types.push(new STyArray(arrayBaseType));

        } else if (newExp.getType() != null) { // Caso seja uma nova instância de tipo primitivo
            // Processa o tipo
            newExp.getType().accept(this);

        } else if (!isDataArray) { // Caso seja um tipo de dado simples
            STyData dataType = new STyData(newExp.getDataName());

            // Verifica se o tipo de dado existe
            if (datas.containsKey(newExp.getDataName())) {
                types.push(dataType);
            } else {
                logError.add(newExp.getLine() + ", " + newExp.getColumn()
                        + ": Tipo de dado " + newExp.getDataName() + " não encontrado ");
                types.push(tyErr);
            }

        } else { // Caso seja um array de tipo de dado
            newExp.getExpr().accept(this);
            SType arraySize = types.pop();

            // Verifica se o tamanho do array é um int
            if (!arraySize.match(tyInt)) {
                logError.add(newExp.getLine() + ", " + newExp.getColumn()
                        + ": Tamanho de um array deve ser int, encontrado " + arraySize);
                types.push(tyErr);
                return;
            }

            // Verifica se o tipo de dado existe
            if (datas.containsKey(newExp.getDataName())) {
                STyData dataType = new STyData(newExp.getDataName());
                types.push(new STyArray(dataType));
            } else {
                logError.add(newExp.getLine() + ", " + newExp.getColumn()
                        + ": Tipo de dado " + newExp.getDataName() + " não encontrado ");
                types.push(tyErr);
            }
        }
    }

    @Override
    public void visit(FuncArgs funcArgs) {
        for (Expr expr : funcArgs.getExps()) {
            // Processa cada expressão chamando o método accept
            expr.accept(this);
        }
    }

    @Override
    public void visit(Data data) {
        // Verifica se o tipo 'data' já está registrado
        if (datas.containsKey(data.getId())) {
            logError.add(data.getLine() + ", " + data.getColumn() + ": O tipo data " + data.getId() + " já existe");
            types.push(tyErr);
            return; // Saída imediata para evitar mais processamento
        }

        // Variáveis para armazenar os campos e tipos de variáveis do tipo data
        HashSet<String> camposExistentes = new HashSet<>();
        ArrayList<String> campos = new ArrayList<>();
        ArrayList<SType> tiposCampos = new ArrayList<>();

        // Processa cada declaração dentro do 'data'
        for (Decl decl : data.getDecls()) {
            // Verifica se o campo já foi declarado
            if (!camposExistentes.add(decl.getId())) {
                logError.add(data.getLine() + ", " + data.getColumn() + ":O campo " + decl.getId() + " no tipo de data "
                        + data.getId() + " já foi definido");
                types.push(tyErr);
                return; // Saída imediata ao encontrar erro
            }

            // Aceita o tipo da declaração
            decl.getType().accept(this);

            // Pega o tipo da pilha
            SType tipoDecl = types.pop();
            campos.add(decl.getId());
            tiposCampos.add(tipoDecl);
        }

        // Registra o tipo data no mapa 'datas'
        DataAttr novoData = new DataAttr(data.getId(), campos, tiposCampos);
        datas.put(data.getId(), novoData);
    }

    @Override
    public void visit(Decl d) {
    }

    @Override
    public void visit(BoolDexp b) {
        // Empilha o tipo booleano na pilha de tipos
        types.push(tyBool);
    }

    @Override
    public void visit(ID i) {
    }

    @Override
    public void visit(BooleanValue booleanValue) {
        types.push(tyBool); // true e false
    }

    /*
     * Funções Auxiliares
     */

    private void typeArithmeticBinOp(Node node, String operatorName) {
        // Desempilha os tipos das duas expressões
        SType rightType = types.pop();
        SType leftType = types.pop();

        // Verifica se ambos os tipos são inteiros
        if (rightType.match(tyInt)) {
            if (leftType.match(tyInt)) {
                // Empilha o tipo resultante da operação
                types.push(leftType);
            } else {
                // Registra um erro se o tipo da esquerda não for compatível
                logError.add(node.getLine() + ", " + node.getColumn() + ": O operador \'" + operatorName
                        + "\' não pode ser aplicado aos tipos "
                        + leftType.toString() + " e " + rightType.toString());
                types.push(tyErr);
            }

            // Verifica se ambos os tipos são flutuantes
        } else if (rightType.match(tyFloat)) {
            if (leftType.match(tyFloat)) {
                types.push(rightType);
            } else {
                // Registra um erro se o tipo da esquerda não for compatível
                logError.add(node.getLine() + ", " + node.getColumn() + ": O operador \'" + operatorName
                        + "\' não pode ser aplicado aos tipos "
                        + leftType.toString() + " e " + rightType.toString());

                types.push(tyErr);
            }
        } else {
            // Registra um erro se o tipo da direita não for nem inteiro nem flutuante
            logError.add(node.getLine() + ", " + node.getColumn() + ": O operador \'" + operatorName
                    + "\' não pode ser aplicado aos tipos "
                    + leftType.toString() + " e " + rightType.toString());
            types.push(tyErr);
        }
    }

    // Método auxiliar para processar matrizes
    private void processaMatriz(ArrayLValue lval, ArrayLValue original) {
        String varId = lval.getlValue().getId();
        SType tipoVar = temp.get(varId); // Obtém o tipo da variável no contexto

        if (tipoVar != null && tipoVar instanceof STyArray) {
            SType argumentoArray = ((STyArray) tipoVar).getArg();

            if (argumentoArray instanceof STyArray) {
                SType tipoElemento = ((STyArray) argumentoArray).getArg();

                // Verifica se o tipo da matriz é permitido
                if (tipoElemento instanceof STyArray) {
                    logError.add(original.getLine() + ", " + original.getColumn()
                            + ": Não é permitido matrizes aninhadas no formato " + tipoVar);
                    types.push(tyErr);
                } else {
                    // Verifica o índice da linha da matriz
                    lval.getExpr().accept(this);
                    SType tipoLinha = types.pop();
                    if (!tipoLinha.match(tyInt)) {
                        logError.add(original.getLine() + ", " + original.getColumn()
                                + ": O índice da matriz deve ser um número inteiro, não " + tipoLinha);
                        types.push(tyErr);
                    } else {
                        types.push(tipoElemento); // Empilha o tipo da matriz
                    }
                }
            } else {
                types.push(argumentoArray); // Empilha o tipo do array
            }
        } else {
            logError.add(original.getLine() + ", " + original.getColumn() + ": A variável " + varId
                    + "não existe ou não é um array ");
            types.push(tyErr);
        }
    }

    // retorna a quantidade de erros
    public int getNumErrors() {
        return logError.size();
    }

    // impressão
    public void printErrors() {
        for (String s : logError) {
            System.out.println(s);
        }
    }
}
