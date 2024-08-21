package ast;

import visitors.Visitor;

/*
 * Esta classe representa um tipo Inteiro.
 * Expr
 */

public class TyArr extends Tipo {

   private Node argType;

   public TyArr(Node t) {
      argType = t;
   }

   public Node getTyArg() {
      return argType;
   }

   public void accept(Visitor v) {
      v.visit(this);
   }

   @Override
   public boolean match(Tipo t) {
      return t instanceof TyArr;
   }
}
