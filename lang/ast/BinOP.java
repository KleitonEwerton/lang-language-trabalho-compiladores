 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

public class BinOP extends Expr {

    private Expr l;
    private Expr r;

    public BinOP(int lin, int col, Expr l, Expr r) {
        super(lin, col);
        this.l = l;
        this.r = r;
    }

    public void setLeft(Expr n) {
        this.l = n;
    }

    public void setRight(Expr n) {
        this.r = n;
    }

    public Expr getLeft() {
        return l;
    }

    public Expr getRight() {
        return r;
    }
}
