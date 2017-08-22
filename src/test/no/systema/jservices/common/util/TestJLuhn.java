package no.systema.jservices.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.junit.Before;
import org.junit.Test;


/**
 * https://en.wikipedia.org/wiki/Luhn_algorithm
 * 
 * @author fredrikmoller
 *
 */

public class TestJLuhn {
	LuhnCheckDigit luhn = null;
	
	@Before
	public void setUp() throws Exception {
		luhn = new LuhnCheckDigit();
	}

	@Test
	public void testFM() throws CheckDigitException {
		String fm = "680626699";
		String fmLast = "2";
		String fmLastDigitCalc = luhn.calculate(fm);
		System.out.println("fmLastDigitCalc="+fmLastDigitCalc);
		assertTrue( fmLastDigitCalc.equals(fmLast));
		
	}
	
	
	@Test
	public void testCB() throws CheckDigitException {
		String cb = "621129485";
		String cbLast = "2";
		String cbLastDigitCalc = luhn.calculate(cb);	
		System.out.println("cbLastDigitCalc="+cbLastDigitCalc);
		assertEquals(cbLast, cbLastDigitCalc);	
	}
	
	@Test
	public void testGS1Norway() throws CheckDigitException {
		String gs2Test = "1212121212121212"; 
		String gs2TestLastDigit = "4"; //http://www.gs1.no/produkter-og-tjenester/onlinetjenester/kontrollsifferberegning
		String gs2TestLastDigitCalc = luhn.calculate(gs2Test);	
		System.out.println("gs2TestLastDigitCalc="+gs2TestLastDigitCalc);
		assertEquals(gs2TestLastDigit,  gs2TestLastDigitCalc);		
		
	}	
	
	@Test
	public void testGS1NorwaySeries() throws CheckDigitException {
		String gs2Test = "7012222122252227"; 
		String gs2TestLastDigit = "7"; //http://www.gs1.no/produkter-og-tjenester/onlinetjenester/kontrollsifferberegning
		String gs2TestLastDigitCalc = luhn.calculate(gs2Test);	
		//String gs2TestLastDigitCalc = routine.calculate(gs2Test);	
		System.out.println("gs2TestLastDigitCalc="+gs2TestLastDigitCalc);
		assertEquals(gs2TestLastDigit, gs2TestLastDigitCalc);	
		
	}		
	
	@Test
	public void testLuhnEx() throws CheckDigitException { //https://en.wikipedia.org/wiki/Luhn_algorithm
		String luhnEx ="7992739871"; //79927398719
		String luhnExLastDigit = "3";
		String luhnExLastDigitCalc = luhn.calculate(luhnEx);	
		System.out.println("luhnExLastDigitCalc="+luhnExLastDigitCalc);
		assertEquals(luhnExLastDigit, luhnExLastDigitCalc);	
		
	}		
	
	@Test
	public void testLuhnAgain2() throws CheckDigitException { //https://en.wikipedia.org/wiki/Luhn_algorithm
		String luhnEx ="123456789012345"; 
		String luhnExLastDigit = "2";
		String luhnExLastDigitCalc = luhn.calculate(luhnEx);	
		System.out.println("luhnExLastDigitCalc="+luhnExLastDigitCalc);
		assertEquals(luhnExLastDigit, luhnExLastDigitCalc);	
		
	}	

	@Test
	public void testGS1NorwayEAN13() throws CheckDigitException {
		String gs2Test = "123456789012"; 
		String gs2TestLastDigit = "8"; //http://www.gs1.no/produkter-og-tjenester/onlinetjenester/kontrollsifferberegning
		String gs2TestLastDigitCalc = luhn.calculate(gs2Test);	
		System.out.println("gs2TestLastDigitCalc="+gs2TestLastDigitCalc);
		assertEquals(gs2TestLastDigit,  gs2TestLastDigitCalc);		
	}		

	@Test
	public void testGS1NorwayEAN14() throws CheckDigitException {
		String gs2Test = "1234567890123"; 
		String gs2TestLastDigit = "1"; //http://www.gs1.no/produkter-og-tjenester/onlinetjenester/kontrollsifferberegning
		String gs2TestLastDigitCalc = luhn.calculate(gs2Test);	
		System.out.println("gs2TestLastDigitCalc="+gs2TestLastDigitCalc);
		assertEquals(gs2TestLastDigit,  gs2TestLastDigitCalc);		
	}	
	

	@Test
	public void testGS1NorwayJOVO() throws CheckDigitException {
		String gs2Test = "7012345000123456"; 
		String gs2TestLastDigit = "1"; //http://www.gs1.no/produkter-og-tjenester/onlinetjenester/kontrollsifferberegning
		String gs2TestLastDigitCalc = luhn.calculate(gs2Test);	
		System.out.println("gs2TestLastDigitCalc="+gs2TestLastDigitCalc);
		assertEquals(gs2TestLastDigit,  gs2TestLastDigitCalc);		
	}	
	
	
}
