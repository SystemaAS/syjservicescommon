package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodtgeDao implements IDao {

	private String kgesta;
	private String kgeuni;
	private String kgekod; // key
	private String kgenot; /* beskrivning */
	private String kgeent;
	private int kgekon;
	private String kgesad;
	private String kgeutl;
	private String kgekk;
	private String kgefra;
	private int kgeutk;
	private String kgepr;
	private String kgetyp;
	private String kgeavr;
	private String kgeie;
	private String kgeke;
	private String kgeii;
	private String kgeki;

	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getKgesta() {
		return kgesta;
	}

	public void setKgesta(String kgesta) {
		this.kgesta = kgesta;
	}

	public String getKgeuni() {
		return kgeuni;
	}

	public void setKgeuni(String kgeuni) {
		this.kgeuni = kgeuni;
	}

	public String getKgekod() {
		return kgekod;
	}

	public void setKgekod(String kgekod) {
		this.kgekod = kgekod;
	}

	public String getKgenot() {
		return kgenot;
	}

	public void setKgenot(String kgenot) {
		this.kgenot = kgenot;
	}

	public String getKgeent() {
		return kgeent;
	}

	public void setKgeent(String kgeent) {
		this.kgeent = kgeent;
	}

	public int getKgekon() {
		return kgekon;
	}

	public void setKgekon(int kgekon) {
		this.kgekon = kgekon;
	}

	public String getKgesad() {
		return kgesad;
	}

	public void setKgesad(String kgesad) {
		this.kgesad = kgesad;
	}

	public String getKgeutl() {
		return kgeutl;
	}

	public void setKgeutl(String kgeutl) {
		this.kgeutl = kgeutl;
	}

	public String getKgekk() {
		return kgekk;
	}

	public void setKgekk(String kgekk) {
		this.kgekk = kgekk;
	}

	public String getKgefra() {
		return kgefra;
	}

	public void setKgefra(String kgefra) {
		this.kgefra = kgefra;
	}

	public int getKgeutk() {
		return kgeutk;
	}

	public void setKgeutk(int kgeutk) {
		this.kgeutk = kgeutk;
	}

	public String getKgepr() {
		return kgepr;
	}

	public void setKgepr(String kgepr) {
		this.kgepr = kgepr;
	}

	public String getKgetyp() {
		return kgetyp;
	}

	public void setKgetyp(String kgetyp) {
		this.kgetyp = kgetyp;
	}

	public String getKgeavr() {
		return kgeavr;
	}

	public void setKgeavr(String kgeavr) {
		this.kgeavr = kgeavr;
	}

	public String getKgeie() {
		return kgeie;
	}

	public void setKgeie(String kgeie) {
		this.kgeie = kgeie;
	}

	public String getKgeke() {
		return kgeke;
	}

	public void setKgeke(String kgeke) {
		this.kgeke = kgeke;
	}

	public String getKgeii() {
		return kgeii;
	}

	public void setKgeii(String kgeii) {
		this.kgeii = kgeii;
	}

	public String getKgeki() {
		return kgeki;
	}

	public void setKgeki(String kgeki) {
		this.kgeki = kgeki;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kgekod", kgekod);
		return keys;
	}

}
