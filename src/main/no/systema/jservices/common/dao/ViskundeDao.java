package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ViskundeDao implements IDao {

	private String aktkod;
	private String firma;
	private int kundnr; // key
	private String dkund;
	private String knavn;
	private String adr1;
	private String adr2;
	private int postnr;
	private String adr3;
	private String kpers;
	private String tlf;
	private String sonavn;
	private String valkod;
	private String spraak;
	private String bankg;
	private String postg;
	private int fmot;
	private String betbet;
	private String betmat;
	private String sfakt;
	private int kgrens;
	private String tfaxnr;
	private int syregn;
	private int sykont;
	private String sylikv;
	private String syopdt;
	private BigDecimal syminu = new BigDecimal(0);
	private BigDecimal syutlp = new BigDecimal(0);
	private String syrg;
	private String sypoge;
	private String systat;
	private String syland;
	private String syselg;
	private int syiat1;
	private int syiat2;
	private String sycoty;
	private String syfr01;
	private String syfr02;
	private String syfr03;
	private String syfr04;
	private String syfr05;
	private String syfr06;
	private int sysalu;
	private String syepos;
	private int aknrku;
	private String vatkku;
	private BigDecimal xxbre = new BigDecimal(0);
	private BigDecimal xxlen = new BigDecimal(0);
	private BigDecimal xxinm3 = new BigDecimal(0);
	private BigDecimal xxinlm = new BigDecimal(0);
	private String rnraku;
	private String golk;
	private String kundgr;
	private String pnpbku;
	private String adr21;
	private String eori;
	private String symvjn;
	private String symvsp;
	private int syncda;
	private String syerro;

	private Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kundnr", kundnr);
		keys.put("firma", firma);
		return keys;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getAktkod() {
		return aktkod;
	}

	public void setAktkod(String aktkod) {
		this.aktkod = aktkod;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public int getKundnr() {
		return kundnr;
	}

	public void setKundnr(int kundnr) {
		this.kundnr = kundnr;
	}

	public String getDkund() {
		return dkund;
	}

	public void setDkund(String dkund) {
		this.dkund = dkund;
	}

	public String getKnavn() {
		return knavn;
	}

	public void setKnavn(String knavn) {
		this.knavn = knavn;
	}

	public String getAdr1() {
		return adr1;
	}

	public void setAdr1(String adr1) {
		this.adr1 = adr1;
	}

	public String getAdr2() {
		return adr2;
	}

	public void setAdr2(String adr2) {
		this.adr2 = adr2;
	}

	public int getPostnr() {
		return postnr;
	}

	public void setPostnr(int postnr) {
		this.postnr = postnr;
	}

	public String getAdr3() {
		return adr3;
	}

	public void setAdr3(String adr3) {
		this.adr3 = adr3;
	}

	public String getKpers() {
		return kpers;
	}

	public void setKpers(String kpers) {
		this.kpers = kpers;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getSonavn() {
		return sonavn;
	}

	public void setSonavn(String sonavn) {
		this.sonavn = sonavn;
	}

	public String getValkod() {
		return valkod;
	}

	public void setValkod(String valkod) {
		this.valkod = valkod;
	}

	public String getSpraak() {
		return spraak;
	}

	public void setSpraak(String spraak) {
		this.spraak = spraak;
	}

	public String getBankg() {
		return bankg;
	}

	public void setBankg(String bankg) {
		this.bankg = bankg;
	}

	public String getPostg() {
		return postg;
	}

	public void setPostg(String postg) {
		this.postg = postg;
	}

	public int getFmot() {
		return fmot;
	}

	public void setFmot(int fmot) {
		this.fmot = fmot;
	}

	public String getBetbet() {
		return betbet;
	}

	public void setBetbet(String betbet) {
		this.betbet = betbet;
	}

	public String getBetmat() {
		return betmat;
	}

	public void setBetmat(String betmat) {
		this.betmat = betmat;
	}

	public String getSfakt() {
		return sfakt;
	}

	public void setSfakt(String sfakt) {
		this.sfakt = sfakt;
	}

	public int getKgrens() {
		return kgrens;
	}

	public void setKgrens(int kgrens) {
		this.kgrens = kgrens;
	}

	public String getTfaxnr() {
		return tfaxnr;
	}

	public void setTfaxnr(String tfaxnr) {
		this.tfaxnr = tfaxnr;
	}

	public int getSyregn() {
		return syregn;
	}

	public void setSyregn(int syregn) {
		this.syregn = syregn;
	}

	public int getSykont() {
		return sykont;
	}

	public void setSykont(int sykont) {
		this.sykont = sykont;
	}

	public String getSylikv() {
		return sylikv;
	}

	public void setSylikv(String sylikv) {
		this.sylikv = sylikv;
	}

	public String getSyopdt() {
		return syopdt;
	}

	public void setSyopdt(String syopdt) {
		this.syopdt = syopdt;
	}

	public BigDecimal getSyminu() {
		return syminu;
	}

	public void setSyminu(BigDecimal syminu) {
		this.syminu = syminu;
	}

	public BigDecimal getSyutlp() {
		return syutlp;
	}

	public void setSyutlp(BigDecimal syutlp) {
		this.syutlp = syutlp;
	}

	public String getSyrg() {
		return syrg;
	}

	public void setSyrg(String syrg) {
		this.syrg = syrg;
	}

	public String getSypoge() {
		return sypoge;
	}

	public void setSypoge(String sypoge) {
		this.sypoge = sypoge;
	}

	public String getSystat() {
		return systat;
	}

	public void setSystat(String systat) {
		this.systat = systat;
	}

	public String getSyland() {
		return syland;
	}

	public void setSyland(String syland) {
		this.syland = syland;
	}

	public String getSyselg() {
		return syselg;
	}

	public void setSyselg(String syselg) {
		this.syselg = syselg;
	}

	public int getSyiat1() {
		return syiat1;
	}

	public void setSyiat1(int syiat1) {
		this.syiat1 = syiat1;
	}

	public int getSyiat2() {
		return syiat2;
	}

	public void setSyiat2(int syiat2) {
		this.syiat2 = syiat2;
	}

	public String getSycoty() {
		return sycoty;
	}

	public void setSycoty(String sycoty) {
		this.sycoty = sycoty;
	}

	public String getSyfr01() {
		return syfr01;
	}

	public void setSyfr01(String syfr01) {
		this.syfr01 = syfr01;
	}

	public String getSyfr02() {
		return syfr02;
	}

	public void setSyfr02(String syfr02) {
		this.syfr02 = syfr02;
	}

	public String getSyfr03() {
		return syfr03;
	}

	public void setSyfr03(String syfr03) {
		this.syfr03 = syfr03;
	}

	public String getSyfr04() {
		return syfr04;
	}

	public void setSyfr04(String syfr04) {
		this.syfr04 = syfr04;
	}

	public String getSyfr05() {
		return syfr05;
	}

	public void setSyfr05(String syfr05) {
		this.syfr05 = syfr05;
	}

	public String getSyfr06() {
		return syfr06;
	}

	public void setSyfr06(String syfr06) {
		this.syfr06 = syfr06;
	}

	public int getSysalu() {
		return sysalu;
	}

	public void setSysalu(int sysalu) {
		this.sysalu = sysalu;
	}

	public String getSyepos() {
		return syepos;
	}

	public void setSyepos(String syepos) {
		this.syepos = syepos;
	}

	public int getAknrku() {
		return aknrku;
	}

	public void setAknrku(int aknrku) {
		this.aknrku = aknrku;
	}

	public String getVatkku() {
		return vatkku;
	}

	public void setVatkku(String vatkku) {
		this.vatkku = vatkku;
	}

	public BigDecimal getXxbre() {
		return xxbre;
	}

	public void setXxbre(BigDecimal xxbre) {
		this.xxbre = xxbre;
	}

	public BigDecimal getXxlen() {
		return xxlen;
	}

	public void setXxlen(BigDecimal xxlen) {
		this.xxlen = xxlen;
	}

	public BigDecimal getXxinm3() {
		return xxinm3;
	}

	public void setXxinm3(BigDecimal xxinm3) {
		this.xxinm3 = xxinm3;
	}

	public BigDecimal getXxinlm() {
		return xxinlm;
	}

	public void setXxinlm(BigDecimal xxinlm) {
		this.xxinlm = xxinlm;
	}

	public String getRnraku() {
		return rnraku;
	}

	public void setRnraku(String rnraku) {
		this.rnraku = rnraku;
	}

	public String getGolk() {
		return golk;
	}

	public void setGolk(String golk) {
		this.golk = golk;
	}

	public String getKundgr() {
		return kundgr;
	}

	public void setKundgr(String kundgr) {
		this.kundgr = kundgr;
	}

	public String getPnpbku() {
		return pnpbku;
	}

	public void setPnpbku(String pnpbku) {
		this.pnpbku = pnpbku;
	}

	public String getAdr21() {
		return adr21;
	}

	public void setAdr21(String adr21) {
		this.adr21 = adr21;
	}

	public String getEori() {
		return eori;
	}

	public void setEori(String eori) {
		this.eori = eori;
	}

	public String getSymvjn() {
		return symvjn;
	}

	public void setSymvjn(String symvjn) {
		this.symvjn = symvjn;
	}

	public String getSymvsp() {
		return symvsp;
	}

	public void setSymvsp(String symvsp) {
		this.symvsp = symvsp;
	}

	public int getSyncda() {
		return syncda;
	}

	public void setSyncda(int syncda) {
		this.syncda = syncda;
	}

	public String getSyerro() {
		return syerro;
	}

	public void setSyerro(String syerro) {
		this.syerro = syerro;
	}

}
