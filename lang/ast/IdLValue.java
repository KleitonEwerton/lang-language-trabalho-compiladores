
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */  
package lang.ast;

import lang.visitors.Visitor;

public class IdLValue extends LValue {

    private String id;

    public IdLValue(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public String getName() {
        return id;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
