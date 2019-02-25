package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FriskkDao;

public interface FriskkDaoService extends GenericDaoService<FriskkDao> {

	List<FriskkDao> findByLike(String fskode);
	List<FriskkDao> findByFsbnr(int fsbnr);
	
}
