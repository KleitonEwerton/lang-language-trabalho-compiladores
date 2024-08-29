package lang.ast;

import lang.visitors.*;

public class IntDexp extends Expr {

    private final int value;

    public IntDexp(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

}
