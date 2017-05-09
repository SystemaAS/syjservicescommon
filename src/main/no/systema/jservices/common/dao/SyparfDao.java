package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class SyparfDao implements IDao {

	private String syrecn; // key
	private String syuser;
	private String sykunr; // key
	private String syavd = "0";
	private String sypaid;
	private String sysort = "0";
	private String syvrdn = "0";
	private String syvrda;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getSyrecn() {
		return syrecn;
	}

	public void setSyrecn(String syrecn) {
		this.syrecn = syrecn;
	}

	public String getSyuser() {
		return syuser;
	}

	public void setSyuser(String syuser) {
		this.syuser = syuser;
	}

	public String getSykunr() {
		return sykunr;
	}

	public void setSykunr(String sykunr) {
		this.sykunr = sykunr;
	}

	public String getSyavd() {
		return syavd;
	}

	public void setSyavd(String syavd) {
		this.syavd = syavd;
	}

	public String getSypaid() {
		return sypaid;
	}

	public void setSypaid(String sypaid) {
		this.sypaid = sypaid;
	}

	public String getSysort() {
		return sysort;
	}

	public void setSysort(String sysort) {
		this.sysort = sysort;
	}

	public String getSyvrdn() {
		return syvrdn;
	}

	public void setSyvrdn(String syvrdn) {
		this.syvrdn = syvrdn;
	}

	public String getSyvrda() {
		return syvrda;
	}

	public void setSyvrda(String syvrda) {
		this.syvrda = syvrda;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("sykunr", sykunr);
		keys.put("syrecn", syrecn);
		return keys;
	}
	
	public void setKeys(String syuser) {
		keys.put("syuser", syuser);
		keys.put("syrecn", syrecn);
		keys.put("sykunr", "0");		
	}

}
