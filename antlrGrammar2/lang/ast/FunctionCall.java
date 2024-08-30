
package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.Visitor;

public class FunctionCall extends Cmd {

    private String id;
    private CallParam functionCallParams;
    private List<LValue> lvalues = new ArrayList<>();

    public FunctionCall(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public FunctionCall(int line, int column, String id, CallParam params) {
        super(line, column);
        this.id = id;
        this.functionCallParams = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CallParam getFCallParams() {
        return functionCallParams;
    }

    public void setFCallParams(CallParam fCallParams) {
        this.functionCallParams = fCallParams;
    }

    public List<LValue> getLValues() {
        return lvalues;
    }

    public void setLValues(List<LValue> lvalues) {
        this.lvalues = lvalues;
    }

    public void addLValue(LValue lvalue) {
        lvalues.add(lvalue);
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder("");
        for (LValue lvalue : lvalues) {
            bld.append(lvalue.toString() + ", ");
        }
        if (functionCallParams != null) {
            if (bld.length() > 0) {
                return id + " ( " + functionCallParams.toString() + " ) " +
                        " < " + bld.substring(0, bld.length() - 2) + " > ; ";
            }
            return id + " ( " + functionCallParams.toString() + " ) ; ";
        } else {
            if (bld.length() > 0) {
                return id + " ( " + "" + " ) " +
                        " < " + bld.substring(0, bld.length() - 2) + " > " + " ; ";
            }
            return id + " ( " + "" + " ) " + "" + " ; ";
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
