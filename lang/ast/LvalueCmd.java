
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

import lang.visitors.Visitor;

public class LvalueCmd extends Cmd {

    private LValue lvalue; // Variável ou lvalue
    private Expr expr; // Expressão a ser atribuída

    public LvalueCmd(int line, int column, LValue lvalue, Expr expr) {
        super(line, column);
        this.lvalue = lvalue;
        this.expr = expr;
    }

    public void setLValue(LValue lvalue) {
        this.lvalue = lvalue;
    }

    public LValue getLValue() {
        return (this.lvalue);
    }

    public Expr getCondition() {
        return (this.expr);
    }

    public void setCondition(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return this.lvalue.toString() + " = " + this.getCondition().toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
