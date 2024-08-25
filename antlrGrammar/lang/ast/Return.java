package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.visitors.*;

public class Return extends Cmd {

    private List<Expr> exprs = new ArrayList<>();  // Lista de expressões a serem retornadas

    public Return(int line, int column, List<Expr> exprs) {
        super(line, column);
        this.exprs = exprs;
    }

    public List<Expr> getEXExprs() {
        return exprs;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("return ");
        for (int i = 0; i < exprs.size(); i++) {
            sb.append(exprs.get(i).toString());
            if (i < exprs.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(";");
        return sb.toString();
    }
}
