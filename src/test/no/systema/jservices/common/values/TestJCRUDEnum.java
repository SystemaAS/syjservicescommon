package no.systema.jservices.common.values;

import org.junit.Assert;
import org.junit.Test;



public class TestJCRUDEnum {

	
	@Test
	public void testCRUDValues() {
		Integer action = 2;
		
		Assert.assertTrue(action.equals(CRUDEnum.READ.getValue()));
	}
}
