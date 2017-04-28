package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodtftDao implements IDao {

	private String kfttyp; // key
	private int kftln; // key
	private String kftsk;
	private String kftftx;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKfttyp() {
		return kfttyp;
	}

	public void setKfttyp(String kfttyp) {
		this.kfttyp = kfttyp;
	}

	public int getKftln() {
		return kftln;
	}

	public void setKftln(int kftln) {
		this.kftln = kftln;
	}

	public String getKftsk() {
		return kftsk;
	}

	public void setKftsk(String kftsk) {
		this.kftsk = kftsk;
	}

	public String getKftftx() {
		return kftftx;
	}

	public void setKftftx(String kftftx) {
		this.kftftx = kftftx;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kfttyp", kfttyp);
		keys.put("kftln", kftln);
		return keys;
	}

}
