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
}
