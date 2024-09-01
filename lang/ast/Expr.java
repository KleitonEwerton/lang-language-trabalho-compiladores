/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

public abstract class Expr extends Node {

    private Expr Expr;

    public Expr(int line, int column) {
        super(line, column);
    }

    public Expr(int line, int column, Expr Expr) {
        super(line, column);
        this.Expr = Expr;
    }

    public Expr getExpr() {
        return Expr;
    }
}