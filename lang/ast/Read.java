
package lang.ast;

import lang.visitors.Visitor;

public class Read extends Cmd {

    private LValue lvalue;

    public Read(int line, int column, LValue lvalue) {
        super(line, column);
        this.lvalue = lvalue;
    }

    @Override
    public String toString() {
        return " read " + lvalue.toString() + " ; ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public LValue getlValue() {
        return lvalue;
    }
}