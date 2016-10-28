// Generated from de/lab4inf/wrb/WRBLexer.g4 by ANTLR 4.5
package de.lab4inf.wrb;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WRBLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, NUMBER=2, FLOAT=3, INT=4, DIGIT=5, LETTER=6, WHITESPACE=7, SEP=8, 
		KOM=9, EXPO=10, EQUAL=11, ADD=12, SUB=13, MULT=14, DIV=15, MODULO=16, 
		UNDERSCORE=17, LBRACKET=18, RBRACKET=19, EVAL=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"VAR", "NUMBER", "FLOAT", "INT", "DIGIT", "LETTER", "WHITESPACE", "SEP", 
		"KOM", "EXPO", "EQUAL", "ADD", "SUB", "MULT", "DIV", "MODULO", "UNDERSCORE", 
		"LBRACKET", "RBRACKET", "EVAL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "';'", "','", null, "'='", 
		null, null, null, null, null, null, "'('", "')'", "'eval '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "VAR", "NUMBER", "FLOAT", "INT", "DIGIT", "LETTER", "WHITESPACE", 
		"SEP", "KOM", "EXPO", "EQUAL", "ADD", "SUB", "MULT", "DIV", "MODULO", 
		"UNDERSCORE", "LBRACKET", "RBRACKET", "EVAL"
	};
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


	public WRBLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WRBLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\7\2\60\n\2\f\2\16\2\63"+
		"\13\2\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\5\6\5B"+
		"\n\5\r\5\16\5C\3\6\3\6\3\7\5\7I\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\13\5\13V\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26\3\2\13\3\2\62;\4\2C\\c|\4\2\13\f\"\""+
		"\3\2--\3\2//\3\2,,\3\2\61\61\3\2\'\'\3\2aau\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\3+\3\2\2\2\5\66\3\2\2\2\78\3\2\2\2\tA\3\2\2\2\13E\3\2\2"+
		"\2\rH\3\2\2\2\17J\3\2\2\2\21N\3\2\2\2\23P\3\2\2\2\25U\3\2\2\2\27W\3\2"+
		"\2\2\31Y\3\2\2\2\33[\3\2\2\2\35]\3\2\2\2\37_\3\2\2\2!a\3\2\2\2#c\3\2\2"+
		"\2%e\3\2\2\2\'g\3\2\2\2)i\3\2\2\2+\61\5\r\7\2,\60\5\r\7\2-\60\5\13\6\2"+
		".\60\5#\22\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61"+
		"\62\3\2\2\2\62\4\3\2\2\2\63\61\3\2\2\2\64\67\5\t\5\2\65\67\5\7\4\2\66"+
		"\64\3\2\2\2\66\65\3\2\2\2\67\6\3\2\2\289\5\t\5\29=\7\60\2\2:<\5\13\6\2"+
		";:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\b\3\2\2\2?=\3\2\2\2@B\5\13\6"+
		"\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\n\3\2\2\2EF\t\2\2\2F\f\3\2"+
		"\2\2GI\t\3\2\2HG\3\2\2\2I\16\3\2\2\2JK\t\4\2\2KL\3\2\2\2LM\b\b\2\2M\20"+
		"\3\2\2\2NO\7=\2\2O\22\3\2\2\2PQ\7.\2\2Q\24\3\2\2\2RV\7`\2\2ST\7,\2\2T"+
		"V\7,\2\2UR\3\2\2\2US\3\2\2\2V\26\3\2\2\2WX\7?\2\2X\30\3\2\2\2YZ\t\5\2"+
		"\2Z\32\3\2\2\2[\\\t\6\2\2\\\34\3\2\2\2]^\t\7\2\2^\36\3\2\2\2_`\t\b\2\2"+
		"` \3\2\2\2ab\t\t\2\2b\"\3\2\2\2cd\t\n\2\2d$\3\2\2\2ef\7*\2\2f&\3\2\2\2"+
		"gh\7+\2\2h(\3\2\2\2ij\7g\2\2jk\7x\2\2kl\7c\2\2lm\7n\2\2mn\7\"\2\2n*\3"+
		"\2\2\2\n\2/\61\66=CHU\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}