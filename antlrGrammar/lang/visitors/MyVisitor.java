package lang.visitors;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lang.parser.*;
import lang.ast.*;

public class MyVisitor extends langBaseVisitor<Node> {

    @Override
    public Node visitProgName(langParser.ProgNameContext ctx) {
        // Método visitChildren visita todos os filhos do nó prog

        System.out.println("Visitando ProgName");

        return visitChildren(ctx);
    }

    @Override
    public Node visitDataDef(langParser.DataDefContext ctx) {
        // Implementação para visitDataDef
        return null;
    }

    @Override
    public Node visitFunDef(langParser.FunDefContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitDataName(langParser.DataNameContext ctx) {
        // Implementação para visitDataName
        return null;
    }

    @Override
    public Node visitDeclName(langParser.DeclNameContext ctx) {
        // Implementação para visitDeclName
        return null;
    }

    @Override
    public Node visitFunName(langParser.FunNameContext ctx) {

        // Acessa o ID através de getChild
        String id = ctx.getChild(0).getText(); // Ajuste o índice com base na estrutura real

        // Obtém a linha e a coluna da função
        int line = ctx.start.getLine();
        int col = ctx.start.getCharPositionInLine();

        // Inicializa os parâmetros e comandos
        Param params = null;
        List<Cmd> commands = new ArrayList<>();
        List<Type> additionalTypes = new ArrayList<>();

        // Verifica se há parâmetros e os extrai, se existirem
        if (ctx.params() != null) {
            // Adapta o código para extrair os parâmetros
            // Assumindo que você tenha um método que transforma o contexto em um objeto
            // Param
            params = (Param) visit(ctx.params());
        }

        // Verifica se há tipos adicionais e os extrai, se existirem
        if (ctx.type() != null) {
            for (int i = 1; i < ctx.type().size(); i++) {
                additionalTypes.add((Type) visit(ctx.type(i)));
            }
        }

        // Extrai e cria a lista de comandos
        if (ctx.cmd() != null) {
            for (langParser.CmdContext cmdCtx : ctx.cmd()) {
                commands.add((Cmd) visit(cmdCtx));
            }
        }

        // Cria a nova instância de Func com base nos dados extraídos
        Func func;
        if (params != null) {
            func = new Func(line, col, id, params);
        } else {
            func = new Func(line, col, id);
        }

        func.setAdditionalTypes(additionalTypes);
        func.setCommands(commands);

        System.out.println(func.toString());
        return func;
    }

    @Override
    public Node visitParamsName(langParser.ParamsNameContext ctx) {
        // Implementação para visitParamsName
        return null;
    }

    @Override
    public Node visitTypeName(langParser.TypeNameContext ctx) {
        // Implementação para visitTypeName
        return null;
    }

    @Override
    public Node visitBtypeName(langParser.BtypeNameContext ctx) {
        // Implementação para visitBtypeName
        return null;
    }

    @Override
    public Node visitIntType(langParser.IntTypeContext ctx) {
        // Implementação para visitIntType
        return null;
    }

    @Override
    public Node visitCharType(langParser.CharTypeContext ctx) {
        // Implementação para visitCharType
        return null;
    }

    @Override
    public Node visitBoolType(langParser.BoolTypeContext ctx) {
        // Implementação para visitBoolType
        return null;
    }

    @Override
    public Node visitFloatType(langParser.FloatTypeContext ctx) {
        // Implementação para visitFloatType
        return null;
    }

    @Override
    public Node visitNameType(langParser.NameTypeContext ctx) {
        // Implementação para visitNameType
        return null;
    }

    @Override
    public Node visitIdType(langParser.IdTypeContext ctx) {
        // Implementação para visitIdType
        return null;
    }

    @Override
    public Node visitBlockCmd(langParser.BlockCmdContext ctx) {
        // Implementação para visitBlockCmd
        return null;
    }

    @Override
    public Node visitIfCmd(langParser.IfCmdContext ctx) {
        // Implementação para visitIfCmd
        return null;
    }

    @Override
    public Node visitIfElseCmd(langParser.IfElseCmdContext ctx) {
        // Implementação para visitIfElseCmd
        return null;
    }

    @Override
    public Node visitIterateCmd(langParser.IterateCmdContext ctx) {
        // Implementação para visitIterateCmd
        return null;
    }

    @Override
    public Node visitReadCmd(langParser.ReadCmdContext ctx) {
        // Implementação para visitReadCmd
        return null;
    }

    @Override
    public Node visitPrintCmd(langParser.PrintCmdContext ctx) {
        // Implementação para visitPrintCmd
        return null;
    }

    @Override
    public Node visitReturnCmd(langParser.ReturnCmdContext ctx) {
        // Implementação para visitReturnCmd
        return null;
    }

    @Override
    public Node visitLvalueCmd(langParser.LvalueCmdContext ctx) {
        // Implementação para visitLvalueCmd
        return null;
    }

    @Override
    public Node visitFuncCallCmd(langParser.FuncCallCmdContext ctx) {
        // Implementação para visitFuncCallCmd
        return null;
    }

    @Override
    public Node visitAndExp(langParser.AndExpContext ctx) {
        // Implementação para visitAndExp
        return null;
    }

    @Override
    public Node visitCexprExp(langParser.CexprExpContext ctx) {
        // Implementação para visitCexprExp
        return super.visitCexprExp(ctx);
    }

    @Override
    public Node visitLessThanCexpr(langParser.LessThanCexprContext ctx) {
        // Implementação para visitLessThanCexpr
        return null;
    }

    @Override
    public Node visitEqualsCexpr(langParser.EqualsCexprContext ctx) {
        // Implementação para visitEqualsCexpr
        return null;
    }

    @Override
    public Node visitNotEqualsCexpr(langParser.NotEqualsCexprContext ctx) {
        // Implementação para visitNotEqualsCexpr
        return null;
    }

    @Override
    public Node visitBaexpCexpr(langParser.BaexpCexprContext ctx) {

        return super.visitBaexpCexpr(ctx);
    }

    @Override
    public Node visitAddBaexp(langParser.AddBaexpContext ctx) {

        System.out.println("Visitando AddBaexp");

        Expr left = (Expr) visit(ctx.baexp());
        Expr right = (Expr) visit(ctx.opexp());
        System.out.println("Visitando AddBaexp: " + left + " + " + right);

        return new Add(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitSubBaexp(langParser.SubBaexpContext ctx) {

        Expr left = (Expr) visit(ctx.baexp());
        Expr right = (Expr) visit(ctx.opexp());

        return new Sub(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitOpexpBaexp(langParser.OpexpBaexpContext ctx) {
        // Implementação para visitOpexpBaexp
        return super.visitOpexpBaexp(ctx);
    }

    @Override
    public Node visitMulOpexp(langParser.MulOpexpContext ctx) {

        Expr left = (Expr) visit(ctx.opexp());
        Expr right = (Expr) visit(ctx.opexp());

        return new Mul(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitDivOpexp(langParser.DivOpexpContext ctx) {
        Expr left = (Expr) visit(ctx.opexp());
        Expr right = (Expr) visit(ctx.opexp());

        return new Div(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitModOpexp(langParser.ModOpexpContext ctx) {
        // Implementação para visitModOpexp
        return null;
    }

    @Override
    public Node visitDexpOpexp(langParser.DexpOpexpContext ctx) {
        // Implementação para visitDexpOpexp
        return super.visitDexpOpexp(ctx);
    }

    @Override
    public Node visitNotDexp(langParser.NotDexpContext ctx) {
        // Implementação para visitNotDexp
        return null;
    }

    @Override
    public Node visitNegDexp(langParser.NegDexpContext ctx) {
        // Implementação para visitNegDexp
        return null;
    }

    @Override
    public Node visitTrueDexp(langParser.TrueDexpContext ctx) {
        // Implementação para visitTrueDexp
        return null;
    }

    @Override
    public Node visitFalseDexp(langParser.FalseDexpContext ctx) {
        // Implementação para visitFalseDexp
        return null;
    }

    @Override
    public Node visitNullDexp(langParser.NullDexpContext ctx) {
        // Implementação para visitNullDexp
        return null;
    }

    @Override
    public Node visitIntDexp(langParser.IntDexpContext ctx) {
        // Implementação para visitIntDexp
        return null;
    }

    @Override
    public Node visitFloatDexp(langParser.FloatDexpContext ctx) {
        // Implementação para visitFloatDexp
        return null;
    }

    @Override
    public Node visitCharDexp(langParser.CharDexpContext ctx) {
        // Implementação para visitCharDexp
        return null;
    }

    @Override
    public Node visitRexpDexp(langParser.RexpDexpContext ctx) {
        // Implementação para visitRexpDexp
        return super.visitRexpDexp(ctx);
    }

    @Override
    public Node visitLvalueRexp(langParser.LvalueRexpContext ctx) {
        // Implementação para visitLvalueRexp
        return null;
    }

    @Override
    public Node visitParenRexp(langParser.ParenRexpContext ctx) {
        // Implementação para visitParenRexp
        return null;
    }

    @Override
    public Node visitNewRexp(langParser.NewRexpContext ctx) {
        // Implementação para visitNewRexp
        return null;
    }

    @Override
    public Node visitFuncCallRexp(langParser.FuncCallRexpContext ctx) {
        // Implementação para visitFuncCallRexp
        return null;
    }

    @Override
    public Node visitIdLvalue(langParser.IdLvalueContext ctx) {
        // Implementação para visitIdLvalue
        return null;
    }

    @Override
    public Node visitArrayLvalue(langParser.ArrayLvalueContext ctx) {
        // Implementação para visitArrayLvalue
        return null;
    }

    @Override
    public Node visitDotLvalue(langParser.DotLvalueContext ctx) {
        // Implementação para visitDotLvalue
        return null;
    }

    @Override
    public Node visitExpsName(langParser.ExpsNameContext ctx) {
        // Implementação para visitArrayLvalue
        return null;
    }

}
