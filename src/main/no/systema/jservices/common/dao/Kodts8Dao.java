package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class Kodts8Dao implements IDao {

	private String ks8avg; // key
	private String ks8skv; // key
	private String ks8ftx;
	private String ks8sat;
	private String ks8sty;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKs8avg() {
		return ks8avg;
	}

	public void setKs8avg(String ks8avg) {
		this.ks8avg = ks8avg;
	}

	public String getKs8skv() {
		return ks8skv;
	}

	public void setKs8skv(String ks8skv) {
		this.ks8skv = ks8skv;
	}

	public String getKs8ftx() {
		return ks8ftx;
	}

	public void setKs8ftx(String ks8ftx) {
		this.ks8ftx = ks8ftx;
	}

	public String getKs8sat() {
		return ks8sat;
	}

	public void setKs8sat(String ks8sat) {
		this.ks8sat = ks8sat;
	}

	public String getKs8sty() {
		return ks8sty;
	}

	public void setKs8sty(String ks8sty) {
		this.ks8sty = ks8sty;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ks8avg", ks8avg);
		keys.put("ks8skv", ks8skv);
		return keys;
	}

}
