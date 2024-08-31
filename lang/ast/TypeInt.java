
package lang.ast;

import lang.visitors.Visitor;

public class TypeInt extends Type {

    public TypeInt(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
