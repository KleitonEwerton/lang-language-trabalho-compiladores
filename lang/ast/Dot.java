package lang.ast;

import lang.visitors.Visitor;

public class Dot extends LValue {

    private LValue lvalue;
    private String id;
    private String dataId;

    public Dot(int line, int column, LValue lvalue, String id, String dataId) {
        super(line, column);
        this.lvalue = lvalue;
        this.id = id;
        this.dataId = dataId;
    }

    public LValue getLValue() {
        return lvalue;
    }

    public String getId() {
        return id;
    }

    public String getDataId() {
        return dataId;
    }

    @Override
    public String toString() {
        return lvalue.toString() + "." + id;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
