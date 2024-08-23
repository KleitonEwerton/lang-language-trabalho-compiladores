// Generated from lang/parser/lang1.g4 by ANTLR 4.8

    package lang.parser;
     

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lang1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lang1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lang1Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(lang1Parser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(lang1Parser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(lang1Parser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(lang1Parser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(lang1Parser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(lang1Parser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(lang1Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBtype(lang1Parser.BtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(lang1Parser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(lang1Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCexpr(lang1Parser.CexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaexp(lang1Parser.BaexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpexp(lang1Parser.OpexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDexp(lang1Parser.DexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRexp(lang1Parser.RexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(lang1Parser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link lang1Parser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(lang1Parser.ExpsContext ctx);
}