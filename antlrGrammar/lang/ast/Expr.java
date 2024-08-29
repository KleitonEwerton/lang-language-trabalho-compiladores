package lang.ast;

import lang.ast.Node;
import lang.visitors.Visitor;

/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
public abstract class Expr extends Node {

      private Expr expr;

      public Expr(int lin, int col) {
            super(lin, col);
      }

      public Expr(int lin, int col, Expr expr) {
            super(lin, col);
            this.expr = expr;
      }

      public Expr getExpr() {
            return expr;
      }

      @Override
      public void accept(Visitor v) {
            v.visit(this);
      }

}
