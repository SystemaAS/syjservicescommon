//package no.systema.jservices.common.jwt.nimbus;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.KeyStore;
//import java.security.cert.Certificate;
//import java.security.cert.CertificateFactory;
////import javax.security.cert.X509Certificate;
//import java.security.cert.X509Certificate;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.nimbusds.jose.jwk.RSAKey;
//import com.nimbusds.jose.util.IOUtils;
//import com.nimbusds.jose.util.StandardCharset;
//import com.nimbusds.jose.util.X509CertUtils;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration("classpath:test-configuration.xml")
//public class TestJAuth {
//
//	@Autowired
//	Auth authorization;
//	
//	
//	@Test
//	public void test() throws IOException {
//		
//		authorization.TheCertThingy();
//
//		System.out.println("So far so good...");
//		
//		
//	}
//	
//	
//	private InputStream getFile() {
//		String certFile = "Buypass_ID-BAREKSTAD_OG_YTTERVÅG_REGNSKAP-serienummer550498454741797052332932-2015-06-24.p12"; 
////		String certFile = "json.txt"; 
//
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//
//			InputStream is = classLoader.getResourceAsStream("no/systema/jservices/common/jwt/nimbus/" + certFile);
//
//			System.out.println("InputStream is = "+is);
//			
//			
//			return is;
//
//		}		
//		
//	@Test
//	public void WTF() throws Exception {
//		
//		     CertificateFactory cf = CertificateFactory.getInstance("X.509");
//
////		     cf.getInstance(getFile());
//		     
//		     X509Certificate cert = (X509Certificate)cf.generateCertificate(getFile());
//
//			System.out.println("WTF, cert="+cert);
//		     
//		     
//		     
//	}
//
//	@Test
//	public void WTF2() throws Exception {
//		String certFile = "Buypass_ID-BAREKSTAD_OG_YTTERVÅG_REGNSKAP-serienummer550498454741797052332932-2015-06-24.p12"; 		
//
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//
//		InputStream is = classLoader.getResourceAsStream("no/systema/jservices/common/jwt/nimbus/" + certFile);
//
//		
//		String targetString = IOUtils.readInputStreamToString(is, StandardCharset.UTF_8);
//		
//		
//		X509Certificate cert = X509CertUtils.parse(targetString);
//		
//		System.out.println("WTF2, cert="+cert);
//		
//	}
//	
//	@Test
//	public void WTF3() throws Exception {
//		String certFile = "BuypassSYSTEMASign.p12"; 		
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		InputStream is = classLoader.getResourceAsStream("no/systema/jservices/common/jwt/nimbus/" + certFile);
//		
//		char[] password = "QBUihhwaQowmcO2S".toCharArray();
//		
//		KeyStore keyStore = KeyStore.getInstance("PKCS12");
//		keyStore.load(is, password);
//		
//		X509Certificate cert = (X509Certificate)keyStore.getCertificate("systema as");
//		
//
//		RSAKey rsaJWK = RSAKey.parse(cert);
//		
//		System.out.println("rsaJWK="+rsaJWK.toJSONString());
//		
//	
//	}
//	
//}
