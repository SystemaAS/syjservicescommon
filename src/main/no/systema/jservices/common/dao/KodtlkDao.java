package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodtlkDao implements IDao {

	private String klkst;
	private String klkuni; //key
	private String klklk;  //key
	private String klknvn;
	private String klkalf;
	private String klkxx1;
	private String klkmin;
	private String klkdis;
	private String klkpro;
	private String klklk2;
	private String klkxx2;
	private String klknve;
	private String klknvt;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKlkst() {
		return klkst;
	}

	public void setKlkst(String klkst) {
		this.klkst = klkst;
	}

	public String getKlkuni() {
		return klkuni;
	}

	public void setKlkuni(String klkuni) {
		this.klkuni = klkuni;
	}

	public String getKlklk() {
		return klklk;
	}

	public void setKlklk(String klklk) {
		this.klklk = klklk;
	}

	public String getKlknvn() {
		return klknvn;
	}

	public void setKlknvn(String klknvn) {
		this.klknvn = klknvn;
	}

	public String getKlkalf() {
		return klkalf;
	}

	public void setKlkalf(String klkalf) {
		this.klkalf = klkalf;
	}

	public String getKlkxx1() {
		return klkxx1;
	}

	public void setKlkxx1(String klkxx1) {
		this.klkxx1 = klkxx1;
	}

	public String getKlkmin() {
		return klkmin;
	}

	public void setKlkmin(String klkmin) {
		this.klkmin = klkmin;
	}

	public String getKlkdis() {
		return klkdis;
	}

	public void setKlkdis(String klkdis) {
		this.klkdis = klkdis;
	}

	public String getKlkpro() {
		return klkpro;
	}

	public void setKlkpro(String klkpro) {
		this.klkpro = klkpro;
	}

	public String getKlklk2() {
		return klklk2;
	}

	public void setKlklk2(String klklk2) {
		this.klklk2 = klklk2;
	}

	public String getKlkxx2() {
		return klkxx2;
	}

	public void setKlkxx2(String klkxx2) {
		this.klkxx2 = klkxx2;
	}

	public String getKlknve() {
		return klknve;
	}

	public void setKlknve(String klknve) {
		this.klknve = klknve;
	}

	public String getKlknvt() {
		return klknvt;
	}

	public void setKlknvt(String klknvt) {
		this.klknvt = klknvt;
	}

	public void setKeys(Map<String, Object> keys) {
		this.keys = keys;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("klkuni", klkuni); 
		keys.put("klklk", klklk); 
		return keys;
	}

}
