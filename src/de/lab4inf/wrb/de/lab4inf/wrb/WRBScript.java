package de.lab4inf.wrb;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.CommonTokenStream;

import de.lab4inf.wrb.WRBLexer;
import de.lab4inf.wrb.WRBParser;

public class WRBScript extends WRBVisitor implements Script {

	@Override
	public Function getFunction(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
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
