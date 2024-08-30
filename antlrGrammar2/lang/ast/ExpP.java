
package lang.ast;

import lang.visitors.Visitor;

public class ExpP extends Expression {

    private Expression exp;

    public ExpP(int line, int column, Expression exp) {
        super(line, column);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return " ( " + exp.toString() + " ) ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
