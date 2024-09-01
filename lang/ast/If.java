/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class If extends Cmd {

    private Expr exp;
    private Cmd cmd;

    public If(int line, int column, Expr exp, Cmd cmd) {
        super(line, column);
        this.exp = exp;
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return " if ( " + exp.toString() + " ) " + cmd.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expr getExpr() {
        return exp;
    }

    public Cmd getCmd() {
        return cmd;
    }

}
