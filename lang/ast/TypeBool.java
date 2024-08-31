
package lang.ast;

import lang.visitors.Visitor;

public class TypeBool extends Type {

    public TypeBool(int line, int column) {
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
