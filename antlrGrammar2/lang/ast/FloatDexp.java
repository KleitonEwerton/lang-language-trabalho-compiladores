
package lang.ast;

import lang.visitors.Visitor;

public class FloatDexp extends LValue {

    private Float value;

    public FloatDexp(int line, int column, Float value) {
        super(line, column);
        this.value = value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " " + value.toString() + " ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getId() {
        return this.getId();
    }
}
