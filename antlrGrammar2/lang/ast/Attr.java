package lang.ast;

import lang.visitors.Visitor;

public class Attr extends Cmd {

    private LValue lvalue;
    private Expression exp;

    public Attr(int line, int column, LValue lvalue, Expression exp) {
        super(line, column);
        this.lvalue = lvalue;
        this.exp = exp;
    }

    public void setLValue(LValue lvalue) {
        this.lvalue = lvalue;
    }

    public LValue getLValue() {
        return (this.lvalue);
    }

    public Expression getExp() {
        return (this.exp);
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return this.lvalue.toString() + " = " + this.exp.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
