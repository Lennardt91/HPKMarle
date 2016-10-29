package de.lab4inf.wrb;
/**
 * Klasse für angepasste Funktionen der Math Klasse
 * @author marten
 *
 */
public class WRBMath {
	/**
	 * Minimum von 3 Werten
	 * @param x 
	 * @param y
	 * @param z
	 * @return min{x,y,z}
	 */
	public static double min(double x, double y, double z) {
		return Math.min(x, Math.min(y, z));
	}
	/**
	 * Minimum von 4 Werten
	 * @param w
	 * @param x
	 * @param y
	 * @param z
	 * @return min{w,x,y,z}
	 */
	public static double min(double w, double x, double y, double z) {
		return Math.min(w, Math.min(x, Math.min(y, z)));
	}
	/**
	 * Maximum von 3 Werten
	 * @param x
	 * @param y
	 * @param z
	 * @return max{x,y,z}
	 */
	public static double max(double x, double y, double z) {
		return Math.max(x, Math.max(y, z));
	}
	/**
	 * Maximum von 4 Werten
	 * @param w
	 * @param x
	 * @param y
	 * @param z
	 * @return max{w,x,y,z}
	 */
	public static double max(double w, double x, double y, double z) {
		return Math.max(w, Math.max(x, Math.max(y, z)));
	}
	/**
	 * Logarithmus zur Basis 2
	 * @param x
	 * @return log_2(x)
	 */
	public static double log2(double x) {
		return Math.log(x) / Math.log(2);
	}
}