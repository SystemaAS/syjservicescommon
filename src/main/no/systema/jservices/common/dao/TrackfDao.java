package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import no.systema.jservices.common.util.DateTimeManager;

public class TrackfDao implements IDao {

	private int ttavd; // key  SONET (4)
	private int ttopd; // key  SONET (7)
	private int ttfbnr = 0; // key SONET (3)
	private String ttacti; // TEGN (3)
	private int ttdate = 0; // SONET (8) 
	private int tttime = 0; // SONET (6)
	private String tttext; //TEGN (70)
	private String ttuser; //TEGN (10)
	private int ttdatl = 0; //SONET (8)
	private int tttiml = 0; //SONET (6)
	private String ttedev; //TEGN (3) 
	private String ttedre; //TEGN (3)
	private String ttdepo; //TEGN (10)
	private String ttname; //TEGN (10)
	private String ttmanu; //TEGN (1)
	private String tttexl; //TEGN (70)
	private int tttur = 0; //SONET (8)
	private String ttlocc; //TEGN (10)
	private String ttloct; //TEGN (30)
	private BigDecimal ttbre = new BigDecimal(0); //SONET (8 6)
	private BigDecimal ttlen = new BigDecimal(0); //SONET (9 6)
	private String tturl; //TEGN (150)
	private String ttman2; //TEGN (1) 
	private Map<String, Object> keys = new HashMap<String, Object>();

	
	
	public int getTtavd() {
		return ttavd;
	}

	public void setTtavd(int ttavd) {
		this.ttavd = ttavd;
	}

	public int getTtopd() {
		return ttopd;
	}

	public void setTtopd(int ttopd) {
		this.ttopd = ttopd;
	}

	public int getTtfbnr() {
		return ttfbnr;
	}

	public void setTtfbnr(int ttfbnr) {
		this.ttfbnr = ttfbnr;
	}



	public String getTtacti() {
		return ttacti;
	}



	public void setTtacti(String ttacti) {
		this.ttacti = ttacti;
	}



	public int getTtdate() {
		return ttdate;
	}

	public void setTtdate(int ttdate) {
		this.ttdate = ttdate;
	}

	public int getTttime() {
		return tttime;
	}

	public void setTttime(int tttime) {
		this.tttime = tttime;
	}

	public String getTttext() {
		return tttext;
	}



	public void setTttext(String tttext) {
		this.tttext = tttext;
	}

	public String getTtuser() {
		return ttuser;
	}

	public void setTtuser(String ttuser) {
		this.ttuser = ttuser;
	}

	public int getTtdatl() {
		return ttdatl;
	}

	public void setTtdatl(int ttdatl) {
		this.ttdatl = ttdatl;
	}

	public int getTttiml() {
		return tttiml;
	}



	public void setTttiml(int tttiml) {
		this.tttiml = tttiml;
	}



	public String getTtedev() {
		return ttedev;
	}



	public void setTtedev(String ttedev) {
		this.ttedev = ttedev;
	}



	public String getTtedre() {
		return ttedre;
	}



	public void setTtedre(String ttedre) {
		this.ttedre = ttedre;
	}



	public String getTtdepo() {
		return ttdepo;
	}



	public void setTtdepo(String ttdepo) {
		this.ttdepo = ttdepo;
	}



	public String getTtname() {
		return ttname;
	}



	public void setTtname(String ttname) {
		this.ttname = ttname;
	}



	public String getTtmanu() {
		return ttmanu;
	}

	public void setTtmanu(String ttmanu) {
		this.ttmanu = ttmanu;
	}

	public String getTttexl() {
		return tttexl;
	}

	public void setTttexl(String tttexl) {
		this.tttexl = tttexl;
	}



	public int getTttur() {
		return tttur;
	}



	public void setTttur(int tttur) {
		this.tttur = tttur;
	}



	public String getTtlocc() {
		return ttlocc;
	}



	public void setTtlocc(String ttlocc) {
		this.ttlocc = ttlocc;
	}



	public String getTtloct() {
		return ttloct;
	}



	public void setTtloct(String ttloct) {
		this.ttloct = ttloct;
	}



	public BigDecimal getTtbre() {
		return ttbre;
	}



	public void setTtbre(BigDecimal ttbre) {
		this.ttbre = ttbre;
	}



	public BigDecimal getTtlen() {
		return ttlen;
	}



	public void setTtlen(BigDecimal ttlen) {
		this.ttlen = ttlen;
	}



	public String getTturl() {
		return tturl;
	}



	public void setTturl(String tturl) {
		this.tturl = tturl;
	}



	public String getTtman2() {
		return ttman2;
	}



	public void setTtman2(String ttman2) {
		this.ttman2 = ttman2;
	}



	public void setKeys(Map<String, Object> keys) {
		this.keys = keys;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ttavd", ttavd);
		keys.put("ttopd", ttopd);
		//keys.put("ttfbnr", ttfbnr);
		return keys;
	}

}
