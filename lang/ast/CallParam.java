
package lang.ast;

import lang.visitors.Visitor;

import java.util.List;

public class CallParam extends Expr {

    private List<Expr> exps;

    public CallParam(int line, int column, List<Expr> exps) {
        super(line, column);
        this.exps = exps;
    }

    public CallParam(int line, int column) {
        super(line, column);
        this.exps = null;
    }

    public List<Expr> getExps() {
        return exps;
    }

    public void setExps(List<Expr> e) {
        this.exps = e;
    }

    public void addExp(Expr e) {
        this.exps.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Expr expression : exps) {
            sb.append(expression).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
