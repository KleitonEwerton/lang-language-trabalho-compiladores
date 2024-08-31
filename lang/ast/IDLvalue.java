
package lang.ast;

import lang.visitors.Visitor;

public class IDLvalue extends LValue {

    private String id;

    public IDLvalue(int line, int column, String id) {
        super(line, column);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
