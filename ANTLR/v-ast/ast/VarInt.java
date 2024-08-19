package ast;

import java.util.HashMap;

public class VarInt extends Node {
    private ID id;
    private Expr expr;

    public VarInt(int line, int col, ID id, Expr expr) {
        super(line, col);
        this.id = id;
        this.expr = expr;
    }

    @Override
    public int interpret(HashMap<String, Integer> context) {
        context.put(id.getName(), expr.interpret(context));
        return 0; // Supondo que a declaração de variável não tenha um valor de retorno
                  // específico.
    }
}
