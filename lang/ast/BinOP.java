package lang.ast;

public class BinOP extends Expr {

    protected Expr left;
    protected Expr right;

    public BinOP(int line, int column, Expr left, Expr right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

    public void setLeft(Expr left) {
        this.left = left;
    }

    public void setRight(Expr right) {
        this.right = right;
    }
}
