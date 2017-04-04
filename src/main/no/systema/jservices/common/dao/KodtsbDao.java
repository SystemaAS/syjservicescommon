package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodtsbDao implements IDao {

	private String ksbkd;
	private String ksbft;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKsbkd() {
		return ksbkd;
	}

	public void setKsbkd(String ksbkd) {
		this.ksbkd = ksbkd;
	}

	public String getKsbft() {
		return ksbft;
	}

	public void setKsbft(String ksbft) {
		this.ksbft = ksbft;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ksbkd", ksbkd);
		return keys;
	}

}
