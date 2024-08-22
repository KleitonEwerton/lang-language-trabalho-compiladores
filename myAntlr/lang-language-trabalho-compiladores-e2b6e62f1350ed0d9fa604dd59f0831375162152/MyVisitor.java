import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class MyVisitor extends lang1BaseVisitor<Integer> {

    @Override
    public Integer visitProg(lang1Parser.ProgContext ctx) {
        System.out.println("visitProg: " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Integer visitFun(lang1Parser.FunContext ctx) {
        System.out.println("visitFun: " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Integer visitCmd(lang1Parser.CmdContext ctx) {
        if (ctx.TYPE_PRINT() != null) {
            // Corrige aqui: `ctx.exp()` retorna uma lista de `ExpContext`
            for (lang1Parser.ExpContext expCtx : ctx.exp()) {
                Integer result = visit(expCtx);
                System.out.println("Output: " + result);
            }
        } else {
            System.out.println("visitCmd: " + ctx.getText());
        }
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLvalue(lang1Parser.LvalueContext ctx) {
        // Implement logic to retrieve the value of a variable
        // For simplicity, let's assume all variables are initialized to 0
        System.out.println("visitLvalue: " + ctx.getText());
        return 0; // Example, update as needed
    }

    @Override
    public Integer visitExp(lang1Parser.ExpContext ctx) {
        if (ctx.INT() != null) {
            // Trata um número inteiro
            return Integer.valueOf(ctx.INT().getText());
        } else if (ctx.lvalue() != null) {
            // Trata uma variável
            return visit(ctx.lvalue());
        } else if (ctx.exp().size() == 2) {
            // Trata operações binárias
            Integer left = visit(ctx.exp(0)); // Visita a expressão à esquerda
            Integer right = visit(ctx.exp(1)); // Visita a expressão à direita
            String op = ctx.getChild(1).getText(); // Pega o operador
            switch (op) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    return left / right;
                case "%":
                    return left % right;
                default:
                    throw new IllegalArgumentException("Operador desconhecido: " + op);
            }
        }
        // Caso o tipo de expressão não esteja claro, visite todos os filhos
        return visitChildren(ctx);
    }

}
