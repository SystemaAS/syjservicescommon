package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class Kodts7Dao implements IDao {

	private String ks7sta;
	private String ks7uni; // key
	private String ks7vf; // key
	private String ks7ftx;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKs7sta() {
		return ks7sta;
	}

	public void setKs7sta(String ks7sta) {
		this.ks7sta = ks7sta;
	}

	public String getKs7uni() {
		return ks7uni;
	}

	public void setKs7uni(String ks7uni) {
		this.ks7uni = ks7uni;
	}

	public String getKs7vf() {
		return ks7vf;
	}

	public void setKs7vf(String ks7vf) {
		this.ks7vf = ks7vf;
	}

	public String getKs7ftx() {
		return ks7ftx;
	}

	public void setKs7ftx(String ks7ftx) {
		this.ks7ftx = ks7ftx;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ks7uni", ks7uni);
		keys.put("ks7vf", ks7vf);
		return keys;
	}

}
