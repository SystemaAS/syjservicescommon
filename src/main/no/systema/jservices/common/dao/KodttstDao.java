package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class KodttstDao implements IDao {

	private String ktssta;
	private String ktsuni;
	private int ktskod; // key
	private String ktsnav;
	private int ktspnr;
	private String ktstrt;
	private BigDecimal ktssat = new BigDecimal(0);
	private String ktsxxx;
	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getKtssta() {
		return ktssta;
	}

	public void setKtssta(String ktssta) {
		this.ktssta = ktssta;
	}

	public String getKtsuni() {
		return ktsuni;
	}

	public void setKtsuni(String ktsuni) {
		this.ktsuni = ktsuni;
	}

	public int getKtskod() {
		return ktskod;
	}

	public void setKtskod(int ktskod) {
		this.ktskod = ktskod;
	}

	public String getKtsnav() {
		return ktsnav;
	}

	public void setKtsnav(String ktsnav) {
		this.ktsnav = ktsnav;
	}

	public int getKtspnr() {
		return ktspnr;
	}

	public void setKtspnr(int ktspnr) {
		this.ktspnr = ktspnr;
	}

	public String getKtstrt() {
		return ktstrt;
	}

	public void setKtstrt(String ktstrt) {
		this.ktstrt = ktstrt;
	}

	public BigDecimal getKtssat() {
		return ktssat;
	}

	public void setKtssat(BigDecimal ktssat) {
		this.ktssat = ktssat;
	}

	public String getKtsxxx() {
		return ktsxxx;
	}

	public void setKtsxxx(String ktsxxx) {
		this.ktsxxx = ktsxxx;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ktskod", ktskod);
		return keys;
	}

}
