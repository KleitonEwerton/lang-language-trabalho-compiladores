package lang.ast;

import lang.ast.BinOP;
import lang.ast.Expr;
import lang.visitors.Visitor;

public class Div extends BinOP {

    public Div(int line, int column, Expr left, Expr right) {
        super(line, column, left, right);
    }

    @Override
    public String toString() {
        return (left.toString() + " / " + right.toString());
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
