package no.systema.jservices.common.dto;

/**
 * * This is the Data Transfer Object between service and UI for Kunderegister - Vareregister - Import(se) - List
 * 
 * @author Fredrik Möller
 * @date June 20, 2017
 *
 */
public class SviwDto {

	private String sviw_knnr;
	private String sviw_knso;
	private String sviw_vasl;
	private String sviw_ulkd;
	private String sviw_vata;
	private String sviw_brut;
	private String sviw_neto;

	public String getSviw_knnr() {
		return sviw_knnr;
	}

	public void setSviw_knnr(String sviw_knnr) {
		this.sviw_knnr = sviw_knnr;
	}

	public String getSviw_knso() {
		return sviw_knso;
	}

	public void setSviw_knso(String sviw_knso) {
		this.sviw_knso = sviw_knso;
	}

	public String getSviw_vasl() {
		return sviw_vasl;
	}

	public void setSviw_vasl(String sviw_vasl) {
		this.sviw_vasl = sviw_vasl;
	}

	public String getSviw_ulkd() {
		return sviw_ulkd;
	}

	public void setSviw_ulkd(String sviw_ulkd) {
		this.sviw_ulkd = sviw_ulkd;
	}

	public String getSviw_vata() {
		return sviw_vata;
	}

	public void setSviw_vata(String sviw_vata) {
		this.sviw_vata = sviw_vata;
	}

	public String getSviw_brut() {
		return sviw_brut;
	}

	public void setSviw_brut(String sviw_brut) {
		this.sviw_brut = sviw_brut;
	}

	public String getSviw_neto() {
		return sviw_neto;
	}

	public void setSviw_neto(String sviw_neto) {
		this.sviw_neto = sviw_neto;
	}

}
