// Generated from lang1.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lang1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE_INT=1, TYPE_CHAR=2, TYPE_BOOL=3, TYPE_FLOAT=4, TYPE_NEW=5, TYPE_DATA=6, 
		TYPE_IF=7, TYPE_ELSE=8, TYPE_ITERATE=9, TYPE_READ=10, TYPE_PRINT=11, TYPE_RETURN=12, 
		TYPE_NULL=13, TYPE_TRUE=14, TYPE_FALSE=15, ID=16, NAME=17, INT=18, FLOAT=19, 
		CHAR=20, NEWLINE=21, WS=22, LINE_COMMENT=23, COMMENT=24, TYPE_OPEN_BRACKET=25, 
		TYPE_CLOSE_BRACKET=26, TYPE_DOT=27, TYPE_OPEN_PARENTHESIS=28, TYPE_CLOSE_PARENTHESIS=29, 
		TYPE_OPEN_BRACE=30, TYPE_CLOSE_BRACE=31, TYPE_EXCLAMATION=32, TYPE_ASTERISK=33, 
		TYPE_DIV=34, TYPE_MOD=35, TYPE_PLUS=36, TYPE_MINUS=37, TYPE_LESS_THAN=38, 
		TYPE_GREATER_THAN=39, TYPE_EQUAL_EQUAL=40, TYPE_NO_EQUAL=41, TYPE_AND=42, 
		TYPE_SEMI=43, TYPE_COLON=44, TYPE_SRO=45, TYPE_COMMA=46, TYPE_EQUAL=47;
	public static final int
		RULE_prog = 0, RULE_def = 1, RULE_data = 2, RULE_decl = 3, RULE_fun = 4, 
		RULE_params = 5, RULE_type = 6, RULE_btype = 7, RULE_cmd = 8, RULE_exp = 9, 
		RULE_cexpr = 10, RULE_baexp = 11, RULE_opexp = 12, RULE_dexp = 13, RULE_rexp = 14, 
		RULE_lvalue = 15, RULE_exps = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "def", "data", "decl", "fun", "params", "type", "btype", "cmd", 
			"exp", "cexpr", "baexp", "opexp", "dexp", "rexp", "lvalue", "exps"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'char'", "'bool'", "'float'", "'new'", "'data'", "'if'", 
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
			"TYPE_RETURN", "TYPE_NULL", "TYPE_TRUE", "TYPE_FALSE", "ID", "NAME", 
			"INT", "FLOAT", "CHAR", "NEWLINE", "WS", "LINE_COMMENT", "COMMENT", "TYPE_OPEN_BRACKET", 
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
	public String getGrammarFileName() { return "lang1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public lang1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitProg(this);
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE_DATA || _la==ID) {
				{
				{
				setState(34);
				def();
				}
				}
				setState(39);
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

	public static class DefContext extends ParserRuleContext {
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_DATA:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				data();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				fun();
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

	public static class DataContext extends ParserRuleContext {
		public TerminalNode TYPE_DATA() { return getToken(lang1Parser.TYPE_DATA, 0); }
		public TerminalNode NAME() { return getToken(lang1Parser.NAME, 0); }
		public TerminalNode TYPE_OPEN_BRACE() { return getToken(lang1Parser.TYPE_OPEN_BRACE, 0); }
		public TerminalNode TYPE_CLOSE_BRACE() { return getToken(lang1Parser.TYPE_CLOSE_BRACE, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(TYPE_DATA);
			setState(45);
			match(NAME);
			setState(46);
			match(TYPE_OPEN_BRACE);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(47);
				decl();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(TYPE_CLOSE_BRACE);
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
		public TerminalNode ID() { return getToken(lang1Parser.ID, 0); }
		public TerminalNode TYPE_SRO() { return getToken(lang1Parser.TYPE_SRO, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TYPE_SEMI() { return getToken(lang1Parser.TYPE_SEMI, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(ID);
			setState(56);
			match(TYPE_SRO);
			setState(57);
			type(0);
			setState(58);
			match(TYPE_SEMI);
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

	public static class FunContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lang1Parser.ID, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(lang1Parser.TYPE_OPEN_PARENTHESIS, 0); }
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(lang1Parser.TYPE_CLOSE_PARENTHESIS, 0); }
		public TerminalNode TYPE_OPEN_BRACE() { return getToken(lang1Parser.TYPE_OPEN_BRACE, 0); }
		public TerminalNode TYPE_CLOSE_BRACE() { return getToken(lang1Parser.TYPE_CLOSE_BRACE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode TYPE_COLON() { return getToken(lang1Parser.TYPE_COLON, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> TYPE_COMMA() { return getTokens(lang1Parser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(lang1Parser.TYPE_COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(ID);
			setState(61);
			match(TYPE_OPEN_PARENTHESIS);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(62);
				params();
				}
			}

			setState(65);
			match(TYPE_CLOSE_PARENTHESIS);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COLON) {
				{
				setState(66);
				match(TYPE_COLON);
				setState(67);
				type(0);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE_COMMA) {
					{
					{
					setState(68);
					match(TYPE_COMMA);
					setState(69);
					type(0);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(77);
			match(TYPE_OPEN_BRACE);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_IF) | (1L << TYPE_ITERATE) | (1L << TYPE_READ) | (1L << TYPE_PRINT) | (1L << TYPE_RETURN) | (1L << ID) | (1L << TYPE_OPEN_BRACE))) != 0)) {
				{
				{
				setState(78);
				cmd();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(TYPE_CLOSE_BRACE);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(lang1Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(lang1Parser.ID, i);
		}
		public List<TerminalNode> TYPE_SRO() { return getTokens(lang1Parser.TYPE_SRO); }
		public TerminalNode TYPE_SRO(int i) {
			return getToken(lang1Parser.TYPE_SRO, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> TYPE_COMMA() { return getTokens(lang1Parser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(lang1Parser.TYPE_COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			setState(87);
			match(TYPE_SRO);
			setState(88);
			type(0);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE_COMMA) {
				{
				{
				setState(89);
				match(TYPE_COMMA);
				setState(90);
				match(ID);
				setState(91);
				match(TYPE_SRO);
				setState(92);
				type(0);
				}
				}
				setState(97);
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

	public static class TypeContext extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TYPE_OPEN_BRACKET() { return getToken(lang1Parser.TYPE_OPEN_BRACKET, 0); }
		public TerminalNode TYPE_CLOSE_BRACKET() { return getToken(lang1Parser.TYPE_CLOSE_BRACKET, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(99);
			btype();
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(101);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(102);
					match(TYPE_OPEN_BRACKET);
					setState(103);
					match(TYPE_CLOSE_BRACKET);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BtypeContext extends ParserRuleContext {
		public TerminalNode TYPE_INT() { return getToken(lang1Parser.TYPE_INT, 0); }
		public TerminalNode TYPE_CHAR() { return getToken(lang1Parser.TYPE_CHAR, 0); }
		public TerminalNode TYPE_BOOL() { return getToken(lang1Parser.TYPE_BOOL, 0); }
		public TerminalNode TYPE_FLOAT() { return getToken(lang1Parser.TYPE_FLOAT, 0); }
		public TerminalNode NAME() { return getToken(lang1Parser.NAME, 0); }
		public TerminalNode ID() { return getToken(lang1Parser.ID, 0); }
		public BtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterBtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitBtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitBtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_btype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_CHAR) | (1L << TYPE_BOOL) | (1L << TYPE_FLOAT) | (1L << ID) | (1L << NAME))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class CmdContext extends ParserRuleContext {
		public List<TerminalNode> TYPE_OPEN_BRACE() { return getTokens(lang1Parser.TYPE_OPEN_BRACE); }
		public TerminalNode TYPE_OPEN_BRACE(int i) {
			return getToken(lang1Parser.TYPE_OPEN_BRACE, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode TYPE_IF() { return getToken(lang1Parser.TYPE_IF, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(lang1Parser.TYPE_OPEN_PARENTHESIS, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(lang1Parser.TYPE_CLOSE_PARENTHESIS, 0); }
		public TerminalNode TYPE_ELSE() { return getToken(lang1Parser.TYPE_ELSE, 0); }
		public TerminalNode TYPE_ITERATE() { return getToken(lang1Parser.TYPE_ITERATE, 0); }
		public TerminalNode TYPE_READ() { return getToken(lang1Parser.TYPE_READ, 0); }
		public List<LvalueContext> lvalue() {
			return getRuleContexts(LvalueContext.class);
		}
		public LvalueContext lvalue(int i) {
			return getRuleContext(LvalueContext.class,i);
		}
		public TerminalNode TYPE_SEMI() { return getToken(lang1Parser.TYPE_SEMI, 0); }
		public TerminalNode TYPE_PRINT() { return getToken(lang1Parser.TYPE_PRINT, 0); }
		public TerminalNode TYPE_RETURN() { return getToken(lang1Parser.TYPE_RETURN, 0); }
		public List<TerminalNode> TYPE_COMMA() { return getTokens(lang1Parser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(lang1Parser.TYPE_COMMA, i);
		}
		public TerminalNode TYPE_EQUAL() { return getToken(lang1Parser.TYPE_EQUAL, 0); }
		public TerminalNode ID() { return getToken(lang1Parser.ID, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public TerminalNode TYPE_LESS_THAN() { return getToken(lang1Parser.TYPE_LESS_THAN, 0); }
		public TerminalNode TYPE_GREATER_THAN() { return getToken(lang1Parser.TYPE_GREATER_THAN, 0); }
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		int _la;
		try {
			int _alt;
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(TYPE_OPEN_BRACE);
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(112);
						cmd();
						}
						} 
					}
					setState(117);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(118);
				match(TYPE_OPEN_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(TYPE_IF);
				setState(120);
				match(TYPE_OPEN_PARENTHESIS);
				setState(121);
				exp(0);
				setState(122);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(123);
				cmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(TYPE_IF);
				setState(126);
				match(TYPE_OPEN_PARENTHESIS);
				setState(127);
				exp(0);
				setState(128);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(129);
				cmd();
				setState(130);
				match(TYPE_ELSE);
				setState(131);
				cmd();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				match(TYPE_ITERATE);
				setState(134);
				match(TYPE_OPEN_PARENTHESIS);
				setState(135);
				exp(0);
				setState(136);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(137);
				cmd();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				match(TYPE_READ);
				setState(140);
				lvalue(0);
				setState(141);
				match(TYPE_SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(143);
				match(TYPE_PRINT);
				setState(144);
				exp(0);
				setState(145);
				match(TYPE_SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(TYPE_RETURN);
				setState(148);
				exp(0);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE_COMMA) {
					{
					{
					setState(149);
					match(TYPE_COMMA);
					setState(150);
					exp(0);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(156);
				match(TYPE_SEMI);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(158);
				lvalue(0);
				setState(159);
				match(TYPE_EQUAL);
				setState(160);
				exp(0);
				setState(161);
				match(TYPE_SEMI);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(163);
				match(ID);
				setState(164);
				match(TYPE_OPEN_PARENTHESIS);
				setState(165);
				exps();
				setState(166);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_LESS_THAN) {
					{
					setState(167);
					match(TYPE_LESS_THAN);
					setState(168);
					lvalue(0);
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==TYPE_COMMA) {
						{
						{
						setState(169);
						match(TYPE_COMMA);
						setState(170);
						lvalue(0);
						}
						}
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(176);
					match(TYPE_GREATER_THAN);
					}
				}

				setState(180);
				match(TYPE_SEMI);
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

	public static class ExpContext extends ParserRuleContext {
		public CexprContext cexpr() {
			return getRuleContext(CexprContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TYPE_AND() { return getToken(lang1Parser.TYPE_AND, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(185);
			cexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(187);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(188);
					match(TYPE_AND);
					setState(189);
					exp(3);
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CexprContext extends ParserRuleContext {
		public List<BaexpContext> baexp() {
			return getRuleContexts(BaexpContext.class);
		}
		public BaexpContext baexp(int i) {
			return getRuleContext(BaexpContext.class,i);
		}
		public TerminalNode TYPE_LESS_THAN() { return getToken(lang1Parser.TYPE_LESS_THAN, 0); }
		public CexprContext cexpr() {
			return getRuleContext(CexprContext.class,0);
		}
		public TerminalNode TYPE_EQUAL_EQUAL() { return getToken(lang1Parser.TYPE_EQUAL_EQUAL, 0); }
		public TerminalNode TYPE_NO_EQUAL() { return getToken(lang1Parser.TYPE_NO_EQUAL, 0); }
		public CexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterCexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitCexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitCexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CexprContext cexpr() throws RecognitionException {
		return cexpr(0);
	}

	private CexprContext cexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CexprContext _localctx = new CexprContext(_ctx, _parentState);
		CexprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_cexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(196);
				baexp(0);
				setState(197);
				match(TYPE_LESS_THAN);
				setState(198);
				baexp(0);
				}
				break;
			case 2:
				{
				setState(200);
				baexp(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new CexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cexpr);
						setState(203);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(204);
						match(TYPE_EQUAL_EQUAL);
						setState(205);
						baexp(0);
						}
						break;
					case 2:
						{
						_localctx = new CexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cexpr);
						setState(206);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(207);
						match(TYPE_NO_EQUAL);
						setState(208);
						baexp(0);
						}
						break;
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BaexpContext extends ParserRuleContext {
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public BaexpContext baexp() {
			return getRuleContext(BaexpContext.class,0);
		}
		public TerminalNode TYPE_PLUS() { return getToken(lang1Parser.TYPE_PLUS, 0); }
		public TerminalNode TYPE_MINUS() { return getToken(lang1Parser.TYPE_MINUS, 0); }
		public BaexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterBaexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitBaexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitBaexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaexpContext baexp() throws RecognitionException {
		return baexp(0);
	}

	private BaexpContext baexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BaexpContext _localctx = new BaexpContext(_ctx, _parentState);
		BaexpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_baexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(215);
			opexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new BaexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_baexp);
						setState(217);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(218);
						match(TYPE_PLUS);
						setState(219);
						opexp(0);
						}
						break;
					case 2:
						{
						_localctx = new BaexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_baexp);
						setState(220);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(221);
						match(TYPE_MINUS);
						setState(222);
						opexp(0);
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OpexpContext extends ParserRuleContext {
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public TerminalNode TYPE_ASTERISK() { return getToken(lang1Parser.TYPE_ASTERISK, 0); }
		public TerminalNode TYPE_DIV() { return getToken(lang1Parser.TYPE_DIV, 0); }
		public TerminalNode TYPE_MOD() { return getToken(lang1Parser.TYPE_MOD, 0); }
		public OpexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterOpexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitOpexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitOpexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpexpContext opexp() throws RecognitionException {
		return opexp(0);
	}

	private OpexpContext opexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OpexpContext _localctx = new OpexpContext(_ctx, _parentState);
		OpexpContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_opexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(229);
			dexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new OpexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_opexp);
						setState(231);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(232);
						match(TYPE_ASTERISK);
						setState(233);
						dexp();
						}
						break;
					case 2:
						{
						_localctx = new OpexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_opexp);
						setState(234);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(235);
						match(TYPE_DIV);
						setState(236);
						dexp();
						}
						break;
					case 3:
						{
						_localctx = new OpexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_opexp);
						setState(237);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(238);
						match(TYPE_MOD);
						setState(239);
						dexp();
						}
						break;
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DexpContext extends ParserRuleContext {
		public TerminalNode TYPE_EXCLAMATION() { return getToken(lang1Parser.TYPE_EXCLAMATION, 0); }
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public TerminalNode TYPE_MINUS() { return getToken(lang1Parser.TYPE_MINUS, 0); }
		public TerminalNode TYPE_TRUE() { return getToken(lang1Parser.TYPE_TRUE, 0); }
		public TerminalNode TYPE_FALSE() { return getToken(lang1Parser.TYPE_FALSE, 0); }
		public TerminalNode TYPE_NULL() { return getToken(lang1Parser.TYPE_NULL, 0); }
		public TerminalNode INT() { return getToken(lang1Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(lang1Parser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(lang1Parser.CHAR, 0); }
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public DexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitDexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DexpContext dexp() throws RecognitionException {
		DexpContext _localctx = new DexpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dexp);
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_EXCLAMATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(TYPE_EXCLAMATION);
				setState(246);
				dexp();
				}
				break;
			case TYPE_MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(TYPE_MINUS);
				setState(248);
				dexp();
				}
				break;
			case TYPE_TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(TYPE_TRUE);
				}
				break;
			case TYPE_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				match(TYPE_FALSE);
				}
				break;
			case TYPE_NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
				match(TYPE_NULL);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 6);
				{
				setState(252);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(253);
				match(FLOAT);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 8);
				{
				setState(254);
				match(CHAR);
				}
				break;
			case TYPE_NEW:
			case ID:
			case TYPE_OPEN_PARENTHESIS:
				enterOuterAlt(_localctx, 9);
				{
				setState(255);
				rexp();
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

	public static class RexpContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(lang1Parser.TYPE_OPEN_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(lang1Parser.TYPE_CLOSE_PARENTHESIS, 0); }
		public TerminalNode TYPE_NEW() { return getToken(lang1Parser.TYPE_NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TYPE_OPEN_BRACKET() { return getToken(lang1Parser.TYPE_OPEN_BRACKET, 0); }
		public TerminalNode TYPE_CLOSE_BRACKET() { return getToken(lang1Parser.TYPE_CLOSE_BRACKET, 0); }
		public TerminalNode ID() { return getToken(lang1Parser.ID, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public RexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterRexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitRexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitRexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RexpContext rexp() throws RecognitionException {
		RexpContext _localctx = new RexpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rexp);
		int _la;
		try {
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				lvalue(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(TYPE_OPEN_PARENTHESIS);
				setState(260);
				exp(0);
				setState(261);
				match(TYPE_CLOSE_PARENTHESIS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				match(TYPE_NEW);
				setState(264);
				type(0);
				setState(269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(265);
					match(TYPE_OPEN_BRACKET);
					setState(266);
					exp(0);
					setState(267);
					match(TYPE_CLOSE_BRACKET);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(271);
				match(ID);
				setState(272);
				match(TYPE_OPEN_PARENTHESIS);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NEW) | (1L << TYPE_NULL) | (1L << TYPE_TRUE) | (1L << TYPE_FALSE) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CHAR) | (1L << TYPE_OPEN_PARENTHESIS) | (1L << TYPE_EXCLAMATION) | (1L << TYPE_MINUS))) != 0)) {
					{
					setState(273);
					exps();
					}
				}

				setState(276);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(277);
				match(TYPE_OPEN_BRACKET);
				setState(278);
				exp(0);
				setState(279);
				match(TYPE_CLOSE_BRACKET);
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

	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lang1Parser.ID, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode TYPE_OPEN_BRACKET() { return getToken(lang1Parser.TYPE_OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_BRACKET() { return getToken(lang1Parser.TYPE_CLOSE_BRACKET, 0); }
		public TerminalNode TYPE_DOT() { return getToken(lang1Parser.TYPE_DOT, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitLvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(284);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(294);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(286);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(287);
						match(TYPE_OPEN_BRACKET);
						setState(288);
						exp(0);
						setState(289);
						match(TYPE_CLOSE_BRACKET);
						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(291);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(292);
						match(TYPE_DOT);
						setState(293);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> TYPE_COMMA() { return getTokens(lang1Parser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(lang1Parser.TYPE_COMMA, i);
		}
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).enterExps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lang1Listener ) ((lang1Listener)listener).exitExps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lang1Visitor ) return ((lang1Visitor<? extends T>)visitor).visitExps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			exp(0);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE_COMMA) {
				{
				{
				setState(300);
				match(TYPE_COMMA);
				setState(301);
				exp(0);
				}
				}
				setState(306);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 9:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 10:
			return cexpr_sempred((CexprContext)_localctx, predIndex);
		case 11:
			return baexp_sempred((BaexpContext)_localctx, predIndex);
		case 12:
			return opexp_sempred((OpexpContext)_localctx, predIndex);
		case 15:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean cexpr_sempred(CexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean baexp_sempred(BaexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean opexp_sempred(OpexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0136\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\5\3-\n\3\3\4\3\4\3\4\3\4\7\4\63\n"+
		"\4\f\4\16\4\66\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6B\n\6\3"+
		"\6\3\6\3\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\5\6N\n\6\3\6\3\6\7\6R\n\6\f"+
		"\6\16\6U\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\t\3\t\3\n\3\n\7\n"+
		"t\n\n\f\n\16\nw\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u009a\n\n\f\n\16\n\u009d\13\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ae\n\n\f\n\16\n\u00b1\13\n"+
		"\3\n\3\n\5\n\u00b5\n\n\3\n\3\n\5\n\u00b9\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00c1\n\13\f\13\16\13\u00c4\13\13\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u00cc\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00d4\n\f\f\f\16\f\u00d7\13\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e2\n\r\f\r\16\r\u00e5\13\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00f3"+
		"\n\16\f\16\16\16\u00f6\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u0103\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0110\n\20\3\20\3\20\3\20\5\20\u0115\n\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u011c\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\7\21\u0129\n\21\f\21\16\21\u012c\13\21\3\22\3\22"+
		"\3\22\7\22\u0131\n\22\f\22\16\22\u0134\13\22\3\22\2\b\16\24\26\30\32 "+
		"\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\3\4\2\3\6\22\23\2\u0152"+
		"\2\'\3\2\2\2\4,\3\2\2\2\6.\3\2\2\2\b9\3\2\2\2\n>\3\2\2\2\fX\3\2\2\2\16"+
		"d\3\2\2\2\20o\3\2\2\2\22\u00b8\3\2\2\2\24\u00ba\3\2\2\2\26\u00cb\3\2\2"+
		"\2\30\u00d8\3\2\2\2\32\u00e6\3\2\2\2\34\u0102\3\2\2\2\36\u011b\3\2\2\2"+
		" \u011d\3\2\2\2\"\u012d\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2"+
		"\2\'(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*-\5\6\4\2+-\5\n\6\2,*\3\2\2\2,+\3"+
		"\2\2\2-\5\3\2\2\2./\7\b\2\2/\60\7\23\2\2\60\64\7 \2\2\61\63\5\b\5\2\62"+
		"\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66"+
		"\64\3\2\2\2\678\7!\2\28\7\3\2\2\29:\7\22\2\2:;\7/\2\2;<\5\16\b\2<=\7-"+
		"\2\2=\t\3\2\2\2>?\7\22\2\2?A\7\36\2\2@B\5\f\7\2A@\3\2\2\2AB\3\2\2\2BC"+
		"\3\2\2\2CM\7\37\2\2DE\7.\2\2EJ\5\16\b\2FG\7\60\2\2GI\5\16\b\2HF\3\2\2"+
		"\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2MD\3\2\2\2MN\3\2\2"+
		"\2NO\3\2\2\2OS\7 \2\2PR\5\22\n\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2"+
		"\2TV\3\2\2\2US\3\2\2\2VW\7!\2\2W\13\3\2\2\2XY\7\22\2\2YZ\7/\2\2Za\5\16"+
		"\b\2[\\\7\60\2\2\\]\7\22\2\2]^\7/\2\2^`\5\16\b\2_[\3\2\2\2`c\3\2\2\2a"+
		"_\3\2\2\2ab\3\2\2\2b\r\3\2\2\2ca\3\2\2\2de\b\b\1\2ef\5\20\t\2fl\3\2\2"+
		"\2gh\f\4\2\2hi\7\33\2\2ik\7\34\2\2jg\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2"+
		"\2\2m\17\3\2\2\2nl\3\2\2\2op\t\2\2\2p\21\3\2\2\2qu\7 \2\2rt\5\22\n\2s"+
		"r\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2x\u00b9\7 "+
		"\2\2yz\7\t\2\2z{\7\36\2\2{|\5\24\13\2|}\7\37\2\2}~\5\22\n\2~\u00b9\3\2"+
		"\2\2\177\u0080\7\t\2\2\u0080\u0081\7\36\2\2\u0081\u0082\5\24\13\2\u0082"+
		"\u0083\7\37\2\2\u0083\u0084\5\22\n\2\u0084\u0085\7\n\2\2\u0085\u0086\5"+
		"\22\n\2\u0086\u00b9\3\2\2\2\u0087\u0088\7\13\2\2\u0088\u0089\7\36\2\2"+
		"\u0089\u008a\5\24\13\2\u008a\u008b\7\37\2\2\u008b\u008c\5\22\n\2\u008c"+
		"\u00b9\3\2\2\2\u008d\u008e\7\f\2\2\u008e\u008f\5 \21\2\u008f\u0090\7-"+
		"\2\2\u0090\u00b9\3\2\2\2\u0091\u0092\7\r\2\2\u0092\u0093\5\24\13\2\u0093"+
		"\u0094\7-\2\2\u0094\u00b9\3\2\2\2\u0095\u0096\7\16\2\2\u0096\u009b\5\24"+
		"\13\2\u0097\u0098\7\60\2\2\u0098\u009a\5\24\13\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7-\2\2\u009f\u00b9\3\2\2\2\u00a0"+
		"\u00a1\5 \21\2\u00a1\u00a2\7\61\2\2\u00a2\u00a3\5\24\13\2\u00a3\u00a4"+
		"\7-\2\2\u00a4\u00b9\3\2\2\2\u00a5\u00a6\7\22\2\2\u00a6\u00a7\7\36\2\2"+
		"\u00a7\u00a8\5\"\22\2\u00a8\u00b4\7\37\2\2\u00a9\u00aa\7(\2\2\u00aa\u00af"+
		"\5 \21\2\u00ab\u00ac\7\60\2\2\u00ac\u00ae\5 \21\2\u00ad\u00ab\3\2\2\2"+
		"\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7)\2\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00a9\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7-"+
		"\2\2\u00b7\u00b9\3\2\2\2\u00b8q\3\2\2\2\u00b8y\3\2\2\2\u00b8\177\3\2\2"+
		"\2\u00b8\u0087\3\2\2\2\u00b8\u008d\3\2\2\2\u00b8\u0091\3\2\2\2\u00b8\u0095"+
		"\3\2\2\2\u00b8\u00a0\3\2\2\2\u00b8\u00a5\3\2\2\2\u00b9\23\3\2\2\2\u00ba"+
		"\u00bb\b\13\1\2\u00bb\u00bc\5\26\f\2\u00bc\u00c2\3\2\2\2\u00bd\u00be\f"+
		"\4\2\2\u00be\u00bf\7,\2\2\u00bf\u00c1\5\24\13\5\u00c0\u00bd\3\2\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\25\3\2\2"+
		"\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\b\f\1\2\u00c6\u00c7\5\30\r\2\u00c7"+
		"\u00c8\7(\2\2\u00c8\u00c9\5\30\r\2\u00c9\u00cc\3\2\2\2\u00ca\u00cc\5\30"+
		"\r\2\u00cb\u00c5\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00d5\3\2\2\2\u00cd"+
		"\u00ce\f\5\2\2\u00ce\u00cf\7*\2\2\u00cf\u00d4\5\30\r\2\u00d0\u00d1\f\4"+
		"\2\2\u00d1\u00d2\7+\2\2\u00d2\u00d4\5\30\r\2\u00d3\u00cd\3\2\2\2\u00d3"+
		"\u00d0\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\27\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\b\r\1\2\u00d9\u00da"+
		"\5\32\16\2\u00da\u00e3\3\2\2\2\u00db\u00dc\f\5\2\2\u00dc\u00dd\7&\2\2"+
		"\u00dd\u00e2\5\32\16\2\u00de\u00df\f\4\2\2\u00df\u00e0\7\'\2\2\u00e0\u00e2"+
		"\5\32\16\2\u00e1\u00db\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\31\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e6\u00e7\b\16\1\2\u00e7\u00e8\5\34\17\2\u00e8\u00f4\3\2\2"+
		"\2\u00e9\u00ea\f\6\2\2\u00ea\u00eb\7#\2\2\u00eb\u00f3\5\34\17\2\u00ec"+
		"\u00ed\f\5\2\2\u00ed\u00ee\7$\2\2\u00ee\u00f3\5\34\17\2\u00ef\u00f0\f"+
		"\4\2\2\u00f0\u00f1\7%\2\2\u00f1\u00f3\5\34\17\2\u00f2\u00e9\3\2\2\2\u00f2"+
		"\u00ec\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5\33\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8"+
		"\7\"\2\2\u00f8\u0103\5\34\17\2\u00f9\u00fa\7\'\2\2\u00fa\u0103\5\34\17"+
		"\2\u00fb\u0103\7\20\2\2\u00fc\u0103\7\21\2\2\u00fd\u0103\7\17\2\2\u00fe"+
		"\u0103\7\24\2\2\u00ff\u0103\7\25\2\2\u0100\u0103\7\26\2\2\u0101\u0103"+
		"\5\36\20\2\u0102\u00f7\3\2\2\2\u0102\u00f9\3\2\2\2\u0102\u00fb\3\2\2\2"+
		"\u0102\u00fc\3\2\2\2\u0102\u00fd\3\2\2\2\u0102\u00fe\3\2\2\2\u0102\u00ff"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103\35\3\2\2\2\u0104"+
		"\u011c\5 \21\2\u0105\u0106\7\36\2\2\u0106\u0107\5\24\13\2\u0107\u0108"+
		"\7\37\2\2\u0108\u011c\3\2\2\2\u0109\u010a\7\7\2\2\u010a\u010f\5\16\b\2"+
		"\u010b\u010c\7\33\2\2\u010c\u010d\5\24\13\2\u010d\u010e\7\34\2\2\u010e"+
		"\u0110\3\2\2\2\u010f\u010b\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u011c\3\2"+
		"\2\2\u0111\u0112\7\22\2\2\u0112\u0114\7\36\2\2\u0113\u0115\5\"\22\2\u0114"+
		"\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\37"+
		"\2\2\u0117\u0118\7\33\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7\34\2\2\u011a"+
		"\u011c\3\2\2\2\u011b\u0104\3\2\2\2\u011b\u0105\3\2\2\2\u011b\u0109\3\2"+
		"\2\2\u011b\u0111\3\2\2\2\u011c\37\3\2\2\2\u011d\u011e\b\21\1\2\u011e\u011f"+
		"\7\22\2\2\u011f\u012a\3\2\2\2\u0120\u0121\f\4\2\2\u0121\u0122\7\33\2\2"+
		"\u0122\u0123\5\24\13\2\u0123\u0124\7\34\2\2\u0124\u0129\3\2\2\2\u0125"+
		"\u0126\f\3\2\2\u0126\u0127\7\35\2\2\u0127\u0129\7\22\2\2\u0128\u0120\3"+
		"\2\2\2\u0128\u0125\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b!\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0132\5\24\13"+
		"\2\u012e\u012f\7\60\2\2\u012f\u0131\5\24\13\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133#\3\2\2\2"+
		"\u0134\u0132\3\2\2\2\37\',\64AJMSalu\u009b\u00af\u00b4\u00b8\u00c2\u00cb"+
		"\u00d3\u00d5\u00e1\u00e3\u00f2\u00f4\u0102\u010f\u0114\u011b\u0128\u012a"+
		"\u0132";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}