// Generated from lang1.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lang1Parser}.
 */
public interface lang1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lang1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(lang1Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(lang1Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(lang1Parser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(lang1Parser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(lang1Parser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(lang1Parser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(lang1Parser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(lang1Parser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(lang1Parser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(lang1Parser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(lang1Parser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(lang1Parser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(lang1Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(lang1Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#btype}.
	 * @param ctx the parse tree
	 */
	void enterBtype(lang1Parser.BtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#btype}.
	 * @param ctx the parse tree
	 */
	void exitBtype(lang1Parser.BtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(lang1Parser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(lang1Parser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(lang1Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(lang1Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterCexpr(lang1Parser.CexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitCexpr(lang1Parser.CexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterBaexp(lang1Parser.BaexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitBaexp(lang1Parser.BaexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterOpexp(lang1Parser.OpexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitOpexp(lang1Parser.OpexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterDexp(lang1Parser.DexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitDexp(lang1Parser.DexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterRexp(lang1Parser.RexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitRexp(lang1Parser.RexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(lang1Parser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(lang1Parser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link lang1Parser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(lang1Parser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link lang1Parser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(lang1Parser.ExpsContext ctx);
}