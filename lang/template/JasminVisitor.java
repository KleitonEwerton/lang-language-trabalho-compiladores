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
    private ST type, stmt, expr;
    private List<ST> funcs, params;

    private String fileName;

    SemanticTypeEnv<LocalEnv<Pair<SemanticType, Integer>>> env;
    LocalEnv<Pair<SemanticType, Integer>> local;

    private int label = 0;

    public JasminVisitor(String fileName, SemanticTypeEnv<LocalEnv<Pair<SemanticType, Integer>>> env) {

        groupTemplate = new STGroupFile("./lang/template/jasmin.stg");
        this.fileName = fileName;
        this.env = env;
    }

    public void visit(Prog p) {
        ST template = groupTemplate.getInstanceOf("program");

        template.add("name", fileName);

        funcs = new ArrayList<ST>();

        for (Func f : p.getFunctions()) {
            f.accept(this);
        }

        template.add("funcs", funcs);

    }

    public void visit(Add e) {
        ST aux = null;

        if (e.getType()) {
            aux = groupTemplate.getInstanceOf("iadd");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Sub e) {
        ST aux = null;
        if (e.getType() instanceof STyInt) {
            aux = groupTemplate.getInstanceOf("isub");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Mul e) {
        ST aux = null;
        if (e.getType() instanceof STyInt) {
            aux = groupTemplate.getInstanceOf("imul");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Div e) {
        ST aux = null;
        if (e.getType() instanceof STyInt) {
            aux = groupTemplate.getInstanceOf("idiv");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(Mod e) {
        ST aux = null;
        if (e.getType() instanceof STyInt) {
            aux = groupTemplate.getInstanceOf("imod");
        }
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(And e) {
        ST aux = groupTemplate.getInstanceOf("and_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        expr = aux;
    }

    public void visit(LessThan e) {
        ST aux = groupTemplate.getInstanceOf("ilt_expr"); // assumi comparação de inteiros
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        aux.add("num", label++);
        expr = aux;
    }

    public void visit(Equals e) {
        ST aux = null;
        if (e.getType() instanceof STyInt)
            aux = groupTemplate.getInstanceOf("equals_expr");
        e.getLeft().accept(this);
        aux.add("left_expr", expr);
        e.getRight().accept(this);
        aux.add("right_expr", expr);
        aux.add("num", label++);
        expr = aux;

    }

    public void visit(Not e) {
        ST aux = groupTemplate.getInstanceOf("not_expr");
        e.getExpr().accept(this);
        aux.add("expr", expr);
        expr = aux;
    }

    @Override
    public void visit(BoolDexp b) {
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
        expr = groupTemplate.getInstanceOf("int_expr");
        expr.add("value", i.getValue());
    }

    public void visit(FloatDexp e) {
        expr = groupTemplate.getInstanceOf("float_expr");
        expr.add("value", e.getValue());
    }

    public void visit(If e) {
        ST aux = groupTemplate.getInstanceOf("if");
        aux.add("num", label++);
        e.getTeste().accept(this);
        aux.add("expr", expr);
        e.getThen().accept(this);
        aux.add("thn", stmt);
        Node n = e.getElse();
        if (n != null) {
            n.accept(this);
            aux.add("els", stmt);
        }
        stmt = aux;
    }

    public void visit(Iterate e) {
        ST aux = groupTemplate.getInstanceOf("while");
        aux.add("num", label++);
        e.getTeste().accept(this);
        aux.add("expr", expr);
        e.getBody().accept(this);
        aux.add("stmt", stmt);
        stmt = aux;
    }

    public void visit(Print e) {
        e.getExpr().accept(this);
        SType t = e.getExpr().getType();
        if (t instanceof STyInt) {
            stmt = groupTemplate.getInstanceOf("iprint");
        }
        stmt.add("expr", expr);
    }

    public void visit(Func f) {

        ST fun = groupTemplate.getInstanceOf("func");
        fun.add("name", f.getID());

        // Variáveis locais da função com informação de tipo
        // * Os parâmetros
        // * Variáveis locais
        local = env.get(f.getID());

        fun.add("decls", local.getKeys().size()); // número de váriaveis locais, incluíndo os parâmetros
        fun.add("stack", 10); // tamanho máximo da pilha. Coloquei 10, mas tem que calcular baseado no tamanho
                              // das subexpressões

        f.getTipo().accept(this);
        fun.add("return", type);

        params = new ArrayList<ST>();
        for (Param p : f.getParams()) {
            p.accept(this);
        }
        fun.add("params", params);

        f.getBody().accept(this);
        fun.add("stmt", stmt);

        funcs.add(fun);

    }

    public void visit(TyInt t) {
        type = groupTemplate.getInstanceOf("int_type");
    }

    public void visit(TyFloat t) {
        type = groupTemplate.getInstanceOf("float_type");
    }

    public void visit(TyBool t) {
        type = groupTemplate.getInstanceOf("boolean_type");
    }

    public void visit(ArrayType t) {
        ST aux = groupTemplate.getInstanceOf("array_type");
        t.getTyArg().accept(this);
        aux.add("type", type);
        type = aux;
    }

    private void processSType(SemanticType t) {

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
    public void visit(ArrayLValue a) {
        System.out.println("Jasmim -> ArrayLValue");
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
        System.out.println("Jasmim -> CharDexp");
    }

    @Override
    public void visit(Cmd c) {
        System.out.println("Jasmim -> Cmd");
    }

    @Override
    public void visit(BlockCmd c) {
        System.out.println("Jasmim -> BlockCmd");
    }

    @Override
    public void visit(Data d) {
        System.out.println("Jasmim -> Data");
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
        System.out.println("Jasmim -> FuncCallCMD");
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
        System.out.println("Jasmim -> IfElse");
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
        ST aux = groupTemplate.getInstanceOf("param");
        p.getTipo().accept(this);
        aux.add("type", type);
        aux.add("name", p.getID());
        params.add(aux);
    }

    @Override
    public void visit(Read r) {
        System.out.println("Jasmim -> Read");
    }

    @Override
    public void visit(Return r) {
        System.out.println("Jasmim -> Return");
    }

    @Override
    public void visit(Type t) {
        System.out.println("Jasmim -> Type");
    }

    @Override
    public void visit(TyChar t) {
        System.out.println("Jasmim -> TyChar");
    }

}
