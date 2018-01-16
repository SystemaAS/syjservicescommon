package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Kontaktinfo för DOKUF
 * 
 * @author Oscar de la Torre
 * @date Jan 15, 2018
 */
public class DokufeDao implements IDao {
	
	private int fe_dfavd; // Avdeling   SONET (4)
	private int fe_dfopd; // Oppdragsnummer   SONET (7)
	private int fe_dffbnr; // Fraktbrevnummer   SONET (3)
	private String fe_n3035; // Party (3)
	private String fe_c3413; // Kontakt id (17)
	private String fe_c3412; // Kontakt navn (35)
	private String fe_c3148A; // Telefon (60)
	private String fe_c3148B; // Mobil (60)
	private String fe_c3148C; // Fax (60)
	private String fe_c3148D; // Sms (60)
	private String fe_c3148E; // Email (60)
	private String fe_c3139; // Kontaktkode (3)
	private Map<String, Object> keys = new HashMap<String, Object>();
	

	public int getFe_dfavd() {
		return fe_dfavd;
	}



	public void setFe_dfavd(int fe_dfavd) {
		this.fe_dfavd = fe_dfavd;
	}



	public int getFe_dfopd() {
		return fe_dfopd;
	}



	public void setFe_dfopd(int fe_dfopd) {
		this.fe_dfopd = fe_dfopd;
	}



	public int getFe_dffbnr() {
		return fe_dffbnr;
	}



	public void setFe_dffbnr(int fe_dffbnr) {
		this.fe_dffbnr = fe_dffbnr;
	}



	public String getFe_n3035() {
		return fe_n3035;
	}



	public void setFe_n3035(String fe_n3035) {
		this.fe_n3035 = fe_n3035;
	}



	public String getFe_c3413() {
		return fe_c3413;
	}



	public void setFe_c3413(String fe_c3413) {
		this.fe_c3413 = fe_c3413;
	}



	public String getFe_c3412() {
		return fe_c3412;
	}



	public void setFe_c3412(String fe_c3412) {
		this.fe_c3412 = fe_c3412;
	}



	public String getFe_c3148A() {
		return fe_c3148A;
	}



	public void setFe_c3148A(String fe_c3148A) {
		this.fe_c3148A = fe_c3148A;
	}



	public String getFe_c3148B() {
		return fe_c3148B;
	}



	public void setFe_c3148B(String fe_c3148B) {
		this.fe_c3148B = fe_c3148B;
	}



	public String getFe_c3148C() {
		return fe_c3148C;
	}



	public void setFe_c3148C(String fe_c3148C) {
		this.fe_c3148C = fe_c3148C;
	}



	public String getFe_c3148D() {
		return fe_c3148D;
	}



	public void setFe_c3148D(String fe_c3148D) {
		this.fe_c3148D = fe_c3148D;
	}



	public String getFe_c3148E() {
		return fe_c3148E;
	}



	public void setFe_c3148E(String fe_c3148E) {
		this.fe_c3148E = fe_c3148E;
	}



	public String getFe_c3139() {
		return fe_c3139;
	}



	public void setFe_c3139(String fe_c3139) {
		this.fe_c3139 = fe_c3139;
	}



	@Override
	public Map<String, Object> getKeys() {
		keys.put("fe_dfavd", fe_dfavd);
		keys.put("fe_dfopd", fe_dfopd);
		keys.put("fe_dffbnr", fe_dffbnr);
		keys.put("fe_n3035", fe_n3035);
		
		return keys;
	}
	//alternative 
	public void setKeys(int avd, int opd, int fbnr) {
		keys.put("fe_dfavd", fe_dfavd);
		keys.put("fe_dfopd", fe_dfopd);
		keys.put("fe_dffbnr", fe_dffbnr);		
	}
	//alternative
	public void setKeys(int avd, int opd) {
		keys.put("fe_dfavd", fe_dfavd);
		keys.put("fe_dfopd", fe_dfopd);
	}

}
