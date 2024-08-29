package lang.ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */

import java.util.HashMap;

import lang.visitors.*;
import lang.ast.*;
import lang.parser.*;

public class Mul extends BinOP {

   public Mul(int lin, int col, Expr l, Expr r) {
      super(lin, col, l, r);
   }

   public String toString() {
      String s = getLeft().toString();
      String ss = getRight().toString();
      if (getRight() instanceof Mul) {
         ss = "(" + ss + ")";
      }
      return s + " * " + ss;
   }

   public void accept(Visitor v) {
      v.visit(this);
   }

}
