/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */

import lang.visitors.*;

public class Div extends BinOP {

    public Div(int lin, int col, Expr l, Expr r) {
        super(lin, col, l, r);
    }

    public String toString() {
        String s = getLeft().toString();
        String ss = getRight().toString();
        if (getRight() instanceof Div) {
            ss = "(" + ss + ")";
        }
        return s + " / " + ss;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}