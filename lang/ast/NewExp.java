/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class NewExp extends Expr {

    private Expr expr;
    private Type type;
    private String dataName;

    public NewExp(int line, int column, Expr expr, Type type) {
        super(line, column);
        this.expr = expr;
        this.type = type;
    }

    public NewExp(int line, int column, Expr expr, String dataName) {
        super(line, column);
        this.expr = expr;
        this.type = null;
        this.dataName = dataName;
    }

    public NewExp(int line, int column, Type type) {
        super(line, column);
        this.expr = null;
        this.type = type;
    }

    public NewExp(int line, int column, String dataName) {
        super(line, column);
        this.expr = null;
        this.type = null;
        this.dataName = dataName;
    }

    @Override
    public String toString() {
        if (type != null) {
            return " new " + type + (expr != null ? (" [ " + expr + " ] ") : " ");
        } else
            return " new " + dataName + (expr != null ? (" [ " + expr + " ] ") : " ");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expr getCondition() {
        return expr;
    }

    public void setCondition(Expr exp) {
        this.expr = exp;
    }

    public Type getBaseType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
}
