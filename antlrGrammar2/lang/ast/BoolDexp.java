package lang.ast;

import lang.visitors.Visitor;

public class BoolDexp extends Expression {

    private Boolean value;

    public BoolDexp(int line, int column, Boolean value) {
        super(line, column);
        this.value = value;
    }

    public void setValue(Boolean v) {
        this.value = v;
    }

    public Boolean getValue() {
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

}
