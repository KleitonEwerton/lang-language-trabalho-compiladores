/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class FuncCall extends Expr {

    private String id;
    private FuncArgs fFuncArgss;
    private Expr exp;

    public FuncCall(int line, int column, String id, FuncArgs fFuncArgss, Expr exp) {
        super(line, column);
        this.id = id;
        this.fFuncArgss = fFuncArgss;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return id + " ( " + (fFuncArgss != null ? fFuncArgss : "") + " ) [ " + exp + " ] ";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FuncArgs getFFuncArgss() {
        return fFuncArgss;
    }

    public void setFFuncArgss(FuncArgs fFuncArgss) {
        this.fFuncArgss = fFuncArgss;
    }

    public Expr getExpIndex() {
        return exp;
    }

    public void setExpIndex(Expr exp) {
        this.exp = exp;
    }
}