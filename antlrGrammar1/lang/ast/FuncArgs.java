package lang.ast;

import java.util.List;
import lang.visitors.*;

public class FuncArgs extends Expr {

    private List<Expr> exprs;

    public FuncArgs(int lin, int col, List<Expr> exprs) {
        super(lin, col);
        this.exprs = exprs;
    }



    public List<Expr> getExprs() {
        return exprs;
    }

    public void setExprs(List<Expr> exprs) {
        this.exprs = exprs;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
