
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

/*
 * Esta classe representa uma expressão de soma.
 * Expr + Expr
 */

import lang.visitors.*;

public class Add extends BinOP {

   public Add(int lin, int col, Expr l, Expr r) {
      super(lin, col, l, r);
   }

   @Override
   public String toString() {
      return (this.getLeft().toString() + " + " + this.getRight().toString());
   }

   public void accept(Visitor v) {
      v.visit(this);
   }

}
