/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.Visitor;

public class Param extends Node {

    private List<String> id;// ID do parâmetro
    private List<Type> type;// Tipo do parâmetro

    public Param(int line, int column) {
        super(line, column);
        this.id = new ArrayList<String>();
        this.type = new ArrayList<Type>();
    }

    public Param(int line, int column, List<String> id, List<Type> type) {
        super(line, column);
        this.id = id;
        this.type = type;
    }

    public int size() {
        return id.size();
    }

    public List<String> getName() {
        return id;
    }

    public String getSingleId(int id) {
        return this.id.get(id);
    }

    public Type getSingleType(int type) {
        return this.type.get(type);
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public List<Type> getBaseType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public void addParameter(String id, Type type) {
        this.id.add(id);
        this.type.add(type);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < id.size(); i++) {
            String idAux = id.get(i).toString();
            String typeAux = type.get(i).toString();
            s += idAux.toString() + " : " + typeAux.toString() + ", ";
        }
        return s;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
