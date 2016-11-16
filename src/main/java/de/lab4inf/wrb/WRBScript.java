package de.lab4inf.wrb;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

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
		ArrayList<KeyValue<String, Integer>> KeyValueList = new ArrayList<KeyValue<String, Integer>>();
		//jva.lang.Math Funktionen
		KeyValueList.add(new KeyValue<String, Integer>("abs", 1));
		KeyValueList.add(new KeyValue<String, Integer>("acos", 1));
		KeyValueList.add(new KeyValue<String, Integer>("asin", 1));
		KeyValueList.add(new KeyValue<String, Integer>("atan", 1));
		KeyValueList.add(new KeyValue<String, Integer>("atan2", 2));
		KeyValueList.add(new KeyValue<String, Integer>("cos", 1));
		KeyValueList.add(new KeyValue<String, Integer>("cosh", 1));
		KeyValueList.add(new KeyValue<String, Integer>("exp", 1));
		KeyValueList.add(new KeyValue<String, Integer>("expm1", 1));
		KeyValueList.add(new KeyValue<String, Integer>("floor", 1));
		KeyValueList.add(new KeyValue<String, Integer>("getExponent", 1));
		KeyValueList.add(new KeyValue<String, Integer>("hypot", 2));
		KeyValueList.add(new KeyValue<String, Integer>("log", 1));
		KeyValueList.add(new KeyValue<String, Integer>("log10", 1));
		KeyValueList.add(new KeyValue<String, Integer>("log1p", 1));
		KeyValueList.add(new KeyValue<String, Integer>("max", 2));
		KeyValueList.add(new KeyValue<String, Integer>("min", 2));
		KeyValueList.add(new KeyValue<String, Integer>("pow", 2));
		KeyValueList.add(new KeyValue<String, Integer>("round", 1));
		KeyValueList.add(new KeyValue<String, Integer>("sin", 1));
		KeyValueList.add(new KeyValue<String, Integer>("sinh", 1));
		KeyValueList.add(new KeyValue<String, Integer>("sqrt", 1));
		KeyValueList.add(new KeyValue<String, Integer>("tan",1));
		KeyValueList.add(new KeyValue<String, Integer>("tanh", 1));
		//de.lab4inf.wrb.WRBMath
		for(int i = 3; i<=10; i++){
			KeyValueList.add(new KeyValue<String, Integer>("min", i));
			KeyValueList.add(new KeyValue<String, Integer>("max", i));
		}
		KeyValueList.add(new KeyValue<String, Integer>("log2", 1));
		
		for(KeyValue<String, Integer>keyValue:KeyValueList){
			func.put(keyValue, new WRBMathFunction(keyValue.getKey(), keyValue.getValue()));
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
