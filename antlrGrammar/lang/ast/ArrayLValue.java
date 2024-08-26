package lang.ast;

import lang.visitors.*;

public class ArrayLValue extends LValue {

    private LValue lValue;
    private Expr expr;

    public ArrayLValue(int line, int column, LValue baseLValue, Expr index) {
        super(line, column);
        this.lValue = baseLValue;
        this.expr = index;
    }

    public LValue getlValue() {
        return lValue;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return lValue.toString() + "[" + expr.toString() + "]";
    }
    
}
