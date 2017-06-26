package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class BridfDao implements IDao {

	private String bibrid; // key
	private String bipo;
	private String bibesk;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getBibrid() {
		return bibrid;
	}

	public void setBibrid(String bibrid) {
		this.bibrid = bibrid;
	}

	public String getBipo() {
		return bipo;
	}

	public void setBipo(String bipo) {
		this.bipo = bipo;
	}

	public String getBibesk() {
		return bibesk;
	}

	public void setBibesk(String bibesk) {
		this.bibesk = bibesk;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("bibrid", bibrid);
		return keys;
	}

}
