 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import java.util.List;
import lang.visitors.*;

public class Exprs extends Expr {

    private Expr expr;

    public Exprs(int line, int column, Expr expr) {
        super(line, column);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return " ( " + expr.toString() + " ) ";
    }
    
}
