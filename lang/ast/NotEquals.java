
package lang.ast;

import lang.visitors.Visitor;

public class NotEquals extends BinOP {

    public NotEquals(int line, int column, Expr left, Expr right) {
        super(line, column, left, right);
    }

    @Override
    public String toString() {
        return left.toString() + " != " + right.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
