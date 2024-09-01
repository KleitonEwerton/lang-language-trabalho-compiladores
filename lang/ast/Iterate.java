
package lang.ast;

import lang.visitors.Visitor;

public class Iterate extends Cmd {

    private String it;
    private Expr exp;
    private Cmd cmd;

    public Iterate(int line, int column, String it, Expr exp, Cmd cmd) {
        super(line, column);
        this.it = it;
        this.exp = exp;
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return it + " ( " + exp.toString() + " ) " + cmd.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expr getExpr() {
        return exp;
    }

    public void setExp(Expr exp) {
        this.exp = exp;
    }

    public Cmd getCmd() {
        return cmd;
    }

    public void setCmd(Cmd cmd) {
        this.cmd = cmd;
    }

}
