package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodtsaDao implements IDao {

	private String ksakd;
	private String ksaft;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKsakd() {
		return ksakd;
	}

	public void setKsakd(String ksakd) {
		this.ksakd = ksakd;
	}

	public String getKsaft() {
		return ksaft;
	}

	public void setKsaft(String ksaft) {
		this.ksaft = ksaft;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ksakd", ksakd);
		return keys;
	}

}
