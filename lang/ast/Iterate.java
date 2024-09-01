/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class Iterate extends Cmd {

    private String it;
    private Expr expr;
    private Cmd cmd;

    public Iterate(int line, int column, String it, Expr expr, Cmd cmd) {
        super(line, column);
        this.it = it;
        this.expr = expr;
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return it + " ( " + expr.toString() + " ) " + cmd.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void setExp(Expr exp) {
        this.expr = exp;
    }

    public Cmd getCmd() {
        return cmd;
    }

    public void setCmd(Cmd cmd) {
        this.cmd = cmd;
    }

    public Expr getExpr() {
        return this.expr;
    }

}
