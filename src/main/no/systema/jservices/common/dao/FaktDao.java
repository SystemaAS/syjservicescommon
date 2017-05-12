package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class FaktDao implements IDao {

	private int faavd; // key
	private int faopd; // key
	private int fali; // key
	private String faval;
	private int fabelv;
	private int fadato;
	private String fakda;

	public String getFaval() {
		return faval;
	}

	public void setFaval(String faval) {
		this.faval = faval;
	}

	public int getFabelv() {
		return fabelv;
	}

	public void setFabelv(int fabelv) {
		this.fabelv = fabelv;
	}

	public int getFadato() {
		return fadato;
	}

	public void setFadato(int fadato) {
		this.fadato = fadato;
	}

	public String getFakda() {
		return fakda;
	}

	public void setFakda(String fakda) {
		this.fakda = fakda;
	}

	public int getFali() {
		return fali;
	}

	public void setFali(int fali) {
		this.fali = fali;
	}

	public int getFaavd() {
		return faavd;
	}

	public void setFaavd(int faavd) {
		this.faavd = faavd;
	}

	public int getFaopd() {
		return faopd;
	}

	public void setFaopd(int faopd) {
		this.faopd = faopd;
	}

	Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("faavd", faavd);
		keys.put("faopd", faopd);
		keys.put("fali", fali);
		return keys;
	}

}
