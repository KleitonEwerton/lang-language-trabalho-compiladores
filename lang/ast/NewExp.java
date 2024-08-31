
package lang.ast;

import lang.visitors.Visitor;

public class NewExp extends Expression {

    private Expression exp;
    private Type type;
    private String dataName;

    public NewExp(int line, int column, Expression exp, Type type) {
        super(line, column);
        this.exp = exp;
        this.type = type;
    }

    public NewExp(int line, int column, Expression exp, String dataName) {
        super(line, column);
        this.exp = exp;
        this.type = null;
        this.dataName = dataName;
    }

    public NewExp(int line, int column, Type type) {
        super(line, column);
        this.exp = null;
        this.type = type;
    }

    public NewExp(int line, int column, String dataName) {
        super(line, column);
        this.exp = null;
        this.type = null;
        this.dataName = dataName;
    }

    @Override
    public String toString() {
        if (type != null) {
            return " new " + type + (exp != null ? (" [ " + exp + " ] ") : " ");
        } else
            return " new " + dataName + (exp != null ? (" [ " + exp + " ] ") : " ");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
}
