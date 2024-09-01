
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.Visitor;

public class Return extends Cmd {

    private List<Expr> exprs = new ArrayList<>();// Lista de expressões a serem retornadas

    public Return(int line, int column, List<Expr> exps) {
        super(line, column);
        this.exprs = exps;
    }

    public List<Expr> getExprs() {
        return exprs;
    }

    public void setExprs(List<Expr> exps) {
        this.exprs = exps;
    }

    @Override
    public String toString() {
        String s = "";
        for (Expr Expr : exprs) {
            s += Expr.toString() + ", ";
        }
        s = "return " + s;
        if (exprs.size() > 0) {
            s = s.substring(0, s.length() - 2);
        }
        s += ";";
        return s;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
