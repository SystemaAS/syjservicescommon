package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Text för DOK29
 * 
 * @author Oscar de la Torre
 * @date Jan 25, 2018
 */
public class Dok29Dao implements IDao {
	
	private int d29avd; // avd  SONET (4)
	private int d29opd; //opd SONET (7)
	private int d29fnr; // Fraktbrevsnr SONET (3)
	private String d29txt; // Text (70)
	private Map<String, Object> keys = new HashMap<String, Object>();
	
		
	
	public int getD29avd() {
		return d29avd;
	}

	public void setD29avd(int d29avd) {
		this.d29avd = d29avd;
	}

	public int getD29opd() {
		return d29opd;
	}

	public void setD29opd(int d29opd) {
		this.d29opd = d29opd;
	}

	public int getD29fnr() {
		return d29fnr;
	}

	public void setD29fnr(int d29fnr) {
		this.d29fnr = d29fnr;
	}

	public String getD29txt() {
		return d29txt;
	}

	public void setD29txt(String d29txt) {
		this.d29txt = d29txt;
	}

	//alternative
	/*public void setKeys(int avd, int opd) {
		keys.put("fmavd", avd);
		keys.put("fmopd", opd);
	}*/
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("d29avd", d29avd);
		keys.put("d29opd", d29opd);
		keys.put("d29fnr", d29fnr);
		return keys;
	}


}
