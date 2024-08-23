// Generated from lang/parser/lang1.g4 by ANTLR 4.8

    package lang.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lang1Lexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TYPE_INT", "TYPE_CHAR", "TYPE_BOOL", "TYPE_FLOAT", "TYPE_NEW", "TYPE_DATA", 
			"TYPE_IF", "TYPE_ELSE", "TYPE_ITERATE", "TYPE_READ", "TYPE_PRINT", "TYPE_RETURN", 
			"TYPE_NULL", "TYPE_TRUE", "TYPE_FALSE", "ID", "NAME", "INT", "FLOAT", 
			"CHAR", "NEWLINE", "WS", "LINE_COMMENT", "COMMENT", "TYPE_OPEN_BRACKET", 
			"TYPE_CLOSE_BRACKET", "TYPE_DOT", "TYPE_OPEN_PARENTHESIS", "TYPE_CLOSE_PARENTHESIS", 
			"TYPE_OPEN_BRACE", "TYPE_CLOSE_BRACE", "TYPE_EXCLAMATION", "TYPE_ASTERISK", 
			"TYPE_DIV", "TYPE_MOD", "TYPE_PLUS", "TYPE_MINUS", "TYPE_LESS_THAN", 
			"TYPE_GREATER_THAN", "TYPE_EQUAL_EQUAL", "TYPE_NO_EQUAL", "TYPE_AND", 
			"TYPE_SEMI", "TYPE_COLON", "TYPE_SRO", "TYPE_COMMA", "TYPE_EQUAL"
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


	public lang1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lang1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0136\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u00b3\n\21\f\21\16\21\u00b6\13"+
		"\21\3\22\3\22\7\22\u00ba\n\22\f\22\16\22\u00bd\13\22\3\23\5\23\u00c0\n"+
		"\23\3\23\6\23\u00c3\n\23\r\23\16\23\u00c4\3\24\5\24\u00c8\n\24\3\24\7"+
		"\24\u00cb\n\24\f\24\16\24\u00ce\13\24\3\24\3\24\3\24\7\24\u00d3\n\24\f"+
		"\24\16\24\u00d6\13\24\3\25\3\25\3\25\3\25\3\26\5\26\u00dd\n\26\3\26\3"+
		"\26\3\26\3\26\3\27\6\27\u00e4\n\27\r\27\16\27\u00e5\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\7\30\u00ee\n\30\f\30\16\30\u00f1\13\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\7\31\u00fb\n\31\f\31\16\31\u00fe\13\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\u00fc\2\61"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\t\3\2c|\6\2\62;C\\aac|"+
		"\3\2C\\\3\2\62;\3\2\2\u0081\4\2\13\13\"\"\4\2\f\f\17\17\2\u0140\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2"+
		"\5e\3\2\2\2\7j\3\2\2\2\to\3\2\2\2\13u\3\2\2\2\ry\3\2\2\2\17~\3\2\2\2\21"+
		"\u0081\3\2\2\2\23\u0086\3\2\2\2\25\u008e\3\2\2\2\27\u0093\3\2\2\2\31\u0099"+
		"\3\2\2\2\33\u00a0\3\2\2\2\35\u00a5\3\2\2\2\37\u00aa\3\2\2\2!\u00b0\3\2"+
		"\2\2#\u00b7\3\2\2\2%\u00bf\3\2\2\2\'\u00c7\3\2\2\2)\u00d7\3\2\2\2+\u00dc"+
		"\3\2\2\2-\u00e3\3\2\2\2/\u00e9\3\2\2\2\61\u00f6\3\2\2\2\63\u0104\3\2\2"+
		"\2\65\u0106\3\2\2\2\67\u0108\3\2\2\29\u010a\3\2\2\2;\u010c\3\2\2\2=\u010e"+
		"\3\2\2\2?\u0110\3\2\2\2A\u0112\3\2\2\2C\u0114\3\2\2\2E\u0116\3\2\2\2G"+
		"\u0118\3\2\2\2I\u011a\3\2\2\2K\u011c\3\2\2\2M\u011e\3\2\2\2O\u0120\3\2"+
		"\2\2Q\u0122\3\2\2\2S\u0125\3\2\2\2U\u0128\3\2\2\2W\u012b\3\2\2\2Y\u012d"+
		"\3\2\2\2[\u012f\3\2\2\2]\u0132\3\2\2\2_\u0134\3\2\2\2ab\7k\2\2bc\7p\2"+
		"\2cd\7v\2\2d\4\3\2\2\2ef\7e\2\2fg\7j\2\2gh\7c\2\2hi\7t\2\2i\6\3\2\2\2"+
		"jk\7d\2\2kl\7q\2\2lm\7q\2\2mn\7n\2\2n\b\3\2\2\2op\7h\2\2pq\7n\2\2qr\7"+
		"q\2\2rs\7c\2\2st\7v\2\2t\n\3\2\2\2uv\7p\2\2vw\7g\2\2wx\7y\2\2x\f\3\2\2"+
		"\2yz\7f\2\2z{\7c\2\2{|\7v\2\2|}\7c\2\2}\16\3\2\2\2~\177\7k\2\2\177\u0080"+
		"\7h\2\2\u0080\20\3\2\2\2\u0081\u0082\7g\2\2\u0082\u0083\7n\2\2\u0083\u0084"+
		"\7u\2\2\u0084\u0085\7g\2\2\u0085\22\3\2\2\2\u0086\u0087\7k\2\2\u0087\u0088"+
		"\7v\2\2\u0088\u0089\7g\2\2\u0089\u008a\7t\2\2\u008a\u008b\7c\2\2\u008b"+
		"\u008c\7v\2\2\u008c\u008d\7g\2\2\u008d\24\3\2\2\2\u008e\u008f\7t\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7c\2\2\u0091\u0092\7f\2\2\u0092\26\3\2\2\2\u0093"+
		"\u0094\7r\2\2\u0094\u0095\7t\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2"+
		"\u0097\u0098\7v\2\2\u0098\30\3\2\2\2\u0099\u009a\7t\2\2\u009a\u009b\7"+
		"g\2\2\u009b\u009c\7v\2\2\u009c\u009d\7w\2\2\u009d\u009e\7t\2\2\u009e\u009f"+
		"\7p\2\2\u009f\32\3\2\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3"+
		"\7n\2\2\u00a3\u00a4\7n\2\2\u00a4\34\3\2\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7"+
		"\7t\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7g\2\2\u00a9\36\3\2\2\2\u00aa\u00ab"+
		"\7h\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7u\2\2\u00ae"+
		"\u00af\7g\2\2\u00af \3\2\2\2\u00b0\u00b4\t\2\2\2\u00b1\u00b3\t\3\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bb\t\4\2\2\u00b8\u00ba"+
		"\t\3\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc$\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\7/\2\2\u00bf"+
		"\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00c3\t\5"+
		"\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5&\3\2\2\2\u00c6\u00c8\7/\2\2\u00c7\u00c6\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb\t\5\2\2\u00ca\u00c9\3\2"+
		"\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\60\2\2\u00d0\u00d4\t"+
		"\5\2\2\u00d1\u00d3\t\5\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5(\3\2\2\2\u00d6\u00d4\3\2\2\2"+
		"\u00d7\u00d8\7)\2\2\u00d8\u00d9\t\6\2\2\u00d9\u00da\7)\2\2\u00da*\3\2"+
		"\2\2\u00db\u00dd\7\17\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\7\f\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b\26"+
		"\2\2\u00e1,\3\2\2\2\u00e2\u00e4\t\7\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\b\27\2\2\u00e8.\3\2\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\7\61\2"+
		"\2\u00eb\u00ef\3\2\2\2\u00ec\u00ee\n\b\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\5+\26\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b\30"+
		"\2\2\u00f5\60\3\2\2\2\u00f6\u00f7\7\61\2\2\u00f7\u00f8\7,\2\2\u00f8\u00fc"+
		"\3\2\2\2\u00f9\u00fb\13\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2"+
		"\u00fc\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc"+
		"\3\2\2\2\u00ff\u0100\7,\2\2\u0100\u0101\7\61\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0103\b\31\2\2\u0103\62\3\2\2\2\u0104\u0105\7]\2\2\u0105\64\3\2\2\2\u0106"+
		"\u0107\7_\2\2\u0107\66\3\2\2\2\u0108\u0109\7\60\2\2\u01098\3\2\2\2\u010a"+
		"\u010b\7*\2\2\u010b:\3\2\2\2\u010c\u010d\7+\2\2\u010d<\3\2\2\2\u010e\u010f"+
		"\7}\2\2\u010f>\3\2\2\2\u0110\u0111\7\177\2\2\u0111@\3\2\2\2\u0112\u0113"+
		"\7#\2\2\u0113B\3\2\2\2\u0114\u0115\7,\2\2\u0115D\3\2\2\2\u0116\u0117\7"+
		"\61\2\2\u0117F\3\2\2\2\u0118\u0119\7\'\2\2\u0119H\3\2\2\2\u011a\u011b"+
		"\7-\2\2\u011bJ\3\2\2\2\u011c\u011d\7/\2\2\u011dL\3\2\2\2\u011e\u011f\7"+
		">\2\2\u011fN\3\2\2\2\u0120\u0121\7@\2\2\u0121P\3\2\2\2\u0122\u0123\7?"+
		"\2\2\u0123\u0124\7?\2\2\u0124R\3\2\2\2\u0125\u0126\7#\2\2\u0126\u0127"+
		"\7?\2\2\u0127T\3\2\2\2\u0128\u0129\7(\2\2\u0129\u012a\7(\2\2\u012aV\3"+
		"\2\2\2\u012b\u012c\7=\2\2\u012cX\3\2\2\2\u012d\u012e\7<\2\2\u012eZ\3\2"+
		"\2\2\u012f\u0130\7<\2\2\u0130\u0131\7<\2\2\u0131\\\3\2\2\2\u0132\u0133"+
		"\7.\2\2\u0133^\3\2\2\2\u0134\u0135\7?\2\2\u0135`\3\2\2\2\16\2\u00b4\u00bb"+
		"\u00bf\u00c4\u00c7\u00cc\u00d4\u00dc\u00e5\u00ef\u00fc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}