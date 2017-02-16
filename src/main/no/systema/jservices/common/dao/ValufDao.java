package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class ValufDao implements IDao {

	private String aktkod;
	private String journr;
	private String firma;
	private String valkod; //key
	private String valtek;
	private String valku1;
	private String valku2;
	private String omrfak;
	private String valaar;
	private String valmnd;
	private String valdag;
	private String avrkvl;
	private String agaavl;
	private String agmnvl;
	private String agdavl;
	private String kur1vl;
	private String kur2vl;
	private String euvevl;
	private String andevl;

	Map<String, Object> keys = new HashMap<String, Object>();
	
	public String getAktkod() {
		return aktkod;
	}

	public void setAktkod(String aktkod) {
		this.aktkod = aktkod;
	}

	public String getJournr() {
		return journr;
	}

	public void setJournr(String journr) {
		this.journr = journr;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getValkod() {
		return valkod;
	}

	public void setValkod(String valkod) {
		this.valkod = valkod;
	}

	public String getValtek() {
		return valtek;
	}

	public void setValtek(String valtek) {
		this.valtek = valtek;
	}

	public String getValku1() {
		return valku1;
	}

	public void setValku1(String valku1) {
		this.valku1 = valku1;
	}

	public String getValku2() {
		return valku2;
	}

	public void setValku2(String valku2) {
		this.valku2 = valku2;
	}

	public String getOmrfak() {
		return omrfak;
	}

	public void setOmrfak(String omrfak) {
		this.omrfak = omrfak;
	}

	public String getValaar() {
		return valaar;
	}

	public void setValaar(String valaar) {
		this.valaar = valaar;
	}

	public String getValmnd() {
		return valmnd;
	}

	public void setValmnd(String valmnd) {
		this.valmnd = valmnd;
	}

	public String getValdag() {
		return valdag;
	}

	public void setValdag(String valdag) {
		this.valdag = valdag;
	}

	public String getAvrkvl() {
		return avrkvl;
	}

	public void setAvrkvl(String avrkvl) {
		this.avrkvl = avrkvl;
	}

	public String getAgaavl() {
		return agaavl;
	}

	public void setAgaavl(String agaavl) {
		this.agaavl = agaavl;
	}

	public String getAgmnvl() {
		return agmnvl;
	}

	public void setAgmnvl(String agmnvl) {
		this.agmnvl = agmnvl;
	}

	public String getAgdavl() {
		return agdavl;
	}

	public void setAgdavl(String agdavl) {
		this.agdavl = agdavl;
	}

	public String getKur1vl() {
		return kur1vl;
	}

	public void setKur1vl(String kur1vl) {
		this.kur1vl = kur1vl;
	}

	public String getKur2vl() {
		return kur2vl;
	}

	public void setKur2vl(String kur2vl) {
		this.kur2vl = kur2vl;
	}

	public String getEuvevl() {
		return euvevl;
	}

	public void setEuvevl(String euvevl) {
		this.euvevl = euvevl;
	}

	public String getAndevl() {
		return andevl;
	}

	public void setAndevl(String andevl) {
		this.andevl = andevl;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("valkod", valkod); 
		return keys;
	}

}
