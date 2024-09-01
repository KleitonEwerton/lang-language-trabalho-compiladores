
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */  
package lang.ast;

import lang.visitors.Visitor;

public class If extends Cmd {

    private Expr condition; // Expressão condicional
    private Cmd cmd; // Comando a ser executado se a condição for verdadeira

    public If(int line, int column, Expr expr, Cmd cmd) {
        super(line, column);
        this.condition = expr;
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return " if ( " + condition.toString() + " ) " + cmd.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expr getCondition() {
        return condition;
    }

    public Cmd getTrueCmd() {
        return cmd;
    }

}
