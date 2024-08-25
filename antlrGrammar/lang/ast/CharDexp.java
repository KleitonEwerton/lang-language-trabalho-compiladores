package lang.ast;

import lang.visitors.*;

public class CharDexp extends Expr {

    private final char value;

    public CharDexp(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
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
