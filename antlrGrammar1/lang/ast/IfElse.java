package lang.ast;

import lang.visitors.*;

public class IfElse extends Cmd {

    private Expr condition; // Expressão condicional
    private Cmd trueCmd; // Comando a ser executado se a condição for verdadeira
    private Cmd falseCmd; // Comando a ser executado se a condição for falsa

    public IfElse(int line, int column, Expr condition, Cmd trueCmd, Cmd falseCmd) {
        super(line, column);
        this.condition = condition;
        this.trueCmd = trueCmd;
        this.falseCmd = falseCmd;
    }

    public Expr getCondition() {
        return condition;
    }

    public Cmd getTrueCmd() {
        return trueCmd;
    }

    public Cmd getFalseCmd() {
        return falseCmd;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "if (" + condition.toString() + ") " + trueCmd.toString() + " else " + falseCmd.toString();
    }
}
