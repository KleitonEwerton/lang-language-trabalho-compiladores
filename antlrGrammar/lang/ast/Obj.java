 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import lang.visitors.Visitor;

public class Obj extends LValue {

    private String id;
    private Object content;
    private Type tipo;

    public Obj(int line, int column) {
        super(line, column);
        id = "";
        tipo = null;
    }

    public Obj(int line, int column, Type tipo) {
        super(line, column);
        this.id = null;
        this.tipo = tipo;
    }

    public Obj(int line, int column, String id, Type tipo) {
        super(line, column);
        this.id = id;
        this.tipo = tipo;
    }

    public String getId() {
        return this.id;
    }

    public Type getType() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(Type tipo) {
        this.tipo = tipo;
    }

    public Object getContent() {
        return this.content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "" + content + " (" + tipo.toString() + ")";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
