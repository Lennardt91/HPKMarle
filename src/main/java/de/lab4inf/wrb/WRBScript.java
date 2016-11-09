package de.lab4inf.wrb;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.CommonTokenStream;

import de.lab4inf.wrb.WRBLexer;
import de.lab4inf.wrb.WRBParser;

public class WRBScript extends WRBVisitor implements Script {
	/**
	 * Erzeugt WRBScript
	 */
	public WRBScript() {
		InsertMathFunktion();
	}
	/**
	 * ließt alle Mathe Funktionen ein, erstellt die WRBMathFunction Objekte
	 * und speichert sie ab
	 */
	private void InsertMathFunktion() {
		//Math Funktionen auslesen und einfügen
		Method methods [] = Math.class.getMethods();
		for(Method m:methods){
			func.put(new KeyValue<String, Integer>(m.getName(), m.getParameterCount()), new WRBMathFunction(m));
		}
		//WRBMath Funktionen auslesen und einfügen
		Method methodsWRB[] = WRBMath.class.getMethods();
		for(Method m:methodsWRB){
			func.put(new KeyValue<String, Integer>(m.getName(), m.getParameterCount()), new WRBMathFunction(m));
		}
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Function getFunction(String name) throws IllegalArgumentException {
		for(int i = 1;i<8;i++){
			if (func.containsKey(new KeyValue(name,i))) {
				return func.get(new KeyValue(name,i));
			}
		}
		throw new IllegalArgumentException("Function " + name + " not found");
	}


	@Override
	public double getVariable(String name) throws IllegalArgumentException {
		if (var.containsKey(name)) {
			return var.get(name);
		}
		throw new IllegalArgumentException("Varibale " + name + " not found,please declare it.");
	}

	@Override
	public void setVariable(String name, double value) {
		var.put(name, value);
	}

	@Override
	public double parse(String definition) throws RecognitionException, IllegalArgumentException {
		ANTLRInputStream input = new ANTLRInputStream(definition);
		WRBLexer lexer = new WRBLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		WRBParser parser = new WRBParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new NewErrorListener());
		return visit(parser.programm());
	}

	@Override
	public double parse(InputStream defStream) throws RecognitionException, IllegalArgumentException, IOException {
		ANTLRInputStream input = new ANTLRInputStream(defStream);
		WRBLexer lexer = new WRBLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);	
		WRBParser parser = new WRBParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new NewErrorListener());
		return visit(parser.programm());
	}

}
