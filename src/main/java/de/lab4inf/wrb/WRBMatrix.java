package de.lab4inf.wrb;

/**
 * Mathematische Matrix
 * 
 * @author marten lenard
 *
 */
public class WRBMatrix {
	/**
	 * Anzahl Zeilen
	 */
	int m;
	/**
	 * Anzahl Spalten
	 */
	int n;
	/**
	 * Matrix
	 */
	double[][] matrix;

	/**
	 * Konstruktor
	 * 
	 * @param matrix
	 *            2 Dim. Array mit den Zahlenwerten
	 */
	public WRBMatrix(double[][] matrix) {
		this.matrix = matrix;
		// Zeilen m und Spalten n bestimmen
		this.m = matrix.length;
		this.n = matrix[0].length ;
	}

	/**
	 * 
	 * @return Anzahl der Reihen
	 */
	public int getColumnCount() {
		return this.n;
	}

	/**
	 * 
	 * @return Anzahl der Reihen
	 */
	public int getRowCount() {
		return this.m;
	}

	/**
	 * Matrix als 2 Dim. Array
	 * 
	 * @return Matrix
	 */
	public double[][] getMatrix() {
		return this.matrix;
	}

	/**
	 * Serielle Matrix Multiplikation
	 * 
	 * @param B
	 *            WRBMatrix mit dem multipliziert werden soll
	 * @return A*B
	 */
	public WRBMatrix matSeriell(WRBMatrix B) {
		return MatrixCalculation.matSeriell(this, B);
	}

	public boolean equals(WRBMatrix B) {
		if (this.m != B.getRowCount())
			return false;
		if (this.n != B.getColumnCount())
			return false;
		double[][] c = B.getMatrix();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (this.matrix[i][j] != c[i][j])
					return false;
			}
		}
		return true;
	}

}
