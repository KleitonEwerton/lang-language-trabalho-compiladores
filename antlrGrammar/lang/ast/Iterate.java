 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import lang.visitors.*;

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
        return "iterate "+ itString + "(" + condition + ") " + cmd;
    }
}
