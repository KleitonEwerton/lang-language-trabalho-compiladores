package ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */

import java.util.HashMap;
import visitors.Visitor;

public class Neg extends Expr {

   private CExpr l;

   public Neg(CExpr l) {
      this.l = l;
   }

   public void accept(Visitor v) {
      v.visit(this);
   }

}
