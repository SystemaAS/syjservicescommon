package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * This class holds configurations for the Visma.net integration
 * 
 * @author fredrikmoller
 *
 */
@Data
public class FirmvisDao implements IDao {

	private String vifirm; //FIRMA I SYSPED	
	private String vibapa; // BASEPATH
	private String viapty; // APPTYPE
	private String vicoid; // COMPANYID
	private String viacto; // ACCESSTOKEN
	private String viauco; // AUTHORIZATION_CODE
	private String viclid; // CLIENT_ID
	private String viclse; // CLIENT_SECRET

	private Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("vicoid", vicoid);
		return keys;
	}

}
