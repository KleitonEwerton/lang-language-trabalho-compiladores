package ast;

/*
 * Esta classe representa um valor booleano False.
 * Expr
 */

import java.util.HashMap;
import visitors.Visitor;

public class Null extends Expr {

      public Null() {

      }

      public Object getValue() {
            return null;
      }

      // @Override
      public String toString() {
            return "null";
      }

      public void accept(Visitor v) {
            // v.visit(this);
      }

}
