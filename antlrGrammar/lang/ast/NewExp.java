 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

public class NewExp extends Expr {

    private String dataName;
    private Type type;
    private Expr expr; // Opcional, pode ser null

    public NewExp(int line, int column, Expr expr, Type type) {
        super(line, column);
        this.type = type;
        this.expr = expr;
    }

    public NewExp(int line, int column, Expr expr, String dataString) {
        super(line, column);
        this.type = null;
        this.dataName = dataString;
        this.expr = expr;
    }

    public NewExp(int line, int column, Type type) {
        super(line, column);
        this.type = type;
        this.expr = null;
    }

    public NewExp(int line, int column, String dataString) {
        super(line, column);
        this.type = null;
        this.expr = null;
        this.dataName = dataString;
    }

    public Type getType() {
        return type;
    }

    public Expr getExpr() {
        return expr;
    }

    public String getDataName() {
        return dataName;
    }

    @Override
    public String toString() {
        if (type != null) {
            return " new " + type + (expr != null ? (" [ " + expr + " ] ") : " ");
        } else
            return " new " + dataName + (expr != null ? (" [ " + expr + " ] ") : " ");
    }

}
