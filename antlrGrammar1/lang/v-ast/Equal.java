package lang.ast;

import visitors.Visitor;

public class Equal extends Expr {

    private Node l;
    private Node r;

    public Equal(Node l, Node r) {

        this.l = l;
        this.r = r;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
