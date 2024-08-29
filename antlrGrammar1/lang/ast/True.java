package lang.ast;

import lang.visitors.*;

public class True extends Expr {

    public True(int line, int column) {
        super(line, column);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "true";
    }
}
