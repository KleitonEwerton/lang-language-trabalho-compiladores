package lang.ast;

import lang.visitors.*;

public class Dot extends LValue{
    
    private LValue lValue;
    private String name;

    public Dot(int line, int column, LValue baseLValue, String fieldName) {
        super(line, column);
        this.lValue = baseLValue;
        this.name = fieldName;
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
