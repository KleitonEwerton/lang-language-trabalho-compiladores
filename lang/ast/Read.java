
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class Read extends Cmd {

    private LValue lvalue;// Lvalue onde o valor será lido

    public Read(int line, int column, LValue lvalue) {
        super(line, column);
        this.lvalue = lvalue;
    }

    @Override
    public String toString() {
        return " read " + lvalue.toString() + " ; ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public LValue getLValue() {
        return lvalue;
    }
}