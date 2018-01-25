package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Text för DOK36
 * 
 * @author Oscar de la Torre
 * @date Jan 25, 2018
 */
public class Dok36Dao implements IDao {
	
	private int d36avd; // avd  SONET (4)
	private int d36opd; //opd SONET (7)
	private int d36fnr; // Fraktbrevsnr SONET (3)
	private String d36txt; // Text (70)
	private Map<String, Object> keys = new HashMap<String, Object>();
	
		
	
	public int getD36avd() {
		return d36avd;
	}

	public void setD36avd(int d36avd) {
		this.d36avd = d36avd;
	}

	public int getD36opd() {
		return d36opd;
	}

	public void setD36opd(int d36opd) {
		this.d36opd = d36opd;
	}

	public int getD36fnr() {
		return d36fnr;
	}

	public void setD36fnr(int d36fnr) {
		this.d36fnr = d36fnr;
	}

	public String getD36txt() {
		return d36txt;
	}

	public void setD36txt(String d36txt) {
		this.d36txt = d36txt;
	}

	//alternative
	/*public void setKeys(int avd, int opd) {
		keys.put("fmavd", avd);
		keys.put("fmopd", opd);
	}*/
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("d36avd", d36avd);
		keys.put("d36opd", d36opd);
		keys.put("d36fnr", d36fnr);
		return keys;
	}


}
