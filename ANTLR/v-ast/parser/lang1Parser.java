// Generated from parser/lang1.g4 by ANTLR 4.8
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
		RULE_lvalue = 10, RULE_exps = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "def", "data", "decl", "fun", "params", "type", "btype", "cmd", 
			"exp", "lvalue", "exps"
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
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE_DATA || _la==ID) {
				{
				{
				setState(24);
				def();
				}
				}
				setState(29);
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
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_def);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_DATA:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				data();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
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
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(TYPE_DATA);
			setState(35);
			match(NAME);
			setState(36);
			match(TYPE_OPEN_BRACE);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(37);
				decl();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(ID);
			setState(46);
			match(TYPE_SRO);
			setState(47);
			type(0);
			setState(48);
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
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ID);
			setState(51);
			match(TYPE_OPEN_PARENTHESIS);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(52);
				params();
				}
			}

			setState(55);
			match(TYPE_CLOSE_PARENTHESIS);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COLON) {
				{
				setState(56);
				match(TYPE_COLON);
				setState(57);
				type(0);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE_COMMA) {
					{
					{
					setState(58);
					match(TYPE_COMMA);
					setState(59);
					type(0);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(67);
			match(TYPE_OPEN_BRACE);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_IF) | (1L << TYPE_ITERATE) | (1L << TYPE_READ) | (1L << TYPE_PRINT) | (1L << TYPE_RETURN) | (1L << ID) | (1L << TYPE_OPEN_BRACE))) != 0)) {
				{
				{
				setState(68);
				cmd();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ID);
			setState(77);
			match(TYPE_SRO);
			setState(78);
			type(0);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE_COMMA) {
				{
				{
				setState(79);
				match(TYPE_COMMA);
				setState(80);
				match(ID);
				setState(81);
				match(TYPE_SRO);
				setState(82);
				type(0);
				}
				}
				setState(87);
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
			setState(89);
			btype();
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
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
					setState(91);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(92);
					match(TYPE_OPEN_BRACKET);
					setState(93);
					match(TYPE_CLOSE_BRACKET);
					}
					} 
				}
				setState(98);
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
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_btype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_CHAR) | (1L << TYPE_BOOL) | (1L << TYPE_FLOAT) | (1L << ID))) != 0)) ) {
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
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		int _la;
		try {
			int _alt;
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(TYPE_OPEN_BRACE);
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(102);
						cmd();
						}
						} 
					}
					setState(107);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(108);
				match(TYPE_OPEN_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(TYPE_IF);
				setState(110);
				match(TYPE_OPEN_PARENTHESIS);
				setState(111);
				exp(0);
				setState(112);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(113);
				cmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				match(TYPE_IF);
				setState(116);
				match(TYPE_OPEN_PARENTHESIS);
				setState(117);
				exp(0);
				setState(118);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(119);
				cmd();
				setState(120);
				match(TYPE_ELSE);
				setState(121);
				cmd();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(TYPE_ITERATE);
				setState(124);
				match(TYPE_OPEN_PARENTHESIS);
				setState(125);
				exp(0);
				setState(126);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(127);
				cmd();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				match(TYPE_READ);
				setState(130);
				lvalue(0);
				setState(131);
				match(TYPE_SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				match(TYPE_PRINT);
				setState(134);
				exp(0);
				setState(135);
				match(TYPE_SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(137);
				match(TYPE_RETURN);
				setState(138);
				exp(0);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE_COMMA) {
					{
					{
					setState(139);
					match(TYPE_COMMA);
					setState(140);
					exp(0);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(TYPE_SEMI);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(148);
				lvalue(0);
				setState(149);
				match(TYPE_EQUAL);
				setState(150);
				exp(0);
				setState(151);
				match(TYPE_SEMI);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(153);
				match(ID);
				setState(154);
				match(TYPE_OPEN_PARENTHESIS);
				setState(155);
				exps();
				setState(156);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_LESS_THAN) {
					{
					setState(157);
					match(TYPE_LESS_THAN);
					setState(158);
					lvalue(0);
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==TYPE_COMMA) {
						{
						{
						setState(159);
						match(TYPE_COMMA);
						setState(160);
						lvalue(0);
						}
						}
						setState(165);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(166);
					match(TYPE_GREATER_THAN);
					}
				}

				setState(170);
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
		public TerminalNode TYPE_EXCLAMATION() { return getToken(lang1Parser.TYPE_EXCLAMATION, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TYPE_MINUS() { return getToken(lang1Parser.TYPE_MINUS, 0); }
		public TerminalNode TYPE_TRUE() { return getToken(lang1Parser.TYPE_TRUE, 0); }
		public TerminalNode TYPE_FALSE() { return getToken(lang1Parser.TYPE_FALSE, 0); }
		public TerminalNode TYPE_NULL() { return getToken(lang1Parser.TYPE_NULL, 0); }
		public TerminalNode INT() { return getToken(lang1Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(lang1Parser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(lang1Parser.CHAR, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(lang1Parser.TYPE_OPEN_PARENTHESIS, 0); }
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
		public TerminalNode TYPE_AND() { return getToken(lang1Parser.TYPE_AND, 0); }
		public TerminalNode TYPE_LESS_THAN() { return getToken(lang1Parser.TYPE_LESS_THAN, 0); }
		public TerminalNode TYPE_EQUAL_EQUAL() { return getToken(lang1Parser.TYPE_EQUAL_EQUAL, 0); }
		public TerminalNode TYPE_NO_EQUAL() { return getToken(lang1Parser.TYPE_NO_EQUAL, 0); }
		public TerminalNode TYPE_PLUS() { return getToken(lang1Parser.TYPE_PLUS, 0); }
		public TerminalNode TYPE_ASTERISK() { return getToken(lang1Parser.TYPE_ASTERISK, 0); }
		public TerminalNode TYPE_DIV() { return getToken(lang1Parser.TYPE_DIV, 0); }
		public TerminalNode TYPE_MOD() { return getToken(lang1Parser.TYPE_MOD, 0); }
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(175);
				match(TYPE_EXCLAMATION);
				setState(176);
				exp(12);
				}
				break;
			case 2:
				{
				setState(177);
				match(TYPE_MINUS);
				setState(178);
				exp(11);
				}
				break;
			case 3:
				{
				setState(179);
				match(TYPE_TRUE);
				}
				break;
			case 4:
				{
				setState(180);
				match(TYPE_FALSE);
				}
				break;
			case 5:
				{
				setState(181);
				match(TYPE_NULL);
				}
				break;
			case 6:
				{
				setState(182);
				match(INT);
				}
				break;
			case 7:
				{
				setState(183);
				match(FLOAT);
				}
				break;
			case 8:
				{
				setState(184);
				match(CHAR);
				}
				break;
			case 9:
				{
				setState(185);
				lvalue(0);
				}
				break;
			case 10:
				{
				setState(186);
				match(TYPE_OPEN_PARENTHESIS);
				setState(187);
				exp(0);
				setState(188);
				match(TYPE_CLOSE_PARENTHESIS);
				}
				break;
			case 11:
				{
				setState(190);
				match(TYPE_NEW);
				setState(191);
				type(0);
				setState(196);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(192);
					match(TYPE_OPEN_BRACKET);
					setState(193);
					exp(0);
					setState(194);
					match(TYPE_CLOSE_BRACKET);
					}
					break;
				}
				}
				break;
			case 12:
				{
				setState(198);
				match(ID);
				setState(199);
				match(TYPE_OPEN_PARENTHESIS);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NEW) | (1L << TYPE_NULL) | (1L << TYPE_TRUE) | (1L << TYPE_FALSE) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CHAR) | (1L << TYPE_OPEN_PARENTHESIS) | (1L << TYPE_EXCLAMATION) | (1L << TYPE_MINUS))) != 0)) {
					{
					setState(200);
					exps();
					}
				}

				setState(203);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(204);
				match(TYPE_OPEN_BRACKET);
				setState(205);
				exp(0);
				setState(206);
				match(TYPE_CLOSE_BRACKET);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(210);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(211);
						match(TYPE_AND);
						setState(212);
						exp(22);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(213);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(214);
						match(TYPE_LESS_THAN);
						setState(215);
						exp(21);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(216);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(217);
						match(TYPE_EQUAL_EQUAL);
						setState(218);
						exp(20);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(219);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(220);
						match(TYPE_NO_EQUAL);
						setState(221);
						exp(19);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(222);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(223);
						match(TYPE_PLUS);
						setState(224);
						exp(18);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(225);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(226);
						match(TYPE_MINUS);
						setState(227);
						exp(17);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(228);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(229);
						match(TYPE_ASTERISK);
						setState(230);
						exp(16);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(231);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(232);
						match(TYPE_DIV);
						setState(233);
						exp(15);
						}
						break;
					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(234);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(235);
						match(TYPE_MOD);
						setState(236);
						exp(14);
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(243);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(253);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(245);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(246);
						match(TYPE_OPEN_BRACKET);
						setState(247);
						exp(0);
						setState(248);
						match(TYPE_CLOSE_BRACKET);
						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(250);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(251);
						match(TYPE_DOT);
						setState(252);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			exp(0);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE_COMMA) {
				{
				{
				setState(259);
				match(TYPE_COMMA);
				setState(260);
				exp(0);
				}
				}
				setState(265);
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
			return precpred(_ctx, 21);
		case 2:
			return precpred(_ctx, 20);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 15);
		case 8:
			return precpred(_ctx, 14);
		case 9:
			return precpred(_ctx, 13);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u010d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\5\3#\n\3"+
		"\3\4\3\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\5\68\n\6\3\6\3\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\5\6D\n"+
		"\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\7\7V\n\7\f\7\16\7Y\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\ba\n\b\f\b\16\bd\13"+
		"\b\3\t\3\t\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0090\n\n\f\n\16\n\u0093\13\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a4\n"+
		"\n\f\n\16\n\u00a7\13\n\3\n\3\n\5\n\u00ab\n\n\3\n\3\n\5\n\u00af\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c7\n\13\3\13\3\13\3\13\5\13"+
		"\u00cc\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d3\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00f0\n\13\f\13"+
		"\16\13\u00f3\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0100"+
		"\n\f\f\f\16\f\u0103\13\f\3\r\3\r\3\r\7\r\u0108\n\r\f\r\16\r\u010b\13\r"+
		"\3\r\2\5\16\24\26\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\4\2\3\6\22\22\2"+
		"\u012e\2\35\3\2\2\2\4\"\3\2\2\2\6$\3\2\2\2\b/\3\2\2\2\n\64\3\2\2\2\fN"+
		"\3\2\2\2\16Z\3\2\2\2\20e\3\2\2\2\22\u00ae\3\2\2\2\24\u00d2\3\2\2\2\26"+
		"\u00f4\3\2\2\2\30\u0104\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3\2"+
		"\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35\3\2\2\2 #\5\6\4\2"+
		"!#\5\n\6\2\" \3\2\2\2\"!\3\2\2\2#\5\3\2\2\2$%\7\b\2\2%&\7\23\2\2&*\7 "+
		"\2\2\')\5\b\5\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3"+
		"\2\2\2-.\7!\2\2.\7\3\2\2\2/\60\7\22\2\2\60\61\7/\2\2\61\62\5\16\b\2\62"+
		"\63\7-\2\2\63\t\3\2\2\2\64\65\7\22\2\2\65\67\7\36\2\2\668\5\f\7\2\67\66"+
		"\3\2\2\2\678\3\2\2\289\3\2\2\29C\7\37\2\2:;\7.\2\2;@\5\16\b\2<=\7\60\2"+
		"\2=?\5\16\b\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AD\3\2\2\2B@\3\2"+
		"\2\2C:\3\2\2\2CD\3\2\2\2DE\3\2\2\2EI\7 \2\2FH\5\22\n\2GF\3\2\2\2HK\3\2"+
		"\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7!\2\2M\13\3\2\2\2NO\7"+
		"\22\2\2OP\7/\2\2PW\5\16\b\2QR\7\60\2\2RS\7\22\2\2ST\7/\2\2TV\5\16\b\2"+
		"UQ\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\r\3\2\2\2YW\3\2\2\2Z[\b\b\1"+
		"\2[\\\5\20\t\2\\b\3\2\2\2]^\f\4\2\2^_\7\33\2\2_a\7\34\2\2`]\3\2\2\2ad"+
		"\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\17\3\2\2\2db\3\2\2\2ef\t\2\2\2f\21\3\2\2"+
		"\2gk\7 \2\2hj\5\22\n\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2"+
		"\2mk\3\2\2\2n\u00af\7 \2\2op\7\t\2\2pq\7\36\2\2qr\5\24\13\2rs\7\37\2\2"+
		"st\5\22\n\2t\u00af\3\2\2\2uv\7\t\2\2vw\7\36\2\2wx\5\24\13\2xy\7\37\2\2"+
		"yz\5\22\n\2z{\7\n\2\2{|\5\22\n\2|\u00af\3\2\2\2}~\7\13\2\2~\177\7\36\2"+
		"\2\177\u0080\5\24\13\2\u0080\u0081\7\37\2\2\u0081\u0082\5\22\n\2\u0082"+
		"\u00af\3\2\2\2\u0083\u0084\7\f\2\2\u0084\u0085\5\26\f\2\u0085\u0086\7"+
		"-\2\2\u0086\u00af\3\2\2\2\u0087\u0088\7\r\2\2\u0088\u0089\5\24\13\2\u0089"+
		"\u008a\7-\2\2\u008a\u00af\3\2\2\2\u008b\u008c\7\16\2\2\u008c\u0091\5\24"+
		"\13\2\u008d\u008e\7\60\2\2\u008e\u0090\5\24\13\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7-\2\2\u0095\u00af\3\2\2\2\u0096"+
		"\u0097\5\26\f\2\u0097\u0098\7\61\2\2\u0098\u0099\5\24\13\2\u0099\u009a"+
		"\7-\2\2\u009a\u00af\3\2\2\2\u009b\u009c\7\22\2\2\u009c\u009d\7\36\2\2"+
		"\u009d\u009e\5\30\r\2\u009e\u00aa\7\37\2\2\u009f\u00a0\7(\2\2\u00a0\u00a5"+
		"\5\26\f\2\u00a1\u00a2\7\60\2\2\u00a2\u00a4\5\26\f\2\u00a3\u00a1\3\2\2"+
		"\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7)\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u009f\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7-"+
		"\2\2\u00ad\u00af\3\2\2\2\u00aeg\3\2\2\2\u00aeo\3\2\2\2\u00aeu\3\2\2\2"+
		"\u00ae}\3\2\2\2\u00ae\u0083\3\2\2\2\u00ae\u0087\3\2\2\2\u00ae\u008b\3"+
		"\2\2\2\u00ae\u0096\3\2\2\2\u00ae\u009b\3\2\2\2\u00af\23\3\2\2\2\u00b0"+
		"\u00b1\b\13\1\2\u00b1\u00b2\7\"\2\2\u00b2\u00d3\5\24\13\16\u00b3\u00b4"+
		"\7\'\2\2\u00b4\u00d3\5\24\13\r\u00b5\u00d3\7\20\2\2\u00b6\u00d3\7\21\2"+
		"\2\u00b7\u00d3\7\17\2\2\u00b8\u00d3\7\24\2\2\u00b9\u00d3\7\25\2\2\u00ba"+
		"\u00d3\7\26\2\2\u00bb\u00d3\5\26\f\2\u00bc\u00bd\7\36\2\2\u00bd\u00be"+
		"\5\24\13\2\u00be\u00bf\7\37\2\2\u00bf\u00d3\3\2\2\2\u00c0\u00c1\7\7\2"+
		"\2\u00c1\u00c6\5\16\b\2\u00c2\u00c3\7\33\2\2\u00c3\u00c4\5\24\13\2\u00c4"+
		"\u00c5\7\34\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00d3\3\2\2\2\u00c8\u00c9\7\22\2\2\u00c9\u00cb\7\36\2\2\u00ca"+
		"\u00cc\5\30\r\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3"+
		"\2\2\2\u00cd\u00ce\7\37\2\2\u00ce\u00cf\7\33\2\2\u00cf\u00d0\5\24\13\2"+
		"\u00d0\u00d1\7\34\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00b0\3\2\2\2\u00d2\u00b3"+
		"\3\2\2\2\u00d2\u00b5\3\2\2\2\u00d2\u00b6\3\2\2\2\u00d2\u00b7\3\2\2\2\u00d2"+
		"\u00b8\3\2\2\2\u00d2\u00b9\3\2\2\2\u00d2\u00ba\3\2\2\2\u00d2\u00bb\3\2"+
		"\2\2\u00d2\u00bc\3\2\2\2\u00d2\u00c0\3\2\2\2\u00d2\u00c8\3\2\2\2\u00d3"+
		"\u00f1\3\2\2\2\u00d4\u00d5\f\27\2\2\u00d5\u00d6\7,\2\2\u00d6\u00f0\5\24"+
		"\13\30\u00d7\u00d8\f\26\2\2\u00d8\u00d9\7(\2\2\u00d9\u00f0\5\24\13\27"+
		"\u00da\u00db\f\25\2\2\u00db\u00dc\7*\2\2\u00dc\u00f0\5\24\13\26\u00dd"+
		"\u00de\f\24\2\2\u00de\u00df\7+\2\2\u00df\u00f0\5\24\13\25\u00e0\u00e1"+
		"\f\23\2\2\u00e1\u00e2\7&\2\2\u00e2\u00f0\5\24\13\24\u00e3\u00e4\f\22\2"+
		"\2\u00e4\u00e5\7\'\2\2\u00e5\u00f0\5\24\13\23\u00e6\u00e7\f\21\2\2\u00e7"+
		"\u00e8\7#\2\2\u00e8\u00f0\5\24\13\22\u00e9\u00ea\f\20\2\2\u00ea\u00eb"+
		"\7$\2\2\u00eb\u00f0\5\24\13\21\u00ec\u00ed\f\17\2\2\u00ed\u00ee\7%\2\2"+
		"\u00ee\u00f0\5\24\13\20\u00ef\u00d4\3\2\2\2\u00ef\u00d7\3\2\2\2\u00ef"+
		"\u00da\3\2\2\2\u00ef\u00dd\3\2\2\2\u00ef\u00e0\3\2\2\2\u00ef\u00e3\3\2"+
		"\2\2\u00ef\u00e6\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\25\3\2\2"+
		"\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\b\f\1\2\u00f5\u00f6\7\22\2\2\u00f6"+
		"\u0101\3\2\2\2\u00f7\u00f8\f\4\2\2\u00f8\u00f9\7\33\2\2\u00f9\u00fa\5"+
		"\24\13\2\u00fa\u00fb\7\34\2\2\u00fb\u0100\3\2\2\2\u00fc\u00fd\f\3\2\2"+
		"\u00fd\u00fe\7\35\2\2\u00fe\u0100\7\22\2\2\u00ff\u00f7\3\2\2\2\u00ff\u00fc"+
		"\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\27\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0109\5\24\13\2\u0105\u0106\7\60"+
		"\2\2\u0106\u0108\5\24\13\2\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\31\3\2\2\2\u010b\u0109\3\2\2"+
		"\2\30\35\"*\67@CIWbk\u0091\u00a5\u00aa\u00ae\u00c6\u00cb\u00d2\u00ef\u00f1"+
		"\u00ff\u0101\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}