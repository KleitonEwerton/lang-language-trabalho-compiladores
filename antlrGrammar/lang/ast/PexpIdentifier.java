 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import lang.visitors.Visitor;

public class PexpIdentifier extends LValue {

    private String id;

    public PexpIdentifier(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
