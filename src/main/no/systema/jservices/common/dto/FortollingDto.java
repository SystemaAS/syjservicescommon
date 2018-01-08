package no.systema.jservices.common.dto;

import java.util.ArrayList;
import java.util.List;
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
	@ExludeMapping
	private String avdelings;
	private int deklarasjonsnr;
	private String registreringsdato;
	private String deklarasjonsdato;
	private String signatur;
	private int mottaker;
	private int reg_vareposter;
	private int off_vareposter;
	private String type;
	private String edim;
//	private String avsnitt;
	private String inputtype;
	private String sadkap01;
	@ExludeMapping
	private List avdelingList;
	@ExludeMapping
	private List signaturList;

	public String getInputtype() {
		return inputtype;
	}

	public void setInputtype(String inputtype) {
		this.inputtype = inputtype;
	}

	public String getDeklarasjonsdato() {
		return deklarasjonsdato;
	}

	public void setDeklarasjonsdato(String deklarasjonsdato) {
		this.deklarasjonsdato = deklarasjonsdato;
	}

	public List getSignaturList() {
		if (signaturList != null) {
			return signaturList;
		} else {
			signaturList = new ArrayList<>();
		}
		return signaturList;
	}

	public void setSignaturList(List signaturList) {
		this.signaturList = signaturList;
	}

	public List getAvdelingList() {
		if (avdelingList != null) {
			return avdelingList;
		} else {
			avdelingList = new ArrayList<>();
		}
		return avdelingList;
	}

	public String getAvdelings() {
		return avdelings;
	}

	public void setAvdelings(String avdelings) {
		this.avdelings = avdelings;
	}

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

	public String getSadkap01() {
		return sadkap01;
	}

	public void setSadkap01(String sadkap01) {
		this.sadkap01 = sadkap01;
	}

}
