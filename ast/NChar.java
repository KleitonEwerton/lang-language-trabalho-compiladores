package ast;

/*
 * Esta classe representa um valor inteiro
 * Expr
 */
import java.util.HashMap;
import visitors.Visitor;

public class NChar extends Expr {

      private char l;

      public NChar(char v) {
            this.l = v;
      }

      public char getValue() {
            return l;
      }

      // @Override
      public String toString() {
            return "" + l;
      }

      public void accept(Visitor v) {
            // v.visit(this);
      }
}
