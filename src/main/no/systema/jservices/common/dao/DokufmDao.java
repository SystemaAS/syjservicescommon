package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Kontaktinfo för DOKUF
 * 
 * @author Oscar de la Torre
 * @date Jan 15, 2018
 */
public class DokufmDao implements IDao {
	
	private String fmst; // Status (1)
	private String fmri; // Recordid (1)
	private int fmavd; // avd  SONET (4)
	private int fmopd; //opd SONET (7)
	private int fmfbnr; // Fraktbrevsnr SONET (3)
	private int fmlinr; // linjenr SONET (2)
	private int fmmknr; // Kollinr SONET (5)
	private int fmlonr; // Löpnr SONET (2)
	private String fmmrk1; // Merking (35)
	private String fmiter; // Inn term (1)
	private String fmuter; // ut term (1)
	private String fmleve; // levert/prod (1)
	private String fmledi; // ledig (10)
	private int fmvkt; // vikt SONET (9)
	
	private BigDecimal fmvol = new BigDecimal(0); // Volym SONET (7,3)
	private BigDecimal fmlm = new BigDecimal(0); // Lastemeter SONET (4,2)
	private int fmlen; // Lengde SONET (5)
	private int fmbrd; // bredd SONET (5)
	private int fmhoy; // Höjd SONET (5)
	private String fmpaid; // pallid (17)
	private int fmitdt; // dato inn SONET (8)
	private int fmittm; // kl inn SONET (6)
	private String fmitus; // user inn (10)
	private int fmutdt; // dato ut SONET (8)
	private int fmuttm; // kl ut SONET (6)
	private String fmutus; // user ut (10)
	private int fmpodt; // dato pod SONET (8)
	private int fmpotm; // kl pod SONET (6)
	private String fmpous; // user pod (10)
	private String fmcol; // col/hentet (1)
	private int fmcodt; // dato col SONET (8)
	private int fmcotm; // kl col SONET (6)
	private String fmcous; // user col (10)
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	
	

	
	public String getFmst() {
		return fmst;
	}
	public void setFmst(String fmst) {
		this.fmst = fmst;
	}
	public String getFmri() {
		return fmri;
	}
	public void setFmri(String fmri) {
		this.fmri = fmri;
	}
	public int getFmavd() {
		return fmavd;
	}
	public void setFmavd(int fmavd) {
		this.fmavd = fmavd;
	}
	public int getFmopd() {
		return fmopd;
	}
	public void setFmopd(int fmopd) {
		this.fmopd = fmopd;
	}
	public int getFmfbnr() {
		return fmfbnr;
	}
	public void setFmfbnr(int fmfbnr) {
		this.fmfbnr = fmfbnr;
	}
	public int getFmlinr() {
		return fmlinr;
	}
	public void setFmlinr(int fmlinr) {
		this.fmlinr = fmlinr;
	}
	public int getFmmknr() {
		return fmmknr;
	}
	public void setFmmknr(int fmmknr) {
		this.fmmknr = fmmknr;
	}
	public int getFmlonr() {
		return fmlonr;
	}
	public void setFmlonr(int fmlonr) {
		this.fmlonr = fmlonr;
	}
	public String getFmmrk1() {
		return fmmrk1;
	}
	public void setFmmrk1(String fmmrk1) {
		this.fmmrk1 = fmmrk1;
	}
	public String getFmiter() {
		return fmiter;
	}
	public void setFmiter(String fmiter) {
		this.fmiter = fmiter;
	}
	public String getFmuter() {
		return fmuter;
	}
	public void setFmuter(String fmuter) {
		this.fmuter = fmuter;
	}
	public String getFmleve() {
		return fmleve;
	}
	public void setFmleve(String fmleve) {
		this.fmleve = fmleve;
	}
	public String getFmledi() {
		return fmledi;
	}
	public void setFmledi(String fmledi) {
		this.fmledi = fmledi;
	}
	public int getFmvkt() {
		return fmvkt;
	}
	public void setFmvkt(int fmvkt) {
		this.fmvkt = fmvkt;
	}
	public BigDecimal getFmvol() {
		return fmvol;
	}
	public void setFmvol(BigDecimal fmvol) {
		this.fmvol = fmvol;
	}
	public BigDecimal getFmlm() {
		return fmlm;
	}
	public void setFmlm(BigDecimal fmlm) {
		this.fmlm = fmlm;
	}
	public int getFmlen() {
		return fmlen;
	}
	public void setFmlen(int fmlen) {
		this.fmlen = fmlen;
	}
	public int getFmbrd() {
		return fmbrd;
	}
	public void setFmbrd(int fmbrd) {
		this.fmbrd = fmbrd;
	}
	public int getFmhoy() {
		return fmhoy;
	}
	public void setFmhoy(int fmhoy) {
		this.fmhoy = fmhoy;
	}
	public String getFmpaid() {
		return fmpaid;
	}
	public void setFmpaid(String fmpaid) {
		this.fmpaid = fmpaid;
	}
	public int getFmitdt() {
		return fmitdt;
	}
	public void setFmitdt(int fmitdt) {
		this.fmitdt = fmitdt;
	}
	public int getFmittm() {
		return fmittm;
	}
	public void setFmittm(int fmittm) {
		this.fmittm = fmittm;
	}
	public String getFmitus() {
		return fmitus;
	}
	public void setFmitus(String fmitus) {
		this.fmitus = fmitus;
	}
	public int getFmutdt() {
		return fmutdt;
	}
	public void setFmutdt(int fmutdt) {
		this.fmutdt = fmutdt;
	}
	public int getFmuttm() {
		return fmuttm;
	}
	public void setFmuttm(int fmuttm) {
		this.fmuttm = fmuttm;
	}
	public String getFmutus() {
		return fmutus;
	}
	public void setFmutus(String fmutus) {
		this.fmutus = fmutus;
	}
	public int getFmpodt() {
		return fmpodt;
	}
	public void setFmpodt(int fmpodt) {
		this.fmpodt = fmpodt;
	}
	public int getFmpotm() {
		return fmpotm;
	}
	public void setFmpotm(int fmpotm) {
		this.fmpotm = fmpotm;
	}
	public String getFmpous() {
		return fmpous;
	}
	public void setFmpous(String fmpous) {
		this.fmpous = fmpous;
	}
	public String getFmcol() {
		return fmcol;
	}
	public void setFmcol(String fmcol) {
		this.fmcol = fmcol;
	}
	public int getFmcodt() {
		return fmcodt;
	}
	public void setFmcodt(int fmcodt) {
		this.fmcodt = fmcodt;
	}
	public int getFmcotm() {
		return fmcotm;
	}
	public void setFmcotm(int fmcotm) {
		this.fmcotm = fmcotm;
	}
	public String getFmcous() {
		return fmcous;
	}
	public void setFmcous(String fmcous) {
		this.fmcous = fmcous;
	}
	
	
	//alternative
	public void setKeys(int avd, int opd) {
		keys.put("fmavd", avd);
		keys.put("fmopd", opd);
	}
	
	public void setKeys(int avd, int opd, int fbnr, int mknr) {
		keys.put("fmavd", avd);
		keys.put("fmopd", opd);
		keys.put("fmfbnr", fbnr);
		keys.put("fmmknr", mknr);
	}
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("fmavd", fmavd);
		keys.put("fmopd", fmopd);
		keys.put("fmfbnr", fmfbnr);
		return keys;
	}


}
