package de.lab4inf.wrb;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;//.Executors;

import com.sun.org.apache.xpath.internal.operations.Mult;

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
		;
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
		int l = A.getColumnCount();
		for (int m = 0; m < l; m++) {
			for (int n = 0; n < l; n++) {
				for (int i = 0; i < c.length; i++) {
					c[m][n] += a[m][i] * b[i][n];
				}
			}

		}
		return new WRBMatrix(c);
	}

	public static WRBMatrix matParallel2(WRBMatrix A, WRBMatrix B) {
		matrixMulPossible(A, B);
		double[][] a = A.getMatrix(), b = B.getMatrix(), c = new double[A.getRowCount()][B.getColumnCount()];
		ExecutorService exec = Executors.newFixedThreadPool(B.getColumnCount());
		try {
			for (int i = 0; i < A.getRowCount(); i++) {
				final int fi = i;
				exec.submit(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j < B.getColumnCount(); j++) {
							for (int k = 0; k < A.getColumnCount(); k++) {
								c[fi][j] += a[fi][k] * b[k][j];
							}
						}
					}
				});

			}
		} finally {
			exec.shutdown();
			while (!exec.isTerminated()) {
			}
		}
		return new WRBMatrix(c);
	}

	public static WRBMatrix matParallel3(WRBMatrix A, WRBMatrix B) {
		matrixMulPossible(A, B);
		WRBMatrix R;
		R = B.transpose();
		double[][] a = A.getMatrix(), r = R.getMatrix(), c = new double[A.getRowCount()][B.getColumnCount()];
		ExecutorService exec = Executors.newFixedThreadPool(A.getRowCount());
		try {

			for (int i = 0; i < A.getRowCount(); i++) {
				final int fi = i;
				exec.submit(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j < B.getColumnCount(); j++) {
							for (int k = 0; k < a[fi].length; k++) {
								c[fi][j] += a[fi][k] * r[j][k];
							}

						}
					}
				});
			}
		} finally {
			exec.shutdown();
			while (!exec.isTerminated()) {
			}

		}
		return new WRBMatrix(c);
	}

	/**
	 * Multipliziert 2 Matrizen parallel(Algorithmus 1 von Praktikumsaufgabe)
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

		final int NUM_CORES = Runtime.getRuntime().availableProcessors();

		/*
		 * //TODO: Noch keine parallele Ausfuehrung for (int i = 1;
		 * i<A.getRowCount(); i++) for (int j = 1; j<B.getColumnCount(); j++)
		 * for (int k = 1; k<A.getColumnCount(); k++) c[i][j] +=
		 * a[i][k]*b[k][j];
		 */

		//////
		ExecutorService exec = Executors.newFixedThreadPool(NUM_CORES * 2);// TODO:
																			// Number
																			// of
																			// Threads
																			// (100
																			// momentan)
																			// festlegen
		try {
			for (int i = 0; i < A.getRowCount(); i++) {
				final int iFinal = i; // i muss final sein zum weiterbearbeiten
				exec.submit(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j < B.getColumnCount(); j++)
							for (int k = 0; k < A.getColumnCount(); k++)
								c[iFinal][j] += a[iFinal][k] * b[k][j];
					}
				});
			}
		} finally {
			exec.shutdown();
			while (!exec.isTerminated()) {
			}
		}
		//////
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
	 *             falls keine multiplikation moeglich ist
	 */
	public static boolean matrixMulPossible(WRBMatrix A, WRBMatrix B) throws IllegalArgumentException {
		if (A.getColumnCount() == B.getRowCount())
			return true;
		else
			throw new IllegalArgumentException(
					"Wrong matrix size. AColSize:" + A.getColumnCount() + " BRowSize:" + B.getRowCount());
	}

}
