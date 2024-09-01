/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import java.util.List;
import java.util.stream.Collectors;

import lang.visitors.*;

public class Prog extends Node {

    private List<Node> defs;

    public Prog(int line, int column, List<Node> defs) {
        super(line, column);
        this.defs = defs;
    }

    public List<Node> getDefs() {
        return defs;
    }

    public void addFunc(Func function) {
        this.defs.add(function);
    }

    public void addData(Data data) {
        this.defs.add(data);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return defs.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

}
