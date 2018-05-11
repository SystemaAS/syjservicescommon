package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class ViskulogDao implements IDao {

	private String firma;
	private int kundnr; //key
	private String knavn;
	private String status;
	private int syncda;
	private int synctm;
	private String syerro;

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

	public String getKnavn() {
		return knavn;
	}

	public void setKnavn(String knavn) {
		this.knavn = knavn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSyncda() {
		return syncda;
	}

	public void setSyncda(int syncda) {
		this.syncda = syncda;
	}

	public int getSynctm() {
		return synctm;
	}

	public void setSynctm(int synctm) {
		this.synctm = synctm;
	}

	public String getSyerro() {
		return syerro;
	}

	public void setSyerro(String syerro) {
		this.syerro = syerro;
	}

}
