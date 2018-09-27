package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class FriskkDao implements IDao {

	private int fsbnr; //key
	private String fskode; //key
	private String fssok; //key
	private int fsdato;
	
	private Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("fsbnr", fsbnr);
		keys.put("fskode", fskode);
		keys.put("fssok", fssok);
		return keys;
	}

}
