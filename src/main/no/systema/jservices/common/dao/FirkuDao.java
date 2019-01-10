package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class FirkuDao implements IDao {

	private String fifirm; //	key
	private int fikufn;
	private int fikufr;	
	private int fikune;
	private int fikuti;	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("fifirm", fifirm);
		return keys;
	}

}
