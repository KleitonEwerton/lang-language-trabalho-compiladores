
package lang.ast;

import lang.visitors.Visitor;

public class TypeChar extends Type {

    public TypeChar(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "Char";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
