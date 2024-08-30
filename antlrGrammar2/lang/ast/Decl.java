package lang.ast;

import lang.visitors.Visitor;

public class Decl extends Node {

    String id;
    Type type;

    public Decl(int line, int column, String id, Type type) {
        super(line, column);
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + " :: " + type + "; ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
