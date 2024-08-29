package lang.ast;

import lang.visitors.*;

public class False extends Expr {

    public False(int line, int column) {
        super(line, column);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "false";
    }
    
}
