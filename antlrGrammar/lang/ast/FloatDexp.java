package lang.ast;

import lang.visitors.*;

public class FloatDexp extends Expr {

    private final float value;

    public FloatDexp(int line, int column, float value) {
        super(line, column);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}