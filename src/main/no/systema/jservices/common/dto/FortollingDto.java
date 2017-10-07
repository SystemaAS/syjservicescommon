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
	private int reg_vareposter;
	private int off_vareposter;
	private String type;
	private String edim;
	
	public String getEdim() {
		return edim;
	}

	public void setEdim(String edim) {
		this.edim = edim;
	}

	public int getOff_vareposter() {
		return off_vareposter;
	}

	public void setOff_vareposter(int off_vareposter) {
		this.off_vareposter = off_vareposter;
	}

	public int getReg_vareposter() {
		return reg_vareposter;
	}

	public void setReg_vareposter(int reg_vareposter) {
		this.reg_vareposter = reg_vareposter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public Map<String, Object> getKeys() {
		return null; // Just used as upstreams DTO
	}

}
