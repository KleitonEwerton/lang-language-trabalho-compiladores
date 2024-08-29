package lang.ast;

import lang.visitors.*;

public class Iterate extends Cmd {

    private Expr condition; // Expressão condicional para o loop
    private Cmd cmd; // Comando a ser repetido enquanto a condição for verdadeira

    public Iterate(int line, int column, Expr condition, Cmd cmd) {
        super(line, column);
        this.condition = condition;
        this.cmd = cmd;
    }

    public Expr getCondition() {
        return condition;
    }

    public Cmd getCmd() {
        return cmd;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "iterate (" + condition + ") " + cmd;
    }
}
