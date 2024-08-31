
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import lang.visitors.*;

public class ArrayLValue extends LValue {

    private LValue lValue;
    private Expr expr;

    public ArrayLValue(int line, int column, LValue baseLValue, Expr index) {
        super(line, column);
        this.lValue = baseLValue;
        this.expr = index;
    }

    public LValue getlValue() {
        return lValue;
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
        return lValue.toString() + "[" + expr.toString() + "]";
    }

    @Override
    public String getId() {
        return lValue.getId();
    }
    
}
