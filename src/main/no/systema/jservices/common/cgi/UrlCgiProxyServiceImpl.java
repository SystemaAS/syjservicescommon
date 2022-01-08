/**
 * 
 */
package no.systema.jservices.common.cgi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//java net
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.*;
/**
 * 
 * @author oscardelatorre
 *
 */
public class UrlCgiProxyServiceImpl implements UrlCgiProxyService{
	private static Logger logger = LoggerFactory.getLogger(UrlCgiProxyServiceImpl.class.getName());
	private static final String ENCODING_JSON_UTF8 = "UTF8";
	private static final String ENCODING_STREAMS_UTF8 = "UTF-8";

	
	@Override
	public String getJsonContent(String urlStr, String urlParameters){
		StringBuilder buffer = new StringBuilder();
		String utfPayload = null;
		
		try{
			
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			//Open writer
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), ENCODING_STREAMS_UTF8);
			writer.write(urlParameters);
			writer.flush();
			//Open reader
			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), ENCODING_STREAMS_UTF8));
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				//logger.info(line);
			}
			writer.close();
			reader.close(); 
			
			EncodingTransformer transformer = new EncodingTransformer();
			utfPayload = transformer.transformToJSONTargetEncoding(buffer.toString(), UrlCgiProxyServiceImpl.ENCODING_JSON_UTF8);
			//logger.info(utfPayload);
			
		}catch(Exception e){
    		e.printStackTrace();
    		logger.info("Error:", e);
    		throw new RuntimeException(e);
    		
    	}
		return utfPayload;
	}
	
}
