package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy from TVINN
 * 
 * @author Fredrik Möller
 * @date Apr 3, 2017
 *
 */
public class Kodts5Dao implements IDao {

	private String ks5sta;
	private String ks5uni; //key
	private String ks5tln; //key
	private String ks5ftx;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKs5sta() {
		return ks5sta;
	}

	public void setKs5sta(String ks5sta) {
		this.ks5sta = ks5sta;
	}

	public String getKs5uni() {
		return ks5uni;
	}

	public void setKs5uni(String ks5uni) {
		this.ks5uni = ks5uni;
	}

	public String getKs5tln() {
		return ks5tln;
	}

	public void setKs5tln(String ks5tln) {
		this.ks5tln = ks5tln;
	}

	public String getKs5ftx() {
		return ks5ftx;
	}

	public void setKs5ftx(String ks5ftx) {
		this.ks5ftx = ks5ftx;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ks5uni", ks5uni);
		keys.put("ks5tln", ks5tln);
		return keys;
	}

}
