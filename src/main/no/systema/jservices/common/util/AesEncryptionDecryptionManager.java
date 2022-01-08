/**
 * 
 */
package no.systema.jservices.common.util;


import java.lang.reflect.Array;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.*;


import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


/**
 * Utility class to manage encryption with AES-algorithm
 * 
 * @author oscardelatorre
 * @date Mar 27, 2018
 * 
 */
public class AesEncryptionDecryptionManager {
	private static final Logger logger = LoggerFactory.getLogger(AesEncryptionDecryptionManager.class.getName());
	private static final String ALGO = "AES";
	private static final byte[] keyValue =
	            //new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
			new byte[]{'B', 'a', 'c', 'h', 'I', 's', 'T', 'h', 'e', 'K', 'e', 'y', 'D', 'u', 'd', 'e' };

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    public String encrypt(String data) {
    	logger.warn("inside AesEncryptionDecryptionManager.encrypt()" );
    	byte[] encVal = null;
    	try{
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        encVal = c.doFinal(data.getBytes());
    	}catch(Exception e){
    		logger.info("ERROR encryption" + e.toString());
    	}
        return Base64.getEncoder().encodeToString(encVal);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     */
    public String decrypt(String encryptedData) {
    	byte[] decValue = null;
    	try{
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
	        decValue = c.doFinal(decordedValue);
    	}catch(Exception e){
    		logger.info("ERROR decryption" + e.toString());
    	}
        return new String(decValue);
    }
    
    public Map<String, String> decryptBearer(String encryptedData) {
    	String FIELD_SEPARATOR = "&";
    	byte[] decValue = null;
    	Map<String,String> map = new HashMap<String,String>();
    	String [] fields;
    	try{
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
	        decValue = c.doFinal(decordedValue);
	        String value = new String(decValue);
	        fields = value.split(FIELD_SEPARATOR, 2);
	        
	        if(fields.length > 1){
	        	map.put("session", fields[0]);
	        	map.put("user", fields[1]);
	        }
	        
    	}catch(Exception e){
    		logger.info("ERROR decryption" + e.toString());
    	}
        return map;
    }

    /**
     * Generate a new encryption key.
     */
    private Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGO);
    }
}
