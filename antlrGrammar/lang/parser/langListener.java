// Generated from lang/parser/lang.g4 by ANTLR 4.8

    package lang.parser;
     

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link langParser}.
 */
public interface langListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code progName}
	 * labeled alternative in {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgName(langParser.ProgNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progName}
	 * labeled alternative in {@link langParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgName(langParser.ProgNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dataDef}
	 * labeled alternative in {@link langParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDataDef(langParser.DataDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dataDef}
	 * labeled alternative in {@link langParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDataDef(langParser.DataDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDef}
	 * labeled alternative in {@link langParser#def}.
	 * @param ctx the parse tree
	 */
	void enterFunDef(langParser.FunDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDef}
	 * labeled alternative in {@link langParser#def}.
	 * @param ctx the parse tree
	 */
	void exitFunDef(langParser.FunDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dataName}
	 * labeled alternative in {@link langParser#data}.
	 * @param ctx the parse tree
	 */
	void enterDataName(langParser.DataNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dataName}
	 * labeled alternative in {@link langParser#data}.
	 * @param ctx the parse tree
	 */
	void exitDataName(langParser.DataNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declName}
	 * labeled alternative in {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclName(langParser.DeclNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declName}
	 * labeled alternative in {@link langParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclName(langParser.DeclNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funName}
	 * labeled alternative in {@link langParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFunName(langParser.FunNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funName}
	 * labeled alternative in {@link langParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFunName(langParser.FunNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramsName}
	 * labeled alternative in {@link langParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParamsName(langParser.ParamsNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramsName}
	 * labeled alternative in {@link langParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParamsName(langParser.ParamsNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code btypeName}
	 * labeled alternative in {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBtypeName(langParser.BtypeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code btypeName}
	 * labeled alternative in {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBtypeName(langParser.BtypeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeName}
	 * labeled alternative in {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(langParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeName}
	 * labeled alternative in {@link langParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(langParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterIntType(langParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitIntType(langParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterCharType(langParser.CharTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitCharType(langParser.CharTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(langParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(langParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(langParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(langParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nameType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterNameType(langParser.NameTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nameType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitNameType(langParser.NameTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterIdType(langParser.IdTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link langParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitIdType(langParser.IdTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterBlockCmd(langParser.BlockCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitBlockCmd(langParser.BlockCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIfCmd(langParser.IfCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIfCmd(langParser.IfCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIfElseCmd(langParser.IfElseCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIfElseCmd(langParser.IfElseCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterateCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterIterateCmd(langParser.IterateCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterateCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitIterateCmd(langParser.IterateCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterReadCmd(langParser.ReadCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitReadCmd(langParser.ReadCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterPrintCmd(langParser.PrintCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitPrintCmd(langParser.PrintCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterReturnCmd(langParser.ReturnCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitReturnCmd(langParser.ReturnCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterLvalueCmd(langParser.LvalueCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitLvalueCmd(langParser.LvalueCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallCmd(langParser.FuncCallCmdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallCmd}
	 * labeled alternative in {@link langParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallCmd(langParser.FuncCallCmdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(langParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(langParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cexprExp}
	 * labeled alternative in {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCexprExp(langParser.CexprExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cexprExp}
	 * labeled alternative in {@link langParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCexprExp(langParser.CexprExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalsCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualsCexpr(langParser.EqualsCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalsCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualsCexpr(langParser.EqualsCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baexpCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterBaexpCexpr(langParser.BaexpCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baexpCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitBaexpCexpr(langParser.BaexpCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqualsCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualsCexpr(langParser.NotEqualsCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqualsCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualsCexpr(langParser.NotEqualsCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThanCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterLessThanCexpr(langParser.LessThanCexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThanCexpr}
	 * labeled alternative in {@link langParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitLessThanCexpr(langParser.LessThanCexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterSubBaexp(langParser.SubBaexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitSubBaexp(langParser.SubBaexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterAddBaexp(langParser.AddBaexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitAddBaexp(langParser.AddBaexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opexpBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterOpexpBaexp(langParser.OpexpBaexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opexpBaexp}
	 * labeled alternative in {@link langParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitOpexpBaexp(langParser.OpexpBaexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterDivOpexp(langParser.DivOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitDivOpexp(langParser.DivOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dexpOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterDexpOpexp(langParser.DexpOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dexpOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitDexpOpexp(langParser.DexpOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterMulOpexp(langParser.MulOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitMulOpexp(langParser.MulOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterModOpexp(langParser.ModOpexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modOpexp}
	 * labeled alternative in {@link langParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitModOpexp(langParser.ModOpexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNotDexp(langParser.NotDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNotDexp(langParser.NotDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNegDexp(langParser.NegDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNegDexp(langParser.NegDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterTrueDexp(langParser.TrueDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitTrueDexp(langParser.TrueDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterFalseDexp(langParser.FalseDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitFalseDexp(langParser.FalseDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNullDexp(langParser.NullDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNullDexp(langParser.NullDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterIntDexp(langParser.IntDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitIntDexp(langParser.IntDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterFloatDexp(langParser.FloatDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitFloatDexp(langParser.FloatDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterCharDexp(langParser.CharDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitCharDexp(langParser.CharDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rexpDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterRexpDexp(langParser.RexpDexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rexpDexp}
	 * labeled alternative in {@link langParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitRexpDexp(langParser.RexpDexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterLvalueRexp(langParser.LvalueRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitLvalueRexp(langParser.LvalueRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterParenRexp(langParser.ParenRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitParenRexp(langParser.ParenRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterNewRexp(langParser.NewRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitNewRexp(langParser.NewRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallRexp(langParser.FuncCallRexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallRexp}
	 * labeled alternative in {@link langParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallRexp(langParser.FuncCallRexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterDotLvalue(langParser.DotLvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitDotLvalue(langParser.DotLvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterIdLvalue(langParser.IdLvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitIdLvalue(langParser.IdLvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterArrayLvalue(langParser.ArrayLvalueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLvalue}
	 * labeled alternative in {@link langParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitArrayLvalue(langParser.ArrayLvalueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expsName}
	 * labeled alternative in {@link langParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExpsName(langParser.ExpsNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expsName}
	 * labeled alternative in {@link langParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExpsName(langParser.ExpsNameContext ctx);
}