
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

import lang.visitors.Visitor;

public class NameType extends Type {

    private String name;

    public NameType(int line, int column, String namString) {
        super(line, column);
        this.name = namString;
    }

    public String getID() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
