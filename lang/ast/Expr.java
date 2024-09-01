
package lang.ast;

public abstract class Expr extends Node {

    private Expr expression;

    public Expr(int line, int column) {
        super(line, column);
    }

    public Expr(int line, int column, Expr expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expr getExpression() {
        return expression;
    }
}