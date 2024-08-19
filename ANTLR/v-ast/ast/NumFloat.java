package ast;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap;

public class NumFloat extends Expr {

      private float l;

      public NumFloat(float l, float c, float v) {
            super(l, c);
            this.l = v;
      }

      public float getValue() {
            return l;
      }

      // @Override
      public String toString() {
            return "" + l;
      }

      @Override
      public Expr evaluate() {
            return this;
      }

      public float interpretF(HashMap<String, Integer> m) {
            return l;
      }
}
