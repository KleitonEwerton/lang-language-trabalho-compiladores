package lang.ast;

import lang.visitors.*;

public abstract class LValue extends Expr {

    public LValue(int line, int column) {
        super(line, column);
    }

    @Override
    public abstract void accept(Visitor v);
}
