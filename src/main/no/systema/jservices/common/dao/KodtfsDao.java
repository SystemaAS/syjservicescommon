package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

/**
 * Produkter fly
 * 
 * @author Oscar de la Torre
 * @date Mars 13, 2018
 */
public class KodtfsDao implements IDao {

	private String kfssta;
	private String kfsuni;
	private int kfsfnr;
	private String kfsnav;
	private String kfskd2;
	private String kfsac;
	private int kfsknr;
	private int kfsmc;
	private String kfsjat;
	private BigDecimal kfskom = new BigDecimal(0);
	private String kfsxxx;
	private int kfsmco;
	private int kfsmc2;
	
	private Map<String, Object> keys = new HashMap<String, Object>();

	

	public String getKfssta() {
		return kfssta;
	}



	public void setKfssta(String kfssta) {
		this.kfssta = kfssta;
	}



	public String getKfsuni() {
		return kfsuni;
	}



	public void setKfsuni(String kfsuni) {
		this.kfsuni = kfsuni;
	}



	public int getKfsfnr() {
		return kfsfnr;
	}



	public void setKfsfnr(int kfsfnr) {
		this.kfsfnr = kfsfnr;
	}



	public String getKfsnav() {
		return kfsnav;
	}



	public void setKfsnav(String kfsnav) {
		this.kfsnav = kfsnav;
	}



	public String getKfskd2() {
		return kfskd2;
	}



	public void setKfskd2(String kfskd2) {
		this.kfskd2 = kfskd2;
	}



	public String getKfsac() {
		return kfsac;
	}



	public void setKfsac(String kfsac) {
		this.kfsac = kfsac;
	}



	public int getKfsknr() {
		return kfsknr;
	}



	public void setKfsknr(int kfsknr) {
		this.kfsknr = kfsknr;
	}



	public int getKfsmc() {
		return kfsmc;
	}



	public void setKfsmc(int kfsmc) {
		this.kfsmc = kfsmc;
	}



	public String getKfsjat() {
		return kfsjat;
	}



	public void setKfsjat(String kfsjat) {
		this.kfsjat = kfsjat;
	}



	public BigDecimal getKfskom() {
		return kfskom;
	}



	public void setKfskom(BigDecimal kfskom) {
		this.kfskom = kfskom;
	}



	public String getKfsxxx() {
		return kfsxxx;
	}



	public void setKfsxxx(String kfsxxx) {
		this.kfsxxx = kfsxxx;
	}



	public int getKfsmco() {
		return kfsmco;
	}



	public void setKfsmco(int kfsmco) {
		this.kfsmco = kfsmco;
	}



	public int getKfsmc2() {
		return kfsmc2;
	}



	public void setKfsmc2(int kfsmc2) {
		this.kfsmc2 = kfsmc2;
	}



	@Override

	public Map<String, Object> getKeys() {
		keys.put("kfsuni", kfsuni);
		keys.put("kfsfnr", kfsfnr);
		
		return keys;
	}

}
