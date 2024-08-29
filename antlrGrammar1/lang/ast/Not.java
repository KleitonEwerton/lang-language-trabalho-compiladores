package lang.ast;

import lang.visitors.*;

public class Not extends Expr {

    private Expr expr;

    public Not(int line, int column, Expr expr) {
        super(line, column);
        this.expr = expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "!" + expr.toString();
    }
}
