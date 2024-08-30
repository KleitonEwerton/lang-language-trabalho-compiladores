
package lang.ast;

import lang.visitors.Visitor;

public abstract class LValue extends Expression {

    public abstract String getId();

    public LValue(int line, int column) {
        super(line, column);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
