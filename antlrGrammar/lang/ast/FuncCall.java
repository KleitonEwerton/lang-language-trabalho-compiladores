 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import java.util.List;
import lang.visitors.*;

public class FuncCall extends Expr {

    private String funcName;
    private Expr expr;
    private FuncArgs funcArgs;

    public FuncCall(int line, int column, String funcName, FuncArgs funcArgs, Expr expr) {
        super(line, column);
        this.funcName = funcName;
        this.funcArgs = funcArgs;
        this.expr = expr;
    }

    public String getFuncName() {
        return funcName;
    }

    public FuncArgs getArgs() {
        return funcArgs;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return funcName + " ( " + (funcArgs != null ? funcArgs : "") + " ) [ " + expr + " ] ";
    }

}
