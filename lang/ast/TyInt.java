
package lang.ast;

import lang.visitors.Visitor;

public class TyInt extends Type {

    public TyInt(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
