
package lang.ast;

import lang.visitors.Visitor;

public class NotEqual extends BinOP {

    public NotEqual(int line, int column, Expression left, Expression right) {
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
