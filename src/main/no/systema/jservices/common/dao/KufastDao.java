package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Produktkoder
 * 
 * @author Fredrik Möller
 * @date Aug 14, 2017
 */
public class KufastDao implements IDao {

	private String kftyp; // key
	private String kfkod; // key
	private String kftxt;
	private String kftxte;

	private Map<String, Object> keys = new HashMap<String, Object>();

	
	public String getKftyp() {
		return kftyp;
	}

	public void setKftyp(String kftyp) {
		this.kftyp = kftyp;
	}

	public String getKfkod() {
		return kfkod;
	}

	public void setKfkod(String kfkod) {
		this.kfkod = kfkod;
	}

	public String getKftxt() {
		return kftxt;
	}

	public void setKftxt(String kftxt) {
		this.kftxt = kftxt;
	}

	public String getKftxte() {
		return kftxte;
	}

	public void setKftxte(String kftxte) {
		this.kftxte = kftxte;
	}


	@Override
	public Map<String, Object> getKeys() {
		keys.put("kftyp", kftyp);
		keys.put("kfkod", kfkod);
		return keys;
	}

}
