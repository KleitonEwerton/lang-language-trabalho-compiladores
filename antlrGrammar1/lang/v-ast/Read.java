package lang.ast;

import visitors.Visitor;

public class Read extends Node {

    private Node l;

    public Read(Node l) {
        this.l = l;
    }

    public void setLeft(Node n) {
        l = n;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
