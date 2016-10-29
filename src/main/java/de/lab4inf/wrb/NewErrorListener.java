package de.lab4inf.wrb;

import java.util.BitSet;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
/**
 * Klasse für die Fehlerbehandlung innerhalb des Parser.
 * @author marten
 * @version 1.1
 *
 */
public class NewErrorListener extends BaseErrorListener {
	/**
	 * Erzeugt einer angepassten Expetion bei einem Syntax Error
	 * @throws IlligalArugmentException
	 * @since 23.11.2015
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		String message;
		message = "Syntax Error at line " + line + " at Postition " + charPositionInLine;
		throw new IllegalArgumentException(message);
	}
	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact,
			BitSet ambigAlts, ATNConfigSet configs) {
		
		super.reportAmbiguity(recognizer, dfa, startIndex, stopIndex, exact, ambigAlts, configs);
	}
	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
			BitSet conflictingAlts, ATNConfigSet configs) {
		
		super.reportAttemptingFullContext(recognizer, dfa, startIndex, stopIndex, conflictingAlts, configs);
	}
	
	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
			ATNConfigSet configs) {
		
		super.reportContextSensitivity(recognizer, dfa, startIndex, stopIndex, prediction, configs);
	}
}