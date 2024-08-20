package ast;

/*
 * Esta classe representa uma expressão negação.
 * Expr + Expr
 */

import java.util.HashMap;
import visitors.Visitor;

public class Not extends Expr {

   CExpr e;

   public Not(CExpr l) {
      e = l;
   }

   public Expr getExpr() {
      return e;
   }

   public void accept(Visitor v) {
      v.visit(this);
   }
}
