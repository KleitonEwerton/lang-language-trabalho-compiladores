 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.Visitor;

public class Decls extends Node {

    private List<Data> datas;
    private List<Func> functions;

    public Decls(int line, int column) {
        super(line, column);
        datas = new ArrayList<Data>();
        functions = new ArrayList<Func>();
    }

    public void addFunction(Func function) {
        this.functions.add(function);
    }

    public void addData(Data data) {
        this.datas.add(data);
    }

    public List<Data> getDatas() {
        return datas;
    }

    public List<Func> getFunctions() {
        return functions;
    }

    @Override
    public String toString() {
        return "Size";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    
}
