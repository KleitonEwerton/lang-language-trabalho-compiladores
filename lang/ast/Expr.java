/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.semantic.types.SemanticType;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
public abstract class Expr extends Node {

    private Expr expr;
    private SemanticType type;

    public Expr(int lin, int col) {
        super(lin, col);
    }

    public Expr(int lin, int col, Expr expr) {
        super(lin, col);
        this.expr = expr;
    }

    public SemanticType getType() {
        return type;
    }

    public void setType(SemanticType type) {
        this.type = type;
    }

    public Expr getExpr() {
        return expr;
    }

}