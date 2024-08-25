// Generated from lang/parser/lang.g4 by ANTLR 4.8

    package lang.parser;
     

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link langParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface langVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code progName}
	 * labeled alternative in {@link langParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgName(langParser.ProgNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataDef}
	 * labeled alternative in {@link langParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDef(langParser.DataDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDef}
	 * labeled alternative in {@link langParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDef(langParser.FunDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataName}
	 * labeled alternative in {@link langParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataName(langParser.DataNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declName}
	 * labeled alternative in {@link langParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclName(langParser.DeclNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funName}
	 * labeled alternative in {@link langParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunName(langParser.FunNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramsName}
	 * labeled alternative in {@link langParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsName(langParser.ParamsNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code btypeName}
	 * labeled alternative in {@link langParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBtypeName(langParser.BtypeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeName}
	 * labeled alternative in {@link langParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(langParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(langParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(langParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(langParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(langParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nameType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameType(langParser.NameTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdType(langParser.IdTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockCmd(langParser.BlockCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCmd(langParser.IfCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseCmd(langParser.IfElseCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterateCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterateCmd(langParser.IterateCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCmd(langParser.ReadCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintCmd(langParser.PrintCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnCmd(langParser.ReturnCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalueCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueCmd(langParser.LvalueCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallCmd(langParser.FuncCallCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link langParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(langParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cexprExp}
	 * labeled alternative in {@link langParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCexprExp(langParser.CexprExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalsCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsCexpr(langParser.EqualsCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baexpCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaexpCexpr(langParser.BaexpCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqualsCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualsCexpr(langParser.NotEqualsCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThanCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanCexpr(langParser.LessThanCexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubBaexp(langParser.SubBaexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddBaexp(langParser.AddBaexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opexpBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpexpBaexp(langParser.OpexpBaexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivOpexp(langParser.DivOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dexpOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDexpOpexp(langParser.DexpOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOpexp(langParser.MulOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModOpexp(langParser.ModOpexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotDexp(langParser.NotDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegDexp(langParser.NegDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueDexp(langParser.TrueDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseDexp(langParser.FalseDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullDexp(langParser.NullDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDexp(langParser.IntDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDexp(langParser.FloatDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDexp(langParser.CharDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rexpDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRexpDexp(langParser.RexpDexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalueRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueRexp(langParser.LvalueRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenRexp(langParser.ParenRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewRexp(langParser.NewRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallRexp(langParser.FuncCallRexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotLvalue(langParser.DotLvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdLvalue(langParser.IdLvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLvalue(langParser.ArrayLvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expsName}
	 * labeled alternative in {@link langParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpsName(langParser.ExpsNameContext ctx);
}