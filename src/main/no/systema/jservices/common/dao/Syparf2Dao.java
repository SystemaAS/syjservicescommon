package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class Syparf2Dao implements IDao {

	private String syrecn; // key
	private String syuser; // key
	private String sykunr = "0"; 
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
		keys.put("syuser", syuser);
		keys.put("syrecn", syrecn);
		return keys;
	}

}
