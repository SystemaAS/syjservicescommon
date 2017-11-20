package no.systema.jservices.common.dto;

import java.util.Map;

import no.systema.jservices.common.dao.IDao;

public class SingleValueDto implements IDao {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Map<String, Object> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
