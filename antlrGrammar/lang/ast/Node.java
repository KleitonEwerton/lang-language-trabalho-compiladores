 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import lang.ast.SuperNode;
import lang.visitors.*;

public class Node extends SuperNode implements Visitable {

    private int line, col;

    public Node() {
        super();
    }

    public Node(int l, int c) {
        super();
        line = l;
        col = c;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return col;
    }

    @Override
    public void accept(Visitor v) {
    }
}