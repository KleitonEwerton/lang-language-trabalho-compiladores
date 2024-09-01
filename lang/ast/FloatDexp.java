

/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class FloatDexp extends LValue {

    private Float value;

    public FloatDexp(int line, int column, Float value) {
        super(line, column);
        this.value = value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getValue() {
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

    @Override
    public String getName() {
        return null;
    }
}
