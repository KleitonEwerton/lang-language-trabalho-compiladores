// Generated from parser/lang.g4 by ANTLR 4.8

    package parser;
    import ast.*;

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
	 * Visit a parse tree produced by {@link langParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(langParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(langParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(langParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(langParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(langParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(langParser.FactorContext ctx);
}