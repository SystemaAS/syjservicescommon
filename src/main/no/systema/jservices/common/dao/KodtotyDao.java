package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodtotyDao implements IDao {

	private String ko1sta;
	private String ko1uni; //key
	private String ko1kod; //key
	private String ko1ntx;
	private String ko1etx;
	
	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKo1sta() {
		return ko1sta;
	}

	public void setKo1sta(String ko1sta) {
		this.ko1sta = ko1sta;
	}

	public String getKo1uni() {
		return ko1uni;
	}

	public void setKo1uni(String ko1uni) {
		this.ko1uni = ko1uni;
	}

	public String getKo1kod() {
		return ko1kod;
	}

	public void setKo1kod(String ko1kod) {
		this.ko1kod = ko1kod;
	}

	public String getKo1ntx() {
		return ko1ntx;
	}

	public void setKo1ntx(String ko1ntx) {
		this.ko1ntx = ko1ntx;
	}

	public String getKo1etx() {
		return ko1etx;
	}

	public void setKo1etx(String ko1etx) {
		this.ko1etx = ko1etx;
	}

	public void setKeys(Map<String, Object> keys) {
		this.keys = keys;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ko1uni", ko1uni); 
		keys.put("ko1kod", ko1kod); 
		return keys;		
	}

}
