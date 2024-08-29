package lang.ast;

import visitors.Visitor;

public class CustomType extends Tipo {
    private String name;

    public CustomType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}