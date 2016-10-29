package de.lab4inf.wrb;

public class WRBMath {
	public static double min(double x, double y, double z) {
		return Math.min(x, Math.min(y, z));
	}

	public static double min(double w, double x, double y, double z) {
		return Math.min(w, Math.min(x, Math.min(y, z)));
	}

	public static double max(double x, double y, double z) {
		return Math.max(x, Math.max(y, z));
	}

	public static double max(double w, double x, double y, double z) {
		return Math.max(w, Math.max(x, Math.max(y, z)));
	}

	public static double log2(double x) {
		return Math.log(x) / Math.log(2);
	}
}