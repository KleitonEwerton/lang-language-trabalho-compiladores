/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class NewExp extends Expr {

    private Expr exp;
    private Type type;
    private String dataName;

    public NewExp(int line, int column, Expr exp, Type type) {
        super(line, column);
        this.exp = exp;
        this.type = type;
    }

    public NewExp(int line, int column, Expr exp, String dataName) {
        super(line, column);
        this.exp = exp;
        this.type = null;
        this.dataName = dataName;
    }

    public NewExp(int line, int column, Expr exp, String dataName, Type type) {
        super(line, column);
        this.exp = exp;
        this.type = type;
        this.dataName = dataName;
    }

    public NewExp(int line, int column, Type type) {
        super(line, column);
        this.exp = null;
        this.type = type;
    }

    public NewExp(int line, int column, String dataName, Type type) {
        super(line, column);
        this.type = type;
        this.dataName = dataName;
        this.exp = null;
    }

    public NewExp(int line, int column, String dataName) {
        super(line, column);
        this.dataName = dataName;
        this.type = null;
        this.exp = null;
    }

    @Override
    public String toString() {
        if (type != null) {
            return " new " + type + (exp != null ? (" [ " + exp + " ] ") : " ");
        } else
            return " new " + dataName + (exp != null ? (" [ " + exp + " ] ") : " ");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expr getExpr() {
        return exp;
    }

    public void setExp(Expr exp) {
        this.exp = exp;
    }

    public Type getTipo() {
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
