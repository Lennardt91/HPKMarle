package de.lab4inf.wrb;

import de.lab4inf.wrb.WRBParser.ExpContext;

/**
 * Klasse zum Speichern und berechnen einer selbst definierten Funktion
 * 
 * @author marten
 * @version 1.0
 * @since 23.11.2015
 */
public class WRBFunction implements Function {
	/**
	 * Anzahl der Argument
	 */
	protected int argc;
	/**
	 * Name der Funtion
	 */
	protected String name;
	/**
	 * Kontext Knoten der Funktion
	 */
	protected ExpContext ctx;
	/**
	 * Liste mit namen der Parameter
	 */
	protected String[] argv;
	/**
	 * benutzter Visitor
	 */
	protected WRBVisitor visitor;

	/**
	 * Kontruktor zum erstllen einer Funktion
	 * 
	 * @param name
	 *            Bezeichung der Funktion
	 * @param argc
	 *            Anzahl der Parameter7
	 * @param visitor
	 *            Benutzter Visitor
	 * @param ctx
	 *            Kontext Knote, an der stelle, wo die Funktion im Parstree
	 *            beginnt
	 */

	public WRBFunction(String name, ExpContext ctx, int argc, WRBVisitor visitor, String... args) {
		this.argc = argc;
		this.name = name;
		this.ctx = ctx;
		this.visitor = visitor;
		this.argv = new String[args.length];
		for (int i = 0; i < argc; i++) {
			argv[i] = args[i];
		}

	}

	/**
	 * Berechnen des Funktswerts
	 * @param args funktionswerte
	 */
	@Override
	public double eval(double... args) throws IllegalArgumentException {
		Double temp[] = new Double[argc];
		for (int i = 0; i < argv.length; i++) {
			if (visitor.var.containsKey(argv[i])) {
				temp[i] = visitor.var.get(argv[i]);
			} else {
				temp[i] = null;
			}
			visitor.var.put(argv[i], args[i]);
		}
		double result = visitor.visit(ctx);
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				visitor.var.put(argv[i], temp[i]);
			}
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public ExpContext getCtx() {
		return ctx;
	}

	public int getArgc() {
		return argc;
	}

}