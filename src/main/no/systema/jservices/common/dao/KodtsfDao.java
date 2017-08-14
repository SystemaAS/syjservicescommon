package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Signaturer
 * 
 * @author Fredrik Möller
 * @date Aug 14, 2017
 *
 */
public class KodtsfDao implements IDao {

	private String kosfst;
	private String kosfun;
	private String kosfsi; // key
	private String kosfnv;
	private String kosfxx;

	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getKosfst() {
		return kosfst;
	}

	public void setKosfst(String kosfst) {
		this.kosfst = kosfst;
	}

	public String getKosfun() {
		return kosfun;
	}

	public void setKosfun(String kosfun) {
		this.kosfun = kosfun;
	}

	public String getKosfsi() {
		return kosfsi;
	}

	public void setKosfsi(String kosfsi) {
		this.kosfsi = kosfsi;
	}

	public String getKosfnv() {
		return kosfnv;
	}

	public void setKosfnv(String kosfnv) {
		this.kosfnv = kosfnv;
	}

	public String getKosfxx() {
		return kosfxx;
	}

	public void setKosfxx(String kosfxx) {
		this.kosfxx = kosfxx;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kosfsi", kosfsi);
		return keys;
	}

}
