package lang.ast;

import lang.visitors.*;

public class LvalueCmd extends Cmd {

    private LValue lvalue; // Variável ou lvalue
    private Expr expr; // Expressão a ser atribuída

    public LvalueCmd(int line, int column, LValue lvalue, Expr expr) {
        super(line, column);
        this.lvalue = lvalue;
        this.expr = expr;
    }

    public LValue getLvalue() {
        return lvalue;
    }

    public void setLvalue(LValue lvalue) {
        this.lvalue = lvalue;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return lvalue.toString() + " = " + expr.toString() + ";";
    }
}
