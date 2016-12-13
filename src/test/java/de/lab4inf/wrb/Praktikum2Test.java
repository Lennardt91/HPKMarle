package de.lab4inf.wrb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class Praktikum2Test {
	final double eps = 1.E-8;
	Script script;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		script = getScript();
		assertNotNull("no script implementation", script);
	}

	/**
	 * Get the actual implementation for the script test.
	 * 
	 * @return script implementation
	 */
	protected Script getScript() {
		return new WRBScript();
	}
	
    /**
     * Test method for {@link de.lab4inf.wrb.Script#getFunction(java.lang.String)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public final void testGetUnknownFunction() throws Exception {
        String key = "dummy";
        script.getFunction(key);
    }
    
    @Test     
    public final void testFunction() throws Exception {  
    String task = "f(x)=2+x;f(4)";         
    assertEquals(6,script.parse(task),eps);     }
    
    @Test     
    public final void testFuncOnItself() throws Exception {  
    String task = "f(x)=2+x;f(f(4))";         
    assertEquals(8,script.parse(task),eps);     }
    
    @Test     
    public final void testAddTwoFunctions() throws Exception {  
    String task = "f(x)=2+x;a(x)=2+x;f(3)+a(4)";         
    assertEquals(11,script.parse(task),eps);     }
    
    @Test
    public final void testMathFunctionMax1() throws Exception{
    	String task = "max(3,23)";
    	assertEquals(23,script.parse(task), eps);
    }
    
    @Test
    public final void testMathFunctionMax2() throws Exception{
    	String task = "max(3,5,6,3,23)";
    	assertEquals(23,script.parse(task), eps);
    }

    @Test
    public final void testMathFunctionMaxWithVariables() throws Exception{
    	String task = "y = 1;x = 45; max(3,5,x,3,y)";
    	assertEquals(45,script.parse(task), eps);
    }
    
    @Test
    public final void testMathFunctionMaxWithFunction() throws Exception{
    	String task = "max(3,5,pow(14,2),3,4)";
    	assertEquals(Math.pow(14, 2),script.parse(task), eps);
    }


}
