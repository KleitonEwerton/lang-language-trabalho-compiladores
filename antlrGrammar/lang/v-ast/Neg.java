package lang.ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */

import java.util.HashMap;
import visitors.Visitor;

public class Neg extends Node {

   private Expr l;

   public Neg(Expr l) {
      this.l = l;
   }

   public void accept(Visitor v) {
      v.visit(this);
   }

}
