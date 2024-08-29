package lang.ast;

import java.util.HashMap;
import visitors.Visitor;

public class CExpr extends Expr {

    private Expr l;
    private Expr il;

    public CExpr(Expr i, Expr il) {
        this.l = i;
        this.il = il;
    }

    public CExpr(Expr i) {
        this.l = i;
        this.il = null;
    }

    public Expr getName() {
        return l;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
