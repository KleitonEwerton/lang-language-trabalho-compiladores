package lang.ast;

import lang.visitors.*;

public class TyChar extends Type {

      public TyChar(int line, int column) {
            super(line, column);
      }

      public String toString() {
            return "Char";
      }

      public void accept(Visitor v) {
            v.visit(this);
      }

}
