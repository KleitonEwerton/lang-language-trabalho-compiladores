/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.visitors.Visitor;

public class Print extends Cmd {

    private Expr expr;// Expressão a ser impressa

    public Print(int line, int column, Expr expr) {
        super(line, column);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return " print " + expr.toString() + " ; ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}