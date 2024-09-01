/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class Dot extends LValue {

    private LValue lvalue;
    private String name;
    private String dataId;

    public Dot(int line, int column, LValue lvalue, String id, String dataId) {
        super(line, column);
        this.lvalue = lvalue;
        this.name = id;
        this.dataId = dataId;
    }

    public LValue getLValue() {
        return lvalue;
    }

    public String getName() {
        return name;
    }

    public String getDataId() {
        return dataId;
    }

    @Override
    public String toString() {
        return lvalue.toString() + "." + name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
