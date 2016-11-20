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
	 * @throws NoSuchMethodException 
	 */
	public WRBMathFunction(String name, int argc) throws NoSuchMethodException {
		// Array an Class Objekten erzeugen zum erzeugen des method objekts
		Class<?>[] clazz = new Class[argc];
		for (int i = 0; i < clazz.length; i++) {
			clazz[i] = double.class;
		}
		try {
			this.name = name;
			this.argc = argc;
			switch(name){
				case "log":
					m = Math.class.getMethod("log10", clazz);
					break;
				case "logE":
					m = Math.class.getMethod("log", clazz);
					break;
				case "ln":
					m = Math.class.getMethod("log", clazz);
					break;
				case "ld":
					m = WRBMath.class.getMethod("log2", clazz);
					break;
				case "lb":
					m = WRBMath.class.getMethod("log2", clazz);
					break;
				case "log2":
					m = WRBMath.class.getMethod("log2", clazz);
					break;
				default:
					if (argc > 2)
						m = WRBMath.class.getMethod(name, clazz);
					else
						m = Math.class.getMethod(name, clazz);
					
					break;
			}
		} catch (NoSuchMethodException e) {
			throw e;
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