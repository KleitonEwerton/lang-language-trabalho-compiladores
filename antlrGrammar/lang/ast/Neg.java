package lang.ast;

import lang.visitors.*;

public class Neg extends Expr {

    public Neg(int line, int column, Expr expr) {
        super(line, column, expr);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "-" + (getExpr() != null ? getExpr().toString() : "");
    }
}
