package lang.ast;

import lang.visitors.Visitor;

public class ArrayLValue extends LValue {

    private LValue lvalue;
    private Expression exp;

    public ArrayLValue(int line, int column, LValue lvalue, Expression exp) {
        super(line, column);
        this.lvalue = lvalue;
        this.exp = exp;
    }

    public LValue getLValue() {
        return lvalue;
    }

    public Expression getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return lvalue.toString() + " [ " + exp.toString() + " ] ";
    }

    @Override
    public String getId() {
        return lvalue.getId();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
