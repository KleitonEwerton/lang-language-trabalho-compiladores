/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

/*
 * Esta classe representa uma Operção binária.
 * Expr [opreação] Expr
 */
import java.util.HashMap;

import lang.visitors.Visitor;

public abstract class BinOP extends Expr {

    private Expr l;
    private Expr r;

    public BinOP(int lin, int col, Expr l, Expr r) {
        super(lin, col);
        this.l = l;
        this.r = r;
    }

    public void setLeft(Expr n) {
        l = n;
    }

    public void setRight(Expr n) {
        r = n;
    }

    public Expr getLeft() {
        return l;
    }

    public Expr getRight() {
        return r;
    }

}