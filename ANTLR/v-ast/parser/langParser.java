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
		TYPE_INT=1, TYPE_CHAR=2, TYPE_BOOL=3, TYPE_FLOAT=4, TYPE_NEW=5, TYPE_DATA=6, 
		TYPE_IF=7, TYPE_ELSE=8, TYPE_ITERATE=9, TYPE_READ=10, TYPE_PRINT=11, TYPE_RET=12, 
		TYPE_NULL=13, TYPE_TRUE=14, TYPE_FALSE=15, ID=16, NAME=17, INT=18, FLOAT=19, 
		CHAR=20, NEWLINE=21, WS=22, LINE_COMMENT=23, COMMENT=24, TYPE_OPEN_BRACKET=25, 
		TYPE_CLOSE_BRACKET=26, TYPE_DOT=27, TYPE_OPEN_PARENTHESIS=28, TYPE_CLOSE_PARENTHESIS=29, 
		TYPE_OPEN_BRACE=30, TYPE_CLOSE_BRACE=31, TYPE_EXCLAMATION=32, TYPE_ASTERISK=33, 
		TYPE_DIV=34, TYPE_MOD=35, TYPE_PLUS=36, TYPE_MINUS=37, TYPE_LESS_THAN=38, 
		TYPE_GREATER_THAN=39, TYPE_EQUAL_EQUAL=40, TYPE_NO_EQUAL=41, TYPE_AND=42, 
		TYPE_SEMI=43, TYPE_COLON=44, TYPE_SRO=45, TYPE_COMMA=46, TYPE_EQUAL=47;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_stmt = 2, RULE_stmtList = 3, RULE_expr = 4, 
		RULE_term = 5, RULE_factor = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "stmt", "stmtList", "expr", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Char'", "'Bool'", "'Float'", "'new'", "'data'", "'if'", 
			"'else'", "'iterate'", "'read'", "'print'", "'return'", "'null'", "'true'", 
			"'false'", null, null, null, null, null, null, null, null, null, "'['", 
			"']'", "'.'", "'('", "')'", "'{'", "'}'", "'!'", "'*'", "'/'", "'%'", 
			"'+'", "'-'", "'<'", "'>'", "'=='", "'!='", "'&&'", "';'", "':'", "'::'", 
			"','", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE_INT", "TYPE_CHAR", "TYPE_BOOL", "TYPE_FLOAT", "TYPE_NEW", 
			"TYPE_DATA", "TYPE_IF", "TYPE_ELSE", "TYPE_ITERATE", "TYPE_READ", "TYPE_PRINT", 
			"TYPE_RET", "TYPE_NULL", "TYPE_TRUE", "TYPE_FALSE", "ID", "NAME", "INT", 
			"FLOAT", "CHAR", "NEWLINE", "WS", "LINE_COMMENT", "COMMENT", "TYPE_OPEN_BRACKET", 
			"TYPE_CLOSE_BRACKET", "TYPE_DOT", "TYPE_OPEN_PARENTHESIS", "TYPE_CLOSE_PARENTHESIS", 
			"TYPE_OPEN_BRACE", "TYPE_CLOSE_BRACE", "TYPE_EXCLAMATION", "TYPE_ASTERISK", 
			"TYPE_DIV", "TYPE_MOD", "TYPE_PLUS", "TYPE_MINUS", "TYPE_LESS_THAN", 
			"TYPE_GREATER_THAN", "TYPE_EQUAL_EQUAL", "TYPE_NO_EQUAL", "TYPE_AND", 
			"TYPE_SEMI", "TYPE_COLON", "TYPE_SRO", "TYPE_COMMA", "TYPE_EQUAL"
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
		public List<TerminalNode> TYPE_SEMI() { return getTokens(langParser.TYPE_SEMI); }
		public TerminalNode TYPE_SEMI(int i) {
			return getToken(langParser.TYPE_SEMI, i);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			((ProgContext)_localctx).s1 = stmt();
			setState(15);
			match(TYPE_SEMI);
			((ProgContext)_localctx).ast =  new StmtList(((ProgContext)_localctx).s1.ast.getLine(), ((ProgContext)_localctx).s1.ast.getCol(), ((ProgContext)_localctx).s1.ast);
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_ITERATE) | (1L << TYPE_PRINT) | (1L << ID) | (1L << INT))) != 0)) {
				{
				{
				setState(17);
				((ProgContext)_localctx).s2 = stmt();
				setState(18);
				match(TYPE_SEMI);
				((ProgContext)_localctx).ast =  new StmtList(((ProgContext)_localctx).s2.ast.getLine(), ((ProgContext)_localctx).s2.ast.getCol(), _localctx.ast, ((ProgContext)_localctx).s2.ast);
				}
				}
				setState(25);
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

	public static class DeclContext extends ParserRuleContext {
		public Node ast;
		public Token TYPE_INT;
		public Token ID;
		public ExprContext expr;
		public TerminalNode TYPE_INT() { return getToken(langParser.TYPE_INT, 0); }
		public TerminalNode ID() { return getToken(langParser.ID, 0); }
		public TerminalNode TYPE_SRO() { return getToken(langParser.TYPE_SRO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((DeclContext)_localctx).TYPE_INT = match(TYPE_INT);
			setState(27);
			((DeclContext)_localctx).ID = match(ID);
			setState(28);
			match(TYPE_SRO);
			setState(29);
			((DeclContext)_localctx).expr = expr();
			((DeclContext)_localctx).ast =  new VarInt((((DeclContext)_localctx).TYPE_INT!=null?((DeclContext)_localctx).TYPE_INT.getLine():0), (((DeclContext)_localctx).TYPE_INT!=null?((DeclContext)_localctx).TYPE_INT.getCharPositionInLine():0), new ID((((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getLine():0), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getCharPositionInLine():0), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null)), ((DeclContext)_localctx).expr.ast);
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
		public DeclContext decl;
		public ExprContext expr;
		public Token op;
		public StmtContext s1;
		public StmtContext s2;
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> TYPE_OPEN_BRACKET() { return getTokens(langParser.TYPE_OPEN_BRACKET); }
		public TerminalNode TYPE_OPEN_BRACKET(int i) {
			return getToken(langParser.TYPE_OPEN_BRACKET, i);
		}
		public List<TerminalNode> TYPE_CLOSE_BRACKET() { return getTokens(langParser.TYPE_CLOSE_BRACKET); }
		public TerminalNode TYPE_CLOSE_BRACKET(int i) {
			return getToken(langParser.TYPE_CLOSE_BRACKET, i);
		}
		public TerminalNode TYPE_COLON() { return getToken(langParser.TYPE_COLON, 0); }
		public TerminalNode TYPE_IF() { return getToken(langParser.TYPE_IF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(langParser.TYPE_OPEN_PARENTHESIS, 0); }
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(langParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public TerminalNode TYPE_ITERATE() { return getToken(langParser.TYPE_ITERATE, 0); }
		public TerminalNode TYPE_PRINT() { return getToken(langParser.TYPE_PRINT, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				((StmtContext)_localctx).decl = decl();
				((StmtContext)_localctx).ast =  ((StmtContext)_localctx).decl.ast;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				((StmtContext)_localctx).expr = expr();
				setState(36);
				((StmtContext)_localctx).op = match(TYPE_IF);
				setState(37);
				match(TYPE_OPEN_BRACKET);
				setState(38);
				((StmtContext)_localctx).s1 = stmt();
				setState(39);
				match(TYPE_CLOSE_BRACKET);
				setState(40);
				match(TYPE_COLON);
				setState(41);
				match(TYPE_OPEN_BRACKET);
				setState(42);
				((StmtContext)_localctx).s2 = stmt();
				setState(43);
				match(TYPE_CLOSE_BRACKET);
				((StmtContext)_localctx).ast =  new If((((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getLine():0), (((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getCharPositionInLine():0), ((StmtContext)_localctx).expr.ast, ((StmtContext)_localctx).s1.ast, ((StmtContext)_localctx).s2.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				((StmtContext)_localctx).expr = expr();
				setState(47);
				((StmtContext)_localctx).op = match(TYPE_IF);
				setState(48);
				match(TYPE_OPEN_BRACKET);
				setState(49);
				((StmtContext)_localctx).s1 = stmt();
				setState(50);
				match(TYPE_CLOSE_BRACKET);
				((StmtContext)_localctx).ast =  new If((((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getLine():0), (((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getCharPositionInLine():0), ((StmtContext)_localctx).expr.ast, ((StmtContext)_localctx).s1.ast);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				((StmtContext)_localctx).op = match(TYPE_ITERATE);
				setState(54);
				match(TYPE_OPEN_PARENTHESIS);
				setState(55);
				((StmtContext)_localctx).expr = expr();
				setState(56);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(57);
				match(TYPE_OPEN_BRACKET);
				setState(58);
				((StmtContext)_localctx).s1 = stmt();
				setState(59);
				match(TYPE_CLOSE_BRACKET);
				((StmtContext)_localctx).ast =  new Iterate((((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getLine():0), (((StmtContext)_localctx).op!=null?((StmtContext)_localctx).op.getCharPositionInLine():0), ((StmtContext)_localctx).expr.ast, ((StmtContext)_localctx).s1.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				((StmtContext)_localctx).op = match(TYPE_PRINT);
				setState(63);
				match(TYPE_OPEN_PARENTHESIS);
				setState(64);
				((StmtContext)_localctx).expr = expr();
				setState(65);
				match(TYPE_CLOSE_PARENTHESIS);
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
		public List<TerminalNode> TYPE_SEMI() { return getTokens(langParser.TYPE_SEMI); }
		public TerminalNode TYPE_SEMI(int i) {
			return getToken(langParser.TYPE_SEMI, i);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitStmtList(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			((StmtListContext)_localctx).s1 = stmt();
			setState(71);
			match(TYPE_SEMI);
			((StmtListContext)_localctx).ast =  new StmtList(((StmtListContext)_localctx).s1.ast.getLine(), ((StmtListContext)_localctx).s1.ast.getCol(), ((StmtListContext)_localctx).s1.ast);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_ITERATE) | (1L << TYPE_PRINT) | (1L << ID) | (1L << INT))) != 0)) {
				{
				{
				setState(73);
				((StmtListContext)_localctx).s2 = stmt();
				setState(74);
				match(TYPE_SEMI);
				((StmtListContext)_localctx).ast =  new StmtList(((StmtListContext)_localctx).s2.ast.getLine(), ((StmtListContext)_localctx).s2.ast.getCol(), _localctx.ast, ((StmtListContext)_localctx).s2.ast);
				}
				}
				setState(81);
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
		public TerminalNode TYPE_PLUS() { return getToken(langParser.TYPE_PLUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				((ExprContext)_localctx).term = term();
				setState(83);
				((ExprContext)_localctx).op = match(TYPE_PLUS);
				setState(84);
				((ExprContext)_localctx).e = expr();
				((ExprContext)_localctx).ast =  new Add((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0), (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getCharPositionInLine():0), ((ExprContext)_localctx).term.ast, ((ExprContext)_localctx).e.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
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
		public TerminalNode TYPE_ASTERISK() { return getToken(langParser.TYPE_ASTERISK, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				((TermContext)_localctx).factor = factor();
				setState(93);
				((TermContext)_localctx).op = match(TYPE_ASTERISK);
				setState(94);
				((TermContext)_localctx).e = term();
				((TermContext)_localctx).ast =  new Mul((((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getLine():0), (((TermContext)_localctx).op!=null?((TermContext)_localctx).op.getCharPositionInLine():0), ((TermContext)_localctx).factor.ast, ((TermContext)_localctx).e.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof langListener ) ((langListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_factor);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((FactorContext)_localctx).ID = match(ID);
				((FactorContext)_localctx).ast =  new ID((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getLine():0), (((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getCharPositionInLine():0), (((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null));
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61o\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4G\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6]\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7g\n\7\3\b\3\b\3"+
		"\b\3\b\5\bm\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2p\2\20\3\2\2\2\4\34\3\2"+
		"\2\2\6F\3\2\2\2\bH\3\2\2\2\n\\\3\2\2\2\ff\3\2\2\2\16l\3\2\2\2\20\21\5"+
		"\6\4\2\21\22\7-\2\2\22\31\b\2\1\2\23\24\5\6\4\2\24\25\7-\2\2\25\26\b\2"+
		"\1\2\26\30\3\2\2\2\27\23\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2"+
		"\2\2\32\3\3\2\2\2\33\31\3\2\2\2\34\35\7\3\2\2\35\36\7\22\2\2\36\37\7/"+
		"\2\2\37 \5\n\6\2 !\b\3\1\2!\5\3\2\2\2\"#\5\4\3\2#$\b\4\1\2$G\3\2\2\2%"+
		"&\5\n\6\2&\'\7\t\2\2\'(\7\33\2\2()\5\6\4\2)*\7\34\2\2*+\7.\2\2+,\7\33"+
		"\2\2,-\5\6\4\2-.\7\34\2\2./\b\4\1\2/G\3\2\2\2\60\61\5\n\6\2\61\62\7\t"+
		"\2\2\62\63\7\33\2\2\63\64\5\6\4\2\64\65\7\34\2\2\65\66\b\4\1\2\66G\3\2"+
		"\2\2\678\7\13\2\289\7\36\2\29:\5\n\6\2:;\7\37\2\2;<\7\33\2\2<=\5\6\4\2"+
		"=>\7\34\2\2>?\b\4\1\2?G\3\2\2\2@A\7\r\2\2AB\7\36\2\2BC\5\n\6\2CD\7\37"+
		"\2\2DE\b\4\1\2EG\3\2\2\2F\"\3\2\2\2F%\3\2\2\2F\60\3\2\2\2F\67\3\2\2\2"+
		"F@\3\2\2\2G\7\3\2\2\2HI\5\6\4\2IJ\7-\2\2JQ\b\5\1\2KL\5\6\4\2LM\7-\2\2"+
		"MN\b\5\1\2NP\3\2\2\2OK\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2"+
		"\2SQ\3\2\2\2TU\5\f\7\2UV\7&\2\2VW\5\n\6\2WX\b\6\1\2X]\3\2\2\2YZ\5\f\7"+
		"\2Z[\b\6\1\2[]\3\2\2\2\\T\3\2\2\2\\Y\3\2\2\2]\13\3\2\2\2^_\5\16\b\2_`"+
		"\7#\2\2`a\5\f\7\2ab\b\7\1\2bg\3\2\2\2cd\5\16\b\2de\b\7\1\2eg\3\2\2\2f"+
		"^\3\2\2\2fc\3\2\2\2g\r\3\2\2\2hi\7\22\2\2im\b\b\1\2jk\7\24\2\2km\b\b\1"+
		"\2lh\3\2\2\2lj\3\2\2\2m\17\3\2\2\2\b\31FQ\\fl";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}