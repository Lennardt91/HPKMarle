package de.lab4inf.wrb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Klasse zum speichern von vordefinierten Mathe Funktionen
 * 
 * @author marten
 * @version 1.0
 * @since 23.11.2015
 */
public class WRBMathFunction implements Function {
	/**
	 * Math Methode, welche gespeichert werden soll
	 */
	protected Method m;
	/**
	 * Anzahl der Argumente
	 */
	protected int argc;
	/**
	 * Bezeichnung der Funktion
	 */
	protected String name;

	/**
	 * Kontruktor
	 * 
	 * @param name
	 *            Bezeichnung der Funktion
	 * @param argc
	 *            Anzahl der Argumente
	 */
	public WRBMathFunction(String name, int argc) {
		// Array an Class Objekten erzeugen zum erzeugen des method objekts
		Class<?>[] clazz = new Class[argc];
		for (int i = 0; i < clazz.length; i++) {
			clazz[i] = double.class;
		}
		try {
			this.name = name;
			this.argc = argc;
			if (name.equals("log")) {
				m = Math.class.getMethod("log10", clazz);
			} else if (name.equals("logE") || name.equals("ln")) {
				m = Math.class.getMethod("log", clazz);
			} else if (name.equals("ld") || name.equals("lb")) {
				m = WRBMath.class.getMethod("log2", clazz);
			} else if (name.equals("log2") || name.equals("lb")) {
				m = WRBMath.class.getMethod(name, clazz);
			} else if (argc > 2) {
				m = WRBMath.class.getMethod(name, clazz);
			} else {
				m = Math.class.getMethod(name, clazz);
			}
		} catch (NoSuchMethodException nsm) {
			System.err.println(nsm.getMessage());
		}
	}
	@Override
	public double eval(double... args) {
		if (args.length != this.argc) {
			throw new IllegalArgumentException(
					"expected " + this.argc + " params \n get " + args.length + " Params @eval " + this.name);
		}
		Object[] obj = new Object[args.length];
		for (int i = 0; i < obj.length; i++) {
			obj[i] = args[i];
		}
		try {
			return (Double) m.invoke(m, obj);
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the argc
	 */
	public int getArgc() {
		return argc;
	}

	/**
	 * 
	 * @return the method
	 */
	public Method getM() {
		return m;
	}

}