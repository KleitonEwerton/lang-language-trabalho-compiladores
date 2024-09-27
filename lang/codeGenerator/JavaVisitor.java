package lang.codeGenerator;

import lang.ast.*;
import lang.visitors.*;
import lang.semantic.*;
import lang.semantic.types.*;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class JavaVisitor extends Visitor {

    private STGroup groupTemplate;
    private ST type, stmt, expr, variavel;
    private ST template; // Armazena todo o código do programa
    private List<ST> funcs, params, datas, declarations;
    private String fileName;

    // Indice que identifica qual o loopAtual, ou seja, se há vários iterate
    // internos
    // A ideia é pra auxiliar no nome da variavel do for de repetição
    private int loopAtual = 0;

    SemanticTypeEnv<LocalEnv<SemanticType>> env; // Ambiente do código

    // Atributos dos tipos data ==> Com o tipo semantico
    private HashMap<String, DataAttr> datasAttrib;

    // Armazena as Funcoes
    private ArrayList<Func> functionsAST;

    // Tipos de dados novos
    private HashMap<String, Data> datasAST;

    // Função atual => função que está sendo observada
    private LocalEnv<SemanticType> funcaoAtualObservada;

    // idRetorno é o indice de qual elemento será retornado quando a função
    // apresenta 2 retornos
    // para ser tratado no comando return
    private int idRetorno = 0;

    public JavaVisitor(String fileName, SemanticTypeEnv<LocalEnv<SemanticType>> env,
            HashMap<String, DataAttr> datasAttrib) {
        groupTemplate = new STGroupFile("./lang/codeGenerator/templates/java.stg");
        this.fileName = fileName;
        this.env = env;
        this.datasAttrib = datasAttrib;
        functionsAST = new ArrayList<Func>();
        datasAST = new HashMap<String, Data>();
    }

    // Partem do prog
    @Override
    public void visit(Prog p) {
        template = groupTemplate.getInstanceOf("program");
        template.add("name", fileName);
        datas = new ArrayList<ST>();
        // Aceita os tipos data para fazer a verificação de tipo
        for (Data d : p.getDatas()) {
            datasAST.put(d.getId(), d);
            d.accept(this);
        }
        template.add("datas", datas);

        funcs = new ArrayList<ST>();
        // Checa as funções
        for (Func f : p.getFunctions()) {
            functionsAST.add(f);
            f.accept(this);
        }
        template.add("funcs", funcs);
        // System.out.println(template.render()); // Imprime na tela o código em alto
        // nivel gerado
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

    // Partem do data
    @Override
    public void visit(Data d) {
        ST data = groupTemplate.getInstanceOf("data");
        data.add("name", d.getId()); // o nome do tipo data
        declarations = new ArrayList<ST>();
        DataAttr dataElement = datasAttrib.get(d.getId());
        List<Decl> listaDeclaracoes = d.getDecls();
        int indiceTipo = 0;
        declarations.clear();
        for (Decl declaration : listaDeclaracoes) {
            ST decl = groupTemplate.getInstanceOf("declaration");
            SemanticType tipo = dataElement.getDataTypes().get(indiceTipo);
            decl.add("name", declaration.getId());
            if (tipo instanceof SemanticArrayType) {
                adjustSemanticArrayType((SemanticArrayType) tipo);
            } else {
                processSemanticType(tipo);
            }
            decl.add("type", type);
            declarations.add(decl);
            indiceTipo++;
        }
        data.add("decl", declarations);
        datas.add(data);
    }

    // Partem do decl
    @Override
    public void visit(Decl d) {
        // Nao faz nada, é tratado em outra funcao
    }

    // Partem do func
    @Override
    public void visit(Func f) {

        ST fun = groupTemplate.getInstanceOf("func");
        fun.add("name", f.getId());

        // Pega todas as funções que têm o mesmo nome
        ArrayList<LocalEnv> funcFinded = (ArrayList) env.findFunctions(f.getId());

        // Função correta encontrada (por padrão, a primeira)
        LocalEnv<SemanticType> local = (LocalEnv<SemanticType>) funcFinded.get(0);

        // Verifica se há sobrecarga de função (mais de uma função com o mesmo nome)
        if (funcFinded.size() > 1) {
            for (int i = 0; i < funcFinded.size(); i++) {
                LocalEnv<SemanticType> funcaoBase = funcFinded.get(i);
                SemanticTypeFunc funcaoBaseTipo = (SemanticTypeFunc) funcaoBase.getFuncType();

                // Verifica se o número de parâmetros da função coincide com a função observada
                if (funcaoBaseTipo.getParamTypes().length == f.getParams().size()) {
                    boolean matchingParams = true;

                    // Verifica se os tipos dos parâmetros coincidem
                    for (int j = 0; j < funcaoBaseTipo.getParamTypes().length; j++) {
                        if (!funcaoBaseTipo.getParamTypes()[j].toString().equals(
                                ((Type) f.getParams().getSingleType(j)).toString())) {
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

        if (f.getReturnTypes().size() < 2) {
            if (f.getReturnTypes().size() == 0) { // void => 0 retornos
                if (f.getId().equals("main")) { // Função 'main' pra C++ tem retornar valor inteiro
                    fun.add("type", "int");
                } else {
                    fun.add("type", "void");
                }
            } else if (f.getReturnTypes().size() == 1) { // 1 retorno somente
                // A função mesmo com somente 1 retorno terá seu nome alterado
                fun = groupTemplate.getInstanceOf("func");
                String nomeFuncao = f.getId() + "_retorno_00";
                fun.add("name", nomeFuncao);
                f.getReturnTypes().get(0).accept(this); // Empilha o único tipo de retorno que será o tipo da função
                fun.add("type", type);
            }

            // Declaração das variaveis que são usadas no corpo da função
            Set<String> keys = local.getKeys();

            // Instancia a lista que vai armazenar os comandos da função
            params = new ArrayList<ST>();

            if (f.getParams() != null) {

                Param paramsList = f.getParams();

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

            for (int i = 0; i < f.getCommands().size(); i++) {
                Cmd command = f.getCommands().get(i);
                command.accept(this);
                fun.add("stmt", stmt);
            }

            // Adiciona o 'return 0;' na função main do código em C++
            if (f.getId().equals("main")) {
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
            for (int j = 0; j < f.getReturnTypes().size(); j++) {
                fun = groupTemplate.getInstanceOf("func");
                String nomeFuncao = f.getId() + "_retorno_0" + idRetorno;
                fun.add("name", nomeFuncao);

                // Empilha o tipo de retorno da função
                f.getReturnTypes().get(idRetorno).accept(this);
                fun.add("type", type);

                // Declaração das variaveis que são usadas no corpo da função
                Set<String> keys = local.getKeys();

                // Instancia a lista que vai armazenar os comandos da função
                params = new ArrayList<ST>();

                if (f.getParams() != null) {

                    Param paramsList = f.getParams();

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

                for (int i = 0; i < f.getCommands().size(); i++) {
                    Cmd command = f.getCommands().get(i);
                    command.accept(this);
                    fun.add("stmt", stmt);
                }

                funcs.add(fun);
                idRetorno++;
            }
        }
    }

    // Partem do params
    @Override
    public void visit(Param p) {
        // Nao faz nada pois já foi tratado em outra funcao
    }

    // Partem do Type
    @Override
    public void visit(ArrayType t) {
        ST aux = groupTemplate.getInstanceOf("array_type");
        t.getBaseType().accept(this);
        aux.add("type", type);
        type = aux;
    }

    // Partem do btype
    @Override
    public void visit(TyInt t) {
        type = groupTemplate.getInstanceOf("int_type");
    }

    @Override
    public void visit(TyChar t) {
        type = groupTemplate.getInstanceOf("char_type");
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
    public void visit(Type t) {
        // Nao faz nada pois já foi tratado em outra funcao
    }

    @Override
    public void visit(NameType i) { // TypeData
        type = groupTemplate.getInstanceOf("data_type");
        type.add("data", i.getID());
    }

    // Partem do cmd
    @Override
    public void visit(Cmd c) {
        c.accept(this); // Executa o comando
    }

    @Override
    public void visit(BlockCmd c) {
        for (Cmd command : c.getCmds()) { // Executa os comandos
            command.accept(this);
        }
    }

    @Override
    public void visit(If i) {
        ST aux = groupTemplate.getInstanceOf("if");
        i.getExpr().accept(this); // Empilha a expressao de verificacao do If
        aux.add("expr", expr);
        if (i.getCmd() instanceof BlockCmd) { // Lista de comandos
            BlockCmd list = (BlockCmd) i.getCmd();
            for (Cmd command : list.getCmds()) { // Executa os comandos
                command.accept(this);
                aux.add("cmd", stmt);
            }
        } else { // Processa o unico comando que tem no 'if'
            i.getCmd().accept(this);
            aux.add("cmd", stmt);
        }
        stmt = aux;
    }

    @Override
    public void visit(IfElse i) {
        ST aux = groupTemplate.getInstanceOf("if_else");
        i.getExpr().accept(this);// Empilha a expressao de verificacao do If e Else
        aux.add("expr", expr);
        if (i.getCmd() instanceof BlockCmd) { // Lista de comandos
            BlockCmd list = (BlockCmd) i.getCmd();
            for (Cmd command : list.getCmds()) { // Executa os comandos
                command.accept(this);
                aux.add("cmd", stmt);
            }
        } else { // Processa o unico comando que tem no 'if'
            i.getCmd().accept(this);
            aux.add("cmd", stmt);
        }

        if (i.getElseCmd() instanceof BlockCmd) { // Lista de comandos do else
            BlockCmd list = (BlockCmd) i.getElseCmd();
            for (Cmd command : list.getCmds()) { // Executa os comandos
                command.accept(this);
                aux.add("els", stmt);
            }
        } else { // Processa o unico comando que tem no 'else'
            i.getElseCmd().accept(this); // Executa a verificação de tipos nos comandos do else
            aux.add("els", stmt);
        }

        stmt = aux;
    }

    @Override
    public void visit(Iterate i) {
        ST aux = groupTemplate.getInstanceOf("iterate");
        i.getExpr().accept(this);
        aux.add("expr", expr);
        loopAtual++; // Incrementa o indice do loop atual
        aux.add("loopAtual", String.valueOf(loopAtual));
        if (i.getCmd() instanceof BlockCmd) { // Se for uma lista de comandos no corpo do iterate
            BlockCmd cmdList = (BlockCmd) i.getCmd();
            for (int j = 0; j < cmdList.getCmds().size(); j++) {
                cmdList.getCmds().get(j).accept(this);
                aux.add("cmd", stmt);
            }
        } else {
            i.getCmd().accept(this);
            aux.add("cmd", stmt);
        }

        loopAtual--; // Decrementa o indice do loop atual
        stmt = aux;
    }

    @Override
    public void visit(Read r) {
        stmt = groupTemplate.getInstanceOf("read");

        // Declaração das variaveis que são usadas no corpo da função
        Set<String> keys = funcaoAtualObservada.getKeys();

        SemanticType t = null;
        // Instancia as variaveis antes de usar nas operações presente no corpo da
        // função
        for (String key : keys) {
            if (key.equals(r.getlValue().toString())) {
                t = funcaoAtualObservada.get(key);
                break;
            }
        }
        // Converte a string digitada para o tipo da variavel
        if (t instanceof SemanticTypeInt) {
            stmt.add("converteTipo", "Integer.parseInt(__Scanner.nextLine())");
        } else if (t instanceof SemanticTypeFloat) {
            stmt.add("converteTipo", "Float.parseFloat(__Scanner.nextLine())");
        } else if (t instanceof SemanticTypeChar) {
            stmt.add("converteTipo", "__Scanner.nextLine().charAt(0)");
        }

        r.getlValue().accept(this);
        stmt.add("expr", expr);
    }

    @Override
    public void visit(Print i) {
        stmt = groupTemplate.getInstanceOf("print");
        i.getExpression().accept(this);
        stmt.add("expr", expr);
    }

    @Override
    public void visit(Return r) {
        if (r.getExps().size() == 1) {
            stmt = groupTemplate.getInstanceOf("return");
            // Processa a expressões de retorno da função
            r.getExps().get(0).accept(this);
            stmt.add("expr", expr);
        } else { // Quando a função tem 2 retornos
            stmt = groupTemplate.getInstanceOf("return");
            // Processa a expressões de retorno da função
            r.getExps().get(idRetorno).accept(this);
            stmt.add("expr", expr);
        }
    }

    @Override
    public void visit(LvalueCmd a) {
        // a = 2 + b + ponto.x + array[1];

        stmt = groupTemplate.getInstanceOf("attribution");

        // Variavel que vai ter os dados atribuidos nela
        LValue lvalue = a.getlValue();

        lvalue.accept(this);

        if (lvalue instanceof IdLValue) {
            stmt.add("var", expr); // lvalue
            // Empilha o tipo da expressao que sera atribuida
            a.getExpr().accept(this);
            stmt.add("expr", expr);

        } else if (lvalue instanceof ArrayLValue) {
            if (lvalue != null
                    && ((ArrayLValue) lvalue).getlValue() instanceof ArrayLValue) { // Trata o caso de matriz
                stmt.add("var", expr); // lvalue
                // Empilha o tipo da expressao que sera atribuida
                a.getExpr().accept(this);
                stmt.add("expr", expr);
            } else { // Array
                // aceita a expressao e joga pro topo da pilha. vai verificar posteriormente
                // dentro do ArrayLValue se casa
                stmt.add("var", expr); // lvalue
                // Empilha o tipo da expressao que sera atribuida
                a.getExpr().accept(this);
                stmt.add("expr", expr);
            }
        } else if (lvalue instanceof Dot) {
            // aceita a expresso e joga pro topo da pilha. vai verificar posteriormente
            // dentro do dataAccess se casa

            stmt.add("var", expr); // lvalue
            // Empilha o tipo da expressao que sera atribuida
            a.getExpr().accept(this);
            stmt.add("expr", expr);
        }

        // VERIFICA se é TypeInstanciate e sua expr chegou null
        if (expr == null && a.getExpr() instanceof NewExp) {
            // new Int, new Float, new Char;
            // Não faz nada pois a declaração da variavel de tipos primitivos já foi feita
            stmt = null;
        }
    }

    @Override
    public void visit(FuncCallCMD f) {
        // Trata chamadas de função do tipo: fat(10)<q>
        /**
         * ---- Regra cmd: ID OPEN_PARENT exps? CLOSE_PARENT (LESS_THAN lvalue (COMMA
         * lvalue)* GREATER_THAN)? SEMI # FunctionCall
         * 
         * Exemplo: divmod(5, 2)<q, r>; // Será retornada 2 valores e armazenados na
         * variavel q e r
         * pode ser tbm
         * divmod(5,2); SEM RETORNO
         */
        ST aux = groupTemplate.getInstanceOf("functionCall");
        String nomeFuncao = f.getId();
        aux.add("name", nomeFuncao);
        if (f.getLValues().size() > 0) { // Tem variaveis para atribuição
            if (f.getLValues().size() == 1) {
                f.getLValues().get(0).accept(this);
                aux.add("var1", expr);
            } else if (f.getLValues().size() == 2) {
                f.getLValues().get(0).accept(this);
                aux.add("var1", expr);
                f.getLValues().get(1).accept(this);
                aux.add("var2", expr);
            }
        } else { // Função sem retornos
            aux = groupTemplate.getInstanceOf("call");
            aux.add("name", nomeFuncao);
        }

        // Adiciona os parametros passados na chamada da função
        for (Expr exp : f.getFFuncArgss().getExps()) {
            exp.accept(this);
            aux.add("args", expr);
        }
        stmt = aux;
    }

    // Partem do exp
    @Override
    public void visit(And a) {
        ST aux = groupTemplate.getInstanceOf("and_expr");
        a.getLeft().accept(this);
        aux.add("left_expr", expr);
        a.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    // Partem do rexp
    @Override
    public void visit(LessThan l) {
        ST aux = groupTemplate.getInstanceOf("lessThan_expr");
        l.getLeft().accept(this);
        aux.add("left_expr", expr);
        l.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Equals e) {
        ST aux = groupTemplate.getInstanceOf("equallity_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(NotEquals n) {
        ST aux = groupTemplate.getInstanceOf("diff_expr");
        n.getLeft().accept(this);
        aux.add("left_expr", expr);
        n.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    // Partem do aexp
    @Override
    public void visit(Add a) {
        ST aux = groupTemplate.getInstanceOf("add_expr");
        a.getLeft().accept(this);
        aux.add("left_expr", expr);
        a.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Sub s) {
        ST aux = groupTemplate.getInstanceOf("sub_expr");
        s.getLeft().accept(this);
        aux.add("left_expr", expr);
        s.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    // Partem do mexp
    @Override
    public void visit(Mul m) {
        ST aux = groupTemplate.getInstanceOf("mult_expr");
        m.getLeft().accept(this);
        aux.add("left_expr", expr);
        m.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Div d) {
        ST aux = groupTemplate.getInstanceOf("div_expr");
        d.getLeft().accept(this);
        aux.add("left_expr", expr);
        d.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Mod m) {
        ST aux = groupTemplate.getInstanceOf("mod_expr");
        m.getLeft().accept(this);
        aux.add("left_expr", expr);
        m.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    // Partem do sexp
    @Override
    public void visit(Not n) {
        ST aux = groupTemplate.getInstanceOf("not_expr");
        n.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Neg n) {
        ST aux = groupTemplate.getInstanceOf("minus_expr");
        n.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(Null n) {
        expr = groupTemplate.getInstanceOf("null_type");
        expr.add("value", n.getValue());
    }

    @Override
    public void visit(IntDexp i) {
        expr = groupTemplate.getInstanceOf("int_expr");
        expr.add("value", i.getValue());
    }

    @Override
    public void visit(FloatDexp p) {
        expr = groupTemplate.getInstanceOf("float_expr");
        expr.add("value", p.getValue());
    }

    @Override
    public void visit(CharDexp c) {
        expr = groupTemplate.getInstanceOf("char_expr");
        expr.add("value", c.getOriginalValue());
    }

    @Override
    public void visit(NewExp t) {
        // a = new Int, a = new Ponto, a = new Ponto[8];
        ST aux = groupTemplate.getInstanceOf("typeInstanciate");

        if (t.getType() != null) {
            if (t.getExpr() != null) { // Array comum e Array de data
                if (t.getType() instanceof ArrayType) { // Matriz
                    // Troca o modo de criação da matriz
                    // Na Lang: ... new Char[][5]
                    // Outras linguagens: ... new Char[5][]
                    ArrayType tArray = (ArrayType) t.getType();
                    ST lvalue = groupTemplate.getInstanceOf("lvalue");
                    tArray.getBaseType().accept(this); // Converte o tipo do array pro padrao java: Ex: Char -> char
                    lvalue.add("name", type);
                    ST arrayAccess = groupTemplate.getInstanceOf("array_access");
                    // Empilha o numero de linhas da matriz
                    t.getExpr().accept(this);
                    arrayAccess.add("expr", expr);
                    lvalue.add("array", arrayAccess);
                    aux.add("type", lvalue); // Adiciona o numero de linhas na frente da declaração

                    // Adiciona uma expressão vazia somente para ter os colchetes das colunas na
                    // matriz
                    aux.add("expr", "");

                    // Empilha o tipo do array
                    // t.getType().accept(this);
                    // aux.add("type", type);
                } else { // Array
                    // Empilha o tipo do array
                    t.getType().accept(this);
                    aux.add("type", type);

                    // Empilha o tamanho do array
                    t.getExpr().accept(this);
                    aux.add("expr", expr);
                }
            } else { // new Int; -- new Float; -- new Char; -- new data;

                if (t.getType() instanceof NameType) { // Se for do tipo Data Adiciona
                    t.getType().accept(this);
                    aux.add("type", type);
                } else { // new Int; -- new Float; -- new Char
                    // Nao faz nada pois a variavel já é instanciada quando as funções são validadas
                    // em program
                    aux = null;
                }
            }
        }

        if (t.getType() == null && (t.getDataName() != null)) {
            aux.add("type", t.getDataName());
        }

        expr = aux;
    }

    @Override
    public void visit(FuncCall f) {
        /************************************************************************************************
         * MESMO QUE TENHA SOMENTE 1 RETORNO, ELA DEVE SER CHAMADA ASSIM: fat(num−1)[0]
         * *
         * Regra *
         * pexp: ID OPEN_PARENT exps? CLOSE_PARENT OPEN_BRACKET exp CLOSE_BRACKET #
         * FunctionReturn *
         * // Como retorna 2 valores, logo precisa do funcao(parametros)[indice]
         * Exemplo: fat(num−1)[0] *
         ***********************************************************************************************/
        ST aux = groupTemplate.getInstanceOf("functionReturn");
        String nomeFuncao = f.getId();
        aux.add("name", nomeFuncao);
        f.getExpIndex().accept(this); // Coloca o indice do retorno na expressao
        aux.add("expr", expr);

        // Adiciona os parametros passados na chamada da função
        for (Expr exp : f.getFFuncArgss().getExps()) {
            exp.accept(this);
            aux.add("args", expr);
        }
        expr = aux;
    }

    // Partem do lvalue
    @Override
    public void visit(LValue l) {
        /* Nao faz nada */
    }

    @Override
    public void visit(ID i) {
        /* Nao faz nada */
    }

    @Override
    public void visit(IdLValue i) {
        expr = groupTemplate.getInstanceOf("lvalue");
        expr.add("name", i.getId());
    }

    @Override
    public void visit(Dot d) {
        expr = groupTemplate.getInstanceOf("lvalue");
        expr.add("name", d.toString());
    }

    @Override
    public void visit(ArrayLValue a) {
        expr = groupTemplate.getInstanceOf("lvalue");
        expr.add("name", a.toString());
    }

    // Partem do exps
    @Override
    public void visit(FuncArgs f) {
        for (Expr exp : f.getExps()) {
            exp.accept(this);
        }
    }

    ////////////// Métodos ///////////
    private void processSemanticType(SemanticType t) {
        if (t instanceof SemanticTypeInt)
            type = groupTemplate.getInstanceOf("int_type");
        else if (t instanceof SemanticTypeBool)
            type = groupTemplate.getInstanceOf("boolean_type");
        else if (t instanceof SemanticTypeFloat)
            type = groupTemplate.getInstanceOf("float_type");
        else if (t instanceof SemanticTypeChar)
            type = groupTemplate.getInstanceOf("char_type");
        else if (t instanceof SemanticTypeData) {
            type = groupTemplate.getInstanceOf("data_type");
            type.add("data", ((SemanticTypeData) t).getDataName());
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

    @Override
    public void visit(BoolDexp b) {
        expr = groupTemplate.getInstanceOf("boolean_expr");
        expr.add("value", b.getValue());
    }

}
