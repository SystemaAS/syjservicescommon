package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class FratxtDao implements IDao {

	private String fxknr = ""; // key
	private String fxlnr = ""; // key
	private String fxtxt = "";
	private String fxxxx = "";
	private String delsys = ""; // key
	private String fxusr = "";
	private String fxdt = "";

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getFxknr() {
		return fxknr;
	}

	public void setFxknr(String fxknr) {
		this.fxknr = fxknr;
	}

	public String getFxlnr() {
		return fxlnr;
	}

	public void setFxlnr(String fxlnr) {
		this.fxlnr = fxlnr;
	}

	public String getFxtxt() {
		return fxtxt;
	}

	public void setFxtxt(String fxtxt) {
		this.fxtxt = fxtxt;
	}

	public String getFxxxx() {
		return fxxxx;
	}

	public void setFxxxx(String fxxxx) {
		this.fxxxx = fxxxx;
	}

	public String getDelsys() {
		return delsys;
	}

	public void setDelsys(String delsys) {
		this.delsys = delsys;
	}

	public String getFxusr() {
		return fxusr;
	}

	public void setFxusr(String fxusr) {
		this.fxusr = fxusr;
	}

	public String getFxdt() {
		return fxdt;
	}

	public void setFxdt(String fxdt) {
		this.fxdt = fxdt;
	}

	public void setKeys(Map<String, Object> keys) {
		this.keys = keys;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("fxknr", fxknr);
		keys.put("fxlnr", fxlnr);
		keys.put("delsys", delsys);
		return keys;
	}

}
