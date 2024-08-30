
package lang.ast;

import lang.visitors.Visitor;

public class Null extends Expression {

    private String value = null;

    public Null(int line, int column) {
        super(line, column);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
