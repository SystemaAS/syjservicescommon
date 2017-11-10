package no.systema.jservices.common.dto;

import java.math.BigDecimal;
import java.util.Map;

import no.systema.jservices.common.dao.IDao;

/**
 * * This is the Data Transfer Object between service and UI delivering data
 * into searchlist, due to big HeadfDao appr. 200 attributes.
 * 
 * @author Fredrik Möller
 * @date Aug 7, 2017
 *
 */
public class HeadfDto implements IDao {
	private int heavd;
	private int heopd;
	private int hedtop;
	private int hedtr;
	private String henas;
	private String henak;
	private int hent;
	private int hevkt;
	private BigDecimal hem3;
	private String helks;
	private String hepns;
	private String helkk;
	private String hepnk;
	private String hesg;
	private String heot;
	private String heur;
	private int hepro;
	private String hegn;
	private String hest;
	private String hepk3;
	private String hepk4;
	
	
	/* days to view in list */
	@ExludeMapping
	private int dftdg;

	public String getHest() {
		return hest;
	}

	public void setHest(String hest) {
		this.hest = hest;
	}

	public String getHeur() {
		return heur;
	}

	public void setHeur(String heur) {
		this.heur = heur;
	}

	public int getHepro() {
		return hepro;
	}

	public void setHepro(int hepro) {
		this.hepro = hepro;
	}

	public String getHegn() {
		return hegn;
	}

	public void setHegn(String hegn) {
		this.hegn = hegn;
	}

	public String getHeot() {
		return heot;
	}

	public void setHeot(String heot) {
		this.heot = heot;
	}

	public int getHedtr() {
		return hedtr;
	}

	public void setHedtr(int hedtr) {
		this.hedtr = hedtr;
	}

	public int getDftdg() {
		return dftdg;
	}

	public void setDftdg(int dftdg) {
		this.dftdg = dftdg;
	}

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

	public String getHepk3() {
		return hepk3;
	}

	public void setHepk3(String hepk3) {
		this.hepk3 = hepk3;
	}
	public String getHepk4() {
		return hepk4;
	}
	public void setHepk4(String hepk4) {
		this.hepk4 = hepk4;
	}
	@Override
	public Map<String, Object> getKeys() {
		// Only to be used in IDao context.
		return null;
	}

}
