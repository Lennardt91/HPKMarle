package de.lab4inf.wrb;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class WRBMatrixTest {
	// Maximale Größe der Matrix beim Timing Test
	int maxsize = 2048;

	public WRBMatrix GenerateMatrix(int m, int n) {
		double[][] a = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = Math.random()*20000-10000;
			}
		}
		return new WRBMatrix(a);
	}

	@Test
	public void TestTransposeEven() {
		double[][] a = new double[3][3];
		double[][] c = new double[3][3];
		a[0][0] = 3.;
		a[0][1] = 5.;
		a[0][2] = 7.;
		a[1][0] = 2.;
		a[1][1] = 6.;
		a[1][2] = 5.;
		a[2][0] = 9.;
		a[2][1] = 8.;
		a[2][2] = 4.;
		c[0][0] = 3.;
		c[0][1] = 2.;
		c[0][2] = 9.;
		c[1][0] = 5.;
		c[1][1] = 6.;
		c[1][2] = 8.;
		c[2][0] = 7.;
		c[2][1] = 5.;
		c[2][2] = 4.;
		WRBMatrix A = new WRBMatrix(a), C = new WRBMatrix(c), result;
		result = A.transpose();
		assertEquals(true, C.equals(result));
	}
	
	@Test
	public void TestTransposeUneven() {
		double[][] a = new double[4][2];
		double[][] c = new double[2][4];
		a[0][0] = 3.;
		a[0][1] = 5.;
		a[1][0] = 7.;
		a[1][1] = 2.;
		a[2][0] = 6.;
		a[2][1] = 5.;
		a[3][0] = 9.;
		a[3][1] = 8.;
		
		c[0][0] = 3.;
		c[0][1] = 7.;
		c[0][2] = 6.;
		c[0][3] = 9.;
		c[1][0] = 5.;
		c[1][1] = 2.;
		c[1][2] = 5.;
		c[1][3] = 8.;
		WRBMatrix A = new WRBMatrix(a), C = new WRBMatrix(c), result;
		result = A.transpose();
		assertEquals(true, C.equals(result));
	}

	@Test
	public void TestResult2x2Seriell() {
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];
		a[0][0] = 3.;
		a[0][1] = 5.;
		a[0][2] = 7.;
		a[1][0] = 2.;
		a[1][1] = 6.;
		a[1][2] = 5.;
		a[2][0] = 9.;
		a[2][1] = 8.;
		a[2][2] = 4.;
		b[0][0] = 2.;
		b[0][1] = 5.;
		b[0][2] = 7.;
		b[1][0] = 3.;
		b[1][1] = 4.;
		b[1][2] = 2.;
		b[2][0] = 9.;
		b[2][1] = 5.;
		b[2][2] = 1.;
		c[0][0] = 84.;
		c[0][1] = 70.;
		c[0][2] = 38.;
		c[1][0] = 67.;
		c[1][1] = 59.;
		c[1][2] = 31.;
		c[2][0] = 78.;
		c[2][1] = 97.;
		c[2][2] = 83.;
		WRBMatrix A = new WRBMatrix(a), B = new WRBMatrix(b), C = new WRBMatrix(c), result;
		result = A.matSeriell(B);
		assertEquals(true, result.equals(C));
	}

	@Test
	public void TestResult2x2ParallelOwn1() {
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];
		a[0][0] = 3.;
		a[0][1] = 5.;
		a[0][2] = 7.;
		a[1][0] = 2.;
		a[1][1] = 6.;
		a[1][2] = 5.;
		a[2][0] = 9.;
		a[2][1] = 8.;
		a[2][2] = 4.;
		b[0][0] = 2.;
		b[0][1] = 5.;
		b[0][2] = 7.;
		b[1][0] = 3.;
		b[1][1] = 4.;
		b[1][2] = 2.;
		b[2][0] = 9.;
		b[2][1] = 5.;
		b[2][2] = 1.;
		c[0][0] = 84.;
		c[0][1] = 70.;
		c[0][2] = 38.;
		c[1][0] = 67.;
		c[1][1] = 59.;
		c[1][2] = 31.;
		c[2][0] = 78.;
		c[2][1] = 97.;
		c[2][2] = 83.;
		WRBMatrix A = new WRBMatrix(a), B = new WRBMatrix(b), C = new WRBMatrix(c), result;
		result = A.matParallelOwn1(B);
		result.printMatr();
		C.printMatr();
		assertEquals(true, result.equals(C));
	}

	@Test
	public void TestResult2x2Parallel2() {
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];
		a[0][0] = 3.;
		a[0][1] = 5.;
		a[0][2] = 7.;
		a[1][0] = 2.;
		a[1][1] = 6.;
		a[1][2] = 5.;
		a[2][0] = 9.;
		a[2][1] = 8.;
		a[2][2] = 4.;
		b[0][0] = 2.;
		b[0][1] = 5.;
		b[0][2] = 7.;
		b[1][0] = 3.;
		b[1][1] = 4.;
		b[1][2] = 2.;
		b[2][0] = 9.;
		b[2][1] = 5.;
		b[2][2] = 1.;
		c[0][0] = 84.;
		c[0][1] = 70.;
		c[0][2] = 38.;
		c[1][0] = 67.;
		c[1][1] = 59.;
		c[1][2] = 31.;
		c[2][0] = 78.;
		c[2][1] = 97.;
		c[2][2] = 83.;
		WRBMatrix A = new WRBMatrix(a), B = new WRBMatrix(b), C = new WRBMatrix(c), result;
		result = A.matParallel2(B);
		assertEquals(true, result.equals(C));
	}

	@Test
	public void TestResult2x2Parallel3() {
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];
		a[0][0] = 3.;
		a[0][1] = 5.;
		a[0][2] = 7.;
		a[1][0] = 2.;
		a[1][1] = 6.;
		a[1][2] = 5.;
		a[2][0] = 9.;
		a[2][1] = 8.;
		a[2][2] = 4.;
		b[0][0] = 2.;
		b[0][1] = 5.;
		b[0][2] = 7.;
		b[1][0] = 3.;
		b[1][1] = 4.;
		b[1][2] = 2.;
		b[2][0] = 9.;
		b[2][1] = 5.;
		b[2][2] = 1.;
		c[0][0] = 84.;
		c[0][1] = 70.;
		c[0][2] = 38.;
		c[1][0] = 67.;
		c[1][1] = 59.;
		c[1][2] = 31.;
		c[2][0] = 78.;
		c[2][1] = 97.;
		c[2][2] = 83.;
		WRBMatrix A = new WRBMatrix(a), B = new WRBMatrix(b), C = new WRBMatrix(c), result;
		result = A.matParallel3(B);
		assertEquals(true, result.equals(C));
	}
	
	@Test
	public void TestResult2x2Parallel4() {
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];
		a[0][0] = 3.;
		a[0][1] = 5.;
		a[0][2] = 7.;
		a[1][0] = 2.;
		a[1][1] = 6.;
		a[1][2] = 5.;
		a[2][0] = 9.;
		a[2][1] = 8.;
		a[2][2] = 4.;
		b[0][0] = 2.;
		b[0][1] = 5.;
		b[0][2] = 7.;
		b[1][0] = 3.;
		b[1][1] = 4.;
		b[1][2] = 2.;
		b[2][0] = 9.;
		b[2][1] = 5.;
		b[2][2] = 1.;
		c[0][0] = 84.;
		c[0][1] = 70.;
		c[0][2] = 38.;
		c[1][0] = 67.;
		c[1][1] = 59.;
		c[1][2] = 31.;
		c[2][0] = 78.;
		c[2][1] = 97.;
		c[2][2] = 83.;
		WRBMatrix A = new WRBMatrix(a), B = new WRBMatrix(b), C = new WRBMatrix(c), result;
		result = A.matParallel4(B);
		assertEquals(true, result.equals(C));
	}
	@Test
	public void TestDifferentDimensionSeriell(){
		WRBMatrix A = GenerateMatrix(2, 3),B = GenerateMatrix(3, 4);
		A.matSeriell(B);
		
	}
	@Test
	public void TestDifferentDimensionParallel2(){
		WRBMatrix A = GenerateMatrix(2, 3),B = GenerateMatrix(3, 5);
		A.matParallel2(B);
	}
	@Test
	public void TestDifferentDimensionParallel3(){
		WRBMatrix A = GenerateMatrix(5, 6),B = GenerateMatrix(6, 5);
		A.matParallel3(B);
	}
	@Test
	public void TestDifferentDimensionParallel4(){
		WRBMatrix A = GenerateMatrix(5, 6),B = GenerateMatrix(6, 5);
		A.matParallel4(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimensionSeriell() {
		WRBMatrix A = GenerateMatrix(4, 5), B = GenerateMatrix(4, 5), C = null;
		C = A.matSeriell(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimensionParallelOwn1() {
		WRBMatrix A = GenerateMatrix(4, 5), B = GenerateMatrix(4, 5), C = null;
		C = A.matParallelOwn1(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimensionParallel2() {
		WRBMatrix A = GenerateMatrix(4, 5), B = GenerateMatrix(4, 5), C = null;
		C = A.matParallel2(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimensionParallel3() {
		WRBMatrix A = GenerateMatrix(4, 5), B = GenerateMatrix(4, 5), C = null;
		C = A.matParallel3(B);
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimensionParallel4() {
		WRBMatrix A = GenerateMatrix(4, 5), B = GenerateMatrix(4, 5), C = null;
		C = A.matParallel4(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimension2Seriell() {
		WRBMatrix A = GenerateMatrix(1, 1), B = GenerateMatrix(10, 10), C = null;
		C = A.matSeriell(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimension2ParallelOwn1() {
		WRBMatrix A = GenerateMatrix(1, 1), B = GenerateMatrix(10, 10), C = null;
		C = A.matParallelOwn1(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimension2Parallel2() {
		WRBMatrix A = GenerateMatrix(1, 1), B = GenerateMatrix(10, 10), C = null;
		C = A.matParallel2(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimension2Parallel3() {
		WRBMatrix A = GenerateMatrix(1, 1), B = GenerateMatrix(10, 10), C = null;
		C = A.matParallel3(B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestWrongDimension2Parallel4() {
		WRBMatrix A = GenerateMatrix(1, 1), B = GenerateMatrix(10, 10), C = null;
		C = A.matParallel4(B);
	}
	
	@Test
	public void TimingTest() {
		HashMap<Integer, WRBMatrix> A = new HashMap<>();
		HashMap<Integer, WRBMatrix> B = new HashMap<>();
		HashMap<Integer, WRBMatrix> C = new HashMap<>();
		HashMap<Integer, Long> serieltimes = new HashMap<>();
		HashMap<Integer, Long> paralleltimes = new HashMap<>();
		WRBMatrix a, b, c;
		int scale = -(int) Math.pow(10, 6);
		long time = 0;
		for (int i = 64; i <= maxsize; i *= 2) {
			A.put(i, GenerateMatrix(i, i));
			B.put(i, GenerateMatrix(i, i));
		}

		for (int i = 64; i <= maxsize; i *= 2) {
			a = A.get(i);
			b = B.get(i);
			time = System.nanoTime();
			c = a.matSeriell(b);
			time -= System.nanoTime();
			C.put(i, c);
			serieltimes.put(i, (time / scale));
		}

/*
		for (int i = 64; i <= maxsize; i *= 2) {
			a = A.get(i);
			b = B.get(i);
			time = System.nanoTime();
			c = a.matParallel2(b);
			time -= System.nanoTime();
			assertEquals(true, c.equals(C.get(i)));
			paralleltimes.put(i, (time / scale));
		}
		Ausgabe(serieltimes, paralleltimes, "parallel 2");
*/
	for (int i = 64; i <= maxsize; i *= 2) {
			a = A.get(i);
			b = B.get(i);
			time = System.nanoTime();
			c = a.matParallel3(b);
			time -= System.nanoTime();
			assertEquals(true, c.equals(C.get(i)));
			paralleltimes.put(i, (time / scale));
		}
		Ausgabe(serieltimes, paralleltimes, "parallel 3");

		for (int i = 64; i <= maxsize; i *= 2) {
			a = A.get(i);
			b = B.get(i);
			time = System.nanoTime();
			c = a.matParallel4(b);
			time -= System.nanoTime();
			assertEquals(true, c.equals(C.get(i)));
			paralleltimes.put(i, (time / scale));
		}
		Ausgabe(serieltimes, paralleltimes, "parallel 4");
		
		for (int i = 64; i <= maxsize; i *= 2) {
			a = A.get(i);
			b = B.get(i);
			time = System.nanoTime();
			c = a.matParallelOwn1(b);
			time -= System.nanoTime();
			assertEquals(true, c.equals(C.get(i)));
			paralleltimes.put(i, (time / scale));
		}
		Ausgabe(serieltimes, paralleltimes, "parallel own 1");

	}

	public void Ausgabe(HashMap<Integer, Long> serieltime, HashMap<Integer, Long> paraltime, String name) {
		String format = name + "\nn\t\t|t seq\t\t|t para\t\t|s(n)\n_______________________________________________________";
		int sice = (int) Math.pow(2, 5 + serieltime.size());
		double speedup = 0.;
		for (int i = 64; i <= sice; i *= 2) {
			speedup = ((1.0 * serieltime.get(i)) / paraltime.get(i));
			// Auf 2 Nackommastellen bechränken
			speedup = speedup * 100;
			speedup = Math.round(speedup);
			speedup = speedup / 100;

			if (serieltime.get(i) > 9999 && paraltime.get(i) > 9999) {
				format += "\n" + i + "\t\t|" + serieltime.get(i) + "ms\t|" + paraltime.get(i) + "ms\t|" + speedup;
			} else if (serieltime.get(i) > 9999) {
				format += "\n" + i + "\t\t|" + serieltime.get(i) + "ms\t|" + paraltime.get(i) + "ms\t\t|" + speedup;
			} else if (paraltime.get(i) > 9999) {
				format += "\n" + i + "\t\t|" + serieltime.get(i) + "ms\t\t|" + paraltime.get(i) + "ms\t|" + speedup;
			} else {
				format += "\n" + i + "\t\t|" + serieltime.get(i) + "ms\t\t|" + paraltime.get(i) + "ms\t\t|" + speedup;
			}
		}
		System.out.println(format+"\n\n");

	}

}
