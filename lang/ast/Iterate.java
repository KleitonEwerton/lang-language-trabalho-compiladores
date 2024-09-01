
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */  
package lang.ast;

import lang.visitors.Visitor;

public class Iterate extends Cmd {

    private String itString;
    private Expr condition; // Expressão condicional para o loop
    private Cmd cmd; // Comando a ser repetido enquanto a condição for verdadeira

    public Iterate(int line, int column, String itString, Expr condition, Cmd cmd) {
        super(line, column);
        this.itString = itString;
        this.condition = condition;
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return itString + " ( " + condition.toString() + " ) " + cmd.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expr getCondition() {
        return condition;
    }

    public void setCondition(Expr exp) {
        this.condition = exp;
    }

    public Cmd getTrueCmd() {
        return cmd;
    }

    public void setCmd(Cmd cmd) {
        this.cmd = cmd;
    }

}
