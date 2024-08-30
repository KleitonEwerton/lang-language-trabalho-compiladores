
package lang.ast;

import lang.visitors.Visitor;

public class FunctionReturn extends Expression {

    private String id;
    private CallParam fCallParams;
    private Expression exp;

    public FunctionReturn(int line, int column, String id, CallParam fCallParams, Expression exp) {
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

    public Expression getExpIndex() {
        return exp;
    }

    public void setExpIndex(Expression exp) {
        this.exp = exp;
    }
}