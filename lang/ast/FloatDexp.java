/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.visitors.*;

public class FloatDexp extends LValue {

    private final float value;

    public FloatDexp(int line, int column, float value) {
        super(line, column);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }

    @Override
    public String getId() {
        return this.getId();
    }
}