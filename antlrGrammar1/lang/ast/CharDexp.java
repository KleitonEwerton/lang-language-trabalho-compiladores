package lang.ast;

import lang.visitors.*;

public class CharDexp extends Expr {

    private String value;

    public CharDexp(int line, int column, String value) {
        super(line, column);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "'" + value + "'";
    }
}
