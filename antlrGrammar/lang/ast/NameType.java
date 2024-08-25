package lang.ast;

import lang.visitors.*;

public class NameType extends Type {

    private String name;

    public NameType(int line, int column, String namString) {
        super(line, column);
        this.name = namString;
    }

    public String getName() {
        return name;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }

}
