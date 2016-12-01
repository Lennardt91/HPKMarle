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
	public void TestResult2x2Seriell() {
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
	@Test
	public void TestResult2x2ParallelOwn1() {
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
		result=A.matParallelOwn1(B);
		assertEquals(true, result.equals(C));
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestWrongDimensionSeriell(){
		WRBMatrix A = GenerateMatrix(4, 5),B = GenerateMatrix(4, 5),C = null;
		C = A.matSeriell(B);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestWrongDimensionParallelOwn1(){
		WRBMatrix A = GenerateMatrix(4, 5),B = GenerateMatrix(4, 5),C = null;
		C = A.matParallelOwn1(B);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestWrongDimension2Seriell(){
		WRBMatrix A = GenerateMatrix(1,1),B = GenerateMatrix(10,10),C =null;
		C = A.matSeriell(B);
	}
	@Test(expected=IllegalArgumentException.class)
	public void TestWrongDimension2ParallelOwn1(){
		WRBMatrix A = GenerateMatrix(1,1),B = GenerateMatrix(10,10),C =null;
		C = A.matParallelOwn1(B);
	}
	@Test
	public void TimingTest(){
		HashMap<Integer, WRBMatrix> A = new HashMap<>();
		HashMap<Integer, WRBMatrix> B = new HashMap<>();
		HashMap<Integer, WRBMatrix> C = new HashMap<>();
		HashMap<Integer, Long> serieltimes = new HashMap<>();
		HashMap<Integer, Long> paralleltimes1 = new HashMap<>();
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
		
		for(int i = 64;i<=maxsize;i*=2){
			a = A.get(i);
			b = B.get(i);
			time = System.nanoTime();
			c = a.matParallelOwn1(b);
			time-= System.nanoTime();
			assertEquals(true, c.equals(C.get(i)));
			paralleltimes1.put(i, (time/scale));
		}
		Ausgabe(serieltimes,paralleltimes1,"paralel own 1");
		
		
		
	}
	public void Ausgabe (HashMap<Integer, Long>serieltime,HashMap<Integer, Long> paraltime,String name){
		String format = name+"\nn\t\t|t seq\t\t|t para\t\t|s(n)";
		int sice = (int) Math.pow(2,5+serieltime.size());
		double speedup=0.;
		for(int i = 64;i<=sice;i*=2){
			speedup = ((1.0*serieltime.get(i))/paraltime.get(i));
			//Auf 2 Nackommastellen bechränken
			speedup = speedup * 100;
			speedup = Math.round(speedup);
			speedup = speedup / 100;
			
			if(serieltime.get(i)>9999 && paraltime.get(i)>9999){
				format+="\n"+i+"\t\t|"+serieltime.get(i)+"ms\t|"+paraltime.get(i)+"ms\t|"+speedup;
			}
			else if(serieltime.get(i)>9999){
				format+="\n"+i+"\t\t|"+serieltime.get(i)+"ms\t|"+paraltime.get(i)+"ms\t\t|"+speedup;
			}
			else if(paraltime.get(i)>9999){
				format+="\n"+i+"\t\t|"+serieltime.get(i)+"ms\t\t|"+paraltime.get(i)+"ms\t|"+speedup;
			}
			else{
				format+="\n"+i+"\t\t|"+serieltime.get(i)+"ms\t\t|"+paraltime.get(i)+"ms\t\t|"+speedup;
			}
		}
		System.out.println(format);
		
	}

}
