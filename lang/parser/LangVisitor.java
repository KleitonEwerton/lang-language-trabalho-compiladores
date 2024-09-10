// Generated from lang/parser/Lang.g4 by ANTLR 4.8

    package lang.parser;
     

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code progName}
	 * labeled alternative in {@link LangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgName(LangParser.ProgNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataDef}
	 * labeled alternative in {@link LangParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDef(LangParser.DataDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDef}
	 * labeled alternative in {@link LangParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDef(LangParser.FunDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataName}
	 * labeled alternative in {@link LangParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataName(LangParser.DataNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declName}
	 * labeled alternative in {@link LangParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclName(LangParser.DeclNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funName}
	 * labeled alternative in {@link LangParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunName(LangParser.FunNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramsName}
	 * labeled alternative in {@link LangParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsName(LangParser.ParamsNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code btypeName}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBtypeName(LangParser.BtypeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeName}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(LangParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(LangParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(LangParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(LangParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(LangParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nameType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameType(LangParser.NameTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockCmd(LangParser.BlockCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCmd(LangParser.IfCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseCmd(LangParser.IfElseCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterateCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterateCmd(LangParser.IterateCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCmd(LangParser.ReadCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintCmd(LangParser.PrintCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnCmd(LangParser.ReturnCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalueCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueCmd(LangParser.LvalueCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallCmd(LangParser.FuncCallCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(LangParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cexprExp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCexprExp(LangParser.CexprExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalsCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsCexpr(LangParser.EqualsCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baexpCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaexpCexpr(LangParser.BaexpCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqualsCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualsCexpr(LangParser.NotEqualsCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThanCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanCexpr(LangParser.LessThanCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubBaexp(LangParser.SubBaexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddBaexp(LangParser.AddBaexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opexpBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpexpBaexp(LangParser.OpexpBaexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivOpexp(LangParser.DivOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dexpOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDexpOpexp(LangParser.DexpOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOpexp(LangParser.MulOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModOpexp(LangParser.ModOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotDexp(LangParser.NotDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegDexp(LangParser.NegDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueDexp(LangParser.TrueDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseDexp(LangParser.FalseDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullDexp(LangParser.NullDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDexp(LangParser.IntDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDexp(LangParser.FloatDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDexp(LangParser.CharDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rexpDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRexpDexp(LangParser.RexpDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalueRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueRexp(LangParser.LvalueRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenRexp(LangParser.ParenRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewRexp(LangParser.NewRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallRexp(LangParser.FuncCallRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotLvalue(LangParser.DotLvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdLvalue(LangParser.IdLvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLvalue(LangParser.ArrayLvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expsName}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpsName(LangParser.ExpsNameContext ctx);
}