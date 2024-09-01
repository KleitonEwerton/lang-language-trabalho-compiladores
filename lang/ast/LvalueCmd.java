package lang.ast;

import lang.visitors.Visitor;

public class LvalueCmd extends Cmd {

    private LValue lvalue;
    private Expr exp;

    public LvalueCmd(int line, int column, LValue lvalue, Expr exp) {
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

    public Expr getExp() {
        return (this.exp);
    }

    public void setExp(Expr exp) {
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
