
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class LvalueRexp extends LValue {

    private String id;

    public LvalueRexp(int line, int column, String id) {
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

    public String getName() {
        return this.id;
    }

    public void setFuncName(String id) {
        this.id = id;
    }

}
