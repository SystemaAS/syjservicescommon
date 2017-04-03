package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy dao-fields from TVINN's TariDao, cant get all field to work yet...
 * 
 * @author fredrikmoller
 *
 */

public class TariDao implements IDao {

	private int tatanr; // key
	private String tatar;
	private String tadato = "0";
	private String tadts = "0";
	private String tadtr = "0";
	private String taordk;
	private String taordb = "0";
	private String taeftk;
	private String taeftb = "0";
	private String taefk;
	private String taefb = "0";
	private String tatxt;
	private String takapn;
	private String taalfa;
	private String taalfaOrig;
	private String tastk;
	private String takap;
	private String takapa;
	private String taenhe;
	private String tarest;
	private String takdae;
	private String takdsae;
	// countries
	private String taeosb = "0";
	private String taeosk;
	private String tatsjb = "0";
	private String tatsjk;
	private String tatyrb = "0";
	private String tatyrk;
	private String taisrb = "0";
	private String taisrk;
	private String taellb = "0";
	private String taellk;
	private String tabulb;
	private String tabulk;
	private String tapolb;
	private String tapolk;
	private String taromb;
	private String taromk;
	private String tan05b;
	private String tan05k;
	// Albania
	private String tan06b;
	private String tan06k;
	// Ukraina
	private String tan07b;
	private String tan07k;
	// Jordan
	private String taungb;
	private String taungk;
	// Tunisia
	private String taslob;
	private String taslok;
	// Min uland
	private String tamulb;
	private String tamulk;
	private String taoulb;
	private String taoulk;
	private String tagrlb;
	private String tagrlk;
	private String taferb;
	private String taferk;
	private String taistb;
	private String taistk;
	private String tamarb;
	private String tamark;
	// Peru
	private String tan08b;
	private String tan08k;
	// Montenegro
	private String tan09b;
	private String tan09k;
	// Hong Kong
	private String tan10b;
	private String tan10k;
	// Mexico
	private String tamexb;
	private String tamexk;
	// VB & GAZA
	private String tavgab;
	private String tavgak;
	// Libanon
	private String tan01b;
	private String tan01k;
	// SACU
	private String tan02b;
	private String tan02k;
	// Egypt
	private String tan03b;
	private String tan03k;
	// Canada
	private String tan04b;
	private String tan04k;
	// BW, NA, SZ
	private String tan11b;
	private String tan11k;
	// Lavere MIL
	private String tan12b;
	private String tan12k;
	private String tan13b;
	private String tan13k;
	private String tan14b;
	private String tan14k;
	private String tan15b;
	private String tan15k;

	Map<String, Object> keys = new HashMap<String, Object>();

	public int getTatanr() {
		return tatanr;
	}

	public void setTatanr(int tatanr) {
		this.tatanr = tatanr;
	}

	public String getTatar() {
		return tatar;
	}

	public void setTatar(String tatar) {
		this.tatar = tatar;
	}

	public String getTadato() {
		return tadato;
	}

	public void setTadato(String tadato) {
		this.tadato = tadato;
	}

	public String getTadts() {
		return tadts;
	}

	public void setTadts(String tadts) {
		this.tadts = tadts;
	}

	public String getTadtr() {
		return tadtr;
	}

	public void setTadtr(String tadtr) {
		this.tadtr = tadtr;
	}

	public String getTaordk() {
		return taordk;
	}

	public void setTaordk(String taordk) {
		this.taordk = taordk;
	}

	public String getTaordb() {
		return taordb;
	}

	public void setTaordb(String taordb) {
		this.taordb = taordb;
	}

	public String getTaeftk() {
		return taeftk;
	}

	public void setTaeftk(String taeftk) {
		this.taeftk = taeftk;
	}

	public String getTaeftb() {
		return taeftb;
	}

	public void setTaeftb(String taeftb) {
		this.taeftb = taeftb;
	}

	public String getTaefk() {
		return taefk;
	}

	public void setTaefk(String taefk) {
		this.taefk = taefk;
	}

	public String getTaefb() {
		return taefb;
	}

	public void setTaefb(String taefb) {
		this.taefb = taefb;
	}

	public String getTatxt() {
		return tatxt;
	}

	public void setTatxt(String tatxt) {
		this.tatxt = tatxt;
	}

	public String getTakapn() {
		return takapn;
	}

	public void setTakapn(String takapn) {
		this.takapn = takapn;
	}

	public String getTaalfa() {
		return taalfa;
	}

	public void setTaalfa(String taalfa) {
		this.taalfa = taalfa;
	}

	public String getTaalfaOrig() {
		return taalfaOrig;
	}

	public void setTaalfaOrig(String taalfaOrig) {
		this.taalfaOrig = taalfaOrig;
	}

	public String getTastk() {
		return tastk;
	}

	public void setTastk(String tastk) {
		this.tastk = tastk;
	}

	public String getTakap() {
		return takap;
	}

	public void setTakap(String takap) {
		this.takap = takap;
	}

	public String getTakapa() {
		return takapa;
	}

	public void setTakapa(String takapa) {
		this.takapa = takapa;
	}

	public String getTaenhe() {
		return taenhe;
	}

	public void setTaenhe(String taenhe) {
		this.taenhe = taenhe;
	}

	public String getTarest() {
		return tarest;
	}

	public void setTarest(String tarest) {
		this.tarest = tarest;
	}

	public String getTakdae() {
		return takdae;
	}

	public void setTakdae(String takdae) {
		this.takdae = takdae;
	}

	public String getTakdsae() {
		return takdsae;
	}

	public void setTakdsae(String takdsae) {
		this.takdsae = takdsae;
	}

	public String getTaeosb() {
		return taeosb;
	}

	public void setTaeosb(String taeosb) {
		this.taeosb = taeosb;
	}

	public String getTaeosk() {
		return taeosk;
	}

	public void setTaeosk(String taeosk) {
		this.taeosk = taeosk;
	}

	public String getTatsjb() {
		return tatsjb;
	}

	public void setTatsjb(String tatsjb) {
		this.tatsjb = tatsjb;
	}

	public String getTatsjk() {
		return tatsjk;
	}

	public void setTatsjk(String tatsjk) {
		this.tatsjk = tatsjk;
	}

	public String getTatyrb() {
		return tatyrb;
	}

	public void setTatyrb(String tatyrb) {
		this.tatyrb = tatyrb;
	}

	public String getTatyrk() {
		return tatyrk;
	}

	public void setTatyrk(String tatyrk) {
		this.tatyrk = tatyrk;
	}

	public String getTaisrb() {
		return taisrb;
	}

	public void setTaisrb(String taisrb) {
		this.taisrb = taisrb;
	}

	public String getTaisrk() {
		return taisrk;
	}

	public void setTaisrk(String taisrk) {
		this.taisrk = taisrk;
	}

	public String getTaellb() {
		return taellb;
	}

	public void setTaellb(String taellb) {
		this.taellb = taellb;
	}

	public String getTaellk() {
		return taellk;
	}

	public void setTaellk(String taellk) {
		this.taellk = taellk;
	}

	public String getTabulb() {
		return tabulb;
	}

	public void setTabulb(String tabulb) {
		this.tabulb = tabulb;
	}

	public String getTabulk() {
		return tabulk;
	}

	public void setTabulk(String tabulk) {
		this.tabulk = tabulk;
	}

	public String getTapolb() {
		return tapolb;
	}

	public void setTapolb(String tapolb) {
		this.tapolb = tapolb;
	}

	public String getTapolk() {
		return tapolk;
	}

	public void setTapolk(String tapolk) {
		this.tapolk = tapolk;
	}

	public String getTaromb() {
		return taromb;
	}

	public void setTaromb(String taromb) {
		this.taromb = taromb;
	}

	public String getTaromk() {
		return taromk;
	}

	public void setTaromk(String taromk) {
		this.taromk = taromk;
	}

	public String getTan05b() {
		return tan05b;
	}

	public void setTan05b(String tan05b) {
		this.tan05b = tan05b;
	}

	public String getTan05k() {
		return tan05k;
	}

	public void setTan05k(String tan05k) {
		this.tan05k = tan05k;
	}

	public String getTan06b() {
		return tan06b;
	}

	public void setTan06b(String tan06b) {
		this.tan06b = tan06b;
	}

	public String getTan06k() {
		return tan06k;
	}

	public void setTan06k(String tan06k) {
		this.tan06k = tan06k;
	}

	public String getTan07b() {
		return tan07b;
	}

	public void setTan07b(String tan07b) {
		this.tan07b = tan07b;
	}

	public String getTan07k() {
		return tan07k;
	}

	public void setTan07k(String tan07k) {
		this.tan07k = tan07k;
	}

	public String getTaungb() {
		return taungb;
	}

	public void setTaungb(String taungb) {
		this.taungb = taungb;
	}

	public String getTaungk() {
		return taungk;
	}

	public void setTaungk(String taungk) {
		this.taungk = taungk;
	}

	public String getTaslob() {
		return taslob;
	}

	public void setTaslob(String taslob) {
		this.taslob = taslob;
	}

	public String getTaslok() {
		return taslok;
	}

	public void setTaslok(String taslok) {
		this.taslok = taslok;
	}

	public String getTamulb() {
		return tamulb;
	}

	public void setTamulb(String tamulb) {
		this.tamulb = tamulb;
	}

	public String getTamulk() {
		return tamulk;
	}

	public void setTamulk(String tamulk) {
		this.tamulk = tamulk;
	}

	public String getTaoulb() {
		return taoulb;
	}

	public void setTaoulb(String taoulb) {
		this.taoulb = taoulb;
	}

	public String getTaoulk() {
		return taoulk;
	}

	public void setTaoulk(String taoulk) {
		this.taoulk = taoulk;
	}

	public String getTagrlb() {
		return tagrlb;
	}

	public void setTagrlb(String tagrlb) {
		this.tagrlb = tagrlb;
	}

	public String getTagrlk() {
		return tagrlk;
	}

	public void setTagrlk(String tagrlk) {
		this.tagrlk = tagrlk;
	}

	public String getTaferb() {
		return taferb;
	}

	public void setTaferb(String taferb) {
		this.taferb = taferb;
	}

	public String getTaferk() {
		return taferk;
	}

	public void setTaferk(String taferk) {
		this.taferk = taferk;
	}

	public String getTaistb() {
		return taistb;
	}

	public void setTaistb(String taistb) {
		this.taistb = taistb;
	}

	public String getTaistk() {
		return taistk;
	}

	public void setTaistk(String taistk) {
		this.taistk = taistk;
	}

	public String getTamarb() {
		return tamarb;
	}

	public void setTamarb(String tamarb) {
		this.tamarb = tamarb;
	}

	public String getTamark() {
		return tamark;
	}

	public void setTamark(String tamark) {
		this.tamark = tamark;
	}

	public String getTan08b() {
		return tan08b;
	}

	public void setTan08b(String tan08b) {
		this.tan08b = tan08b;
	}

	public String getTan08k() {
		return tan08k;
	}

	public void setTan08k(String tan08k) {
		this.tan08k = tan08k;
	}

	public String getTan09b() {
		return tan09b;
	}

	public void setTan09b(String tan09b) {
		this.tan09b = tan09b;
	}

	public String getTan09k() {
		return tan09k;
	}

	public void setTan09k(String tan09k) {
		this.tan09k = tan09k;
	}

	public String getTan10b() {
		return tan10b;
	}

	public void setTan10b(String tan10b) {
		this.tan10b = tan10b;
	}

	public String getTan10k() {
		return tan10k;
	}

	public void setTan10k(String tan10k) {
		this.tan10k = tan10k;
	}

	public String getTamexb() {
		return tamexb;
	}

	public void setTamexb(String tamexb) {
		this.tamexb = tamexb;
	}

	public String getTamexk() {
		return tamexk;
	}

	public void setTamexk(String tamexk) {
		this.tamexk = tamexk;
	}

	public String getTavgab() {
		return tavgab;
	}

	public void setTavgab(String tavgab) {
		this.tavgab = tavgab;
	}

	public String getTavgak() {
		return tavgak;
	}

	public void setTavgak(String tavgak) {
		this.tavgak = tavgak;
	}

	public String getTan01b() {
		return tan01b;
	}

	public void setTan01b(String tan01b) {
		this.tan01b = tan01b;
	}

	public String getTan01k() {
		return tan01k;
	}

	public void setTan01k(String tan01k) {
		this.tan01k = tan01k;
	}

	public String getTan02b() {
		return tan02b;
	}

	public void setTan02b(String tan02b) {
		this.tan02b = tan02b;
	}

	public String getTan02k() {
		return tan02k;
	}

	public void setTan02k(String tan02k) {
		this.tan02k = tan02k;
	}

	public String getTan03b() {
		return tan03b;
	}

	public void setTan03b(String tan03b) {
		this.tan03b = tan03b;
	}

	public String getTan03k() {
		return tan03k;
	}

	public void setTan03k(String tan03k) {
		this.tan03k = tan03k;
	}

	public String getTan04b() {
		return tan04b;
	}

	public void setTan04b(String tan04b) {
		this.tan04b = tan04b;
	}

	public String getTan04k() {
		return tan04k;
	}

	public void setTan04k(String tan04k) {
		this.tan04k = tan04k;
	}

	public String getTan11b() {
		return tan11b;
	}

	public void setTan11b(String tan11b) {
		this.tan11b = tan11b;
	}

	public String getTan11k() {
		return tan11k;
	}

	public void setTan11k(String tan11k) {
		this.tan11k = tan11k;
	}

	public String getTan12b() {
		return tan12b;
	}

	public void setTan12b(String tan12b) {
		this.tan12b = tan12b;
	}

	public String getTan12k() {
		return tan12k;
	}

	public void setTan12k(String tan12k) {
		this.tan12k = tan12k;
	}

	public String getTan13b() {
		return tan13b;
	}

	public void setTan13b(String tan13b) {
		this.tan13b = tan13b;
	}

	public String getTan13k() {
		return tan13k;
	}

	public void setTan13k(String tan13k) {
		this.tan13k = tan13k;
	}

	public String getTan14b() {
		return tan14b;
	}

	public void setTan14b(String tan14b) {
		this.tan14b = tan14b;
	}

	public String getTan14k() {
		return tan14k;
	}

	public void setTan14k(String tan14k) {
		this.tan14k = tan14k;
	}

	public String getTan15b() {
		return tan15b;
	}

	public void setTan15b(String tan15b) {
		this.tan15b = tan15b;
	}

	public String getTan15k() {
		return tan15k;
	}

	public void setTan15k(String tan15k) {
		this.tan15k = tan15k;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("tatanr", tatanr);
		return keys;
	}

}
