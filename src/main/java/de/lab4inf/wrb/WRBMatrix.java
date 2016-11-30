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
	private int maxFieldValue = 1000; // Maximaler und minimaler Wert, den ein Feld der Matrix annehmen kann
	private int maxRowOrColSizeValue = 5; //Maximaler Wert den eine Reihe oder Spalte annehmen kann
	
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
	 * Konstruktor fuer random Matrix in gewuenschter Groesse
	 * @param rows Anzahl der Reihen
	 * @param cols Anzahl der Spalten
	 */
	public WRBMatrix(int rows, int cols){
		this.m = rows;
		this.n = cols;
		
		this.matrix = new double[m][n];
		for (int i = 0; i<m; i++)
			for (int j = 0; j<n; j++)
				matrix[i][j] = getRndFieldValue();
	}
	
	/**
	 * Konstruktor fuer random Matrix in random Groesse(beschraenkt auf maximal 5 Spalten und Reihen)
	 */
	public WRBMatrix(){
		this.m = this.getRndRowOrColSize();
		this.n = this.getRndRowOrColSize();
		
		
		this.matrix = new double[m][n];
		for (int i = 0; i<m; i++)
			for (int j = 0; j<n; j++)
				matrix[i][j] = getRndFieldValue();
	}
	
	/**
	 * Gibt einen Zufaelligen Wert fuer ein Feld zurueck
	 * @return zufaelliger Wert im Rahmen des WRBMatrix rndFieldValue
	 */
	private int getRndFieldValue(){
		return (int)Math.random()*maxFieldValue*2 - maxFieldValue; //RND Zahl von -rndFieldValue bis +rndFieldValue
	}
	
	private int getRndRowOrColSize(){
		return (int)Math.random()*maxRowOrColSizeValue + 1;
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
