
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class FuncCall extends Expr {

    private String funcName;
    private FuncArgs funcArgs;
    private Expr expr;

    public FuncCall(int line, int column, String id, FuncArgs funcArgs, Expr expr) {
        super(line, column);
        this.funcName = id;
        this.funcArgs = funcArgs;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return funcName + " ( " + (funcArgs != null ? funcArgs : "") + " ) [ " + expr + " ] ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getName() {
        return funcName;
    }

    public void setFuncName(String id) {
        this.funcName = id;
    }

    public FuncArgs getFFuncArgss() {
        return funcArgs;
    }

    public void setFFuncArgss(FuncArgs fFuncArgss) {
        this.funcArgs = fFuncArgss;
    }

    public Expr getExpIndex() {
        return expr;
    }

    public void setExpIndex(Expr exp) {
        this.expr = exp;
    }
}