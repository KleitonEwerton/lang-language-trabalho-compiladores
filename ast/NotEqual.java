package ast;

import visitors.Visitor;

public class NotEqual extends BinOP {
    public NotEqual(Expr l, Expr r) {
        super(l, r);
    }

    public String toString() {
        String s = getLeft().toString();
        String ss = getRight().toString();
        if (getRight() instanceof Add) {
            ss = "(" + ss + ")";
        }
        return s + " != " + ss;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
