package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class HeadfDao implements IDao {

	private int heavd; // key
	private int heopd; // key
	private String heur; // maybe key?
	private String hest;
	private int hedtop;
	private String helka;
	private String heot;
	private String hekdpl;

	public int getHeavd() {
		return heavd;
	}

	public void setHeavd(int heavd) {
		this.heavd = heavd;
	}

	public int getHeopd() {
		return heopd;
	}

	public void setHeopd(int heopd) {
		this.heopd = heopd;
	}

	public String getHeur() {
		return heur;
	}

	public void setHeur(String heur) {
		this.heur = heur;
	}

	public String getHest() {
		return hest;
	}

	public void setHest(String hest) {
		this.hest = hest;
	}

	public int getHedtop() {
		return hedtop;
	}

	public void setHedtop(int hedtop) {
		this.hedtop = hedtop;
	}

	public String getHelka() {
		return helka;
	}

	public void setHelka(String helka) {
		this.helka = helka;
	}

	public String getHeot() {
		return heot;
	}

	public void setHeot(String heot) {
		this.heot = heot;
	}

	public String getHekdpl() {
		return hekdpl;
	}

	public void setHekdpl(String hekdpl) {
		this.hekdpl = hekdpl;
	}

	Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("heavd", heavd);
		keys.put("heopd", heopd);
		return keys;
	}

}
