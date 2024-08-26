package lang.ast;

import java.util.List;
import java.util.stream.Collectors;

import lang.visitors.*;

public class Prog extends Node {

    private List<Node> defs;

    public Prog(int line, int column, List<Node> defs) {
        super(line, column);
        this.defs = defs;
    }

    public List<Node> getDefs() {
        return defs;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return defs.stream()
                   .map(Object::toString)
                   .collect(Collectors.joining("\n"));
    }
}
