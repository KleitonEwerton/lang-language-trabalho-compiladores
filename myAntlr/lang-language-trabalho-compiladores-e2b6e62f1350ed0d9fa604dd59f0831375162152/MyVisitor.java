import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class MyVisitor extends ExampleBaseVisitor<Integer> {

    @Override
    public Integer visitProg(ExampleParser.ProgContext ctx) {
        System.out.println("visitProg: " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Integer visitStat(ExampleParser.StatContext ctx) {
        System.out.println("visitStat: " + ctx.getText());

        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }
        return 0;
    }

    @Override
    public Integer visitExpr(ExampleParser.ExprContext ctx) {
        System.out.println("visitExpr: " + ctx.getText());

        if (ctx.INT() != null) {
            return Integer.valueOf(ctx.INT().getText());
        } else if (ctx.ID() != null) {
            // Handle variables here
            return 0;
        } else if (ctx.op != null) {
            switch (ctx.op.getType()) {
                case ExampleParser.ADD:
                    return visit(ctx.expr(0)) + visit(ctx.expr(1));
                case ExampleParser.SUB:
                    return visit(ctx.expr(0)) - visit(ctx.expr(1));
                case ExampleParser.MUL:
                    return visit(ctx.expr(0)) * visit(ctx.expr(1));
                case ExampleParser.DIV:
                    return visit(ctx.expr(0)) / visit(ctx.expr(1));
            }
        }
        return visitChildren(ctx);
    }
}
