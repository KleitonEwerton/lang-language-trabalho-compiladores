
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.visitors.*;

/*
 * Esta classe representa uma expressão booleana.
 * Expr && Expr
 */
public class And extends BinOP {

    public And(int line, int column, Expr left, Expr right) {
        super(line, column, left, right);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + " && " + getRight().toString() + ")";
    }
}