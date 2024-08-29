package lang.ast;

import lang.visitors.*;

public class IdLValue extends LValue {
    private String id;

    public IdLValue(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return id;
    }

}
