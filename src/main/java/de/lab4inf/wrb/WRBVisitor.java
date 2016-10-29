package de.lab4inf.wrb;

import java.util.HashMap;

import de.lab4inf.wrb.WRBParser.*;

class WRBVisitor extends WRBParserBaseVisitor<Double> {
	/**
	 * HashMap zum Speichern desr Variablenn
	 */
	protected HashMap<String, Double> var = new HashMap<String, Double>();
	/**
	 * HashMap zum Speichern der Funktionen
	 */
	protected HashMap<KeyValue<String, Integer>, Function> func = new HashMap<KeyValue<String, Integer>, Function>();

	@Override
	public Double visitProgramm(ProgrammContext ctx) {
		Double result = null;
		// Durchlaufen aller Programm einträge
		for (int i = 0; i < ctx.state().size(); i++) {
			result = visit(ctx.state(i));
		}
		return result;
	}

	@Override
	public Double visitState(StateContext ctx) {
		// Prüfen, ob Variablendeclaration,Funktionsdefinition oder Berechnung
		if (ctx.exp() != null) {
			return visit(ctx.exp());
		}
		if (ctx.vardec() != null) {
			return visit(ctx.vardec());
		}
		if (ctx.funcdec() != null) {
			return visit(ctx.funcdec());
		}
		return 0.;
	}

	@Override
	public Double visitVardec(VardecContext ctx) {
		// Wert der Variablen berechnen
		Double result = visit(ctx.exp());
		// Variable speichern
		var.put(ctx.VAR().toString(), result);
		return result;
	}

	@Override
	public Double visitFuncdec(FuncdecContext ctx) {
		String name = ctx.VAR(0).getText();
		String argv[] = new String[ctx.VAR().size() - 1];
		for (int i = 0; i < argv.length; i++) {
			argv[i] = ctx.VAR(i + 1).toString();
		}
		func.put(new KeyValue<String, Integer>(name, argv.length), new WRBFunction(name, ctx.exp(), argv.length, this, argv));
		if (func.get(new KeyValue<String, Integer>(name, argv.length)) == null) {
			System.out.println("Cant insert Function ");
			System.out.println(name);
		}
		return 0.;
	}

	// Alle Berechnungen unterhalb von exp
	@Override
	public Double visitBracket(BracketContext ctx) {
		// Vorzeichen berücksichtigen
		if (ctx.sign() == null) {
			return visit(ctx.exp());
		}
		return visit(ctx.sign()) * visit(ctx.exp());
	}

	@Override
	public Double visitDiv(DivContext ctx) {
		return (visit(ctx.left) / visit(ctx.right));
	}

	@Override
	public Double visitMult(MultContext ctx) {
		return (visit(ctx.left) * visit(ctx.right));
	}

	@Override
	public Double visitSub(SubContext ctx) {
		return (visit(ctx.left) - visit(ctx.right));
	}

	@Override
	public Double visitAdd(AddContext ctx) {
		return (visit(ctx.left) + visit(ctx.right));
	}

	@Override
	public Double visitFunc(FuncContext ctx) {
		return visit(ctx.function());
	}

	@Override
	public Double visitVar(VarContext ctx) {
		// versuchen, wert zu lesen
		Double result = var.get(ctx.VAR().toString());
		if (result == null) {
			throw new IllegalArgumentException("Variable " + ctx.VAR().toString() + " not found");
		}
		// Vorzeichen berücksichtigen
		if (ctx.sign() == null) {
			return result;
		}
		return visit(ctx.sign()) * result;
	}

	@Override
	public Double visitNum(NumContext ctx) {
		// Vorzeichen beachten
		if (ctx.sign() != null) {
			return visit(ctx.sign()) * Double.valueOf(ctx.NUMBER().toString());
		}
		return Double.valueOf(ctx.NUMBER().toString());
	}

	@Override
	public Double visitSign(SignContext ctx) {
		if (ctx.ADD() == null) {
			return -1.;
		}
		return +1.;
	}

	@Override
	public Double visitExpo(ExpoContext ctx) {
		return (Math.pow(visit(ctx.left).doubleValue(), visit(ctx.right).doubleValue()));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Double visitFunction(FunctionContext ctx) throws IllegalArgumentException {
		String name = ctx.VAR().toString();
		if (func.containsKey(new KeyValue(name, ctx.exp().size()))) {
			// Parameter werte berechnen und in Array Speichern
			double[] ar = new double[ctx.exp().size()];
			for (int i = 0; i < ctx.exp().size(); i++) {
				ar[i] = visit(ctx.exp(i));
			}
			return func.get(new KeyValue(name, ctx.exp().size())).eval(ar);
		}
		throw new IllegalArgumentException("Funktion not found");

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Function getFunction(String name) {
		for (int i = 1; i < 8; i++) {
			if (func.containsKey(new KeyValue(name, i))) {
				return func.get(new KeyValue(name, i));
			}
		}
		throw new IllegalArgumentException("Function " + name + " not found");
	}
}
