/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class Not extends Expr {
    private Expr exp;

    public Not(int line, int column, Expr exp) {
        super(line, column);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return " ! " + exp.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}