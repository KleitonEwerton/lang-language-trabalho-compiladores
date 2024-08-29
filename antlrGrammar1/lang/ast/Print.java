package lang.ast;

import lang.visitors.*;

public class Print extends Cmd {

    private Expr expr; // Expressão a ser impressa

    public Print(int line, int column, Expr expr) {
        super(line, column);
        this.expr = expr;
    }

    public Expr getExpression() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "print " + expr.toString() + ";";
    }
}
