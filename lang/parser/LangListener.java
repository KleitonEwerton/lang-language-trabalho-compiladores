// Generated from lang/parser/Lang.g4 by ANTLR 4.8

    package lang.parser;    

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code progName}
	 * labeled alternative in {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgName(LangParser.ProgNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progName}
	 * labeled alternative in {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgName(LangParser.ProgNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dataName}
	 * labeled alternative in {@link LangParser#data}.
	 * @param ctx the parse tree
	 */
	void enterDataName(LangParser.DataNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dataName}
	 * labeled alternative in {@link LangParser#data}.
	 * @param ctx the parse tree
	 */
	void exitDataName(LangParser.DataNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declName}
	 * labeled alternative in {@link LangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclName(LangParser.DeclNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declName}
	 * labeled alternative in {@link LangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclName(LangParser.DeclNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funName}
	 * labeled alternative in {@link LangParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunName(LangParser.FunNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funName}
	 * labeled alternative in {@link LangParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunName(LangParser.FunNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramsName}
	 * labeled alternative in {@link LangParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParamsName(LangParser.ParamsNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramsName}
	 * labeled alternative in {@link LangParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParamsName(LangParser.ParamsNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code btypeName}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBtypeName(LangParser.BtypeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code btypeName}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBtypeName(LangParser.BtypeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeName}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(LangParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeName}
	 * labeled alternative in {@link LangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(LangParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterIntType(LangParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitIntType(LangParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterCharType(LangParser.CharTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitCharType(LangParser.CharTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(LangParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(LangParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(LangParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(LangParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterIdType(LangParser.IdTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitIdType(LangParser.IdTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterBlockCmd(LangParser.BlockCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitBlockCmd(LangParser.BlockCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIfCmd(LangParser.IfCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIfCmd(LangParser.IfCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIfElseCmd(LangParser.IfElseCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIfElseCmd(LangParser.IfElseCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterateCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIterateCmd(LangParser.IterateCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterateCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIterateCmd(LangParser.IterateCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterReadCmd(LangParser.ReadCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitReadCmd(LangParser.ReadCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterPrintCmd(LangParser.PrintCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitPrintCmd(LangParser.PrintCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterReturnCmd(LangParser.ReturnCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitReturnCmd(LangParser.ReturnCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterLvalueCmd(LangParser.LvalueCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitLvalueCmd(LangParser.LvalueCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallCmd(LangParser.FuncCallCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallCmd}
	 * labeled alternative in {@link LangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallCmd(LangParser.FuncCallCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(LangParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(LangParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cexprExp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCexprExp(LangParser.CexprExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cexprExp}
	 * labeled alternative in {@link LangParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCexprExp(LangParser.CexprExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalsCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualsCexpr(LangParser.EqualsCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalsCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualsCexpr(LangParser.EqualsCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baexpCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterBaexpCexpr(LangParser.BaexpCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baexpCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitBaexpCexpr(LangParser.BaexpCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqualsCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualsCexpr(LangParser.NotEqualsCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqualsCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualsCexpr(LangParser.NotEqualsCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThanCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterLessThanCexpr(LangParser.LessThanCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThanCexpr}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitLessThanCexpr(LangParser.LessThanCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterSubBaexp(LangParser.SubBaexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitSubBaexp(LangParser.SubBaexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterAddBaexp(LangParser.AddBaexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitAddBaexp(LangParser.AddBaexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opexpBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterOpexpBaexp(LangParser.OpexpBaexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opexpBaexp}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitOpexpBaexp(LangParser.OpexpBaexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterDivOpexp(LangParser.DivOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitDivOpexp(LangParser.DivOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dexpOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterDexpOpexp(LangParser.DexpOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dexpOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitDexpOpexp(LangParser.DexpOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterMulOpexp(LangParser.MulOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitMulOpexp(LangParser.MulOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterModOpexp(LangParser.ModOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modOpexp}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitModOpexp(LangParser.ModOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNotDexp(LangParser.NotDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNotDexp(LangParser.NotDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNegDexp(LangParser.NegDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNegDexp(LangParser.NegDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterTrueDexp(LangParser.TrueDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitTrueDexp(LangParser.TrueDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterFalseDexp(LangParser.FalseDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitFalseDexp(LangParser.FalseDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNullDexp(LangParser.NullDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNullDexp(LangParser.NullDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterIntDexp(LangParser.IntDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitIntDexp(LangParser.IntDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterFloatDexp(LangParser.FloatDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitFloatDexp(LangParser.FloatDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterCharDexp(LangParser.CharDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitCharDexp(LangParser.CharDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rexpDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterRexpDexp(LangParser.RexpDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rexpDexp}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitRexpDexp(LangParser.RexpDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterLvalueRexp(LangParser.LvalueRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitLvalueRexp(LangParser.LvalueRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterParenRexp(LangParser.ParenRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitParenRexp(LangParser.ParenRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterNewRexp(LangParser.NewRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitNewRexp(LangParser.NewRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallRexp(LangParser.FuncCallRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallRexp}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallRexp(LangParser.FuncCallRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterDotLvalue(LangParser.DotLvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitDotLvalue(LangParser.DotLvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterIdLvalue(LangParser.IdLvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitIdLvalue(LangParser.IdLvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterArrayLvalue(LangParser.ArrayLvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLvalue}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitArrayLvalue(LangParser.ArrayLvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expsName}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExpsName(LangParser.ExpsNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expsName}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExpsName(LangParser.ExpsNameContext ctx);
}