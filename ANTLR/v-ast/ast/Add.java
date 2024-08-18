package ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */

import java.util.HashMap;

public class Add extends BinOP {

   public Add(int lin, int col, Expr l, Expr r) {
      super(lin, col, l, r);
   }

   public String toString() {
      String s = getLeft().toString();
      if (getLeft() instanceof Add) {
         s = "(" + s + ")";
      }
      return s + " + " + getRight().toString();
   }

   @Override
   public Expr evaluate() {
      return this;
   }

   public int interpret(HashMap<String, Integer> m) {
      return getLeft().interpret(m) + getRight().interpret(m);
   }

}
