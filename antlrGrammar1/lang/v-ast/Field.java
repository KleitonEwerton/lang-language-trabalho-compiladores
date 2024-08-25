package lang.ast;

import java.lang.reflect.Type;

import visitors.Visitor;

public class Field extends Node {

    private String name;
    private Type type;

    public Field(Node i, String il) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    // @Override
    public String toString() {
        return name + " : " + type.toString();
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}