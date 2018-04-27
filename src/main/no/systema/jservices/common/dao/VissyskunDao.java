/**
 * 
 */
package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * This class holds the cross-ref between VISKUNDE kundnr and Visma-net Customer number
 * 
 * @author fredrikmoller
 *
 */
public class VissyskunDao implements IDao {

	private String firma;
	private int kundnr; // key
	private int visknr; 
	private Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kundnr", kundnr);
		return keys;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public int getKundnr() {
		return kundnr;
	}

	public void setKundnr(int kundnr) {
		this.kundnr = kundnr;
	}

	public int getVisknr() {
		return visknr;
	}

	public void setVisknr(int visknr) {
		this.visknr = visknr;
	}

}
