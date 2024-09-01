
package lang.ast;

import lang.visitors.Visitor;

public class Mul extends BinOP {

    public Mul(int line, int column, Expr left, Expr right) {
        super(line, column, left, right);
    }

    @Override
    public String toString() {
        return (left.toString() + " * " + right.toString());
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
