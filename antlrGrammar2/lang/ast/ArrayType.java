
package lang.ast;

import lang.visitors.Visitor;

public class ArrayType extends Type {

    private Type type;

    public ArrayType(int line, int column, Type type) {
        super(line, column);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return type.toString() + "[]";
    }
}
