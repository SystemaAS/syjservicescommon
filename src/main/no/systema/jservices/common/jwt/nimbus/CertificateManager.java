package no.systema.jservices.common.jwt.nimbus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.util.IOUtils;
import com.nimbusds.jose.util.StandardCharset;
import com.nimbusds.jose.util.X509CertUtils;

import lombok.NonNull;

@Service
public class CertificateManager {
	private static Logger logger = Logger.getLogger(CertificateManager.class.getName());
	private static String CATALINA_HOME = System.getProperty("catalina.home");
	private static String PREFIX_NAME = "Buypass ID-SYSTEMA";

	/**
	 * Looks i catalina.home/espedsg/certificates after File named with the prefix; Buypass ID-SYSTEMA
	 * 
	 * @return InputStream the located .p12 file
	 * @throws FileNotFoundException 
	 */
	public InputStream loadCertificate() throws FileNotFoundException {
		InputStream certificate = new FileInputStream(getCertificateFile());

		return certificate;
	}

	public void parse(@NonNull InputStream certFile) throws IOException {
		
		@NonNull String targetString = IOUtils.readInputStreamToString(certFile, StandardCharset.UTF_8);
	
		logger.info("targetString="+targetString);
		
		
		@NonNull X509Certificate cert = X509CertUtils.parse(targetString);

		logger.info("cert="+cert);
		
		
	}

	
	
	

//	public InputStream loadCertificate(InputStream certFile) throws FileNotFoundException {
//		InputStream certificate = new FileInputStream(certFile);
//
//		return certificate;
//	}	
	
	private File getCertificateFile() throws FileNotFoundException {
		String folder = CATALINA_HOME + "/espedsg/certificates";
		File certificateFolder = FileUtils.getFile(folder);
		logger.debug("Certificate folder found="+certificateFolder);
		
		File certificateFile = null;
		String[] extensions = {"p12"};
		Collection<File> files = FileUtils.listFiles(certificateFolder, extensions, false);
		
		logger.debug("files.size with .p12 extensions="+files.size());
		
		for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			logger.debug("file="+file.getName());
		}		
		
		Collection<File> filtered =
				files
		        .stream()
		        .filter(f -> f.getName().startsWith(PREFIX_NAME))
		        .collect(Collectors.toSet());	
		
		if (filtered.size() != 1) {
			String errMsg = String.format("Could not find single tuple on certifiction file in folder %s", certificateFolder.getAbsolutePath());
			logger.error(errMsg);
			throw new RuntimeException("SEVERE ERROR loading certificate!!! "+ errMsg);
		}

		for (Iterator<File> iterator = filtered.iterator(); iterator.hasNext();) {
			certificateFile = (File) iterator.next();
		}
		
		return certificateFile;
	}
	
}
