// Generated from parser/lang.g4 by ANTLR 4.8

    package parser;
    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class langParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TYPE_INT=12, TYPE_CHAR=13, TYPE_BOOL=14, TYPE_FLOAT=15, 
		TYPE_DATA=16, TYPE_IF=17, TYPE_ELSE=18, TYPE_ITERATE=19, TYPE_READ=20, 
		TYPE_PRINT=21, TYPE_RET=22, TYPE_NULL=23, TYPE_TRUE=24, TYPE_FALSE=25, 
		ID=26, INT=27, NEWLINE=28, WS=29, LINE_COMMENT=30, COMMENT=31;
	public static final int
		RULE_prog = 0, RULE_stmt = 1, RULE_stmtList = 2, RULE_expr = 3, RULE_term = 4, 
		RULE_factor = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stmt", "stmtList", "expr", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'['", "']'", "':'", "'('", "')'", "'{'", "'}'", 
			"'+'", "'*'", "'int'", "'Char'", "'Bool'", "'Float'", "'data'", "'if'", 
			"'else'", "'iterate'", "'read'", "'print'", "'return'", "'null'", "'true'", 
			"'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TYPE_INT", "TYPE_CHAR", "TYPE_BOOL", "TYPE_FLOAT", "TYPE_DATA", "TYPE_IF", 
			"TYPE_ELSE", "TYPE_ITERATE", "TYPE_READ", "TYPE_PRINT", "TYPE_RET", "TYPE_NULL", 
			"TYPE_TRUE", "TYPE_FALSE", "ID", "INT", "NEWLINE", "WS", "LINE_COMMENT", 
			"COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public langParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public StmtList ast;
		public StmtContext s1;
		public StmtContext s2;
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			((ProgContext)_localctx).s1 = stmt();
			setState(13);
			match(T__0);
			((ProgContext)_localctx).ast =  new StmtList(((ProgContext)_localctx).s1.ast.getLine(), ((ProgContext)_localctx).s1.ast.getCol(), ((ProgContext)_localctx).s1.ast);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_ITERATE) | (1L << ID) | (1L << INT))) != 0)) {
				{
				{
				setState(15);
				((ProgContext)_localctx).s2 = stmt();
				setState(16);
				match(T__0);
				((ProgContext)_localctx).ast =  new StmtList(((ProgContext)_localctx).s2.ast.getLine(), ((ProgContext)_localctx).s2.ast.getCol(), _localctx.ast, ((ProgContext)_localctx).s2.ast);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Node ast;
		public Token TYPE_INT;
		public Token ID;
		public ExprContext expr;
		public Token op;
		public StmtContext s1;
		public StmtContext s2;
		public Token TYPE_ITERATE;
		public ExprContext cond;
		public StmtListContext body;
		public TerminalNode TYPE_INT() { return getToken(langParser.TYPE_INT, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TYPE_IF() { return getToken(langParser.TYPE_IF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode TYPE_ITERATE() { return getToken(langParser.TYPE_ITERATE, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				((StmtContext)_localctx).TYPE_INT = match(TYPE_INT);
				setState(25);
				((StmtContext)_localctx).ID = match(ID);
				setState(26);
				match(T__1);
				setState(27);
				((StmtContext)_localctx).expr = expr();
				((StmtContext)_localctx).ast =  new VarDecl((((StmtContext)_localctx).TYPE_INT!=null?((StmtContext)_localctx).TYPE_INT.getLine():0), (((StmtContext)_localctx).TYPE_INT!=null?((StmtContext)_localctx).TYPE_INT.getCharPositionInLine():0), new ID((((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getLine():0), (((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getCharPositionInLine():0), (((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getText():null)), ((StmtContext)_localctx).expr.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				((StmtContext)_localctx).ID = match(ID);
				setState(31);
				match(T__1);
				setState(32);
				((StmtContext)_localctx).expr = expr();
				((StmtContext)_localctx).ast =  new Attr((((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getLine():0), (((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getCharPositionInLine():0), new ID((((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getLine():0), (((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getCharPositionInLine():0), (((StmtContext)_localctx).ID!=null?((StmtContext)_localctx).ID.getText():null)), ((StmtContext)_localctx).expr.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				((StmtContext)_localctx).expr = expr();
				setState(36);
				((StmtContext)_localctx).op = match(TYPE_IF);
				setState(37);
				match(T__2);
				setState(38);
				((StmtContext)_localctx).s1 = stmt();
				setState(39);
				match(T__3);
				setState(40);
				match(T__4);
				setState(41);
				match(T__2);
				setState(42);
				((StmtContext)_localctx).s2 = stmt();
				setState(43);
				match(T__3);
				((StmtContext)_localctx).ast =  new If((((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getLine():0), (((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getCharPositionInLine():0), ((StmtContext)_localctx).expr.ast, ((StmtContext)_localctx).s1.ast, ((StmtContext)_localctx).s2.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				((StmtContext)_localctx).expr = expr();
				setState(47);
				((StmtContext)_localctx).op = match(TYPE_IF);
				setState(48);
				match(T__2);
				setState(49);
				((StmtContext)_localctx).s1 = stmt();
				setState(50);
				match(T__3);
				((StmtContext)_localctx).ast =  new If((((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getLine():0), (((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getCharPositionInLine():0), ((StmtContext)_localctx).expr.ast, ((StmtContext)_localctx).s1.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				((StmtContext)_localctx).TYPE_ITERATE = match(TYPE_ITERATE);
				setState(54);
				match(T__5);
				setState(55);
				((StmtContext)_localctx).cond = expr();
				setState(56);
				match(T__6);
				setState(57);
				match(T__7);
				setState(58);
				((StmtContext)_localctx).body = stmtList();
				setState(59);
				match(T__8);
				((StmtContext)_localctx).ast =  new While((((StmtContext)_localctx).TYPE_ITERATE!=null?((StmtContext)_localctx).TYPE_ITERATE.getLine():0), (((StmtContext)_localctx).TYPE_ITERATE!=null?((StmtContext)_localctx).TYPE_ITERATE.getCharPositionInLine():0), ((StmtContext)_localctx).cond.ast, ((StmtContext)_localctx).body.ast);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(62);
				((StmtContext)_localctx).expr = expr();
				((StmtContext)_localctx).ast =  new Print(((StmtContext)_localctx).expr.ast.getLine(), ((StmtContext)_localctx).expr.ast.getCol(), ((StmtContext)_localctx).expr.ast);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtListContext extends ParserRuleContext {
		public StmtList ast;
		public StmtContext s1;
		public StmtContext s2;
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			((StmtListContext)_localctx).s1 = stmt();
			setState(68);
			match(T__0);
			((StmtListContext)_localctx).ast =  new StmtList(((StmtListContext)_localctx).s1.ast.getLine(), ((StmtListContext)_localctx).s1.ast.getCol(), ((StmtListContext)_localctx).s1.ast);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_ITERATE) | (1L << ID) | (1L << INT))) != 0)) {
				{
				{
				setState(70);
				((StmtListContext)_localctx).s2 = stmt();
				setState(71);
				match(T__0);
				((StmtListContext)_localctx).ast =  new StmtList(((StmtListContext)_localctx).s2.ast.getLine(), ((StmtListContext)_localctx).s2.ast.getCol(), _localctx.ast, ((StmtListContext)_localctx).s2.ast);
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Expr ast;
		public TermContext term;
		public Token op;
		public ExprContext e;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				((ExprContext)_localctx).term = term();
				setState(80);
				((ExprContext)_localctx).op = match(T__9);
				setState(81);
				((ExprContext)_localctx).e = expr();
				((ExprContext)_localctx).ast =  new Add((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0), (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getCharPositionInLine():0), ((ExprContext)_localctx).term.ast, ((ExprContext)_localctx).e.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((ExprContext)_localctx).term = term();
				((ExprContext)_localctx).ast =  ((ExprContext)_localctx).term.ast;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Expr ast;
		public FactorContext factor;
		public Token op;
		public TermContext e;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				((TermContext)_localctx).factor = factor();
				setState(90);
				((TermContext)_localctx).op = match(T__10);
				setState(91);
				((TermContext)_localctx).e = term();
				((TermContext)_localctx).ast =  new Mul((((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getLine():0), (((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getCharPositionInLine():0), ((TermContext)_localctx).factor.ast, ((TermContext)_localctx).e.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				((TermContext)_localctx).factor = factor();
				((TermContext)_localctx).ast =  ((TermContext)_localctx).factor.ast;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Expr ast;
		public Token ID;
		public Token INT;
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode INT() { return getToken(langParser.INT, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof langVisitor ) return ((langVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factor);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((FactorContext)_localctx).ID = match(ID);
				((FactorContext)_localctx).ast =  new ID((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getLine():0), (((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getCharPositionInLine():0), (((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				((FactorContext)_localctx).INT = match(INT);
				((FactorContext)_localctx).ast =  new Num((((FactorContext)_localctx).INT!=null?((FactorContext)_localctx).INT.getLine():0), (((FactorContext)_localctx).INT!=null?((FactorContext)_localctx).INT.getCharPositionInLine():0), Integer.parseInt((((FactorContext)_localctx).INT!=null?((FactorContext)_localctx).INT.getText():null)));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!l\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\26\n"+
		"\2\f\2\16\2\31\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5Z\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6d\n\6\3\7\3\7\3\7\3\7\5\7j"+
		"\n\7\3\7\2\2\b\2\4\6\b\n\f\2\2\2o\2\16\3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\b"+
		"Y\3\2\2\2\nc\3\2\2\2\fi\3\2\2\2\16\17\5\4\3\2\17\20\7\3\2\2\20\27\b\2"+
		"\1\2\21\22\5\4\3\2\22\23\7\3\2\2\23\24\b\2\1\2\24\26\3\2\2\2\25\21\3\2"+
		"\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31\27\3\2"+
		"\2\2\32\33\7\16\2\2\33\34\7\34\2\2\34\35\7\4\2\2\35\36\5\b\5\2\36\37\b"+
		"\3\1\2\37D\3\2\2\2 !\7\34\2\2!\"\7\4\2\2\"#\5\b\5\2#$\b\3\1\2$D\3\2\2"+
		"\2%&\5\b\5\2&\'\7\23\2\2\'(\7\5\2\2()\5\4\3\2)*\7\6\2\2*+\7\7\2\2+,\7"+
		"\5\2\2,-\5\4\3\2-.\7\6\2\2./\b\3\1\2/D\3\2\2\2\60\61\5\b\5\2\61\62\7\23"+
		"\2\2\62\63\7\5\2\2\63\64\5\4\3\2\64\65\7\6\2\2\65\66\b\3\1\2\66D\3\2\2"+
		"\2\678\7\25\2\289\7\b\2\29:\5\b\5\2:;\7\t\2\2;<\7\n\2\2<=\5\6\4\2=>\7"+
		"\13\2\2>?\b\3\1\2?D\3\2\2\2@A\5\b\5\2AB\b\3\1\2BD\3\2\2\2C\32\3\2\2\2"+
		"C \3\2\2\2C%\3\2\2\2C\60\3\2\2\2C\67\3\2\2\2C@\3\2\2\2D\5\3\2\2\2EF\5"+
		"\4\3\2FG\7\3\2\2GN\b\4\1\2HI\5\4\3\2IJ\7\3\2\2JK\b\4\1\2KM\3\2\2\2LH\3"+
		"\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\7\3\2\2\2PN\3\2\2\2QR\5\n\6\2RS"+
		"\7\f\2\2ST\5\b\5\2TU\b\5\1\2UZ\3\2\2\2VW\5\n\6\2WX\b\5\1\2XZ\3\2\2\2Y"+
		"Q\3\2\2\2YV\3\2\2\2Z\t\3\2\2\2[\\\5\f\7\2\\]\7\r\2\2]^\5\n\6\2^_\b\6\1"+
		"\2_d\3\2\2\2`a\5\f\7\2ab\b\6\1\2bd\3\2\2\2c[\3\2\2\2c`\3\2\2\2d\13\3\2"+
		"\2\2ef\7\34\2\2fj\b\7\1\2gh\7\35\2\2hj\b\7\1\2ie\3\2\2\2ig\3\2\2\2j\r"+
		"\3\2\2\2\b\27CNYci";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}