package de.lab4inf.wrb;

/**
 * Mathematische Matrix
 * 
 * @author marten lennardt
 *
 */
public class WRBMatrix {
	
	int m;  //Anzahl Zeilen der Matrix
	int n; //Anzahl Spalten der Matrix
	double[][] matrix; //Matrix als 2 dimensionales Array

	/**
	 * Konstruktor
	 * 
	 * @param matrix 2 Dim. Array mit den Zahlenwerten
	 */
	public WRBMatrix(double[][] matrix) {
		this.matrix = matrix;
		// Zeilen m und Spalten n bestimmen
		this.m = matrix.length;
		this.n = matrix[0].length ;
	}

	/**
	 * 
	 * @return Anzahl der Spalten
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
	 * @return Matrix als 2 dimensionales Array
	 */
	public double[][] getMatrix() {
		return this.matrix;
	}

	/**
	 * Serielle Matrix Multiplikation
	 * 
	 * @param B
	 *            WRBMatrix mit der multipliziert werden soll
	 * @return Ergebnis der seriellen Berechnung als WRBMatrix
	 */
	public WRBMatrix matSeriell(WRBMatrix B) {
		return MatrixCalculation.matSeriell(this, B);
	}

	/**
	 * Prueft 2 Matrizen auf Gleichheit
	 * @param B Matrix mit der die andere Matrix verglichen werden soll
	 * @return true, wenn die Matrizen gleich sind, sonst false
	 */
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
