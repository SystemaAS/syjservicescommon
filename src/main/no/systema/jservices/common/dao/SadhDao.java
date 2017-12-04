package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Subset of Sadh (fortolling import)
 * 
 * @author Fredrik Möller
 * @date 4 dec, 2017
 */
public class SadhDao implements IDao {

	private String sist; // Status
	private int siavd; // AVDELING
	private int sitdn; // Tolldeklarasjonsnr
	private String sisg; // Signatur
	private int sidt; // Registreringsdato
	private String siur; // Oppr.kode 
	private String sidty; // Deklarasjonstype
	private int sidp; // Dekl.prosedyre    
	private int sikns; // Kundenr Selger 
	private String sinas; // Navn Selger    
	private int sintk; // Antall kolli    
	private String sikddk; // Dagsoppgjør/Kontant 
	private int sivkb; // Bruttovekt 
	private BigDecimal sibel1 = new BigDecimal(0); // Beløp tollb.frakt 
	private String sival2; // Val.kode A. kost 
	private BigDecimal sibel2 = new BigDecimal(0); // Beløp A. kost  
	private String silv; // Leveringsvilkår kod 
	private BigDecimal sibel3 = new BigDecimal(0); // Beløp Faktsum 
	private int sitrt; // Transporttype 
	private int sitrm; // Transportmåte     
	private String sidtg; // Dekl. godkj.dato
	private String sikdtr; // Transportavgift kode
	private int siopd; // Oppdragsnummer  
	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getSist() {
		return sist;
	}

	public void setSist(String sist) {
		this.sist = sist;
	}

	public int getSiavd() {
		return siavd;
	}

	public void setSiavd(int siavd) {
		this.siavd = siavd;
	}

	public int getSitdn() {
		return sitdn;
	}

	public void setSitdn(int sitdn) {
		this.sitdn = sitdn;
	}

	public String getSisg() {
		return sisg;
	}

	public void setSisg(String sisg) {
		this.sisg = sisg;
	}

	public int getSidt() {
		return sidt;
	}

	public void setSidt(int sidt) {
		this.sidt = sidt;
	}

	public String getSiur() {
		return siur;
	}

	public void setSiur(String siur) {
		this.siur = siur;
	}

	public String getSidty() {
		return sidty;
	}

	public void setSidty(String sidty) {
		this.sidty = sidty;
	}

	public int getSidp() {
		return sidp;
	}

	public void setSidp(int sidp) {
		this.sidp = sidp;
	}

	public int getSikns() {
		return sikns;
	}

	public void setSikns(int sikns) {
		this.sikns = sikns;
	}

	public String getSinas() {
		return sinas;
	}

	public void setSinas(String sinas) {
		this.sinas = sinas;
	}

	public int getSintk() {
		return sintk;
	}

	public void setSintk(int sintk) {
		this.sintk = sintk;
	}

	public String getSikddk() {
		return sikddk;
	}

	public void setSikddk(String sikddk) {
		this.sikddk = sikddk;
	}

	public int getSivkb() {
		return sivkb;
	}

	public void setSivkb(int sivkb) {
		this.sivkb = sivkb;
	}

	public BigDecimal getSibel1() {
		return sibel1;
	}

	public void setSibel1(BigDecimal sibel1) {
		this.sibel1 = sibel1;
	}

	public String getSival2() {
		return sival2;
	}

	public void setSival2(String sival2) {
		this.sival2 = sival2;
	}

	public BigDecimal getSibel2() {
		return sibel2;
	}

	public void setSibel2(BigDecimal sibel2) {
		this.sibel2 = sibel2;
	}

	public String getSilv() {
		return silv;
	}

	public void setSilv(String silv) {
		this.silv = silv;
	}

	public BigDecimal getSibel3() {
		return sibel3;
	}

	public void setSibel3(BigDecimal sibel3) {
		this.sibel3 = sibel3;
	}

	public int getSitrt() {
		return sitrt;
	}

	public void setSitrt(int sitrt) {
		this.sitrt = sitrt;
	}

	public int getSitrm() {
		return sitrm;
	}

	public void setSitrm(int sitrm) {
		this.sitrm = sitrm;
	}

	public String getSidtg() {
		return sidtg;
	}

	public void setSidtg(String sidtg) {
		this.sidtg = sidtg;
	}

	public String getSikdtr() {
		return sikdtr;
	}

	public void setSikdtr(String sikdtr) {
		this.sikdtr = sikdtr;
	}

	public int getSiopd() {
		return siopd;
	}

	public void setSiopd(int siopd) {
		this.siopd = siopd;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("siavd", siavd);
		keys.put("sitdn", sitdn);
		return keys;
	}

}
