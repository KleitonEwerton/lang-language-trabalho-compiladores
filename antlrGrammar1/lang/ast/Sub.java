package lang.ast;

import java.util.HashMap;

import lang.visitors.*;
import lang.ast.*;
import lang.parser.*;

public class Sub extends BinOP {

   public Sub(int lin, int col, Expr l, Expr r) {
      super(lin, col, l, r);
   }

   public String toString() {
      String s = getLeft().toString();
      String ss = getRight().toString();
      if (getRight() instanceof Sub) {
         ss = "(" + ss + ")";
      }
      return s + " - " + ss;
   }

   public void accept(Visitor v) {
      v.visit(this);
   }

}
