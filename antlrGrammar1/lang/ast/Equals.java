package lang.ast;

import lang.visitors.*;

public class Equals extends BinOP {
    
    public Equals(int line, int column, Expr left, Expr right) {
        super(line, column, left, right);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + " == " + getRight().toString() + ")";
    }

}
