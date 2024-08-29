package lang.ast;

import lang.visitors.*;

public class Read extends Cmd {

    private LValue lvalue; // Lvalue onde o valor será lido

    public Read(int line, int column, LValue lvalue) {
        super(line, column);
        this.lvalue = lvalue;
    }

    public LValue getLvalue() {
        return lvalue;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "read " + lvalue.toString() + ";";
    }
}
