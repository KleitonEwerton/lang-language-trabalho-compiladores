
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.Visitor;

public class FuncCall extends Cmd {
    private List<LValue> lvalues = new ArrayList<>();

    private String id;

    private CallParam fcp;

    public FuncCall(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public FuncCall(int line, int column, String id, CallParam params) {
        super(line, column);
        this.id = id;
        this.fcp = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CallParam getFCallParams() {
        return fcp;
    }

    public void setFCallParams(CallParam fCallParams) {
        this.fcp = fCallParams;
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
        if (fcp != null) {
            if (bld.length() > 0) {
                return id + " ( " + fcp.toString() + " ) " +
                        " < " + bld.substring(0, bld.length() - 2) + " > ; ";
            }
            return id + " ( " + fcp.toString() + " ) ; ";
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
