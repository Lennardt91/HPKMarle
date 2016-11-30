package de.lab4inf.wrb;
/**
 * Klasse für berechnungen mit WRBMatrix Matrizen
 * @author marten lenard
 *
 */
public final class MatrixCalculation {

	public static WRBMatrix matSeriell(WRBMatrix A, WRBMatrix B) throws IllegalArgumentException {
		if(A.getColumnCount()!=B.getRowCount())
			throw new IllegalArgumentException("Wrong Matrix size");
		double [][]a = A.getMatrix();
		double [][]b = B.getMatrix();
		double [][]c = new double [A.getRowCount()][B.getColumnCount()];
		int l = A.getColumnCount();
		System.out.println("m;n;i\n");
		for(int m = 0;m<l;m++){
			for (int n = 0;n<l;m++){
				for(int i = 0;i<c.length;i++){
					System.out.println(m+";"+n+";"+i);
					c[m][n]+=a[m][i]*b[i][n];
				}
			}
			
		}
		return new WRBMatrix(c);
	}

}
