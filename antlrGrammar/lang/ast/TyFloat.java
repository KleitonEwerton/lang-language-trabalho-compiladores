 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import lang.visitors.*;

/*
 * Esta classe representa um tipo Float.
 * Expr
 */
public class TyFloat extends Type {

      public TyFloat(int line, int column) {
            super(line, column);
      }

      public String toString() {
            return "Float";
      }

      public void accept(Visitor v) {
            v.visit(this);
      }
}
