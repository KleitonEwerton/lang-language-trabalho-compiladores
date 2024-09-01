
package lang.ast;

import lang.visitors.Visitor;

public class IfElse extends Cmd {

    private Expr exp;
    private Cmd cmd;
    private Cmd elseCmd;

    public IfElse(int line, int column, Expr exp, Cmd cmd, Cmd elseCmd) {
        super(line, column);
        this.exp = exp;
        this.cmd = cmd;
        this.elseCmd = elseCmd;
    }

    @Override
    public String toString() {
        return " if ( " + exp.toString() + " ) " + cmd.toString() + " else " + elseCmd.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expr getExp() {
        return exp;
    }

    public Cmd getCmd() {
        return cmd;
    }

    public Cmd getElseCmd() {
        return elseCmd;
    }
}
