
package lang.ast;

import lang.visitors.Visitor;

public class Neg extends Expr {

    private Expr exp;

    public Neg(int line, int column, Expr exp) {
        super(line, column);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return " - " + exp.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
