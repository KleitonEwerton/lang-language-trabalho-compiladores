/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.Visitor;

public class Return extends Cmd {

    private List<Expr> exps = new ArrayList<>();

    public Return(int line, int column, List<Expr> exps) {
        super(line, column);
        this.exps = exps;
    }

    public List<Expr> getExps() {
        return exps;
    }

    public void setExps(List<Expr> exps) {
        this.exps = exps;
    }

    @Override
    public String toString() {
        String s = "";
        for (Expr expression : exps) {
            s += expression.toString() + ", ";
        }
        s = "return " + s;
        if (exps.size() > 0) {
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
