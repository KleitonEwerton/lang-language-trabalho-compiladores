
package lang.ast;

import lang.visitors.Visitor;

public class NameType extends Type {

    private String val;

    public NameType(int line, int column, String val) {
        super(line, column);
        this.val = val;
    }

    public String getID() {
        return this.val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
