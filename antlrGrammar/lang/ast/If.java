package lang.ast;

/*
 * Esta classe representa um comando condicional.
 * ?(E) {C} : {C} 
 */

import lang.visitors.*;

public class If extends Cmd {

     private Expr condition; // Expressão condicional
     private Cmd cmd; // Comando a ser executado se a condição for verdadeira

     public If(int line, int column, Expr condition, Cmd cmd) {
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
          return "if (" + condition.toString() + ") " + cmd.toString();
     }
}
