package de.lab4inf.wrb;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class WRBMatrixTest {
	public WRBMatrix GenerateMatrix(int m, int n) {
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
	@Test(expected=IllegalArgumentException.class)
	public void TestWrongDimension(){
		WRBMatrix A = GenerateMatrix(4, 5),B = GenerateMatrix(4, 5),C = null;
		C = A.matSeriell(B);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestWrongDimension2(){
		WRBMatrix A = GenerateMatrix(1,1),B = GenerateMatrix(10,10),C =null;
		C = A.matSeriell(B);
	}
	@Test
	public void TimingTest(){
		HashMap<Integer, WRBMatrix> A = new HashMap<>();
		HashMap<Integer, WRBMatrix> B = new HashMap<>();
		HashMap<Integer, WRBMatrix> C = new HashMap<>();
		HashMap<Integer, Long> serieltimes = new HashMap<>();
		HashMap<Integer, Long> paraleltimes = new HashMap<>();
		WRBMatrix a,b,c;
		int maxsize = 2048;
		int scale = -(int) Math.pow(10, 6);
		long time = 0;
		for(int i = 64;i<2049;i*=2){
			A.put(i, GenerateMatrix(i, i));
			B.put(i, GenerateMatrix(i, i));
		}
		
		for(int i = 64;i<=maxsize;i*=2){
			a = A.get(i);
			b = B.get(i);
			time = System.nanoTime();
			c = a.matSeriell(b);
			time-= System.nanoTime();
			C.put(i, c);
			serieltimes.put(i, (time/scale));
		}
		Ausgabe(serieltimes,paraleltimes,"seriel");
		
		
	}
	public void Ausgabe (HashMap<Integer, Long>serieltime,HashMap<Integer, Long> paraltime,String name){
		String format = name+"\nn\t\t|t seq\t\t|t pall\t\t|s(n)";
		int sice = (int) Math.pow(2,5+serieltime.size());
		for(int i = 64;i<=sice;i*=2){
			format+="\n"+i+"\t\t|"+serieltime.get(i)+"ms\t\t|"+0+"ms\t\t|"+0+"ms";
		}
		System.out.println(format);
		
	}

}
