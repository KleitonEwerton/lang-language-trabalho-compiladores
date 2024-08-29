package lang.ast;

import lang.visitors.*;
public class Paren extends Expr {

    private final Expr expr;

    public Paren(int line, int column, Expr expr) {
        super(line, column);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "(" + expr.toString() + ")";
    }
}
