package de.lab4inf.wrb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.antlr.runtime.RecognitionException;
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
    public final void testMathFunctionLog() throws Exception{
    	String task = "log(5)";
    	assertEquals(Math.log(5),script.parse(task), eps);
    }
    
    @Test
    public final void testMathFunctionMax1() throws Exception{
    	String task = "max(3,23,3)";
    	assertEquals(23,script.parse(task), eps);
    }
    
    @Test
    public final void testMathFunctionMax2() throws Exception{
    	String task = "max(3,5,6,3,23,3)";
    	assertEquals(23,script.parse(task), eps);
    }

    @Test
    public final void testMathFunctionMaxWithVariables() throws Exception{
    	String task = "y = 1;x = 45; max(3,5,x,3,y,3)";
    	assertEquals(45,script.parse(task), eps);
    }
    
    @Test
    public final void testMathFunctionMaxWithFunction() throws Exception{
    	String task = "max(3,5,sqrt(14),3,23,3)";
    	assertEquals(Math.sqrt(14),script.parse(task), eps);
    }


}