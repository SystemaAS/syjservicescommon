package no.systema.jservices.common.elma.proxy;

import java.net.URI;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import no.systema.jservices.common.elma.entities.Entries;
import no.systema.jservices.common.elma.entities.Entry;
import no.systema.jservices.common.util.ApplicationPropertiesUtil;
import no.systema.jservices.common.util.CommonClientHttpRequestInterceptor;
import no.systema.jservices.common.util.CommonResponseErrorHandler;

@Service
public class EntryRequest {

	private static Logger logger = Logger.getLogger(EntryRequest.class.getName());
	
	
//    @Value("${no.difi.host}")
//    String host2;	
//	
//    @Value("${no.difi.path.elma}")
//    String path2;		
	
	
//	String host = ApplicationPropertiesUtil.getProperty("no.difi.host");
//	String path = ApplicationPropertiesUtil.getProperty("no.difi.path.elma");
	
	
	String host = "hotell.difi.no";
	String path = "api/json/difi/elma/participants";
	
    RestTemplate restTemplate;
    
	/**
	 * Initialize  {@linkplain RestTemplate} with {@linkplain MappingJackson2HttpMessageConverter} and <br>
	 * a Interceptor, {@linkplain VismaClientHttpRequestInterceptor}
	 * 
	 * @return RestTemplate
	 */
    @Bean
	public RestTemplate restTemplate(){
    	restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Arrays.asList(new CommonClientHttpRequestInterceptor()));
		restTemplate.setErrorHandler(new CommonResponseErrorHandler());

		return restTemplate;  
		
	}	
	
    /**
     * Get elma entity
     * 
     * @param orgnr
     * @return the elma Entity is exist, else return null
     */
    public Entry getElmaEntry(String orgnr) {
    	Entries entries;
    	
    	entries = restTemplate.getForObject(ehf(orgnr), Entries.class);
    	
    	if (entries.getPosts() == 1) {
    		return entries.getEntries().get(0);
    	} else {
    		return null;
    	}
    	
    }
    
	/**
	 * Get URI for EHF dataset for specific orgnr
	 * 
	 * @param orgnr
	 * @return URI, ex. https://hotell.difi.no/api/json/difi/elma/participants?query=966261218
	 */
	public URI ehf(String orgnr) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host(host)
				.path(path)
				.query("query={expand1}")
				.buildAndExpand(orgnr)
				.encode();

		return uriComponents.toUri();

	}    
    
	
}
