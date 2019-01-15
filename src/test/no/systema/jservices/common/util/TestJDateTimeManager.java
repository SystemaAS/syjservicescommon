package no.systema.jservices.common.util;

import org.junit.Assert;
import org.junit.Test;


public class TestJDateTimeManager {

	@Test
	public final void testGetDate() {
		int date = 20181210;
		String dateOutput = DateTimeManager.getDate(date);
		Assert.assertTrue("", dateOutput.equals("10.12.18"));
		
	}
	
	@Test
	public final void testGetDateTime() {
		int date = 20181210;
		int time = 91223;
		String dateTimeOutput = DateTimeManager.getDateTime(date, time);
		System.out.println("dateTimeOutput="+dateTimeOutput);
		Assert.assertTrue("Should look like this 10.12.18 09:12:23", dateTimeOutput.equals("10.12.18 09:12:23"));
		
	}	
	
	
	
	
}
