package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Frankatur
 * 
 * @author Fredrik Möller
 * @date Aug 14, 2017
 */
public class KodtfrDao implements IDao {

	private String kfrsta;
	private String kfruni;
	private String kfrkod; // key
	private String kfrntx;
	private String kfrttx;
	private String kfrcp;

	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getKfrsta() {
		return kfrsta;
	}

	public void setKfrsta(String kfrsta) {
		this.kfrsta = kfrsta;
	}

	public String getKfruni() {
		return kfruni;
	}

	public void setKfruni(String kfruni) {
		this.kfruni = kfruni;
	}

	public String getKfrkod() {
		return kfrkod;
	}

	public void setKfrkod(String kfrkod) {
		this.kfrkod = kfrkod;
	}

	public String getKfrntx() {
		return kfrntx;
	}

	public void setKfrntx(String kfrntx) {
		this.kfrntx = kfrntx;
	}

	public String getKfrttx() {
		return kfrttx;
	}

	public void setKfrttx(String kfrttx) {
		this.kfrttx = kfrttx;
	}

	public String getKfrcp() {
		return kfrcp;
	}

	public void setKfrcp(String kfrcp) {
		this.kfrcp = kfrcp;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kfrkod", kfrkod);
		return keys;
	}

}
