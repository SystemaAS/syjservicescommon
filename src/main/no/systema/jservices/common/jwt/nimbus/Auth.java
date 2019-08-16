package no.systema.jservices.common.jwt.nimbus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class Auth {
	private static Logger logger = Logger.getLogger(Auth.class.getName());
	
	@Autowired
	private CertificateManager certificateManager;

    public InputStream TheCertThingy() throws IOException {
////    	InputStream is = certificateManager.loadCertificate(certFile);
//    	
//    	certificateManager.parse(certFile);
    	
    	InputStream certFile = certificateManager.loadCertificate();
    	
    	
    	return certFile;
    	
    }
    
  
    
    
}
