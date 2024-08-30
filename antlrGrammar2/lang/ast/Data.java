package lang.ast;

import java.util.List;
import lang.visitors.Visitor;

public class Data extends Node {

    private String nameType;
    private List<Decl> declarations;

    public Data(int line, int column, String nameType, List<Decl> declarations) {
        super(line, column);
        this.nameType = nameType;
        this.declarations = declarations;
    }

    public void addDeclaration(Decl declaration) {
        this.declarations.add(declaration);
    }

    public Decl getDeclarationByPosition(int position) {
        return this.declarations.get(position);
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Decl> getDeclarations() {
        return this.declarations;
    }

    public String getNameType() {
        return this.nameType;
    }

    public String getId() {
        return nameType;
    }

    @Override
    public String toString() {
        String s = "data " + this.nameType + " { \n";
        for (Decl declaration : declarations) {
            s += declaration.toString() + "\n";
        }
        s += " } ";
        return s;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
