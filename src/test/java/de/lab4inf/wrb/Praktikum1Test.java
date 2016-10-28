package test.java.de.lab4inf.wrb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.antlr.runtime.RecognitionException;
import org.junit.Before;
import org.junit.Test;

import de.lab4inf.wrb.Script;
import de.lab4inf.wrb.WRBScript;

public class Praktikum1Test {
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

	@Test(expected = IllegalArgumentException.class)
	public final void testWrongInput() throws Exception {
		String input = "a 1 / 123";
		script.parse(input);
	}
	
	@Test
	public final void testComplexPointBeforeLine() throws IllegalArgumentException, RecognitionException
    {
    	double result = script.parse("100+12*5-(20+11)");
    	assertEquals(result,129,eps);
    }
}
