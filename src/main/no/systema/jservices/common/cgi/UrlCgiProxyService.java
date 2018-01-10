/**
 * 
 */
package no.systema.jservices.common.cgi;

/**
 * 
 * This interface lends a cgi request to the back-end usually returning a Payload String (JSON or other list structure)
 * 
 * @author oscardelatorre
 *
 */
public interface UrlCgiProxyService {
	/**
	 * Returns a content JSON-payload from a http request via POST
	 * 
	 * @param urlStr
	 * @param urlParameters
	 * @return
	 */
	public String getJsonContent(String urlStr, String urlParams);
	
}
