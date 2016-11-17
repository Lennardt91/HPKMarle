package de.lab4inf.wrb;

/**
 * Klasse für angepasste Funktionen der Math Klasse
 * 
 * @author marten
 *
 */
public class WRBMath {
	/**
	 * Minimum von n double Werten
	 * 
	 * @return min(x1,x1...,xn)
	 */
	public static double min(double arg1, double arg2, double arg3) {
		return supermin(arg1, arg2, arg3);
	}

	public static double min(double arg1, double arg2, double arg3, double arg4) {
		return supermin(arg1, arg2, arg3, arg4);
	}

	public static double min(double arg1, double arg2, double arg3, double arg4, double arg5) {
		return supermin(arg1, arg2, arg3, arg4, arg5);
	}

	/**
	 * Minimum von n double Werten
	 * 
	 * @return min(x1,x1...,xn)
	 */
	public static double supermin(double... arg) {
		double tmp = Double.MAX_VALUE;
		for (double x : arg) {
			tmp = Math.min(tmp, x);
		}
		return tmp;
	}

	public static double max(double arg1, double arg2, double arg3) {
		return supermax(arg1, arg2, arg3);
	}

	public static double max(double arg1, double arg2, double arg3, double arg4) {
		return supermax(arg1, arg2, arg3, arg4);
	}

	public static double max(double arg1, double arg2, double arg3, double arg4, double arg5) {
		return supermax(arg1, arg2, arg3, arg4, arg5);
	}

	/**
	 * Maximum von n double Werten
	 * 
	 * @return max(x1,x2,..xn)
	 */
	public static double supermax(double... arg) {
		double tmp = Double.MIN_VALUE;
		for (double x : arg) {
			tmp = Math.max(tmp, x);
		}
		return tmp;
	}

	/**
	 * Logarithmus zur Basis 2
	 * 
	 * @param x
	 * @return log_2(x)
	 */
	public static double log2(double x) {
		return Math.log(x) / Math.log(2);
	}
}