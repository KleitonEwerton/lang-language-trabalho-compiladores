/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
public abstract class Expr extends Node {

    private Expr expr;

    public Expr(int lin, int col) {
        super(lin, col);
    }

    public Expr(int lin, int col, Expr expr) {
        super(lin, col);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

}