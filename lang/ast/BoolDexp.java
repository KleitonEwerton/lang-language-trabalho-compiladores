/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.visitors.*;

public class BoolDexp extends Expr {
    private Boolean value;

    public BoolDexp(int line, int column, Boolean value) {
        super(line, column);
        this.value = value;
    }

    public void setValue(Boolean v) {
        this.value = v;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " " + value.toString() + " ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}