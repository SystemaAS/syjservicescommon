package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * This class holds configurations for the Visma.net integration
 * 
 * @author fredrikmoller
 *
 */
public class FirmvisDao implements IDao {

	private String vifirm;
	private String vibapa; // BASEPATH
	private String viapty; // APPTYPE
	private String vicoid; // COMPANYID: key
	private String viacto; // ACCESSTOKEN
	private Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("vicoid", vicoid);
		return keys;
	}

	public String getVifirm() {
		return vifirm;
	}

	public void setVifirm(String vifirm) {
		this.vifirm = vifirm;
	}

	public String getVibapa() {
		return vibapa;
	}

	public void setVibapa(String vibapa) {
		this.vibapa = vibapa;
	}

	public String getViapty() {
		return viapty;
	}

	public void setViapty(String viapty) {
		this.viapty = viapty;
	}

	public String getVicoid() {
		return vicoid;
	}

	public void setVicoid(String vicoid) {
		this.vicoid = vicoid;
	}

	public String getViacto() {
		return viacto;
	}

	public void setViacto(String viacto) {
		this.viacto = viacto;
	}

}
