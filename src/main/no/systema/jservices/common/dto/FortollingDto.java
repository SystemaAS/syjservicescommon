package no.systema.jservices.common.dto;

import java.util.Map;

import no.systema.jservices.common.dao.IDao;

/**
 * This class is primary used as serving reports with data
 * 
 * @author Fredrik Möller
 * @date Sept, 27 2017
 *
 */
public class FortollingDto implements IDao {

	private int avdeling;
	private int deklarasjonsnr;
	private String registreringsdato;
	private String signatur;
	private int mottaker;
	private int totaltoll;
	private int totalavg;
	private int vareposter;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotaltoll() {
		return totaltoll;
	}

	public void setTotaltoll(int totaltoll) {
		this.totaltoll = totaltoll;
	}

	public int getTotalavg() {
		return totalavg;
	}

	public void setTotalavg(int totalavg) {
		this.totalavg = totalavg;
	}

	public int getMottaker() {
		return mottaker;
	}

	public void setMottaker(int mottaker) {
		this.mottaker = mottaker;
	}

	public int getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(int avdeling) {
		this.avdeling = avdeling;
	}

	public int getDeklarasjonsnr() {
		return deklarasjonsnr;
	}

	public void setDeklarasjonsnr(int deklarasjonsnr) {
		this.deklarasjonsnr = deklarasjonsnr;
	}

	public String getRegistreringsdato() {
		return registreringsdato;
	}

	public void setRegistreringsdato(String registreringsdato) {
		this.registreringsdato = registreringsdato;
	}

	public String getSignatur() {
		return signatur;
	}

	public void setSignatur(String signatur) {
		this.signatur = signatur;
	}

	public int getVareposter() {
		return vareposter;
	}

	public void setVareposter(int vareposter) {
		this.vareposter = vareposter;
	}

	@Override
	public Map<String, Object> getKeys() {
		return null; // Just used as upstreams DTO
	}

}
