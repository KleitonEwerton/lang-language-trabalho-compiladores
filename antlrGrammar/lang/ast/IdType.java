package lang.ast;

import lang.visitors.*;

public class IdType extends Type {

    private String id;

    public IdType(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return id;
    }
}
