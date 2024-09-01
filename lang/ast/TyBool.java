
package lang.ast;

import lang.visitors.Visitor;

public class TyBool extends Type {

    public TyBool(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Bool";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
