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
	@ExludeMapping
	private String fradato;
	@ExludeMapping
	private String tildato;
	private String deklarasjonsdato;
	private String signatur;
	private int mottaker;
	private int avsender;	
	private int reg_vareposter;
	private int off_vareposter;
	private String type;
	private String edim;
	private String inputtype;
	@ExludeMapping
	private List avdelingList;
	@ExludeMapping
	private List signaturList;
	private String extern_referanse;
	private int antall_dager;
	private String avsender_land;
	private int wai;
	private int waii;
	private int waiii;
	private int waiv;
	private int wav;
	private int wavi;
	private int wavii;
	private int waviii;
	private int waix;
	private int wax;
	private int waxi;
	private int waxii;
	private int waxiii;
	private int waxiv;
	private int waxv;
	private int waxvi;
	private int waxvii;
	private int waxviii;
	private int waxvix;
	private int waxx;
	private int waxxi;
	
	
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

	/**
	 * 
	 * @return format YYYY, where query
	 */
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

	public int getAvsender() {
		return avsender;
	}

	public void setAvsender(int avsender) {
		this.avsender = avsender;
	}

	@Override
	public Map<String, Object> getKeys() {
		return null; // Just used as upstreams DTO
	}

	public String getExtern_referanse() {
		return extern_referanse;
	}

	public void setExtern_referanse(String extern_referanse) {
		this.extern_referanse = extern_referanse;
	}

	public int getAntall_dager() {
		return antall_dager;
	}

	public void setAntall_dager(int antall_dager) {
		this.antall_dager = antall_dager;
	}

	public String getAvsender_land() {
		return avsender_land;
	}

	public void setAvsender_land(String avsender_land) {
		this.avsender_land = avsender_land;
	}

	public String getFradato() {
		return fradato;
	}

	public void setFradato(String fradato) {
		this.fradato = fradato;
	}

	public String getTildato() {
		return tildato;
	}

	public void setTildato(String tildato) {
		this.tildato = tildato;
	}

	public int getWai() {
		return wai;
	}

	public void setWai(int wai) {
		this.wai = wai;
	}

	public int getWaii() {
		return waii;
	}

	public void setWaii(int waii) {
		this.waii = waii;
	}

	public int getWaiii() {
		return waiii;
	}

	public void setWaiii(int waiii) {
		this.waiii = waiii;
	}

	public int getWaiv() {
		return waiv;
	}

	public void setWaiv(int waiv) {
		this.waiv = waiv;
	}

	public int getWav() {
		return wav;
	}

	public void setWav(int wav) {
		this.wav = wav;
	}

	public int getWavi() {
		return wavi;
	}

	public void setWavi(int wavi) {
		this.wavi = wavi;
	}

	public int getWavii() {
		return wavii;
	}

	public void setWavii(int wavii) {
		this.wavii = wavii;
	}

	public int getWaviii() {
		return waviii;
	}

	public void setWaviii(int waviii) {
		this.waviii = waviii;
	}

	public int getWaix() {
		return waix;
	}

	public void setWaix(int waix) {
		this.waix = waix;
	}

	public int getWax() {
		return wax;
	}

	public void setWax(int wax) {
		this.wax = wax;
	}

	public int getWaxi() {
		return waxi;
	}

	public void setWaxi(int waxi) {
		this.waxi = waxi;
	}

	public int getWaxii() {
		return waxii;
	}

	public void setWaxii(int waxii) {
		this.waxii = waxii;
	}

	public int getWaxiii() {
		return waxiii;
	}

	public void setWaxiii(int waxiii) {
		this.waxiii = waxiii;
	}

	public int getWaxiv() {
		return waxiv;
	}

	public void setWaxiv(int waxiv) {
		this.waxiv = waxiv;
	}

	public int getWaxv() {
		return waxv;
	}

	public void setWaxv(int waxv) {
		this.waxv = waxv;
	}

	public int getWaxvi() {
		return waxvi;
	}

	public void setWaxvi(int waxvi) {
		this.waxvi = waxvi;
	}

	public int getWaxvii() {
		return waxvii;
	}

	public void setWaxvii(int waxvii) {
		this.waxvii = waxvii;
	}

	public int getWaxviii() {
		return waxviii;
	}

	public void setWaxviii(int waxviii) {
		this.waxviii = waxviii;
	}

	public int getWaxvix() {
		return waxvix;
	}

	public void setWaxvix(int waxvix) {
		this.waxvix = waxvix;
	}

	public int getWaxx() {
		return waxx;
	}

	public void setWaxx(int waxx) {
		this.waxx = waxx;
	}

	public int getWaxxi() {
		return waxxi;
	}

	public void setWaxxi(int waxxi) {
		this.waxxi = waxxi;
	}
	
}
