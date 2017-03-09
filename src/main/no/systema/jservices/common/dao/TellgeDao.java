package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class TellgeDao implements IDao {

	private String geco; //key
	private String geno; 

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getGeco() {
		return geco;
	}

	public void setGeco(String geco) {
		this.geco = geco;
	}

	public String getGeno() {
		return geno;
	}

	public void setGeno(String geno) {
		this.geno = geno;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("geco", geco);
		return keys;
	}

}
