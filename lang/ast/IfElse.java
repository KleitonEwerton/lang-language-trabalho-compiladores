 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */  
package lang.ast;

import lang.visitors.Visitor;

public class IfElse extends Cmd {

    private Expr condition;
    private Cmd trueCmd;
    private Cmd falseCmd;

    public IfElse(int line, int column, Expr condition, Cmd trueCmd, Cmd falseCmd) {
        super(line, column);
        this.condition = condition;
        this.trueCmd = trueCmd;
        this.falseCmd = falseCmd;
    }

    @Override
    public String toString() {
        return " if ( " + condition.toString() + " ) " + trueCmd.toString() + " else " + falseCmd.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
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
}
