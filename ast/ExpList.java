package ast;

import java.util.HashMap;
import visitors.Visitor;

public class ExpList extends Node {

    private Node exp;
    private Node expList;

    public ExpList(Node e, Node el) {
        this.exp = e;
        this.expList = el;
    }

    public ExpList(Node exp) {
        this.exp = exp;
        this.expList = null;
    }

    public Node getExp() {
        return exp;
    }

    public Node getExpList() {
        return expList;
    }

    // @Override
    public String toString() {
        if (expList != null && !(expList instanceof ExpList)) {
            return exp.toString() + ", " + expList.toString();
        }
        return exp.toString() + ", " + (expList != null ? expList.toString() : "");
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}