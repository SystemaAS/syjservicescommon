package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class ArkextDao implements IDao {

	private String arcfir;
	private String arcext; // key
	private String arcpad;
	private String arcane;
	private String arcpae;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getArcfir() {
		return arcfir;
	}

	public void setArcfir(String arcfir) {
		this.arcfir = arcfir;
	}

	public String getArcext() {
		return arcext;
	}

	public void setArcext(String arcext) {
		this.arcext = arcext;
	}

	public String getArcpad() {
		return arcpad;
	}

	public void setArcpad(String arcpad) {
		this.arcpad = arcpad;
	}

	public String getArcane() {
		return arcane;
	}

	public void setArcane(String arcane) {
		this.arcane = arcane;
	}

	public String getArcpae() {
		return arcpae;
	}

	public void setArcpae(String arcpae) {
		this.arcpae = arcpae;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("arcext", arcext);
		return keys;
	}

}
