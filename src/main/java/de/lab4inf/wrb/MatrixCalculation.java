package de.lab4inf.wrb;


/**
 * Klasse fuer Berechnungen mit WRBMatrix Matrizen
 * 
 * @author marten lennardt
 *
 */
public final class MatrixCalculation {
	
	/**
	 * Transport eine Matrix
	 * 
	 * @param zu
	 *            transponierende Matrix
	 * @return transponierte Matrix
	 */
	public static WRBMatrix transpose(WRBMatrix A) {
		A.getMatrix();
		double[][] c = new double[A.getColumnCount()][A.getRowCount()], a = A.getMatrix();
		
		for (int i = 0; i < A.getColumnCount(); i++) {
			for (int j = 0; j < A.getRowCount(); j++) {
				c[i][j] = a[j][i];
			}
		}
		return new WRBMatrix(c);
	}

	/**
	 * Multipliziert 2 Matrizen parallel
	 * 
	 * @param A
	 *            Erste WRBMatrix
	 * @param B
	 *            Zweite WRBMatrix
	 * @return Ergebnis als WRBMatrix
	 * @throws IllegalArgumentException
	 */
	public static WRBMatrix matSeriell(WRBMatrix A, WRBMatrix B) throws IllegalArgumentException {
		matrixMulPossible(A, B);
		double[][] a = A.getMatrix();
		double[][] b = B.getMatrix();
		double[][] c = new double[A.getRowCount()][B.getColumnCount()];
		final int l = A.getRowCount();
		final int n = B.getColumnCount();
		for (int x = 0; x < l; x++) {
			for (int y = 0; y < n; y++) {
				for (int z = 0; z < l; z++) {
					c[x][y] += a[x][z] * b[z][y];
				}
			}

		}
		return new WRBMatrix(c);
	}
	
	/**
	 * Multipliziert 2 Matrizen parallel(Algorithmus 2 von Praktikumsaufgabe)
	 * 
	 * @param A
	 *            Erste WRBMatrix
	 * @param B
	 *            Zweite WRBMatrix
	 * @return Ergebnis als WRBMatrix
	 * @throws IllegalArgumentException
	 */
	public static WRBMatrix matParallel2(WRBMatrix A, WRBMatrix B) {
		matrixMulPossible(A, B);
		double[][] a = A.getMatrix(), b = B.getMatrix(), c = new double[A.getRowCount()][B.getColumnCount()];
		final int l = A.getRowCount();
		final int n = B.getColumnCount();
		
		WRBTaskObserver taskObs = new WRBTaskObserver();
		
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < n; j++) {
					final int fi = i;
					final int fj = j;
					taskObs.doRunnable(
							new Runnable() {
								@Override
								public void run() {
									for (int k = 0; k < n; k++) {
										c[fi][fj] += a[fi][k] * b[k][fj];
									}
								}
							}
					);
				}
				

			}
			
		taskObs.waitAllDone();
		//taskObs.shutdownNow();
		return new WRBMatrix(c);
	}
	

	/**
	 * Multipliziert 2 Matrizen parallel(Algorithmus 3 von Praktikumsaufgabe)
	 * 
	 * @param A
	 *            Erste WRBMatrix
	 * @param B
	 *            Zweite WRBMatrix
	 * @return Ergebnis als WRBMatrix
	 * @throws IllegalArgumentException
	 */
	public static WRBMatrix matParallel3(WRBMatrix A, WRBMatrix B) {
		matrixMulPossible(A, B);
		WRBMatrix R;
		final int l = A.getRowCount();
		final int n = B.getColumnCount();
		R = B.transpose();
		double[][] a = A.getMatrix(), r = R.getMatrix(), c = new double[A.getRowCount()][B.getColumnCount()];
		WRBTaskObserver taskObs = new WRBTaskObserver();

		
		
/*
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				final int fi = i;
				final int fj = j;
				taskObs.doRunnable(
						new Runnable() {
							@Override
							public void run() {
								for (int k = 0; k < n; k++) {
									c[fi][fj] += a[fi][k] * r[fj][k];
								}
							}
						}
				);
				
				
				
			}
		}
*/
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				final int fi = i;
				final int fj = j;
				taskObs.doRunnable(
						new Runnable() {
							@Override
							public void run() {
								//double newc = 0;
								for (int k = 0; k < n; k++) {
									//newc += a[fi][k] * r[fj][k];
									c[fi][fj] += a[fi][k] * r[fj][k];
								}
								//c[fi][fj] = newc;
							}
						}
				);
				
				
				
			}
		}
		
		
		taskObs.waitAllDone();
		//taskObs.shutdownNow();
		return new WRBMatrix(c);
	}
	
	/**
	 * Multipliziert 2 Matrizen parallel(Algorithmus 4 von Praktikumsaufgabe)
	 * 
	 * @param A
	 *            Erste WRBMatrix
	 * @param B
	 *            Zweite WRBMatrix
	 * @return Ergebnis als WRBMatrix
	 * @throws IllegalArgumentException
	 */
	public static WRBMatrix matParallel4(WRBMatrix A, WRBMatrix B) {
		matrixMulPossible(A, B);
		WRBMatrix R=B.transpose();
		double[][] a = A.getMatrix(), r = R.getMatrix(), c = new double[A.getRowCount()][B.getColumnCount()];
		WRBTaskObserver taskObs = new WRBTaskObserver();
		
			for (int i = 0; i < A.getRowCount(); i++) {
				final int fi = i;
				taskObs.doRunnable(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j < B.getColumnCount(); j++) {
							for (int k = 0; k < A.getColumnCount(); k++) {
								c[fi][j] += a[fi][k] * r[j][k];
							}
						}

					}
				});
			}
		taskObs.waitAllDone();
		//taskObs.shutdownNow();	
		return new WRBMatrix(c);
	}

	/**
	 * Multipliziert 2 Matrizen parallel
	 * 
	 * @param A
	 *            Erste WRBMatrix
	 * @param B
	 *            Zweite WRBMatrix
	 * @return Ergebnis als WRBMatrix
	 * @throws IllegalArgumentException
	 */
	public static WRBMatrix matParallelOwn1(WRBMatrix A, WRBMatrix B) throws IllegalArgumentException {
		matrixMulPossible(A, B);
		double[][] a = A.getMatrix();
		double[][] b = B.getMatrix();
		double[][] c = new double[A.getRowCount()][B.getColumnCount()];
		WRBTaskObserver taskObs = new WRBTaskObserver();
		final int l = A.getRowCount();
		final int n = B.getColumnCount();
		final int taskcount = l*n;
		final int tasksPerRunnable = 800;
		
		
		if ((taskcount<50)){
			for (int x = 0; x < l; x++) {
				for (int y = 0; y < n; y++) {
					for (int z = 0; z < l; z++) {
						c[x][y] += a[x][z] * b[z][y];
					}
				}
			}
		}else{
			//new Runnable
			//teilt j und i in pakete von tasksPerRunnable ergebnissen auf und berechnet diese
			for (int q = 0; q<taskcount;q += tasksPerRunnable ){
				final int startI = q/n;
				final int startJ = q%n;
				taskObs.doRunnable(new Runnable() {
					@Override
					public void run() {
						int counter = 0;
						int innerJ = startJ;
						for (int i = startI; i < l; i++){
							for (int j = innerJ; j < n; j++){
								for (int k = 0; k < l; k++){
											c[i][j] += a[i][k] * b[k][j];		
								}
										
								counter++;
								if (!(counter<tasksPerRunnable)){
									i = l;
									j = n;
								}
								
							}
							innerJ = 0;
						}
						
				}});
				
					
					
					
				}
		}
		/*
		for (int i = 0; i < l; i++) {
					for (int j = 0; j < n; j++)
								for (int k = 0; k < l; k++)
									c[i][j] += a[i][k] * b[k][j];
		}
		*/
		
		
		taskObs.waitAllDone();
		taskObs.shutdownNow();
		return new WRBMatrix(c);
		}

	/**
	 * Berechnet, ob eine Matrix Multiplikation ueberhaupt in der Reihenfolge
	 * moeglich ist
	 * 
	 * @param A
	 *            Erste zu multiplizierende Matrix
	 * @param B
	 *            Letzte zu multiplizierende Matrix
	 * @return true, falls eine multiplikation moeglich ist
	 * @throws IllegalArgumentException
	 *
	 */
	public static boolean matrixMulPossible(WRBMatrix A, WRBMatrix B) throws IllegalArgumentException {
		if (A.getColumnCount() == B.getRowCount())
			return true;
		else
			throw new IllegalArgumentException(
					"Wrong matrix size. AColSize:" + A.getColumnCount() + " BRowSize:" + B.getRowCount());
	}

}
