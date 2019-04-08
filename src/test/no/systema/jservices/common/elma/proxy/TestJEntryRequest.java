package no.systema.jservices.common.elma.proxy;

import java.net.URI;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import no.systema.jservices.common.elma.entities.Entry;


@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:test-configuration.xml")
public class TestJEntryRequest {

	
	@Autowired 
	EntryRequest entryRequest;
	
	String orgnr_exist, orgnr_not_exist;
	
	@Before
	public final void setup(){
		entryRequest.host = "hotell.difi.no";
		entryRequest.path = "api/json/difi/elma/participants";
		orgnr_exist = "984722117";  //finns två av
		orgnr_not_exist = "936809219"; //= system as
		
	}
	
	@Test
	public final void testEntryRequestURI() {
		URI uri = entryRequest.ehf(orgnr_exist);
		Assert.assertNotNull(uri);

		System.out.println("uri=" + uri.toString());

	}
	
	@Test
	public final void testEntryRequestOrgnrExist() {
		Entry entry = entryRequest.getElmaEntry(orgnr_exist);
		Assert.assertNotNull(entry);
		
//		System.out.println("entry="+ReflectionToStringBuilder.toString(entry, ToStringStyle.MULTI_LINE_STYLE));
		
	}
	
	
	@Test
	public final void testEntryRequestOrgnrNOTExist() {
		Entry entry = entryRequest.getElmaEntry(orgnr_not_exist);
		Assert.assertNull(entry);
		
	}	
	
	
}
