package no.systema.jservices.common.jwt.nimbus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:test-configuration.xml")
public class TestJAuthorization {

	@Autowired
	Authorization authorization;
	
	
	@Test
	public void test() throws IOException {
		
		authorization.TheCertThingy(getFile());

		System.out.println("So far so good...");
		
		
	}
	
	
	private InputStream getFile() {
		String certFile = "Buypass_ID-BAREKSTAD_OG_YTTERVÅG_REGNSKAP-serienummer550498454741797052332932-2015-06-24.p12"; 
//		String certFile = "json.txt"; 

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

			InputStream is = classLoader.getResourceAsStream("no/systema/jservices/common/jwt/nimbus/" + certFile);

			System.out.println("InputStream is = "+is);
			
			
			return is;

		}		
		
		
	
	
}
