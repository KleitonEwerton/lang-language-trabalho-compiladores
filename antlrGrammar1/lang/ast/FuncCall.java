package lang.ast;

import java.util.List;
import lang.visitors.*;

public class FuncCall extends Expr {

    private String funcName;
    private Expr expr;
    private FuncArgs funcArgs;
    private List<Expr> arguments;

    public FuncCall(int line, int col, String funcName, List<Expr> arguments, Expr indexExpr) {
        super(line, col);
        this.funcName = funcName;
        this.arguments = arguments;
        this.expr = indexExpr;
    }

    public String getFuncName() {
        return funcName;
    }

    public FuncArgs getArgs() {
        return funcArgs;
    }

    public List<Expr> getArguments() {
        return arguments;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(funcName).append("(");
        if (arguments != null && !arguments.isEmpty()) {
            for (int i = 0; i < arguments.size(); i++) {
                sb.append(arguments.get(i).toString());
                if (i < arguments.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append(")");
        sb.append("[").append(expr.toString()).append("]");
        return sb.toString();
    }

}
