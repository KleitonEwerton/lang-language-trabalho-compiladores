package ast;

import visitors.Visitor;

public class Data extends Node {

    private String id;
    private String type;

    public Data(String i, String t) {
        id = i;
        type = t;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
