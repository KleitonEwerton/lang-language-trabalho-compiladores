
package lang.ast;

import lang.visitors.Visitor;

public class ExpParenthesis extends Expression {

    private Expression exp;

    public ExpParenthesis(int line, int column, Expression exp) {
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
