package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class SadkaaDao implements IDao {

	private String sadkaa02; //id
	private String sadkaa03; //desc

	public String getSadkaa02() {
		return sadkaa02;
	}

	public void setSadkaa02(String sadkaa02) {
		this.sadkaa02 = sadkaa02;
	}

	public String getSadkaa03() {
		return sadkaa03;
	}

	public void setSadkaa03(String sadkaa03) {
		this.sadkaa03 = sadkaa03;
	}

	private Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		keys.put("sadkaa02", sadkaa02);
		return keys;
	}

}
