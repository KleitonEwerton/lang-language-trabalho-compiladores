package lang.ast;

/*
 * Esta classe representa uma variável.
 * Expr
 */

import java.util.HashMap;
import visitors.Visitor;

public class Call extends Expr {

   private String l;
   private Node args;
   private Node expList;

   public Call(String id, Node xs, Node expList) {
      l = id;
      args = xs;
      this.expList = expList;
   }

   public String getName() {
      return l;
   }

   public Node getArgs() {
      return args;
   }

   public Node getExpList() {
      return expList;
   }

   public void accept(Visitor v) {
      v.visit(this);
   }

}
