package lang.ast;

import java.util.List;
import lang.visitors.*;

public class Exprs extends Expr {

    private List<Expr> exprs;

    public Exprs(int line, int column, List<Expr> exprs) {
        super(line, column);
        this.exprs = exprs;
    }

    public List<Expr> getExprs() {
        return exprs;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return String.join(", ", exprs.stream().map(Expr::toString).toArray(String[]::new));
    }
    
}
