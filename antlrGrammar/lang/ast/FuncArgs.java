 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import java.util.List;
import lang.visitors.*;

public class FuncArgs extends Expr {

    private List<Expr> exprs;

    public FuncArgs(int lin, int col) {
        super(lin, col);
        this.exprs = null;
    }

    public FuncArgs(int lin, int col, List<Expr> exprs) {
        super(lin, col);
        this.exprs = exprs;
    }

    public void addExpr(Expr e) {
        this.exprs.add(e);
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
