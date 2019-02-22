package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.FriskkDao;

public class FriskkDaoServiceImpl extends GenericDaoServiceImpl<FriskkDao> implements FriskkDaoService{

	@Override
	public List<FriskkDao> findByLike(String fskode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fskode", WILD_CARD + fskode + WILD_CARD);
		return findAll(params);
	}
	
}
