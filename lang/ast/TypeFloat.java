
package lang.ast;

import lang.visitors.Visitor;

public class TypeFloat extends Type {

    public TypeFloat(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Float";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
