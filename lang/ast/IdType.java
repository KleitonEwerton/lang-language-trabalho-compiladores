
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */  
package lang.ast;

import lang.visitors.Visitor;

public class IdType extends Expr {
    private String id;

    public IdType(int line, int column, String value) {
        super(line, column);
        this.id = value;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
