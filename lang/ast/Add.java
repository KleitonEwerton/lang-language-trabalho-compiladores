package lang.ast;

import lang.visitors.Visitor;

public class Add extends BinOP {

    public Add(int line, int column, Expr left, Expr right) {
        super(line, column, left, right);
    }

    @Override
    public String toString() {
        return (this.left.toString() + " + " + this.right.toString());
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
