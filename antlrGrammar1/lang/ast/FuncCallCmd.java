package lang.ast;

import java.util.List;

import lang.visitors.*;

public class FuncCallCmd extends Cmd {

    private String id; // Identificador da função
    private List<Expr> exprs; // Lista de expressões (argumentos) para a chamada da função
    private List<LValue> lvalues; // Lista opcional de variáveis genéricas (se houver)

    public FuncCallCmd(int line, int column, String id, List<Expr> exprs, List<LValue> lvalues) {
        super(line, column);
        this.id = id;
        this.exprs = exprs;
        this.lvalues = lvalues;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Expr> getExprs() {
        return exprs;
    }

    public void setExprs(List<Expr> exprs) {
        this.exprs = exprs;
    }

    public List<LValue> getLvalues() {
        return lvalues;
    }

    public void setLvalues(List<LValue> lvalues) {
        this.lvalues = lvalues;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(id + "(");

        // Adiciona os argumentos
        for (int i = 0; i < exprs.size(); i++) {
            sb.append(exprs.get(i).toString());
            if (i < exprs.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append(")");

        // Adiciona variáveis genéricas se existirem
        if (lvalues != null && !lvalues.isEmpty()) {
            sb.append("<");
            for (int i = 0; i < lvalues.size(); i++) {
                sb.append(lvalues.get(i).toString());
                if (i < lvalues.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(">");
        }

        sb.append(";");
        return sb.toString();
    }
}
