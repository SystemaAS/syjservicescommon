package no.systema.jservices.common.dto;

import java.util.ArrayList;
import java.util.List;
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
public class FaktDWDto implements IDao {

	private int avdeling;
	@ExludeMapping
	private String avdelings; 
	private String registreringsdato;
	private String bilkod;
	private int sumlin;
	private int belop;
	private String omskost;
	private String intext;
	private String varek;

	/*
	@ExludeMapping
	private String favkexcl;
	@ExludeMapping
	private List avdelingList;
	@ExludeMapping
	private List signaturList;
	@ExludeMapping
	private List favkList;
*/

	
	
	public String getBilkod() {
		return bilkod;
	}

	public int getBelop() {
		return belop;
	}

	public void setBelop(int belop) {
		this.belop = belop;
	}

	public void setBilkod(String bilkod) {
		this.bilkod = bilkod;
	}

	public int getSumlin() {
		return sumlin;
	}

	public void setSumlin(int sumlin) {
		this.sumlin = sumlin;
	}

	public String getOmskost() {
		return omskost;
	}

	public void setOmskost(String omskost) {
		this.omskost = omskost;
	}

	public String getIntext() {
		return intext;
	}

	public void setIntext(String intext) {
		this.intext = intext;
	}

	public String getVarek() {
		return varek;
	}

	public void setVarek(String varek) {
		this.varek = varek;
	}
/*
	public String getFavkexcl() {
		return favkexcl;
	}

	public void setFavkexcl(String favkexcl) {
		this.favkexcl = favkexcl;
	}

	public List getFavkList() {
		if (favkList != null) {
			return favkList;
		} else {
			favkList = new ArrayList<>();
		}
		return favkList;
	}

	public void setFavkList(List inclFavkList) {
		this.favkList = inclFavkList;
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
*/
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

	@Override
	public Map<String, Object> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
