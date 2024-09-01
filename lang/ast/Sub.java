
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class Sub extends BinOP {

    public Sub(int line, int column, Expr left, Expr right) {
        super(line, column, left, right);
    }

    public String toString() {
        String s = getLeft().toString();
        String ss = getRight().toString();
        if (getRight() instanceof Sub) {
            ss = "(" + ss + ")";
        }
        return s + " - " + ss;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
