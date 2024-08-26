package lang.ast;

public class NewExp extends Expr {
    private Type type;
    private Expr expr; // Opcional, pode ser null

    public NewExp(int line, int column, Type type, Expr expr) {
        super(line, column);
        this.type = type;
        this.expr = expr;
    }

    public Type getType() {
        return type;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        if (expr != null) {
            return "new " + type.toString() + "[" + expr.toString() + "]";
        } else {
            return "new " + type.toString();
        }
    }

}
