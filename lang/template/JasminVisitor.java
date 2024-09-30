package lang.template;

import lang.ast.*;
import lang.visitors.*;
import lang.semantic.*;
import lang.semantic.types.*;
import java.util.*;
import org.w3c.dom.Attr;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class JasminVisitor extends Visitor {

    private STGroup groupTemplate;
    private ST type, stmt, expr, template;
    private List<ST> funcs, params;

    private String fileName;

    private int loop = 0; // Loop
    private int ret = 0; // Retorno

    SemanticTypeEnv<LocalEnv<SemanticType>> env;

    LocalEnv<Pair<SemanticType, Integer>> local;

    private HashMap<String, DataAttr> datasAttr;
    private LocalEnv<SemanticType> funcObs;

    private int label = 0;

    public JasminVisitor(String fileName, SemanticTypeEnv<LocalEnv<SemanticType>> env,
            HashMap<String, DataAttr> datasAttr) {

        groupTemplate = new STGroupFile("./lang/template/jasmin.stg");
        this.fileName = fileName;
        this.datasAttr = datasAttr;
        this.env = env;
    }

    public void visit(Prog p) {

        System.out.println("Jasmin -> Prog");

        template = groupTemplate.getInstanceOf("program").add("name", fileName);

        funcs = new ArrayList<ST>();

        for (Func f : p.getFunctions()) {
            f.accept(this);
        }

        template.add("funcs", funcs);

    }

    public void visit(Add e) {

        System.out.println("Jasmin -> Add");

        ST aux = null;

        if (e.getType() instanceof SemanticTypeInt) {
            aux = groupTemplate.getInstanceOf("iadd");
        }

        e.getLeft().accept(this);
        aux.add("left_expr", expr);

        e.getRight().accept(this);

        aux.add("right_expr", expr);

        expr = aux;
    }

    public void visit(Sub e) {

        System.out.println("Jasmin -> Sub");

        ST aux = null;
        if (e.getType() instanceof SemanticTypeInt) {
            aux = groupTemplate.getInstanceOf("isub");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Mul e) {
        System.out.println("Jasmin -> Mul");
        ST aux = null;
        if (e.getType() instanceof SemanticTypeInt) {
            aux = groupTemplate.getInstanceOf("imul");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Div e) {
        System.out.println("Jasmin -> Div");
        ST aux = null;
        if (e.getType() instanceof SemanticTypeInt) {
            aux = groupTemplate.getInstanceOf("idiv");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Mod e) {
        System.out.println("Jasmin -> Mod");
        ST aux = null;
        if (e.getType() instanceof SemanticTypeInt) {
            aux = groupTemplate.getInstanceOf("imod");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(And e) {
        System.out.println("Jasmin -> And");
        ST aux = groupTemplate.getInstanceOf("and_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(LessThan e) {

        System.out.println("Jasmin -> LessThan");

        ST aux = groupTemplate.getInstanceOf("ilt_expr"); // assumi comparação de inteiros
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        aux.add("num", label++);
        expr = aux;
    }

    public void visit(Equals e) {
        System.out.println("Jasmin -> Equals");
        ST aux = null;
        if (e.getType() instanceof SemanticTypeInt)
            aux = groupTemplate.getInstanceOf("equals_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        aux.add("num", label++);
        expr = aux;

    }

    public void visit(Not e) {
        System.out.println("Jasmin -> Not");
        ST aux = groupTemplate.getInstanceOf("not_expr");
        e.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(BoolDexp b) {
        System.out.println("Jasmin -> BoolDexp");
        if (b.getValue() == true) {
            expr = groupTemplate.getInstanceOf("boolean_true");
            expr.add("value", true);
        }
        if (b.getValue() == false) {
            expr = groupTemplate.getInstanceOf("boolean_false");
            expr.add("value", false);

        }

    }

    public void visit(IntDexp i) {
        System.out.println("Jasmin -> IntDexp");
        expr = groupTemplate.getInstanceOf("int_expr");
        expr.add("value", i.getValue());
    }

    public void visit(FloatDexp e) {
        System.out.println("Jasmin -> FloatDexp");
        expr = groupTemplate.getInstanceOf("float_expr");
        expr.add("value", e.getValue());
    }

    public void visit(If e) {
        System.out.println("Jasmin -> If");
        ST ifTemplate = groupTemplate.getInstanceOf("if");

        ifTemplate.add("num", label++);

        e.getExpr().accept(this);

        ifTemplate.add("expr", expr);

        Cmd comandoIf = e.getCmd();

        if (comandoIf instanceof BlockCmd) {

            System.out.println("Jasmin -> BlockCmd");

            List<Cmd> comandosBloco = ((BlockCmd) comandoIf).getCmds();
            List<String> cmdsIf = new ArrayList<>();
            for (Cmd cmd : comandosBloco) {
                cmd.accept(this);
                cmdsIf.add(stmt.render());
            }

            // ifTemplate.add("cmd_if", cmdsIf);

        } else {
            comandoIf.accept(this);
        }

        stmt = ifTemplate;
    }

    public void visit(Iterate e) {
        System.out.println("Jasmin -> Iterate");

        ST aux = groupTemplate.getInstanceOf("while");

        aux.add("num", label++);

        e.getExpr().accept(this);

        aux.add("expr", expr);

        e.getCmd().accept(this);

        // aux.add("stmt", stmt);

        stmt = aux;
    }

    public void visit(Print e) {
        System.out.println("Jasmin -> Print");
        e.getExpression().accept(this);

        SemanticType t = e.getExpression().getType();

        if (t instanceof SemanticTypeInt) {
            stmt = groupTemplate.getInstanceOf("iprint");
            stmt.add("expr", expr);
        }

    }

    public void visit(Func f) {
        System.out.println("Jasmin -> Func");
        ST functionTemplate = groupTemplate.getInstanceOf("func");
        functionTemplate.add("name", f.getId());

        // Variáveis locais da função com informação de tipo
        // * Os parâmetros
        // * Variáveis locais
        // Lista todas as funções encontradas com o mesmo nome
        ArrayList<LocalEnv> foundFunctions = (ArrayList) env.findFunctions(f.getId());

        // Inicializa a função correta com a primeira da lista
        LocalEnv<SemanticType> currentFunctionEnv = foundFunctions.get(0);

        System.out.println("Jasmin -> Func -> Local");

        System.out.println(f.getId() + " -> " + local + " -> " + env.get(f.getId()));

        // locais, incluíndo os parâmetros
        // functionTemplate.add("decls", local.getKeys().size()); // número de váriaveis
        // !!!! AQUI DEVE SER A QUANTIDADE DE VARIAS DECLARADAS
        functionTemplate.add("decls", env.getKeys().size()); // número de váriaveis locais, incluíndo os parâmetros
        functionTemplate.add("stack", 10); // tamanho máximo da pilha. Coloquei 10, mas tem que calcular baseado no
                                           // tamanho
        // das subexpressões

        params = new ArrayList<ST>();

        if (f.getParams() != null) {

            Param paramList = f.getParams();

        }

        functionTemplate.add("params", params);

        for (Cmd command : f.getCommands()) {
            command.accept(this);
            // functionTemplate.add("stmt", stmt);
        }

        // Adiciona 'return 0;' no final da função 'main'

        // Tratamento para funções com múltiplos retornos

        // f.getReturnTypes().accept(this);

        // functionTemplate.add("return", type);

        // functionTemplate.add("stmt", stmt);

        funcs.add(functionTemplate);

    }

    public void visit(TyInt t) {
        System.out.println("Jasmin -> TyInt");
        type = groupTemplate.getInstanceOf("int_type");
    }

    public void visit(TyFloat t) {
        System.out.println("Jasmin -> TyFloat");
        type = groupTemplate.getInstanceOf("float_type");
    }

    public void visit(TyBool t) {
        System.out.println("Jasmin -> TyBool");
        type = groupTemplate.getInstanceOf("boolean_type");
    }

    public void visit(ArrayType t) {
        System.out.println("Jasmin -> ArrayType");
        ST aux = groupTemplate.getInstanceOf("array_type");
        t.getBaseType().accept(this);
        aux.add("type", type);
        type = aux;
    }

    private void processSType(SemanticType t) {
        System.out.println("Jasmin -> processSType");
        if (t instanceof SemanticTypeInt)
            type = groupTemplate.getInstanceOf("int_type");
        else if (t instanceof SemanticTypeBool)
            type = groupTemplate.getInstanceOf("boolean_type");
        else if (t instanceof SemanticTypeFloat)
            type = groupTemplate.getInstanceOf("float_type");
        else if (t instanceof SemanticArrayType) {
            ST aux = groupTemplate.getInstanceOf("array_type");
            processSType(((SemanticArrayType) t).getArg());
            aux.add("type", type);
            type = aux;
        }

    }

    @Override
    public void visit(ArrayLValue e) {
        // stmt = groupTemplate.getInstanceOf("iarray");
        // e.getType().accept(this);
        // stmt.add("expr", expr);
        // stmt.add("num", local.get(e.getId()).second());
    }

    @Override
    public void visit(LvalueCmd a) {
        System.out.println("Jasmim -> LvalueCmd");
    }

    @Override
    public void visit(FuncArgs f) {
        System.out.println("Jasmim -> FuncArgs");
    }

    @Override
    public void visit(CharDexp c) {
        System.out.println("Jasmin -> CharDexp");

        // Inicializando o template correspondente para expressões de caracteres

        // Pegando o primeiro caractere da string e convertendo para inteiro (valor
        // ASCII/Unicode)
        char charValue = c.getOriginalValue().charAt(0);
        int asciiValue = (int) charValue; // Convertendo o char para seu valor numérico

        expr = groupTemplate.getInstanceOf("char_expr");
        System.out.println("SJasmin -> CharDexp : " + charValue + " -> " + asciiValue + " " + expr);

        // Adicionando o valor numérico do caractere no template
        expr.add("value", asciiValue);
        System.out.println("S2Jasmin -> CharDexp");
        // A expressão 'expr' será usada posteriormente onde for necessário
    }

    @Override
    public void visit(Cmd c) {

        c.accept(this);

    }

    @Override
    public void visit(BlockCmd c) {

        for (Cmd cmd : c.getCmds()) {
            cmd.accept(this);
        }
    }

    @Override
    public void visit(Data d) {
        ST dataTemplate = groupTemplate.getInstanceOf("data_decl");
        dataTemplate.add("name", d.getId());

        List<ST> fields = new ArrayList<>();
        for (Decl field : d.getDecls()) {
            ST fieldDecl = groupTemplate.getInstanceOf("field_decl");
            fieldDecl.add("type", mapToJasminType(field.getType())); // Função que converte o tipo da linguagem para
                                                                     // Jasmin
            fieldDecl.add("name", field.getId());
            fields.add(fieldDecl);
        }

        dataTemplate.add("fields", fields);
        funcs.add(dataTemplate); // Adiciona ao template global
    }

    @Override
    public void visit(Decl d) {
        System.out.println("Jasmim -> Decl");
    }

    @Override
    public void visit(Dot d) {
        System.out.println("Jasmim -> Dot");
    }

    @Override
    public void visit(FuncCallCMD f) {
        System.out.println("Jasmin -> FuncCallCMD");

        f.getFFuncArgss().accept(this); // Processando chamada de função
        stmt = groupTemplate.getInstanceOf("func_call_cmd");
        stmt.add("func_call", expr); // Atribui a expressão gerada da função
    }

    @Override
    public void visit(FuncCall f) {
        System.out.println("Jasmim -> FuncCall");
    }

    @Override
    public void visit(ID i) {
        System.out.println("Jasmim -> ID");
    }

    @Override
    public void visit(IdLValue i) {
        System.out.println("Jasmim -> IdLValue");
    }

    @Override
    public void visit(IfElse i) {
        System.out.println("Jasmin -> IfElse");

        ST ifElseTemplate = groupTemplate.getInstanceOf("if_else");
        ifElseTemplate.add("num", label++); // Gerar label único para o bloco if

        i.getExpr().accept(this);
        ifElseTemplate.add("expr", expr); // Expressão condicional

        // Processar comandos do bloco if
        Cmd cmdIf = i.getCmd();

        cmdIf.accept(this);

        ifElseTemplate.add("cmd_if", stmt.render());

        // Processar comandos do bloco else (se existirem)
        if (i.getElseCmd() != null) {
            Cmd cmdElse = i.getElseCmd();
            cmdElse.accept(this);
            ifElseTemplate.add("cmd_else", stmt.render());
        }

        stmt = ifElseTemplate;
    }

    @Override
    public void visit(LValue l) {
        System.out.println("Jasmim -> LValue");
    }

    @Override
    public void visit(Neg n) {
        System.out.println("Jasmim -> Neg");
    }

    @Override
    public void visit(NameType i) {
        System.out.println("Jasmim -> NameType");
    }

    @Override
    public void visit(NewExp t) {
        System.out.println("Jasmim -> NewExp");
    }

    @Override
    public void visit(NotEquals n) {
        System.out.println("Jasmim -> NotEquals");
    }

    @Override
    public void visit(Null n) {
        System.out.println("Jasmim -> Null");
    }

    @Override
    public void visit(Param p) {

    }

    @Override
    public void visit(Read r) {
        System.out.println("Jasmim -> Read");
    }

    @Override
    public void visit(Return r) {

        System.out.println("Jasmin -> Return");

        if (r.getExps().size() == 1) {
            r.getExps().get(0).accept(this); // Avalia a expressão de retorno
        } else {
            r.getExps().get(ret).accept(this);
        }
        stmt = groupTemplate.getInstanceOf("return");
        stmt.add("expr", expr);
    }

    @Override
    public void visit(Type t) {
        System.out.println("Jasmim -> Type");
    }

    @Override
    public void visit(TyChar t) {
        System.out.println("Jasmim -> TyChar");
    }

    public String getTemplate() {
        return template.render();
    }

    private String mapToJasminType(Type t) {
        if (t instanceof TyInt) {
            return "I"; // Tipo Jasmin para inteiros
        } else if (t instanceof TyFloat) {
            return "F"; // Tipo Jasmin para floats
        } else if (t instanceof TyBool) {
            return "Z"; // Tipo Jasmin para booleanos
        } else if (t instanceof ArrayType) {
            // Para arrays, retorna o símbolo de array "[" seguido pelo tipo base
            return "[" + mapToJasminType(((ArrayType) t).getBaseType());
        } else if (t instanceof TyChar) {
            return "C"; // Tipo Jasmin para char
        }
        return "V"; // Por padrão, Void para tipos não reconhecidos
    }

}
