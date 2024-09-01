/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import java.util.List;

import lang.visitors.*;

public class Data extends Node {

    private String name;
    private List<Decl> decls;

    public Data(int line, int column, String name, List<Decl> decls) {
        super(line, column);
        this.name = name;
        this.decls = decls;
    }

    public void addDeclaration(Decl declaration) {
        this.decls.add(declaration);
    }

    public Decl getDeclarationByPosition(int position) {
        return this.decls.get(position);
    }

    public void setName(String nameType) {
        this.name = nameType;
    }

    public List<Decl> getDecls() {
        return this.decls;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return name;
    }

    @Override
    public String toString() {
        String s = "data " + this.name + " { \n";
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
