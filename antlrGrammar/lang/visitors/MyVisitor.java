package lang.visitors;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import java.util.HashMap;
import java.util.Map;
import lang.parser.*;
import lang.ast.*;

public class MyVisitor extends langBaseVisitor<Node> {

    @Override
    public Node visitProgName(langParser.ProgNameContext ctx) {
        // Método visitChildren visita todos os filhos do nó prog
        return visitChildren(ctx);
    }

    @Override
    public Node visitDataDef(langParser.DataDefContext ctx) {
        // Implementação para visitDataDef
        return null;
    }

    @Override
    public Node visitFunDef(langParser.FunDefContext ctx) {
        // Implementação para visitFunDef
        System.out.println("Aqui - Fun");
        return null;
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
        // Implementação para visitFunName
        return null;
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
        // Implementação para visitBaexpCexpr
        return super.visitBaexpCexpr(ctx);
    }



    @Override
    public Node visitAddBaexp(langParser.AddBaexpContext ctx) {
        return null;
    }

    @Override
    public Node visitSubBaexp(langParser.SubBaexpContext ctx) {
        // Implementação para visitSubBaexp
        return null;
    }

    @Override
    public Node visitOpexpBaexp(langParser.OpexpBaexpContext ctx) {
        // Implementação para visitOpexpBaexp
        return super.visitOpexpBaexp(ctx);
    }


    
    @Override
    public Node visitMulOpexp(langParser.MulOpexpContext ctx) {
        // Implementação para visitMulOpexp
        return null;
    }

    
    @Override
    public Node visitDivOpexp(langParser.DivOpexpContext ctx) {
        // Implementação para visitDivOpexp
        return null;
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
