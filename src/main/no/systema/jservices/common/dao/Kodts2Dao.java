package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class Kodts2Dao implements IDao {

	private String ks2sta;
	private String ks2uni; // key
	private String ks2lk; // key
	private String ks2ftx;
	private String ks2pre;
	private String ks2mo;
	private String ks2nas;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKs2sta() {
		return ks2sta;
	}

	public void setKs2sta(String ks2sta) {
		this.ks2sta = ks2sta;
	}

	public String getKs2uni() {
		return ks2uni;
	}

	public void setKs2uni(String ks2uni) {
		this.ks2uni = ks2uni;
	}

	public String getKs2lk() {
		return ks2lk;
	}

	public void setKs2lk(String ks2lk) {
		this.ks2lk = ks2lk;
	}

	public String getKs2ftx() {
		return ks2ftx;
	}

	public void setKs2ftx(String ks2ftx) {
		this.ks2ftx = ks2ftx;
	}

	public String getKs2pre() {
		return ks2pre;
	}

	public void setKs2pre(String ks2pre) {
		this.ks2pre = ks2pre;
	}

	public String getKs2mo() {
		return ks2mo;
	}

	public void setKs2mo(String ks2mo) {
		this.ks2mo = ks2mo;
	}

	public String getKs2nas() {
		return ks2nas;
	}

	public void setKs2nas(String ks2nas) {
		this.ks2nas = ks2nas;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ks2uni", ks2uni);
		keys.put("ks2lk", ks2lk);
		return keys;
	}

}
