/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.visitors.*;

/*
 * Esta classe representa um tipo de array.
 */

public class ArrayType extends Type {

    private Type baseType; // O tipo base do array

    public ArrayType(int line, int column, Type baseType) {
        super(line, column);
        this.baseType = baseType;
    }

    public Type getBaseType() {
        return baseType;
    }

    public void setBaseType(Type baseType) {
        this.baseType = baseType;
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