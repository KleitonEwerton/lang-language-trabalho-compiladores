/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.ast.BinOP;
import lang.ast.Expr;
import lang.visitors.Visitor;

public class Div extends BinOP {

    public Div(int lin, int col, Expr l, Expr r) {
        super(lin, col, l, r);
    }

    public String toString() {
        String s = getLeft().toString();
        String ss = getRight().toString();
        return s + " / " + ss;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
