package no.systema.jservices.common.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



/**
 * https://www.gs1.org/how-calculate-check-digit-manually
 * 
 * @author fredrikmoller
 *
 */
public class TestJGSINCheckDigit {

	String[] valid = null;
	
	@Before
    public  void setUp() throws Exception {
    }	
	
	@Test
	public final void testValidGsin() {
		String cd1 =GSINCheckDigit.calculate("7012345000123456");
		assertEquals("1", cd1);

		String cd2 =GSINCheckDigit.calculate("4356223942392349");
		assertEquals("4", cd2);		
		
	}

}
