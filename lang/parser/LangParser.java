// Generated from lang/parser/Lang.g4 by ANTLR 4.8

    package lang.parser;
     

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, LINE_COMMENT=3, COMMENT=4, TYPE_INT=5, TYPE_FLOAT=6, 
		TYPE_CHAR=7, TYPE_BOOL=8, TYPE_DATA=9, TYPE_IF=10, TYPE_ELSE=11, TYPE_ITERATE=12, 
		TYPE_READ=13, TYPE_PRINT=14, TYPE_RETURN=15, TYPE_NEW=16, TYPE_TRUE=17, 
		TYPE_FALSE=18, TYPE_NULL=19, TYPE_AND=20, TYPE_EQUAL_EQUAL=21, TYPE_NO_EQUAL=22, 
		TYPE_EXCLAMATION=23, TYPE_COMMA=24, DOT=25, TYPE_SEMI=26, TYPE_COLON=27, 
		TYPE_SRO=28, TYPE_LESS_THAN=29, TYPE_GREATER_THAN=30, TYPE_EQUAL=31, TYPE_ASTERISK=32, 
		TYPE_PLUS=33, TYPE_MINUS=34, TYPE_DIV=35, TYPE_MOD=36, TYPE_OPEN_BRACKET=37, 
		TYPE_CLOSE_BRACKET=38, TYPE_OPEN_PARENTHESIS=39, TYPE_CLOSE_PARENTHESIS=40, 
		TYPE_OPEN_BRACE=41, TYPE_CLOSE_BRACE=42, ID=43, TYPE_NAME=44, INT=45, 
		FLOAT=46, CHAR=47;
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
			null, null, null, null, null, "'Int'", "'Float'", "'Char'", "'Bool'", 
			"'data'", "'if'", "'else'", "'iterate'", "'read'", "'print'", "'return'", 
			"'new'", "'true'", "'false'", "'null'", "'&&'", "'=='", "'!='", "'!'", 
			"','", "'.'", "';'", "':'", "'::'", "'<'", "'>'", "'='", "'*'", "'+'", 
			"'-'", "'/'", "'%'", "'['", "']'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "WS", "LINE_COMMENT", "COMMENT", "TYPE_INT", "TYPE_FLOAT", 
			"TYPE_CHAR", "TYPE_BOOL", "TYPE_DATA", "TYPE_IF", "TYPE_ELSE", "TYPE_ITERATE", 
			"TYPE_READ", "TYPE_PRINT", "TYPE_RETURN", "TYPE_NEW", "TYPE_TRUE", "TYPE_FALSE", 
			"TYPE_NULL", "TYPE_AND", "TYPE_EQUAL_EQUAL", "TYPE_NO_EQUAL", "TYPE_EXCLAMATION", 
			"TYPE_COMMA", "DOT", "TYPE_SEMI", "TYPE_COLON", "TYPE_SRO", "TYPE_LESS_THAN", 
			"TYPE_GREATER_THAN", "TYPE_EQUAL", "TYPE_ASTERISK", "TYPE_PLUS", "TYPE_MINUS", 
			"TYPE_DIV", "TYPE_MOD", "TYPE_OPEN_BRACKET", "TYPE_CLOSE_BRACKET", "TYPE_OPEN_PARENTHESIS", 
			"TYPE_CLOSE_PARENTHESIS", "TYPE_OPEN_BRACE", "TYPE_CLOSE_BRACE", "ID", 
			"TYPE_NAME", "INT", "FLOAT", "CHAR"
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
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgNameContext extends ProgContext {
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public ProgNameContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterProgName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitProgName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitProgName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new ProgNameContext(_localctx);
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
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
	 
		public DefContext() { }
		public void copyFrom(DefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunDefContext extends DefContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FunDefContext(DefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFunDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFunDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFunDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DataDefContext extends DefContext {
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public DataDefContext(DefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDataDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDataDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDataDef(this);
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
				_localctx = new DataDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				data();
				}
				break;
			case ID:
				_localctx = new FunDefContext(_localctx);
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
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	 
		public DataContext() { }
		public void copyFrom(DataContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DataNameContext extends DataContext {
		public TerminalNode TYPE_DATA() { return getToken(LangParser.TYPE_DATA, 0); }
		public TerminalNode TYPE_NAME() { return getToken(LangParser.TYPE_NAME, 0); }
		public TerminalNode TYPE_OPEN_BRACE() { return getToken(LangParser.TYPE_OPEN_BRACE, 0); }
		public TerminalNode TYPE_CLOSE_BRACE() { return getToken(LangParser.TYPE_CLOSE_BRACE, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DataNameContext(DataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDataName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDataName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDataName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data);
		int _la;
		try {
			_localctx = new DataNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(TYPE_DATA);
			setState(45);
			match(TYPE_NAME);
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
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclNameContext extends DeclContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode TYPE_SRO() { return getToken(LangParser.TYPE_SRO, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TYPE_SEMI() { return getToken(LangParser.TYPE_SEMI, 0); }
		public DeclNameContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDeclName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDeclName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDeclName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			_localctx = new DeclNameContext(_localctx);
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
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	 
		public FunContext() { }
		public void copyFrom(FunContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunNameContext extends FunContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(LangParser.TYPE_OPEN_PARENTHESIS, 0); }
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(LangParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public TerminalNode TYPE_OPEN_BRACE() { return getToken(LangParser.TYPE_OPEN_BRACE, 0); }
		public TerminalNode TYPE_CLOSE_BRACE() { return getToken(LangParser.TYPE_CLOSE_BRACE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode TYPE_COLON() { return getToken(LangParser.TYPE_COLON, 0); }
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
		public List<TerminalNode> TYPE_COMMA() { return getTokens(LangParser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(LangParser.TYPE_COMMA, i);
		}
		public FunNameContext(FunContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFunName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFunName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFunName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun);
		int _la;
		try {
			_localctx = new FunNameContext(_localctx);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_IF) | (1L << TYPE_ITERATE) | (1L << TYPE_READ) | (1L << TYPE_PRINT) | (1L << TYPE_RETURN) | (1L << TYPE_OPEN_BRACE) | (1L << ID))) != 0)) {
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
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	 
		public ParamsContext() { }
		public void copyFrom(ParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamsNameContext extends ParamsContext {
		public List<TerminalNode> ID() { return getTokens(LangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LangParser.ID, i);
		}
		public List<TerminalNode> TYPE_SRO() { return getTokens(LangParser.TYPE_SRO); }
		public TerminalNode TYPE_SRO(int i) {
			return getToken(LangParser.TYPE_SRO, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> TYPE_COMMA() { return getTokens(LangParser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(LangParser.TYPE_COMMA, i);
		}
		public ParamsNameContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterParamsName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitParamsName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitParamsName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			_localctx = new ParamsNameContext(_localctx);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BtypeNameContext extends TypeContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public BtypeNameContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBtypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBtypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBtypeName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeNameContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TYPE_OPEN_BRACKET() { return getToken(LangParser.TYPE_OPEN_BRACKET, 0); }
		public TerminalNode TYPE_CLOSE_BRACKET() { return getToken(LangParser.TYPE_CLOSE_BRACKET, 0); }
		public TypeNameContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTypeName(this);
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
			_localctx = new BtypeNameContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

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
					_localctx = new TypeNameContext(new TypeContext(_parentctx, _parentState));
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
		public BtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btype; }
	 
		public BtypeContext() { }
		public void copyFrom(BtypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharTypeContext extends BtypeContext {
		public TerminalNode TYPE_CHAR() { return getToken(LangParser.TYPE_CHAR, 0); }
		public CharTypeContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCharType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCharType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NameTypeContext extends BtypeContext {
		public TerminalNode TYPE_NAME() { return getToken(LangParser.TYPE_NAME, 0); }
		public NameTypeContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNameType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNameType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNameType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatTypeContext extends BtypeContext {
		public TerminalNode TYPE_FLOAT() { return getToken(LangParser.TYPE_FLOAT, 0); }
		public FloatTypeContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFloatType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFloatType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends BtypeContext {
		public TerminalNode TYPE_INT() { return getToken(LangParser.TYPE_INT, 0); }
		public IntTypeContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends BtypeContext {
		public TerminalNode TYPE_BOOL() { return getToken(LangParser.TYPE_BOOL, 0); }
		public BoolTypeContext(BtypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_btype);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(TYPE_INT);
				}
				break;
			case TYPE_CHAR:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(TYPE_CHAR);
				}
				break;
			case TYPE_BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(TYPE_BOOL);
				}
				break;
			case TYPE_FLOAT:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(TYPE_FLOAT);
				}
				break;
			case TYPE_NAME:
				_localctx = new NameTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				match(TYPE_NAME);
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

	public static class CmdContext extends ParserRuleContext {
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	 
		public CmdContext() { }
		public void copyFrom(CmdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReadCmdContext extends CmdContext {
		public TerminalNode TYPE_READ() { return getToken(LangParser.TYPE_READ, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode TYPE_SEMI() { return getToken(LangParser.TYPE_SEMI, 0); }
		public ReadCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterReadCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitReadCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitReadCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseCmdContext extends CmdContext {
		public TerminalNode TYPE_IF() { return getToken(LangParser.TYPE_IF, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(LangParser.TYPE_OPEN_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(LangParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode TYPE_ELSE() { return getToken(LangParser.TYPE_ELSE, 0); }
		public IfElseCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIfElseCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIfElseCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIfElseCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueCmdContext extends CmdContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode TYPE_EQUAL() { return getToken(LangParser.TYPE_EQUAL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_SEMI() { return getToken(LangParser.TYPE_SEMI, 0); }
		public LvalueCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLvalueCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLvalueCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLvalueCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterateCmdContext extends CmdContext {
		public TerminalNode TYPE_ITERATE() { return getToken(LangParser.TYPE_ITERATE, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(LangParser.TYPE_OPEN_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(LangParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public IterateCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIterateCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIterateCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIterateCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintCmdContext extends CmdContext {
		public TerminalNode TYPE_PRINT() { return getToken(LangParser.TYPE_PRINT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_SEMI() { return getToken(LangParser.TYPE_SEMI, 0); }
		public PrintCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterPrintCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitPrintCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPrintCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnCmdContext extends CmdContext {
		public TerminalNode TYPE_RETURN() { return getToken(LangParser.TYPE_RETURN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TYPE_SEMI() { return getToken(LangParser.TYPE_SEMI, 0); }
		public List<TerminalNode> TYPE_COMMA() { return getTokens(LangParser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(LangParser.TYPE_COMMA, i);
		}
		public ReturnCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterReturnCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitReturnCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitReturnCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfCmdContext extends CmdContext {
		public TerminalNode TYPE_IF() { return getToken(LangParser.TYPE_IF, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(LangParser.TYPE_OPEN_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(LangParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public IfCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIfCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIfCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIfCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockCmdContext extends CmdContext {
		public TerminalNode TYPE_OPEN_BRACE() { return getToken(LangParser.TYPE_OPEN_BRACE, 0); }
		public TerminalNode TYPE_CLOSE_BRACE() { return getToken(LangParser.TYPE_CLOSE_BRACE, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlockCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBlockCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBlockCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBlockCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallCmdContext extends CmdContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(LangParser.TYPE_OPEN_PARENTHESIS, 0); }
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(LangParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public TerminalNode TYPE_SEMI() { return getToken(LangParser.TYPE_SEMI, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public TerminalNode TYPE_LESS_THAN() { return getToken(LangParser.TYPE_LESS_THAN, 0); }
		public List<LvalueContext> lvalue() {
			return getRuleContexts(LvalueContext.class);
		}
		public LvalueContext lvalue(int i) {
			return getRuleContext(LvalueContext.class,i);
		}
		public TerminalNode TYPE_GREATER_THAN() { return getToken(LangParser.TYPE_GREATER_THAN, 0); }
		public List<TerminalNode> TYPE_COMMA() { return getTokens(LangParser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(LangParser.TYPE_COMMA, i);
		}
		public FuncCallCmdContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFuncCallCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFuncCallCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncCallCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new BlockCmdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(TYPE_OPEN_BRACE);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_IF) | (1L << TYPE_ITERATE) | (1L << TYPE_READ) | (1L << TYPE_PRINT) | (1L << TYPE_RETURN) | (1L << TYPE_OPEN_BRACE) | (1L << ID))) != 0)) {
					{
					{
					setState(117);
					cmd();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(TYPE_CLOSE_BRACE);
				}
				break;
			case 2:
				_localctx = new IfCmdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(TYPE_IF);
				setState(125);
				match(TYPE_OPEN_PARENTHESIS);
				setState(126);
				exp(0);
				setState(127);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(128);
				cmd();
				}
				break;
			case 3:
				_localctx = new IfElseCmdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				match(TYPE_IF);
				setState(131);
				match(TYPE_OPEN_PARENTHESIS);
				setState(132);
				exp(0);
				setState(133);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(134);
				cmd();
				setState(135);
				match(TYPE_ELSE);
				setState(136);
				cmd();
				}
				break;
			case 4:
				_localctx = new IterateCmdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(TYPE_ITERATE);
				setState(139);
				match(TYPE_OPEN_PARENTHESIS);
				setState(140);
				exp(0);
				setState(141);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(142);
				cmd();
				}
				break;
			case 5:
				_localctx = new ReadCmdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(TYPE_READ);
				setState(145);
				lvalue(0);
				setState(146);
				match(TYPE_SEMI);
				}
				break;
			case 6:
				_localctx = new PrintCmdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				match(TYPE_PRINT);
				setState(149);
				exp(0);
				setState(150);
				match(TYPE_SEMI);
				}
				break;
			case 7:
				_localctx = new ReturnCmdContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(152);
				match(TYPE_RETURN);
				setState(153);
				exp(0);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE_COMMA) {
					{
					{
					setState(154);
					match(TYPE_COMMA);
					setState(155);
					exp(0);
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(TYPE_SEMI);
				}
				break;
			case 8:
				_localctx = new LvalueCmdContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(163);
				lvalue(0);
				setState(164);
				match(TYPE_EQUAL);
				setState(165);
				exp(0);
				setState(166);
				match(TYPE_SEMI);
				}
				break;
			case 9:
				_localctx = new FuncCallCmdContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(168);
				match(ID);
				setState(169);
				match(TYPE_OPEN_PARENTHESIS);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NEW) | (1L << TYPE_TRUE) | (1L << TYPE_FALSE) | (1L << TYPE_NULL) | (1L << TYPE_EXCLAMATION) | (1L << TYPE_MINUS) | (1L << TYPE_OPEN_PARENTHESIS) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CHAR))) != 0)) {
					{
					setState(170);
					exps();
					}
				}

				setState(173);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_LESS_THAN) {
					{
					setState(174);
					match(TYPE_LESS_THAN);
					setState(175);
					lvalue(0);
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==TYPE_COMMA) {
						{
						{
						setState(176);
						match(TYPE_COMMA);
						setState(177);
						lvalue(0);
						}
						}
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(183);
					match(TYPE_GREATER_THAN);
					}
				}

				setState(187);
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
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TYPE_AND() { return getToken(LangParser.TYPE_AND, 0); }
		public AndExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAndExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAndExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAndExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CexprExpContext extends ExpContext {
		public CexprContext cexpr() {
			return getRuleContext(CexprContext.class,0);
		}
		public CexprExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCexprExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCexprExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCexprExp(this);
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
			_localctx = new CexprExpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(191);
			cexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpContext(new ExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(193);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(194);
					match(TYPE_AND);
					setState(195);
					exp(3);
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public CexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cexpr; }
	 
		public CexprContext() { }
		public void copyFrom(CexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualsCexprContext extends CexprContext {
		public CexprContext cexpr() {
			return getRuleContext(CexprContext.class,0);
		}
		public TerminalNode TYPE_EQUAL_EQUAL() { return getToken(LangParser.TYPE_EQUAL_EQUAL, 0); }
		public BaexpContext baexp() {
			return getRuleContext(BaexpContext.class,0);
		}
		public EqualsCexprContext(CexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterEqualsCexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitEqualsCexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitEqualsCexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaexpCexprContext extends CexprContext {
		public BaexpContext baexp() {
			return getRuleContext(BaexpContext.class,0);
		}
		public BaexpCexprContext(CexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBaexpCexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBaexpCexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBaexpCexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualsCexprContext extends CexprContext {
		public CexprContext cexpr() {
			return getRuleContext(CexprContext.class,0);
		}
		public TerminalNode TYPE_NO_EQUAL() { return getToken(LangParser.TYPE_NO_EQUAL, 0); }
		public BaexpContext baexp() {
			return getRuleContext(BaexpContext.class,0);
		}
		public NotEqualsCexprContext(CexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNotEqualsCexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNotEqualsCexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNotEqualsCexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanCexprContext extends CexprContext {
		public List<BaexpContext> baexp() {
			return getRuleContexts(BaexpContext.class);
		}
		public BaexpContext baexp(int i) {
			return getRuleContext(BaexpContext.class,i);
		}
		public TerminalNode TYPE_LESS_THAN() { return getToken(LangParser.TYPE_LESS_THAN, 0); }
		public LessThanCexprContext(CexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLessThanCexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLessThanCexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLessThanCexpr(this);
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
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new LessThanCexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(202);
				baexp(0);
				setState(203);
				match(TYPE_LESS_THAN);
				setState(204);
				baexp(0);
				}
				break;
			case 2:
				{
				_localctx = new BaexpCexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				baexp(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(215);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new EqualsCexprContext(new CexprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cexpr);
						setState(209);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(210);
						match(TYPE_EQUAL_EQUAL);
						setState(211);
						baexp(0);
						}
						break;
					case 2:
						{
						_localctx = new NotEqualsCexprContext(new CexprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cexpr);
						setState(212);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(213);
						match(TYPE_NO_EQUAL);
						setState(214);
						baexp(0);
						}
						break;
					}
					} 
				}
				setState(219);
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

	public static class BaexpContext extends ParserRuleContext {
		public BaexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baexp; }
	 
		public BaexpContext() { }
		public void copyFrom(BaexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubBaexpContext extends BaexpContext {
		public BaexpContext baexp() {
			return getRuleContext(BaexpContext.class,0);
		}
		public TerminalNode TYPE_MINUS() { return getToken(LangParser.TYPE_MINUS, 0); }
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public SubBaexpContext(BaexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterSubBaexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitSubBaexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitSubBaexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddBaexpContext extends BaexpContext {
		public BaexpContext baexp() {
			return getRuleContext(BaexpContext.class,0);
		}
		public TerminalNode TYPE_PLUS() { return getToken(LangParser.TYPE_PLUS, 0); }
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public AddBaexpContext(BaexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAddBaexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAddBaexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAddBaexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpexpBaexpContext extends BaexpContext {
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public OpexpBaexpContext(BaexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterOpexpBaexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitOpexpBaexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitOpexpBaexp(this);
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
			_localctx = new OpexpBaexpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(221);
			opexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new AddBaexpContext(new BaexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_baexp);
						setState(223);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(224);
						match(TYPE_PLUS);
						setState(225);
						opexp(0);
						}
						break;
					case 2:
						{
						_localctx = new SubBaexpContext(new BaexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_baexp);
						setState(226);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(227);
						match(TYPE_MINUS);
						setState(228);
						opexp(0);
						}
						break;
					}
					} 
				}
				setState(233);
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

	public static class OpexpContext extends ParserRuleContext {
		public OpexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opexp; }
	 
		public OpexpContext() { }
		public void copyFrom(OpexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivOpexpContext extends OpexpContext {
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public TerminalNode TYPE_DIV() { return getToken(LangParser.TYPE_DIV, 0); }
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public DivOpexpContext(OpexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDivOpexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDivOpexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDivOpexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DexpOpexpContext extends OpexpContext {
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public DexpOpexpContext(OpexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDexpOpexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDexpOpexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDexpOpexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulOpexpContext extends OpexpContext {
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public TerminalNode TYPE_ASTERISK() { return getToken(LangParser.TYPE_ASTERISK, 0); }
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public MulOpexpContext(OpexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterMulOpexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitMulOpexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitMulOpexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModOpexpContext extends OpexpContext {
		public OpexpContext opexp() {
			return getRuleContext(OpexpContext.class,0);
		}
		public TerminalNode TYPE_MOD() { return getToken(LangParser.TYPE_MOD, 0); }
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public ModOpexpContext(OpexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterModOpexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitModOpexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitModOpexp(this);
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
			_localctx = new DexpOpexpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(235);
			dexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new MulOpexpContext(new OpexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_opexp);
						setState(237);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(238);
						match(TYPE_ASTERISK);
						setState(239);
						dexp();
						}
						break;
					case 2:
						{
						_localctx = new DivOpexpContext(new OpexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_opexp);
						setState(240);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(241);
						match(TYPE_DIV);
						setState(242);
						dexp();
						}
						break;
					case 3:
						{
						_localctx = new ModOpexpContext(new OpexpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_opexp);
						setState(243);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(244);
						match(TYPE_MOD);
						setState(245);
						dexp();
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		public DexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dexp; }
	 
		public DexpContext() { }
		public void copyFrom(DexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TrueDexpContext extends DexpContext {
		public TerminalNode TYPE_TRUE() { return getToken(LangParser.TYPE_TRUE, 0); }
		public TrueDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterTrueDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitTrueDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTrueDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatDexpContext extends DexpContext {
		public TerminalNode FLOAT() { return getToken(LangParser.FLOAT, 0); }
		public FloatDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFloatDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFloatDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFloatDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotDexpContext extends DexpContext {
		public TerminalNode TYPE_EXCLAMATION() { return getToken(LangParser.TYPE_EXCLAMATION, 0); }
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public NotDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNotDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNotDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNotDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharDexpContext extends DexpContext {
		public TerminalNode CHAR() { return getToken(LangParser.CHAR, 0); }
		public CharDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCharDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCharDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCharDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseDexpContext extends DexpContext {
		public TerminalNode TYPE_FALSE() { return getToken(LangParser.TYPE_FALSE, 0); }
		public FalseDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFalseDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFalseDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFalseDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullDexpContext extends DexpContext {
		public TerminalNode TYPE_NULL() { return getToken(LangParser.TYPE_NULL, 0); }
		public NullDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNullDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNullDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNullDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegDexpContext extends DexpContext {
		public TerminalNode TYPE_MINUS() { return getToken(LangParser.TYPE_MINUS, 0); }
		public DexpContext dexp() {
			return getRuleContext(DexpContext.class,0);
		}
		public NegDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNegDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNegDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNegDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntDexpContext extends DexpContext {
		public TerminalNode INT() { return getToken(LangParser.INT, 0); }
		public IntDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIntDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIntDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIntDexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RexpDexpContext extends DexpContext {
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public RexpDexpContext(DexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterRexpDexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitRexpDexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitRexpDexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DexpContext dexp() throws RecognitionException {
		DexpContext _localctx = new DexpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dexp);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_EXCLAMATION:
				_localctx = new NotDexpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(TYPE_EXCLAMATION);
				setState(252);
				dexp();
				}
				break;
			case TYPE_MINUS:
				_localctx = new NegDexpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(TYPE_MINUS);
				setState(254);
				dexp();
				}
				break;
			case TYPE_TRUE:
				_localctx = new TrueDexpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(TYPE_TRUE);
				}
				break;
			case TYPE_FALSE:
				_localctx = new FalseDexpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				match(TYPE_FALSE);
				}
				break;
			case TYPE_NULL:
				_localctx = new NullDexpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(257);
				match(TYPE_NULL);
				}
				break;
			case INT:
				_localctx = new IntDexpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(258);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatDexpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(259);
				match(FLOAT);
				}
				break;
			case CHAR:
				_localctx = new CharDexpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(260);
				match(CHAR);
				}
				break;
			case TYPE_NEW:
			case TYPE_OPEN_PARENTHESIS:
			case ID:
				_localctx = new RexpDexpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(261);
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
		public RexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rexp; }
	 
		public RexpContext() { }
		public void copyFrom(RexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewRexpContext extends RexpContext {
		public TerminalNode TYPE_NEW() { return getToken(LangParser.TYPE_NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TYPE_OPEN_BRACKET() { return getToken(LangParser.TYPE_OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_BRACKET() { return getToken(LangParser.TYPE_CLOSE_BRACKET, 0); }
		public NewRexpContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNewRexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNewRexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNewRexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenRexpContext extends RexpContext {
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(LangParser.TYPE_OPEN_PARENTHESIS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(LangParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public ParenRexpContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterParenRexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitParenRexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitParenRexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueRexpContext extends RexpContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public LvalueRexpContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterLvalueRexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitLvalueRexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLvalueRexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallRexpContext extends RexpContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public TerminalNode TYPE_OPEN_PARENTHESIS() { return getToken(LangParser.TYPE_OPEN_PARENTHESIS, 0); }
		public TerminalNode TYPE_CLOSE_PARENTHESIS() { return getToken(LangParser.TYPE_CLOSE_PARENTHESIS, 0); }
		public TerminalNode TYPE_OPEN_BRACKET() { return getToken(LangParser.TYPE_OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_BRACKET() { return getToken(LangParser.TYPE_CLOSE_BRACKET, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public FuncCallRexpContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFuncCallRexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFuncCallRexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncCallRexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RexpContext rexp() throws RecognitionException {
		RexpContext _localctx = new RexpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rexp);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new LvalueRexpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				lvalue(0);
				}
				break;
			case 2:
				_localctx = new ParenRexpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(TYPE_OPEN_PARENTHESIS);
				setState(266);
				exp(0);
				setState(267);
				match(TYPE_CLOSE_PARENTHESIS);
				}
				break;
			case 3:
				_localctx = new NewRexpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				match(TYPE_NEW);
				setState(270);
				type(0);
				setState(275);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(271);
					match(TYPE_OPEN_BRACKET);
					setState(272);
					exp(0);
					setState(273);
					match(TYPE_CLOSE_BRACKET);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new FuncCallRexpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(277);
				match(ID);
				setState(278);
				match(TYPE_OPEN_PARENTHESIS);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_NEW) | (1L << TYPE_TRUE) | (1L << TYPE_FALSE) | (1L << TYPE_NULL) | (1L << TYPE_EXCLAMATION) | (1L << TYPE_MINUS) | (1L << TYPE_OPEN_PARENTHESIS) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << CHAR))) != 0)) {
					{
					setState(279);
					exps();
					}
				}

				setState(282);
				match(TYPE_CLOSE_PARENTHESIS);
				setState(283);
				match(TYPE_OPEN_BRACKET);
				setState(284);
				exp(0);
				setState(285);
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
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	 
		public LvalueContext() { }
		public void copyFrom(LvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DotLvalueContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LangParser.DOT, 0); }
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public DotLvalueContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDotLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDotLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDotLvalue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdLvalueContext extends LvalueContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public IdLvalueContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIdLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIdLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIdLvalue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLvalueContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode TYPE_OPEN_BRACKET() { return getToken(LangParser.TYPE_OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TYPE_CLOSE_BRACKET() { return getToken(LangParser.TYPE_CLOSE_BRACKET, 0); }
		public ArrayLvalueContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterArrayLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitArrayLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitArrayLvalue(this);
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
			_localctx = new IdLvalueContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(290);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(300);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayLvalueContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(292);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(293);
						match(TYPE_OPEN_BRACKET);
						setState(294);
						exp(0);
						setState(295);
						match(TYPE_CLOSE_BRACKET);
						}
						break;
					case 2:
						{
						_localctx = new DotLvalueContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(297);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(298);
						match(DOT);
						setState(299);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
	 
		public ExpsContext() { }
		public void copyFrom(ExpsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpsNameContext extends ExpsContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> TYPE_COMMA() { return getTokens(LangParser.TYPE_COMMA); }
		public TerminalNode TYPE_COMMA(int i) {
			return getToken(LangParser.TYPE_COMMA, i);
		}
		public ExpsNameContext(ExpsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterExpsName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitExpsName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitExpsName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exps);
		int _la;
		try {
			_localctx = new ExpsNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			exp(0);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE_COMMA) {
				{
				{
				setState(306);
				match(TYPE_COMMA);
				setState(307);
				exp(0);
				}
				}
				setState(312);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u013c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\5\3-\n\3\3\4\3\4\3\4\3\4\7\4\63\n"+
		"\4\f\4\16\4\66\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6B\n\6\3"+
		"\6\3\6\3\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\5\6N\n\6\3\6\3\6\7\6R\n\6\f"+
		"\6\16\6U\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\t\3\t\3\t\3\t\3\t"+
		"\5\tu\n\t\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u009f\n\n\f\n\16\n\u00a2\13\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ae\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\n\u00b5\n\n\f\n\16\n\u00b8\13\n\3\n\3\n\5\n\u00bc\n\n\3\n\5\n\u00bf"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00c7\n\13\f\13\16\13\u00ca\13"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d2\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f"+
		"\u00da\n\f\f\f\16\f\u00dd\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u00e8\n\r\f\r\16\r\u00eb\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u00f9\n\16\f\16\16\16\u00fc\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0109\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0116\n\20\3\20\3\20"+
		"\3\20\5\20\u011b\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u0122\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u012f\n\21\f\21"+
		"\16\21\u0132\13\21\3\22\3\22\3\22\7\22\u0137\n\22\f\22\16\22\u013a\13"+
		"\22\3\22\2\b\16\24\26\30\32 \23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"\2\2\2\u015d\2\'\3\2\2\2\4,\3\2\2\2\6.\3\2\2\2\b9\3\2\2\2\n>\3\2\2"+
		"\2\fX\3\2\2\2\16d\3\2\2\2\20t\3\2\2\2\22\u00be\3\2\2\2\24\u00c0\3\2\2"+
		"\2\26\u00d1\3\2\2\2\30\u00de\3\2\2\2\32\u00ec\3\2\2\2\34\u0108\3\2\2\2"+
		"\36\u0121\3\2\2\2 \u0123\3\2\2\2\"\u0133\3\2\2\2$&\5\4\3\2%$\3\2\2\2&"+
		")\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*-\5\6\4\2+-\5\n"+
		"\6\2,*\3\2\2\2,+\3\2\2\2-\5\3\2\2\2./\7\13\2\2/\60\7.\2\2\60\64\7+\2\2"+
		"\61\63\5\b\5\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\67\3\2\2\2\66\64\3\2\2\2\678\7,\2\28\7\3\2\2\29:\7-\2\2:;\7\36\2\2"+
		";<\5\16\b\2<=\7\34\2\2=\t\3\2\2\2>?\7-\2\2?A\7)\2\2@B\5\f\7\2A@\3\2\2"+
		"\2AB\3\2\2\2BC\3\2\2\2CM\7*\2\2DE\7\35\2\2EJ\5\16\b\2FG\7\32\2\2GI\5\16"+
		"\b\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2MD\3\2"+
		"\2\2MN\3\2\2\2NO\3\2\2\2OS\7+\2\2PR\5\22\n\2QP\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7,\2\2W\13\3\2\2\2XY\7-\2\2YZ\7\36"+
		"\2\2Za\5\16\b\2[\\\7\32\2\2\\]\7-\2\2]^\7\36\2\2^`\5\16\b\2_[\3\2\2\2"+
		"`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\r\3\2\2\2ca\3\2\2\2de\b\b\1\2ef\5\20\t"+
		"\2fl\3\2\2\2gh\f\4\2\2hi\7\'\2\2ik\7(\2\2jg\3\2\2\2kn\3\2\2\2lj\3\2\2"+
		"\2lm\3\2\2\2m\17\3\2\2\2nl\3\2\2\2ou\7\7\2\2pu\7\t\2\2qu\7\n\2\2ru\7\b"+
		"\2\2su\7.\2\2to\3\2\2\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\21\3"+
		"\2\2\2vz\7+\2\2wy\5\22\n\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3"+
		"\2\2\2|z\3\2\2\2}\u00bf\7,\2\2~\177\7\f\2\2\177\u0080\7)\2\2\u0080\u0081"+
		"\5\24\13\2\u0081\u0082\7*\2\2\u0082\u0083\5\22\n\2\u0083\u00bf\3\2\2\2"+
		"\u0084\u0085\7\f\2\2\u0085\u0086\7)\2\2\u0086\u0087\5\24\13\2\u0087\u0088"+
		"\7*\2\2\u0088\u0089\5\22\n\2\u0089\u008a\7\r\2\2\u008a\u008b\5\22\n\2"+
		"\u008b\u00bf\3\2\2\2\u008c\u008d\7\16\2\2\u008d\u008e\7)\2\2\u008e\u008f"+
		"\5\24\13\2\u008f\u0090\7*\2\2\u0090\u0091\5\22\n\2\u0091\u00bf\3\2\2\2"+
		"\u0092\u0093\7\17\2\2\u0093\u0094\5 \21\2\u0094\u0095\7\34\2\2\u0095\u00bf"+
		"\3\2\2\2\u0096\u0097\7\20\2\2\u0097\u0098\5\24\13\2\u0098\u0099\7\34\2"+
		"\2\u0099\u00bf\3\2\2\2\u009a\u009b\7\21\2\2\u009b\u00a0\5\24\13\2\u009c"+
		"\u009d\7\32\2\2\u009d\u009f\5\24\13\2\u009e\u009c\3\2\2\2\u009f\u00a2"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00a4\7\34\2\2\u00a4\u00bf\3\2\2\2\u00a5\u00a6\5"+
		" \21\2\u00a6\u00a7\7!\2\2\u00a7\u00a8\5\24\13\2\u00a8\u00a9\7\34\2\2\u00a9"+
		"\u00bf\3\2\2\2\u00aa\u00ab\7-\2\2\u00ab\u00ad\7)\2\2\u00ac\u00ae\5\"\22"+
		"\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00bb"+
		"\7*\2\2\u00b0\u00b1\7\37\2\2\u00b1\u00b6\5 \21\2\u00b2\u00b3\7\32\2\2"+
		"\u00b3\u00b5\5 \21\2\u00b4\u00b2\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00ba\7 \2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b0\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\7\34\2\2\u00bev\3\2\2\2\u00be~\3"+
		"\2\2\2\u00be\u0084\3\2\2\2\u00be\u008c\3\2\2\2\u00be\u0092\3\2\2\2\u00be"+
		"\u0096\3\2\2\2\u00be\u009a\3\2\2\2\u00be\u00a5\3\2\2\2\u00be\u00aa\3\2"+
		"\2\2\u00bf\23\3\2\2\2\u00c0\u00c1\b\13\1\2\u00c1\u00c2\5\26\f\2\u00c2"+
		"\u00c8\3\2\2\2\u00c3\u00c4\f\4\2\2\u00c4\u00c5\7\26\2\2\u00c5\u00c7\5"+
		"\24\13\5\u00c6\u00c3\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\25\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\b\f\1"+
		"\2\u00cc\u00cd\5\30\r\2\u00cd\u00ce\7\37\2\2\u00ce\u00cf\5\30\r\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00d2\5\30\r\2\u00d1\u00cb\3\2\2\2\u00d1\u00d0\3"+
		"\2\2\2\u00d2\u00db\3\2\2\2\u00d3\u00d4\f\5\2\2\u00d4\u00d5\7\27\2\2\u00d5"+
		"\u00da\5\30\r\2\u00d6\u00d7\f\4\2\2\u00d7\u00d8\7\30\2\2\u00d8\u00da\5"+
		"\30\r\2\u00d9\u00d3\3\2\2\2\u00d9\u00d6\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\27\3\2\2\2\u00dd\u00db\3\2\2"+
		"\2\u00de\u00df\b\r\1\2\u00df\u00e0\5\32\16\2\u00e0\u00e9\3\2\2\2\u00e1"+
		"\u00e2\f\5\2\2\u00e2\u00e3\7#\2\2\u00e3\u00e8\5\32\16\2\u00e4\u00e5\f"+
		"\4\2\2\u00e5\u00e6\7$\2\2\u00e6\u00e8\5\32\16\2\u00e7\u00e1\3\2\2\2\u00e7"+
		"\u00e4\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\31\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b\16\1\2\u00ed\u00ee"+
		"\5\34\17\2\u00ee\u00fa\3\2\2\2\u00ef\u00f0\f\6\2\2\u00f0\u00f1\7\"\2\2"+
		"\u00f1\u00f9\5\34\17\2\u00f2\u00f3\f\5\2\2\u00f3\u00f4\7%\2\2\u00f4\u00f9"+
		"\5\34\17\2\u00f5\u00f6\f\4\2\2\u00f6\u00f7\7&\2\2\u00f7\u00f9\5\34\17"+
		"\2\u00f8\u00ef\3\2\2\2\u00f8\u00f2\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f9\u00fc"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\33\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fd\u00fe\7\31\2\2\u00fe\u0109\5\34\17\2\u00ff\u0100"+
		"\7$\2\2\u0100\u0109\5\34\17\2\u0101\u0109\7\23\2\2\u0102\u0109\7\24\2"+
		"\2\u0103\u0109\7\25\2\2\u0104\u0109\7/\2\2\u0105\u0109\7\60\2\2\u0106"+
		"\u0109\7\61\2\2\u0107\u0109\5\36\20\2\u0108\u00fd\3\2\2\2\u0108\u00ff"+
		"\3\2\2\2\u0108\u0101\3\2\2\2\u0108\u0102\3\2\2\2\u0108\u0103\3\2\2\2\u0108"+
		"\u0104\3\2\2\2\u0108\u0105\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2"+
		"\2\2\u0109\35\3\2\2\2\u010a\u0122\5 \21\2\u010b\u010c\7)\2\2\u010c\u010d"+
		"\5\24\13\2\u010d\u010e\7*\2\2\u010e\u0122\3\2\2\2\u010f\u0110\7\22\2\2"+
		"\u0110\u0115\5\16\b\2\u0111\u0112\7\'\2\2\u0112\u0113\5\24\13\2\u0113"+
		"\u0114\7(\2\2\u0114\u0116\3\2\2\2\u0115\u0111\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0122\3\2\2\2\u0117\u0118\7-\2\2\u0118\u011a\7)\2\2\u0119\u011b"+
		"\5\"\22\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2"+
		"\u011c\u011d\7*\2\2\u011d\u011e\7\'\2\2\u011e\u011f\5\24\13\2\u011f\u0120"+
		"\7(\2\2\u0120\u0122\3\2\2\2\u0121\u010a\3\2\2\2\u0121\u010b\3\2\2\2\u0121"+
		"\u010f\3\2\2\2\u0121\u0117\3\2\2\2\u0122\37\3\2\2\2\u0123\u0124\b\21\1"+
		"\2\u0124\u0125\7-\2\2\u0125\u0130\3\2\2\2\u0126\u0127\f\4\2\2\u0127\u0128"+
		"\7\'\2\2\u0128\u0129\5\24\13\2\u0129\u012a\7(\2\2\u012a\u012f\3\2\2\2"+
		"\u012b\u012c\f\3\2\2\u012c\u012d\7\33\2\2\u012d\u012f\7-\2\2\u012e\u0126"+
		"\3\2\2\2\u012e\u012b\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131!\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0138\5\24\13"+
		"\2\u0134\u0135\7\32\2\2\u0135\u0137\5\24\13\2\u0136\u0134\3\2\2\2\u0137"+
		"\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139#\3\2\2\2"+
		"\u013a\u0138\3\2\2\2!\',\64AJMSaltz\u00a0\u00ad\u00b6\u00bb\u00be\u00c8"+
		"\u00d1\u00d9\u00db\u00e7\u00e9\u00f8\u00fa\u0108\u0115\u011a\u0121\u012e"+
		"\u0130\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}