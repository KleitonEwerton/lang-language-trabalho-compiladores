package lang.ast;

import lang.visitors.Visitor;

public abstract class Cmd extends Node {

    public Cmd(int line, int column) {
        super(line, column);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}