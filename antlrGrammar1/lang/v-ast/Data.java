package lang.ast;

import visitors.Visitor;

public class Data extends Node {

    private String id;
    private Node decl[];

    public Data(String i, Node d[]) {
        id = i;
        decl = d;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
