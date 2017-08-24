package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KunkoDao implements IDao {

	private int kukun1;
	private int kukun2;
	private String kuintn;
	private String kualfa;
	private int kuvadr;
	private Map<String, Object> keys = new HashMap<String, Object>();

	public int getKukun1() {
		return kukun1;
	}

	public void setKukun1(int kukun1) {
		this.kukun1 = kukun1;
	}

	public int getKukun2() {
		return kukun2;
	}

	public void setKukun2(int kukun2) {
		this.kukun2 = kukun2;
	}

	public String getKuintn() {
		return kuintn;
	}

	public void setKuintn(String kuintn) {
		this.kuintn = kuintn;
	}

	public String getKualfa() {
		return kualfa;
	}

	public void setKualfa(String kualfa) {
		this.kualfa = kualfa;
	}

	public int getKuvadr() {
		return kuvadr;
	}

	public void setKuvadr(int kuvadr) {
		this.kuvadr = kuvadr;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kukun1", kukun1);
		keys.put("kukun2", kukun2);
		keys.put("kuvadr", kuvadr);
		return keys;
	}

}
