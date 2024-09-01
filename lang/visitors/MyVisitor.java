
package lang.visitors;

import java.util.ArrayList;
import java.util.List;

import lang.ast.*;
import lang.parser.LangBaseVisitor;
import lang.parser.LangParser.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class MyVisitor extends LangBaseVisitor<Node> {

    @Override
    public Node visitProgName(ProgNameContext ctx) {

        Prog program = new Prog(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()); // Linha e
                                                                                                   // coluna

        for (int i = 0; i < (ctx.data().size()) && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.data(i);
            program.addData((Data) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        for (int i = 0; i < (ctx.func().size()) && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.func(i);
            program.addFunction((Func) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        return program;
    }

    @Override
    public Node visitDataName(DataNameContext ctx) {

        String nametype = ctx.NAME_TYPE().getText();
        List<Decl> decls = new ArrayList<Decl>();

        for (int i = 0; i < ctx.decl().size(); i++) {
            Decl declarationAccept = (Decl) ctx.decl().get(i).accept(this);
            decls.add(declarationAccept);
        }

        return new Data(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), nametype, decls);
    }

    @Override
    public Node visitDeclName(DeclNameContext ctx) {

        return new Decl(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                ctx.getChild(0).getText(),
                (Type) ctx.type().accept(this));
    }

    @Override
    public Node visitFunName(FunNameContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        Func function = new Func(line, column, ctx.getChild(0).getText());

        Param parameters;

        if (ctx.params() != null) {
            parameters = (Param) ctx.params().accept(this);
            function.setParameters(parameters);
        }

        for (int i = 0; i < (ctx.type().size()) && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.type(i);
            function.addReturnTypes((Type) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        for (int i = 0; i < (ctx.cmd().size()) && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.cmd(i);
            function.addCommand((Cmd) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        return function;
    }

    @Override
    public Node visitParamsName(ParamsNameContext ctx) {

        List<String> ids = new ArrayList<>();
        List<Type> types = new ArrayList<>();

        for (int i = 0; i < ctx.type().size(); i++) {
            ids.add(ctx.ID().get(i).getText());
            types.add((Type) ctx.type().get(i).accept(this));
        }

        Param parameters = new Param(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ids,
                types);

        return parameters;
    }

    @Override
    public Node visitBtypeName(BtypeNameContext ctx) {

        return super.visitBtypeName(ctx);
    }

    @Override
    public Node visitTypeName(TypeNameContext ctx) {

        Type type = (Type) ctx.type().accept(this);
        return new ArrayType(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), type);
    }

    @Override
    public Node visitIntType(IntTypeContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new TypeInt(line, column);
    }

    @Override
    public Node visitCharType(CharTypeContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new TypeChar(line, column);
    }

    @Override
    public Node visitBoolType(BoolTypeContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new TypeBool(line, column);
    }

    @Override
    public Node visitFloatType(FloatTypeContext ctx) {

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new TypeFloat(line, column);
    }

    @Override
    public Node visitIdType(IdTypeContext ctx) {

        String nameType = ctx.getChild(0).getText();
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new NameType(line, column, nameType);
    }

    @Override
    public Node visitBlockCmd(BlockCmdContext ctx) {

        List<Cmd> cmds = new ArrayList<>();

        for (int i = 0; i < ctx.cmd().size(); i++) {
            cmds.add((Cmd) ctx.cmd().get(i).accept(this));
        }

        return new CmdsList(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), cmds);
    }

    @Override
    public Node visitIfCmd(IfCmdContext ctx) {

        Expression exp = (Expression) ctx.getChild(2).accept(this);
        Cmd cmd = (Cmd) ctx.getChild(4).accept(this);

        return new If(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp, cmd);
    }

    @Override
    public Node visitIfElseCmd(IfElseCmdContext ctx) {

        Expression exp = (Expression) ctx.getChild(2).accept(this);
        Cmd cmd = (Cmd) ctx.getChild(4).accept(this);
        Cmd elseCmd = (Cmd) ctx.getChild(6).accept(this);

        return new IfElse(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp, cmd, elseCmd);
    }

    @Override
    public Node visitIterateCmd(IterateCmdContext ctx) {

        Expression exp = (Expression) ctx.getChild(2).accept(this);
        Cmd cmd = (Cmd) ctx.getChild(4).accept(this);

        return new Iterate(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.getChild(0).getText(),
                exp, cmd);
    }

    @Override
    public Node visitReadCmd(ReadCmdContext ctx) {

        LValue lValue = (LValue) ctx.getChild(1).accept(this);
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new Read(line, column, lValue);
    }

    @Override
    public Node visitPrintCmd(PrintCmdContext ctx) {

        Expression expression = (Expression) ctx.exp().accept(this);
        return new Print(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), expression);
    }

    @Override
    public Node visitReturnCmd(ReturnCmdContext ctx) {

        List<Expression> exps = new ArrayList<Expression>();

        for (int i = 0; i < ctx.exp().size(); i++) {
            exps.add((Expression) ctx.exp().get(i).accept(this));
        }

        return new Return(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exps);
    }

    @Override
    public Node visitLvalueCmd(LvalueCmdContext ctx) {

        return new Attr(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                (LValue) ctx.lvalue().accept(this), (Expression) ctx.exp().accept(this));
    }

    @Override
    public Node visitFuncCallCmd(FuncCallCmdContext ctx) {

        FunctionCall fcall = new FunctionCall(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.getChild(0).getText());

        if (ctx.exps() != null) {
            CallParam exps = (CallParam) ctx.exps().accept(this);

            fcall = new FunctionCall(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                    ctx.getChild(0).getText(), exps);
        }

        for (int i = 0; i < ctx.lvalue().size() && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.lvalue(i);
            fcall.addLValue((LValue) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        return fcall;
    }

    @Override
    public Node visitCexprExp(CexprExpContext ctx) {

        return super.visitCexprExp(ctx);
    }

    @Override
    public Node visitAndExp(AndExpContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new And(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitAExpCall(AExpCallContext ctx) {

        return super.visitAExpCall(ctx);
    }

    @Override
    public Node visitLessThan(LessThanContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new LessThan(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitEquality(EqualityContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new Equals(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitDifference(DifferenceContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new NotEqual(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitAdditionOperation(AdditionOperationContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new Add(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitSubtractionOperation(SubtractionOperationContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new Sub(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitMExpCall(MExpCallContext ctx) {

        return super.visitMExpCall(ctx);
    }

    @Override
    public Node visitDivisionOperation(DivisionOperationContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new Div(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitSExpCall(SExpCallContext ctx) {

        return super.visitSExpCall(ctx);
    }

    @Override
    public Node visitMultiplicationOperation(MultiplicationOperationContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new Mul(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitModularOperation(ModularOperationContext ctx) {

        Expression left = (Expression) ctx.getChild(0).accept(this);
        Expression right = (Expression) ctx.getChild(2).accept(this);

        return new Mod(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitNot(NotContext ctx) {

        Expression exp = (Expression) ctx.getChild(1).accept(this);

        return new Not(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp);
    }

    @Override
    public Node visitMinus(MinusContext ctx) {

        Expression exp = (Expression) ctx.getChild(1).accept(this);

        return new Min(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp);
    }

    @Override
    public Node visitTrue(TrueContext ctx) {

        return new BoolDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                Boolean.parseBoolean(ctx.getChild(0).getText()));
    }

    @Override
    public Node visitFalse(FalseContext ctx) {

        return new BoolDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                Boolean.parseBoolean(ctx.getChild(0).getText()));
    }

    @Override
    public Node visitNull(NullContext ctx) {

        return new Null(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Node visitIntegerNumber(IntegerNumberContext ctx) {

        return new IntDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                Integer.parseInt(ctx.getChild(0).getText()));
    }

    @Override
    public Node visitFloatNumber(FloatNumberContext ctx) {

        return new FloatDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                Float.parseFloat(ctx.FLOAT().getText()));
    }

    @Override
    public Node visitCharLitteral(CharLitteralContext ctx) {

        return new CharDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.CHAR().getText());
    }

    @Override
    public Node visitPExpCall(PExpCallContext ctx) {

        return super.visitPExpCall(ctx);
    }

    @Override
    public Node visitPexpIdentifier(PexpIdentifierContext ctx) {

        return super.visitPexpIdentifier(ctx);
    }

    @Override
    public Node visitExpParenthesis(ExpParenthesisContext ctx) {

        return (Expression) ctx.getChild(1).accept(this);
    }

    @Override
    public Node visitTypeInstanciate(TypeInstanciateContext ctx) {

        if (ctx.type().accept(this) instanceof NameType) {

            if (ctx.exp() != null) {
                Expression exp = (Expression) ctx.exp().accept(this);

                return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp,
                        ctx.type().getText());
            } else {
                return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                        ctx.type().getText());
            }
        }

        if (ctx.exp() != null) {
            Expression exp = (Expression) ctx.exp().accept(this);
            Type type = (Type) ctx.type().accept(this);

            return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp, type);
        } else {
            Type type = (Type) ctx.type().accept(this);
            return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), type);
        }
    }

    @Override
    public Node visitFunctionReturn(FunctionReturnContext ctx) {

        String str = ctx.ID().getText();
        CallParam fCallPar = (CallParam) ctx.exps().accept(this);
        Expression exp = (Expression) ctx.exp().accept(this);
        return new FuncRet(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), str, fCallPar, exp);
    }

    @Override
    public Node visitArrayAccess(ArrayAccessContext ctx) {

        LValue lVal = (LValue) ctx.getChild(0).accept(this);
        Expression exp = (Expression) ctx.getChild(2).accept(this);

        return new ArrayLValue(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), lVal, exp);
    }

    @Override
    public Node visitIdentifier(IdentifierContext ctx) {

        return new IDLvalue(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.ID().getText());
    }

    @Override
    public Node visitDataAccess(DataAccessContext ctx) {

        LValue lVal = (LValue) ctx.lvalue().accept(this);
        String str = ctx.getChild(2).getText();
        String dataId = ctx.lvalue().getText();
        return new DotLvalue(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), lVal, str, dataId);
    }

    @Override
    public Node visitFCallParams(FCallParamsContext ctx) {

        CallParam fcall = new CallParam(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        List<Expression> exps = new ArrayList<>();

        for (int i = 0; i < ctx.exp().size(); i++) {
            exps.add((Expression) ctx.exp().get(i).accept(this));
        }
        fcall.setExps(exps);
        return fcall;
    }
}
