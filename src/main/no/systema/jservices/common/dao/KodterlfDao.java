package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodterlfDao implements IDao {

	private String kotmun;
	private String kotmko; //key
	private String kotmnv;
	private int kotmxx;
	private Map<String, Object> keys = new HashMap<String, Object>();

	

	public String getKotmun() {
		return kotmun;
	}



	public void setKotmun(String kotmun) {
		this.kotmun = kotmun;
	}



	public String getKotmko() {
		return kotmko;
	}



	public void setKotmko(String kotmko) {
		this.kotmko = kotmko;
	}



	public String getKotmnv() {
		return kotmnv;
	}



	public void setKotmnv(String kotmnv) {
		this.kotmnv = kotmnv;
	}



	public int getKotmxx() {
		return kotmxx;
	}



	public void setKotmxx(int kotmxx) {
		this.kotmxx = kotmxx;
	}



	@Override
	public Map<String, Object> getKeys() {
		keys.put("kotmko", kotmko);
		return keys;
	}

}
