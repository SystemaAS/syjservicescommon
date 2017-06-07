package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class Svtx10fDao implements IDao {

	private String svtx10_01; // goodsNomenclatureCod    //key
	private String svtx10_31; // description   
	private String svtx10_05; // productLineSuffix   
	private String svtx10_07; // statisticalIndicator  
	private String svtx10_02; //  dateEnd    
	private String svtx10_03; // dateStart  
	private String svtx10_12; // quantityIndents
	private String svtx10_43; // footnoteId
	private String svtx10_44; // footnoteType
	private String svtx10_53a; // goodsNomenclatureGr1
	private String svtx10_54a; // goodsNomenclatureGr1
	private String svtx10_53b; // goodsNomenclatureGr2

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getSvtx10_01() {
		return svtx10_01;
	}

	public void setSvtx10_01(String svtx10_01) {
		this.svtx10_01 = svtx10_01;
	}

	public String getSvtx10_31() {
		return svtx10_31;
	}

	public void setSvtx10_31(String svtx10_31) {
		this.svtx10_31 = svtx10_31;
	}

	public String getSvtx10_05() {
		return svtx10_05;
	}

	public void setSvtx10_05(String svtx10_05) {
		this.svtx10_05 = svtx10_05;
	}

	public String getSvtx10_07() {
		return svtx10_07;
	}

	public void setSvtx10_07(String svtx10_07) {
		this.svtx10_07 = svtx10_07;
	}

	public String getSvtx10_02() {
		return svtx10_02;
	}

	public void setSvtx10_02(String svtx10_02) {
		this.svtx10_02 = svtx10_02;
	}

	public String getSvtx10_03() {
		return svtx10_03;
	}

	public void setSvtx10_03(String svtx10_03) {
		this.svtx10_03 = svtx10_03;
	}

	public String getSvtx10_12() {
		return svtx10_12;
	}

	public void setSvtx10_12(String svtx10_12) {
		this.svtx10_12 = svtx10_12;
	}

	public String getSvtx10_43() {
		return svtx10_43;
	}

	public void setSvtx10_43(String svtx10_43) {
		this.svtx10_43 = svtx10_43;
	}

	public String getSvtx10_44() {
		return svtx10_44;
	}

	public void setSvtx10_44(String svtx10_44) {
		this.svtx10_44 = svtx10_44;
	}

	public String getSvtx10_53a() {
		return svtx10_53a;
	}

	public void setSvtx10_53a(String svtx10_53a) {
		this.svtx10_53a = svtx10_53a;
	}

	public String getSvtx10_54a() {
		return svtx10_54a;
	}

	public void setSvtx10_54a(String svtx10_54a) {
		this.svtx10_54a = svtx10_54a;
	}

	public String getSvtx10_53b() {
		return svtx10_53b;
	}

	public void setSvtx10_53b(String svtx10_53b) {
		this.svtx10_53b = svtx10_53b;
	}

	@Override
	public Map<String, Object> getKeys() {
//		keys.put("svtx10_01", svtx10_01);
//		return keys;
		throw new UnsupportedOperationException("No keys identified and defined in dao, hence reduced GenericDao-functionality for Svtx10fDao!");
	}

}
