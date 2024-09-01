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
	 * Enter a parse tree produced by the {@code AExpCall}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterAExpCall(LangParser.AExpCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AExpCall}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitAExpCall(LangParser.AExpCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(LangParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(LangParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterEquality(LangParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitEquality(LangParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Difference}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void enterDifference(LangParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Difference}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 */
	void exitDifference(LangParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditionOperation}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterAdditionOperation(LangParser.AdditionOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditionOperation}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitAdditionOperation(LangParser.AdditionOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubtractionOperation}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterSubtractionOperation(LangParser.SubtractionOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubtractionOperation}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitSubtractionOperation(LangParser.SubtractionOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MExpCall}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void enterMExpCall(LangParser.MExpCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MExpCall}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 */
	void exitMExpCall(LangParser.MExpCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivisionOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterDivisionOperation(LangParser.DivisionOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivisionOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitDivisionOperation(LangParser.DivisionOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SExpCall}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterSExpCall(LangParser.SExpCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SExpCall}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitSExpCall(LangParser.SExpCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicationOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationOperation(LangParser.MultiplicationOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicationOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationOperation(LangParser.MultiplicationOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ModularOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void enterModularOperation(LangParser.ModularOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ModularOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 */
	void exitModularOperation(LangParser.ModularOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNot(LangParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNot(LangParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterMinus(LangParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitMinus(LangParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterTrue(LangParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitTrue(LangParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterFalse(LangParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitFalse(LangParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Null}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterNull(LangParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Null}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitNull(LangParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterIntegerNumber(LangParser.IntegerNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitIntegerNumber(LangParser.IntegerNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatNumber}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterFloatNumber(LangParser.FloatNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatNumber}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitFloatNumber(LangParser.FloatNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharLitteral}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterCharLitteral(LangParser.CharLitteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharLitteral}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitCharLitteral(LangParser.CharLitteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PExpCall}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void enterPExpCall(LangParser.PExpCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PExpCall}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 */
	void exitPExpCall(LangParser.PExpCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PexpIdentifier}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterPexpIdentifier(LangParser.PexpIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PexpIdentifier}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitPexpIdentifier(LangParser.PexpIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpParenthesis}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterExpParenthesis(LangParser.ExpParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpParenthesis}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitExpParenthesis(LangParser.ExpParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInstanciate}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterTypeInstanciate(LangParser.TypeInstanciateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInstanciate}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitTypeInstanciate(LangParser.TypeInstanciateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionReturn}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturn(LangParser.FunctionReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionReturn}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturn(LangParser.FunctionReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAccess}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(LangParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAccess}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(LangParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(LangParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(LangParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DataAccess}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterDataAccess(LangParser.DataAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DataAccess}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitDataAccess(LangParser.DataAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FCallParams}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterFCallParams(LangParser.FCallParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FCallParams}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitFCallParams(LangParser.FCallParamsContext ctx);
}