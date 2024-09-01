
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

import java.util.List;

public class FuncArgs extends Expr {

    private List<Expr> exprs;

    public FuncArgs(int line, int column, List<Expr> exps) {
        super(line, column);
        this.exprs = exps;
    }

    public FuncArgs(int line, int column) {
        super(line, column);
        this.exprs = null;
    }

    public List<Expr> getExprs() {
        return exprs;
    }

    public void setExprs(List<Expr> e) {
        this.exprs = e;
    }

    public void addExp(Expr e) {
        this.exprs.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Expr Expr : exprs) {
            sb.append(Expr).append(", ");
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
