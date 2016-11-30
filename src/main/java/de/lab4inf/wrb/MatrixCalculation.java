package de.lab4inf.wrb;
/**
 * Klasse fuer Berechnungen mit WRBMatrix Matrizen
 * @author marten lennardt
 *
 */
public final class MatrixCalculation {

	/**
	 * Multipliziert 2 Matrizen parallel
	 * @param A Erste WRBMatrix
	 * @param B Zweite WRBMatrix
	 * @return Ergebnis als WRBMatrix
	 * @throws IllegalArgumentException
	 */
	public static WRBMatrix matSeriell(WRBMatrix A, WRBMatrix B) throws IllegalArgumentException {
		if(A.getColumnCount()!=B.getRowCount())
			throw new IllegalArgumentException("Wrong matrix size. AColSize:" + A.getColumnCount() + " BRowSize:" + B.getRowCount());
		double [][]a = A.getMatrix();
		double [][]b = B.getMatrix();
		double [][]c = new double [A.getRowCount()][B.getColumnCount()];
		int l = A.getColumnCount();
		System.out.println("m;n;i\n");
		for(int m = 0;m<l;m++){
			for (int n = 0;n<l;n++){
				for(int i = 0;i<c.length;i++){
					System.out.println(m+";"+n+";"+i);
					c[m][n]+=a[m][i]*b[i][n];
				}
			}
			
		}
		return new WRBMatrix(c);
	}

	/**
	 * Multipliziert 2 Matrizen parallel(Algorithmus 1 von Praktikumsaufgabe)
	 * @param A Erste WRBMatrix
	 * @param B Zweise WRBMatrix
	 * @return Ergebnis als WRBMatrix
	 * @throws IllegalArgumentException
	 */	
	public static WRBMatrix matParallel1(WRBMatrix A, WRBMatrix B) throws IllegalArgumentException{
		if(A.getColumnCount() != B.getRowCount())
			throw new IllegalArgumentException("Wrong matrix size. AColSize:" + A.getColumnCount() + " BRowSize:" + B.getRowCount());
		
		double [][]a = A.getMatrix();
		double [][]b = B.getMatrix();
		double [][]c = new double [A.getRowCount()][B.getColumnCount()];
		
		//TODO: Noch keine parallele Ausfuehrung
		for (int i = 1; i<A.getRowCount(); i++)
			for (int j = 1; j<B.getColumnCount(); j++)
				for (int k = 1; k<A.getColumnCount(); k++)
					c[i][j] += a[i][k]*b[k][j];
		
		return new WRBMatrix(c);
	}
}
