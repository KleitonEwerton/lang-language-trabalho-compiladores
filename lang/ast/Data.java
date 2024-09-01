 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

import java.util.List;
import lang.visitors.Visitor;

public class Data extends Node {

    private String nameType;
    private List<Decl> decls;

    public Data(int line, int column, String nameType, List<Decl> decls) {
        super(line, column);
        this.nameType = nameType;
        this.decls = decls;
    }

    public void addDeclaration(Decl declaration) {
        this.decls.add(declaration);
    }

    public Decl getDeclarationByPosition(int position) {
        return this.decls.get(position);
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Decl> getDecls() {
        return this.decls;
    }

    public String getNameType() {
        return this.nameType;
    }

    public String getName() {
        return nameType;
    }

    @Override
    public String toString() {
        String s = "data " + this.nameType + " { \n";
        for (Decl declaration : decls) {
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
