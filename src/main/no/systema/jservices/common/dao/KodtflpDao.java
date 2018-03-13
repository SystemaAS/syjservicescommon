package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Produkter fly
 * 
 * @author Oscar de la Torre
 * @date Mars 12, 2018
 */
public class KodtflpDao implements IDao {

	private String kofmun;
	private String kofmko;
	private String kofmk2;
	private String kofmk3;
	private String kofmk4;
	private String kofmk5;
	private String kofmk6;
	private String kofmk7;
	private String kofmnv;
	private String kofmxx;
	
	private Map<String, Object> keys = new HashMap<String, Object>();

	
	
	public String getKofmun() {
		return kofmun;
	}







	public void setKofmun(String kofmun) {
		this.kofmun = kofmun;
	}







	public String getKofmko() {
		return kofmko;
	}







	public void setKofmko(String kofmko) {
		this.kofmko = kofmko;
	}







	public String getKofmk2() {
		return kofmk2;
	}







	public void setKofmk2(String kofmk2) {
		this.kofmk2 = kofmk2;
	}







	public String getKofmk3() {
		return kofmk3;
	}







	public void setKofmk3(String kofmk3) {
		this.kofmk3 = kofmk3;
	}







	public String getKofmk4() {
		return kofmk4;
	}







	public void setKofmk4(String kofmk4) {
		this.kofmk4 = kofmk4;
	}







	public String getKofmk5() {
		return kofmk5;
	}







	public void setKofmk5(String kofmk5) {
		this.kofmk5 = kofmk5;
	}







	public String getKofmk6() {
		return kofmk6;
	}







	public void setKofmk6(String kofmk6) {
		this.kofmk6 = kofmk6;
	}







	public String getKofmk7() {
		return kofmk7;
	}







	public void setKofmk7(String kofmk7) {
		this.kofmk7 = kofmk7;
	}







	public String getKofmnv() {
		return kofmnv;
	}







	public void setKofmnv(String kofmnv) {
		this.kofmnv = kofmnv;
	}







	public String getKofmxx() {
		return kofmxx;
	}







	public void setKofmxx(String kofmxx) {
		this.kofmxx = kofmxx;
	}







	@Override

	public Map<String, Object> getKeys() {
		keys.put("kofmun", kofmun);
		keys.put("kofmko", kofmko);
		
		return keys;
	}

}
