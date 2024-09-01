
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.visitors.Visitable;
import lang.visitors.Visitor;

public class Node extends SuperNode implements Visitable {

	private int line;
	private int column;

	public Node() {
		super();
	}

	public Node(int line, int column) {
		super();
		this.line = line;
		this.column = column;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public void accept(Visitor v) {
	}

}
