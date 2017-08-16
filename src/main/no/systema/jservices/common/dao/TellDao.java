package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Indexes for Oppdrag
 * 
 * @author Fredrik Möller
 * @date Aug 16, 2017
 */
public class TellDao implements IDao {

	private String testat;
	private int teavd;
	private int teopdn;
	private int teturn;
	private int tetmin;
	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getTestat() {
		return testat;
	}

	public void setTestat(String testat) {
		this.testat = testat;
	}

	public int getTeavd() {
		return teavd;
	}

	public void setTeavd(int teavd) {
		this.teavd = teavd;
	}

	public int getTeopdn() {
		return teopdn;
	}

	public void setTeopdn(int teopdn) {
		this.teopdn = teopdn;
	}

	public int getTeturn() {
		return teturn;
	}

	public void setTeturn(int teturn) {
		this.teturn = teturn;
	}

	public int getTetmin() {
		return tetmin;
	}

	public void setTetmin(int tetmin) {
		this.tetmin = tetmin;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("teavd", teavd);
		return keys;
	}

}
