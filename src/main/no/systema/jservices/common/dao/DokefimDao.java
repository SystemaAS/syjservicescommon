package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class DokefimDao implements IDao {
	
	private int imavd;      //avdeling                                 1    4     4   4   0 s  
	private int imopd;      //oppdragsnr                               5   11     7   7   0 s  
	private int imlop;      //lopenr                                  12   14     3   3   0 s  
	private String hesdf;      //frakt fra                               15   19     5         a  
	private String hesdt;      //frakt til                               20   24     5         a  
	private String hegn;       //godsnr                                  25   39    15         a  
	private String hehawb;     //bil/hawbnr                              40   48     9         a  
	private String helka;      //landkode                                49   50     2         a  
	private String helkk;      //landkode kjøper                         51   52     2         a  
	private String trsta4;     //produkt fly                             53   53     1         a  
	private String hefr;       //frankatur                               54   56     3         a  
	private String domoms;     //momskode                                57   57     1         a  
	private int hekns;      //kundenr                                 58   65     8   8   0 s  
	
	private Map<String, Object> keys = new HashMap<String, Object>();

	
	public int getImavd() {
		return imavd;
	}
	public void setImavd(int imavd) {
		this.imavd = imavd;
	}
	public int getImopd() {
		return imopd;
	}
	public void setImopd(int imopd) {
		this.imopd = imopd;
	}
	public int getImlop() {
		return imlop;
	}
	public void setImlop(int imlop) {
		this.imlop = imlop;
	}
	public String getHesdf() {
		return hesdf;
	}
	public void setHesdf(String hesdf) {
		this.hesdf = hesdf;
	}
	public String getHesdt() {
		return hesdt;
	}
	public void setHesdt(String hesdt) {
		this.hesdt = hesdt;
	}
	public String getHegn() {
		return hegn;
	}
	public void setHegn(String hegn) {
		this.hegn = hegn;
	}
	public String getHehawb() {
		return hehawb;
	}
	public void setHehawb(String hehawb) {
		this.hehawb = hehawb;
	}
	public String getHelka() {
		return helka;
	}
	public void setHelka(String helka) {
		this.helka = helka;
	}
	public String getHelkk() {
		return helkk;
	}
	public void setHelkk(String helkk) {
		this.helkk = helkk;
	}
	public String getTrsta4() {
		return trsta4;
	}
	public void setTrsta4(String trsta4) {
		this.trsta4 = trsta4;
	}
	public String getHefr() {
		return hefr;
	}
	public void setHefr(String hefr) {
		this.hefr = hefr;
	}
	public String getDomoms() {
		return domoms;
	}
	public void setDomoms(String domoms) {
		this.domoms = domoms;
	}
	public int getHekns() {
		return hekns;
	}
	public void setHekns(int hekns) {
		this.hekns = hekns;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("imavd", imavd);
		keys.put("imopd", imopd);
		keys.put("imlop", imlop);
		return keys;
	}

	
}
