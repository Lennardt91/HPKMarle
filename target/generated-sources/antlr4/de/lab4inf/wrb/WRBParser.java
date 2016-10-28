// Generated from de/lab4inf/wrb/WRBParser.g4 by ANTLR 4.5
package de.lab4inf.wrb;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WRBParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, NUMBER=2, FLOAT=3, INT=4, DIGIT=5, LETTER=6, WHITESPACE=7, SEP=8, 
		KOM=9, EXPO=10, EQUAL=11, ADD=12, SUB=13, MULT=14, DIV=15, MODULO=16, 
		UNDERSCORE=17, LBRACKET=18, RBRACKET=19, EVAL=20;
	public static final int
		RULE_programm = 0, RULE_state = 1, RULE_funcdec = 2, RULE_vardec = 3, 
		RULE_exp = 4, RULE_function = 5, RULE_sign = 6;
	public static final String[] ruleNames = {
		"programm", "state", "funcdec", "vardec", "exp", "function", "sign"
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

	@Override
	public String getGrammarFileName() { return "WRBParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WRBParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgrammContext extends ParserRuleContext {
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(WRBParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(WRBParser.SEP, i);
		}
		public TerminalNode EOF() { return getToken(WRBParser.EOF, 0); }
		public ProgrammContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterProgramm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitProgramm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitProgramm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgrammContext programm() throws RecognitionException {
		ProgrammContext _localctx = new ProgrammContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			state();
			setState(19);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(15);
					match(SEP);
					setState(16);
					state();
					}
					} 
				}
				setState(21);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(23);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(22);
				match(SEP);
				}
			}

			setState(26);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(25);
				match(EOF);
				}
				break;
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

	public static class StateContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public FuncdecContext funcdec() {
			return getRuleContext(FuncdecContext.class,0);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_state);
		try {
			setState(31);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				vardec();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				funcdec();
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

	public static class FuncdecContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(WRBParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(WRBParser.VAR, i);
		}
		public TerminalNode LBRACKET() { return getToken(WRBParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(WRBParser.RBRACKET, 0); }
		public TerminalNode EQUAL() { return getToken(WRBParser.EQUAL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> KOM() { return getTokens(WRBParser.KOM); }
		public TerminalNode KOM(int i) {
			return getToken(WRBParser.KOM, i);
		}
		public FuncdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterFuncdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitFuncdec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitFuncdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdecContext funcdec() throws RecognitionException {
		FuncdecContext _localctx = new FuncdecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(VAR);
			setState(34);
			match(LBRACKET);
			setState(35);
			match(VAR);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KOM) {
				{
				{
				setState(36);
				match(KOM);
				setState(37);
				match(VAR);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(RBRACKET);
			setState(44);
			match(EQUAL);
			setState(45);
			exp(0);
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

	public static class VardecContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(WRBParser.VAR, 0); }
		public TerminalNode EQUAL() { return getToken(WRBParser.EQUAL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitVardec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(VAR);
			setState(48);
			match(EQUAL);
			setState(49);
			exp(0);
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
	public static class DivContext extends ExpContext {
		public ExpContext left;
		public ExpContext right;
		public TerminalNode DIV() { return getToken(WRBParser.DIV, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public DivContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddContext extends ExpContext {
		public ExpContext left;
		public ExpContext right;
		public TerminalNode ADD() { return getToken(WRBParser.ADD, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public AddContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketContext extends ExpContext {
		public TerminalNode LBRACKET() { return getToken(WRBParser.LBRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(WRBParser.RBRACKET, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public BracketContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubContext extends ExpContext {
		public ExpContext left;
		public ExpContext right;
		public TerminalNode SUB() { return getToken(WRBParser.SUB, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SubContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpoContext extends ExpContext {
		public ExpContext left;
		public ExpContext right;
		public TerminalNode EXPO() { return getToken(WRBParser.EXPO, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpoContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterExpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitExpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitExpo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends ExpContext {
		public ExpContext left;
		public ExpContext right;
		public TerminalNode MULT() { return getToken(WRBParser.MULT, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public MultContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncContext extends ExpContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public FuncContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends ExpContext {
		public TerminalNode VAR() { return getToken(WRBParser.VAR, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public VarContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumContext extends ExpContext {
		public TerminalNode NUMBER() { return getToken(WRBParser.NUMBER, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public NumContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitNum(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new BracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(53);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(52);
					sign();
					}
				}

				setState(55);
				match(LBRACKET);
				setState(56);
				exp(0);
				setState(57);
				match(RBRACKET);
				}
				break;
			case 2:
				{
				_localctx = new FuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(59);
					sign();
					}
				}

				setState(62);
				function();
				}
				break;
			case 3:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(63);
					sign();
					}
				}

				setState(66);
				match(VAR);
				}
				break;
			case 4:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(67);
					sign();
					}
				}

				setState(70);
				match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(88);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExpoContext(new ExpContext(_parentctx, _parentState));
						((ExpoContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(73);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(74);
						match(EXPO);
						setState(75);
						((ExpoContext)_localctx).right = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new ExpContext(_parentctx, _parentState));
						((DivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(76);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(77);
						match(DIV);
						setState(78);
						((DivContext)_localctx).right = exp(8);
						}
						break;
					case 3:
						{
						_localctx = new MultContext(new ExpContext(_parentctx, _parentState));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(79);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(80);
						match(MULT);
						setState(81);
						((MultContext)_localctx).right = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new SubContext(new ExpContext(_parentctx, _parentState));
						((SubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(82);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(83);
						match(SUB);
						setState(84);
						((SubContext)_localctx).right = exp(6);
						}
						break;
					case 5:
						{
						_localctx = new AddContext(new ExpContext(_parentctx, _parentState));
						((AddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(85);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(86);
						match(ADD);
						setState(87);
						((AddContext)_localctx).right = exp(5);
						}
						break;
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(WRBParser.VAR, 0); }
		public TerminalNode LBRACKET() { return getToken(WRBParser.LBRACKET, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(WRBParser.RBRACKET, 0); }
		public List<TerminalNode> KOM() { return getTokens(WRBParser.KOM); }
		public TerminalNode KOM(int i) {
			return getToken(WRBParser.KOM, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(VAR);
			setState(94);
			match(LBRACKET);
			setState(95);
			exp(0);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KOM) {
				{
				{
				setState(96);
				match(KOM);
				setState(97);
				exp(0);
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(RBRACKET);
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

	public static class SignContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(WRBParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(WRBParser.ADD, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBParserListener ) ((WRBParserListener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBParserVisitor ) return ((WRBParserVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26n\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\5\2\32\n\2\3\2\5\2\35\n\2\3\3\3\3\3\3\5\3\"\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\5\68\n\6\3\6\3\6\3\6\3\6\3\6\5\6?\n\6\3\6\3\6\5\6C\n\6\3\6"+
		"\3\6\5\6G\n\6\3\6\5\6J\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\7\3\7\3\7\3\7\3\7\7\7e\n\7"+
		"\f\7\16\7h\13\7\3\7\3\7\3\b\3\b\3\b\2\3\n\t\2\4\6\b\n\f\16\2\3\3\2\16"+
		"\17y\2\20\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b\61\3\2\2\2\nI\3\2\2\2\f_\3\2"+
		"\2\2\16k\3\2\2\2\20\25\5\4\3\2\21\22\7\n\2\2\22\24\5\4\3\2\23\21\3\2\2"+
		"\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2"+
		"\2\30\32\7\n\2\2\31\30\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\35\7\2\2"+
		"\3\34\33\3\2\2\2\34\35\3\2\2\2\35\3\3\2\2\2\36\"\5\n\6\2\37\"\5\b\5\2"+
		" \"\5\6\4\2!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"\5\3\2\2\2#$\7\3\2\2$%"+
		"\7\24\2\2%*\7\3\2\2&\'\7\13\2\2\')\7\3\2\2(&\3\2\2\2),\3\2\2\2*(\3\2\2"+
		"\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\25\2\2./\7\r\2\2/\60\5\n\6\2\60\7"+
		"\3\2\2\2\61\62\7\3\2\2\62\63\7\r\2\2\63\64\5\n\6\2\64\t\3\2\2\2\65\67"+
		"\b\6\1\2\668\5\16\b\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\24\2\2:"+
		";\5\n\6\2;<\7\25\2\2<J\3\2\2\2=?\5\16\b\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2"+
		"\2@J\5\f\7\2AC\5\16\b\2BA\3\2\2\2BC\3\2\2\2CD\3\2\2\2DJ\7\3\2\2EG\5\16"+
		"\b\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HJ\7\4\2\2I\65\3\2\2\2I>\3\2\2\2IB\3"+
		"\2\2\2IF\3\2\2\2J\\\3\2\2\2KL\f\n\2\2LM\7\f\2\2M[\5\n\6\nNO\f\t\2\2OP"+
		"\7\21\2\2P[\5\n\6\nQR\f\b\2\2RS\7\20\2\2S[\5\n\6\tTU\f\7\2\2UV\7\17\2"+
		"\2V[\5\n\6\bWX\f\6\2\2XY\7\16\2\2Y[\5\n\6\7ZK\3\2\2\2ZN\3\2\2\2ZQ\3\2"+
		"\2\2ZT\3\2\2\2ZW\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\13\3\2\2\2^"+
		"\\\3\2\2\2_`\7\3\2\2`a\7\24\2\2af\5\n\6\2bc\7\13\2\2ce\5\n\6\2db\3\2\2"+
		"\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\25\2\2j\r\3\2"+
		"\2\2kl\t\2\2\2l\17\3\2\2\2\17\25\31\34!*\67>BFIZ\\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}