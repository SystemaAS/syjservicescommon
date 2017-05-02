package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class Cum3lmDao implements IDao {

	private String m3firm;
	private int m3kund; //key
	private int m3m3;
	private int mllm;

	public String getM3firm() {
		return m3firm;
	}

	public void setM3firm(String m3firm) {
		this.m3firm = m3firm;
	}

	public int getM3kund() {
		return m3kund;
	}

	public void setM3kund(int m3kund) {
		this.m3kund = m3kund;
	}

	public int getM3m3() {
		return m3m3;
	}

	public void setM3m3(int m3m3) {
		this.m3m3 = m3m3;
	}

	public int getMllm() {
		return mllm;
	}

	public void setMllm(int mllm) {
		this.mllm = mllm;
	}

	Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("m3kund", m3kund);
		return keys;
	}

}
