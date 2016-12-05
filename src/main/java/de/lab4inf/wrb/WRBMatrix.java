package de.lab4inf.wrb;


/**
 * Mathematische Matrix
 * 
 * @author marten lennardt
 *
 */
public class WRBMatrix {

	volatile int m; // Anzahl Zeilen der Matrix
	volatile int n; // Anzahl Spalten der Matrix
	volatile double[][] matrix; // Matrix als 2 dimensionales Array
	
	
	
	private static int maxFieldValue = 1000; // Maximaler und minimaler Wert, den ein
										// Feld der Matrix annehmen kann
	private static int maxRowOrColSizeValue = 5; // Maximaler Wert den eine Reihe oder
											// Spalte annehmen kann

	/**
	 * Konstruktor
	 * 
	 * @param matrix
	 *            2 Dim. Array mit den Zahlenwerten
	 */
	public WRBMatrix(double[][] matrix) {
		this.matrix = matrix;
		// Zeilen m und Spalten n bestimmen
		this.n = matrix[0].length;
		this.m = matrix.length;
	}
	

	/**
	 * Konstruktor fuer random Matrix in gewuenschter Groesse
	 * 
	 * @param rows
	 *            Anzahl der Reihen
	 * @param cols
	 *            Anzahl der Spalten
	 */
	public WRBMatrix(int rows, int cols) {
		this.m = rows;
		this.n = cols;

		this.matrix = new double[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = getRndFieldValue();
	}

	/**
	 * Konstruktor fuer random Matrix in random Groesse(beschraenkt auf
	 * maxRowAndColValue)
	 */
	public WRBMatrix() {
		this.m = this.getRndRowOrColSize();
		this.n = this.getRndRowOrColSize();

		this.matrix = new double[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = getRndFieldValue();
	}

	/**
	 * Gibt einen Zufaelligen Wert fuer ein Feld zurueck
	 * 
	 * @return zufaelliger Wert im Rahmen des WRBMatrix rndFieldValue
	 */
	private int getRndFieldValue() {
		return (int) Math.random() * maxFieldValue * 2 - maxFieldValue; // RND
																		// Zahl
																		// von
																		// -rndFieldValue
																		// bis
																		// +rndFieldValue
	}

	private int getRndRowOrColSize() {
		return (int) Math.random() * maxRowOrColSizeValue + 1;
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

	public WRBMatrix matParallelOwn1(WRBMatrix B) {
		return MatrixCalculation.matParallelOwn1(this, B);
	}

	public WRBMatrix matParallel2(WRBMatrix B) {
		return MatrixCalculation.matParallel2(this, B);
	}

	public WRBMatrix matParallel3(WRBMatrix B) {
		return MatrixCalculation.matParallel3(this, B);
	}
	public WRBMatrix matParallel4(WRBMatrix B) {
		return MatrixCalculation.matParallel4(this, B);
	}

	/**
	 * Gibt die Transponierte Matrix zurück
	 * 
	 * @return A^T
	 */
	public WRBMatrix transpose() {
		return MatrixCalculation.transpose(this);
	}

	/**
	 * Prueft 2 Matrizen auf Gleichheit
	 * 
	 * @param B
	 *            Matrix mit der die andere Matrix verglichen werden soll
	 * @return true, wenn die Matrizen gleich sind, sonst false
	 */
	public boolean equals(WRBMatrix B) {
		double eps = 1.E-8;
		if (this.m != B.getRowCount())
			return false;
		if (this.n != B.getColumnCount())
			return false;
		double[][] c = B.getMatrix();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((Math.abs(matrix[i][j] - c[i][j]))/c[i][j]>eps) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Gibt eine Matrix auf der Konsole aus
	 */
	public void printMatr() {
		for (int i = 0; i < this.getRowCount(); i++) {
			for (int j = 0; j < this.getColumnCount(); j++)
				System.out.print("|" + this.matrix[i][j]);
			System.out.println();
		}
		System.out.println();
	}

}
