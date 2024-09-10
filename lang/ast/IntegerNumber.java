package lang.ast;

import lang.visitors.Visitor;

public class IntegerNumber extends LValue {

    private int value;

    public IntegerNumber(int line, int column, int value) {
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

    @Override
    public String getId() {
        return Integer.toString(value);
    }

}
