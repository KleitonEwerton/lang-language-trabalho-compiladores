import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import java.util.HashMap;
import java.util.Map;

public class MyVisitor extends lang1BaseVisitor<Integer> {

    private final Map<String, Integer> memory = new HashMap<>(); // Armazena valores de variáveis

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
            Integer result = visit(ctx.exp(0)); // Avalia a expressão para print
            System.out.println("checando print: " + result); // Verifica o valor que está sendo impresso
            System.out.println("Output: " + result); // Imprime o resultado
            return result;

        } else if (ctx.TYPE_RETURN() != null) {
            Integer result = visit(ctx.exp(0)); // Avalia a expressão para return
            System.out.println("Result: " + result);
            return result;
        } else if (ctx.TYPE_EQUAL() != null) { // Atribuição de valor a uma variável
            String varName = ctx.lvalue(0).getText(); // Acessa o primeiro elemento da lista de lvalues
            Integer value = visit(ctx.exp(0)); // Avalia a expressão e atribui à variável
            memory.put(varName, value);
            System.out.println("Assign: " + varName + " = " + value);
            return value;
        } else {
            System.out.println("visitCmd: " + ctx.getText());
        }
        return visitChildren(ctx);
    }

    @Override
    public Integer visitLvalue(lang1Parser.LvalueContext ctx) {
        String varName = ctx.getText();
        Integer value = memory.getOrDefault(varName, 0); // Retorna o valor da variável, ou 0 se não estiver definido
        System.out.println("visitLvalue: " + varName + " = " + value);
        return value;
    }

    @Override
    public Integer visitBaexp(lang1Parser.BaexpContext ctx) {
        if (ctx.TYPE_PLUS() != null) {
            Integer left = visit(ctx.baexp()); // Avalia o lado esquerdo
            Integer right = visit(ctx.opexp()); // Avalia o lado direito

            System.out.println("visitBaexp: " + left + " + " + right);

            return left + right;
        } else if (ctx.TYPE_MINUS() != null) {
            Integer left = visit(ctx.baexp());
            Integer right = visit(ctx.opexp());

            System.out.println("visitBaexp: " + left + " - " + right);

            return left - right;
        } else {
            Integer result = visitChildren(ctx); // Continua a visitação e retorna o valor resultante
            System.out.println("visitBaexp (default): " + result);
            return result;
        }
    }

    @Override
    public Integer visitOpexp(lang1Parser.OpexpContext ctx) {
        if (ctx.TYPE_ASTERISK() != null) {
            Integer left = visit(ctx.opexp());
            Integer right = visit(ctx.dexp());

            System.out.println("visitOpexp: " + left + " * " + right);

            return left * right;
        } else if (ctx.TYPE_DIV() != null) {
            Integer left = visit(ctx.opexp());
            Integer right = visit(ctx.dexp());

            System.out.println("visitOpexp: " + left + " / " + right);

            if (right == 0) {
                throw new ArithmeticException("Divisão por zero");
            }
            return left / right;
        } else if (ctx.TYPE_MOD() != null) {
            Integer left = visit(ctx.opexp());
            Integer right = visit(ctx.dexp());

            System.out.println("visitOpexp: " + left + " % " + right);
            return left % right;
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public Integer visitDexp(lang1Parser.DexpContext ctx) {
        if (ctx.INT() != null) {
            return Integer.parseInt(ctx.INT().getText());
        } else if (ctx.TYPE_TRUE() != null) {
            return 1;
        } else if (ctx.TYPE_FALSE() != null) {
            return 0;
        } else {
            return visitChildren(ctx);
        }
    }
}
