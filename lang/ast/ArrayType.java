 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

import lang.visitors.Visitor;

public class ArrayType extends Type {

    private Type baseType;

    public ArrayType(int line, int column, Type type) {
        super(line, column);
        this.baseType = type;
    }

    public Type getBaseType() {
        return baseType;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return baseType.toString() + "[]";
    }
}
