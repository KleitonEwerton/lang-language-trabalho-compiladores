 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */  
package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.Visitor;

public class FuncCallCmd extends Cmd {

    private String id; // Identificador da função
    private FuncArgs functionFuncArgss; // Lista de expressões (argumentos) para a chamada da função
    private List<LValue> lvalues = new ArrayList<>(); // Lista opcional de variáveis genéricas (se houver)

    public FuncCallCmd(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public FuncCallCmd(int line, int column, String id, FuncArgs funcArgs) {
        super(line, column);
        this.id = id;
        this.functionFuncArgss = funcArgs;
    }

    public String getName() {
        return id;
    }

    public void setFuncName(String id) {
        this.id = id;
    }

    public FuncArgs getFFuncArgss() {
        return functionFuncArgss;
    }

    public void setFFuncArgss(FuncArgs fFuncArgss) {
        this.functionFuncArgss = fFuncArgss;
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
        if (functionFuncArgss != null) {
            if (bld.length() > 0) {
                return id + " ( " + functionFuncArgss.toString() + " ) " +
                        " < " + bld.substring(0, bld.length() - 2) + " > ; ";
            }
            return id + " ( " + functionFuncArgss.toString() + " ) ; ";
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
