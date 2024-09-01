
package lang.ast;

import lang.visitors.Visitor;

public class TyFloat extends Type {

    public TyFloat(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Float";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
