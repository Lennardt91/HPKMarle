package de.lab4inf.wrb;

import static org.junit.Assert.*;

import org.junit.Test;

public class WRBMatrixTest {
	public WRBMatrix generateMatrix(int m, int n) {
		double[][] a = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = Math.random();
			}
		}
		return new WRBMatrix(a);
	}

	@Test
	public void TestResult2x2() {
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];
		a[0][0] = 3;
		a[0][1] = 5;
		a[0][2] = 7;
		a[1][0] = 2;
		a[1][1] = 6;
		a[1][2] = 5;
		a[2][0] = 9;
		a[2][1] = 8;
		a[2][2] = 4;
		b[0][0] = 2;
		b[0][1] = 5;
		b[0][2] = 7;
		b[1][0] = 3;
		b[1][1] = 4;
		b[1][2] = 2;
		b[2][0] = 9;
		b[2][1] = 5;
		b[2][2] = 1;
		c[0][0] = 84;
		c[0][1] = 70;
		c[0][2] = 38;
		c[1][0] = 67;
		c[1][1] = 59;
		c[1][2] = 31;
		c[2][0] = 78;
		c[2][1] = 97;
		c[2][2] = 83;
		WRBMatrix A = new WRBMatrix(a), B = new WRBMatrix(b), C = new WRBMatrix(c), result;
		result=A.matSeriell(B);
		assertEquals(true, result.equals(C));
	}

}
