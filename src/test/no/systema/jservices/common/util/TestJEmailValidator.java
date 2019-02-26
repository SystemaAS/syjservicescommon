package no.systema.jservices.common.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestJEmailValidator {

	
	EmailValidator emailValidator;
	
	@Before
	public void setUp()  {
		emailValidator = new EmailValidator();
		
	}	
	
	@Test
	public final void testValidatorValid() {
		String email = "kalle.anka@ankeborg.com";
		assertTrue(emailValidator.validateEmail(email));
	}

	@Test
	public final void testValidatorInValid() {
		String email = ":kalle.anka@ankeborg.com";
		assertFalse(emailValidator.validateEmail(email));

		email = "kalle.æøå@ankeborg.com";
		assertFalse(emailValidator.validateEmail(email));
	
	}

	



}


