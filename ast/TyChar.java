package ast;

import visitors.Visitor;

public class TyChar extends Tipo {

      public TyChar() {
      }

      public boolean match(Tipo t) {
            return t instanceof TyChar;
      }

      public String toString() {
            return "Char";
      }

      public void accept(Visitor v) {
            v.visit(this);
      }

}
