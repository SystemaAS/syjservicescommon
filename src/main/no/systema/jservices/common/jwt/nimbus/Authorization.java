package no.systema.jservices.common.jwt.nimbus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class Authorization {
	private static Logger logger = Logger.getLogger(Authorization.class.getName());
	
	@Autowired
	private CertificateManager certificateManager;

    public InputStream TheCertThingy(@NonNull InputStream certFile) throws IOException {
//    	InputStream is = certificateManager.loadCertificate(certFile);
    	
    	certificateManager.parse(certFile);
    	
    	
    	return certFile;
    	
    }
    
    
}
