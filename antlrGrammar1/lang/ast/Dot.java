package lang.ast;

import lang.visitors.*;

public class Dot extends LValue{
    
    private LValue lValue;
    private String name;
    private String data;

    public Dot(int line, int column, LValue baseLValue, String fieldName, String data) {
        super(line, column);
        this.lValue = baseLValue;
        this.name = fieldName;
        this.data = data;
    }

    public LValue getlValue() {
        return lValue;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return lValue.toString() + "." + name;
    }
}
