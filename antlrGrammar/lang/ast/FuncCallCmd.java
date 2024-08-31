 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import java.util.List;

import lang.visitors.*;

public class FuncCallCmd extends Cmd {

    private String id; // Identificador da função
    private FuncArgs funcArgs; // Lista de expressões (argumentos) para a chamada da função
    private List<LValue> lvalues; // Lista opcional de variáveis genéricas (se houver)

    public FuncCallCmd(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public FuncCallCmd(int line, int column, String id, FuncArgs params) {
        super(line, column);
        this.id = id;
        this.funcArgs = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FuncArgs getFuncArgs() {
        return funcArgs;
    }

    public List<LValue> getLvalues() {
        return lvalues;
    }

    public void setLvalues(List<LValue> lvalues) {
        this.lvalues = lvalues;
    }

    public void addLValue(LValue lvalue) {
        lvalues.add(lvalue);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder("");
        for (LValue lvalue : lvalues) {
            bld.append(lvalue.toString() + ", ");
        }
        if (funcArgs != null) {
            if (bld.length() > 0) {
                return id + " ( " + funcArgs.toString() + " ) " +
                        " < " + bld.substring(0, bld.length() - 2) + " > ; ";
            }
            return id + " ( " + funcArgs.toString() + " ) ; ";
        } else {
            if (bld.length() > 0) {
                return id + " ( " + "" + " ) " +
                        " < " + bld.substring(0, bld.length() - 2) + " > " + " ; ";
            }
            return id + " ( " + "" + " ) " + "" + " ; ";
        }
    }
}
