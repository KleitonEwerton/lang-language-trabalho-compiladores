package ast;

import java.util.HashMap;
import visitors.Visitor;

public class Index extends Node {
    private Node index;
    private Node indexList;

    public Index(Node i, Node il) {
        this.index = i;
        this.indexList = il;
    }

    public Index(Node index) {
        this.index = index;
        this.indexList = null;
    }

    public Node getIndex() {
        return index;
    }

    public Node getIndexList() {
        return indexList;
    }

    // @Override
    public String toString() {
        if (indexList != null && !(indexList instanceof Index)) {
            return index.toString() + ", " + indexList.toString();
        }
        return index.toString() + ", " + (indexList != null ? indexList.toString() : "");
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
