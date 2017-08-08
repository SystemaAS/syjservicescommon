package no.systema.jservices.common.dto;

import java.math.BigDecimal;
import java.util.Map;

import no.systema.jservices.common.dao.IDao;

/**
 * * This is the Data Transfer Object between service and UI delivering data into searchlist, due to big HeadfDao appr. 200 attributes.
 * 
 * @author Fredrik Möller
 * @date Aug 7, 2017
 *
 */
public class HeadfDto implements IDao {

	/* Avdeling */
	private int heavd; 
	/* Ordernr */
	private int heopd;
	/*  Oppdragsdato  */
	private int hedtop;
	/* Avsender */
	private String henas;
	/* Mottaker */
	private String henak;
	/* Antall */
	private int hent;
	/* Vekt */
	private int hevkt;
	/* M3 */
	private BigDecimal hem3;
	/* Landkode selger */
	private String helks;
	/* Postnr selger */
	private String hepns;
	/* Landkode kjøper */
	private String helkk;
	/* Postnr kjøper */
	private String hepnk;
	/* Signatur*/
	private String hesg; 

	public String getHesg() {
		return hesg;
	}

	public void setHesg(String hesg) {
		this.hesg = hesg;
	}

	public int getHeopd() {
		return heopd;
	}

	public void setHeopd(int heopd) {
		this.heopd = heopd;
	}

	public int getHedtop() {
		return hedtop;
	}

	public void setHedtop(int hedtop) {
		this.hedtop = hedtop;
	}

	public String getHenas() {
		return henas;
	}

	public void setHenas(String henas) {
		this.henas = henas;
	}

	public String getHenak() {
		return henak;
	}

	public void setHenak(String henak) {
		this.henak = henak;
	}

	public int getHent() {
		return hent;
	}

	public void setHent(int hent) {
		this.hent = hent;
	}

	public int getHevkt() {
		return hevkt;
	}

	public void setHevkt(int hevkt) {
		this.hevkt = hevkt;
	}

	public BigDecimal getHem3() {
		return hem3;
	}

	public void setHem3(BigDecimal hem3) {
		this.hem3 = hem3;
	}

	public String getHelks() {
		return helks;
	}

	public void setHelks(String helks) {
		this.helks = helks;
	}

	public String getHepns() {
		return hepns;
	}

	public void setHepns(String hepns) {
		this.hepns = hepns;
	}

	public String getHelkk() {
		return helkk;
	}

	public void setHelkk(String helkk) {
		this.helkk = helkk;
	}

	public String getHepnk() {
		return hepnk;
	}

	public void setHepnk(String hepnk) {
		this.hepnk = hepnk;
	}

	public int getHeavd() {
		return heavd;
	}

	public void setHeavd(int heavd) {
		this.heavd = heavd;
	}

	@Override
	public Map<String, Object> getKeys() {
		//Only to be used in IDao context.
		return null;
	}

}
