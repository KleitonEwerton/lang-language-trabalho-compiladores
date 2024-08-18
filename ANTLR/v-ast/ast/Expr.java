package ast;

/*
* Esta classe representa um comando de Impressão.
* Expr
*/
public abstract class Expr extends Node {

      public Expr(int l, int c) {
            super(l, c);
      }

      public Node getAst() {
            return this; // ou retorne um nó específico, se necessário
      }

      public abstract Expr evaluate();

}
