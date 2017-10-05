package no.systema.jservices.common.dto;

import java.util.Map;

import no.systema.jservices.common.dao.IDao;

/**
 * * This is the Data Transfer Object between service and UI, primary for report
 * dashboard
 * 
 * @author Fredrik Möller
 * @date Aug 4, 2017
 *
 */
public class FaktDto implements IDao {

	private int avdeling;
	private String registreringsdato;
	@ExludeMapping
	private String signatur;
	private int mottaker;

	private int tupro; // turnr
	private String tubilk; // turnr
	private int faopd; // oppdrag
	private int fabeln; // belopp
	private String fakda; // pengatyp
	private String fask;
	private String favk;

	public int getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(int avdeling) {
		this.avdeling = avdeling;
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

	public int getMottaker() {
		return mottaker;
	}

	public void setMottaker(int mottaker) {
		this.mottaker = mottaker;
	}

	public String getFask() {
		return fask;
	}

	public void setFask(String fask) {
		this.fask = fask;
	}

	public String getFavk() {
		return favk;
	}

	public void setFavk(String favk) {
		this.favk = favk;
	}

	public int getFabeln() {
		return fabeln;
	}

	public void setFabeln(int fabeln) {
		this.fabeln = fabeln;
	}

	public String getTubilk() {
		return tubilk;
	}

	public void setTubilk(String tubilk) {
		this.tubilk = tubilk;
	}

	public int getTupro() {
		return tupro;
	}

	public void setTupro(int tupro) {
		this.tupro = tupro;
	}

	public String getFakda() {
		return fakda;
	}

	public void setFakda(String fakda) {
		this.fakda = fakda;
	}

	public int getFaopd() {
		return faopd;
	}

	public void setFaopd(int faopd) {
		this.faopd = faopd;
	}

	@Override
	public Map<String, Object> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
