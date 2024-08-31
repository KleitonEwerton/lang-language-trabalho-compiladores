
package lang.ast;

public abstract class Expression extends Node {

    private Expression expression;

    public Expression(int line, int column) {
        super(line, column);
    }

    public Expression(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}