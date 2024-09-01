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
	 * labeled alternative in {@link LangParser#func}.
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
	 * Visit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link LangParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdType(LangParser.IdTypeContext ctx);
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
	 * Visit a parse tree produced by the {@code AExpCall}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAExpCall(LangParser.AExpCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(LangParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(LangParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Difference}
	 * labeled alternative in {@link LangParser#cexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(LangParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionOperation}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionOperation(LangParser.AdditionOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubtractionOperation}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtractionOperation(LangParser.SubtractionOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MExpCall}
	 * labeled alternative in {@link LangParser#baexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMExpCall(LangParser.MExpCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivisionOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivisionOperation(LangParser.DivisionOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SExpCall}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSExpCall(LangParser.SExpCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationOperation(LangParser.MultiplicationOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModularOperation}
	 * labeled alternative in {@link LangParser#opexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModularOperation(LangParser.ModularOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(LangParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(LangParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(LangParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(LangParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Null}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(LangParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerNumber}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerNumber(LangParser.IntegerNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatNumber}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatNumber(LangParser.FloatNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharLitteral}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLitteral(LangParser.CharLitteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PExpCall}
	 * labeled alternative in {@link LangParser#dexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpCall(LangParser.PExpCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PexpIdentifier}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPexpIdentifier(LangParser.PexpIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpParenthesis}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParenthesis(LangParser.ExpParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInstanciate}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInstanciate(LangParser.TypeInstanciateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionReturn}
	 * labeled alternative in {@link LangParser#rexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturn(LangParser.FunctionReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAccess}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(LangParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(LangParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataAccess}
	 * labeled alternative in {@link LangParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataAccess(LangParser.DataAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FCallParams}
	 * labeled alternative in {@link LangParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFCallParams(LangParser.FCallParamsContext ctx);
}