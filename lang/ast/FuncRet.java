/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class FuncRet extends Expr {

    private String id;
    private CallParam fCallParams;
    private Expr exp;

    public FuncRet(int line, int column, String id, CallParam fCallParams, Expr exp) {
        super(line, column);
        this.id = id;
        this.fCallParams = fCallParams;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return id + " ( " + (fCallParams != null ? fCallParams : "") + " ) [ " + exp + " ] ";
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

    public CallParam getFCallParams() {
        return fCallParams;
    }

    public void setFCallParams(CallParam fCallParams) {
        this.fCallParams = fCallParams;
    }

    public Expr getExpIndex() {
        return exp;
    }

    public void setExpIndex(Expr exp) {
        this.exp = exp;
    }
}