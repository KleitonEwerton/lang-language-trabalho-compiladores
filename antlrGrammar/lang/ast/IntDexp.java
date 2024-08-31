 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import lang.visitors.*;

public class IntDexp extends LValue {

    private Integer value;

    public IntDexp(int line, int column, Integer value) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public String getId() {
       return null;
    }

}
