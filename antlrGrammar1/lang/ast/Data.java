package lang.ast;

import java.util.List;
import java.util.stream.Collectors;

import lang.visitors.*;

public class Data extends Node {

    private String name;
    private List<Decl> decls;

    public Data(int line, int column, String name, List<Decl> decls) {
        super(line, column);
        this.name = name;
        this.decls = decls;
    }

    public String getName() {
        return name;
    }

    public List<Decl> getDecls() {
        return decls;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    
    @Override
    public String toString() {
        String declsString = decls.stream()
                                  .map(Decl::toString)
                                  .collect(Collectors.joining(", "));
        return "data " + name + " {" + declsString + "}";
    }
}
