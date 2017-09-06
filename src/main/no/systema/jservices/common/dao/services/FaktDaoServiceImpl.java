package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.FaktDao;
import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FaktDto;

public class FaktDaoServiceImpl extends GenericDaoServiceImpl<FaktDao> implements FaktDaoService{

	@Override
	public List<FaktDao> getYear(int year) {
		int qYear = year * 10000; // e.g. 2017 -> 20170000
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fadato" + GREATER_THEN, qYear);
		return findAll(params);
	}

	public List<FaktDto> getYearSumGroupAvdOpdDato(int year) {
		StringBuilder queryString = new StringBuilder("select faavd, faopd, sum(fabeln) sumfabeln, fadato, fakda, faopko ");
		queryString.append(" from fakt ");
		queryString.append(" where fadato > 0 ");
		queryString.append(" and  faavd > 0 ");
		queryString.append(" and  faopd > 0  ");
		queryString.append(" group by faopd, faavd , fadato, fakda, faopko ");
		queryString.append(" order by fadato ");
		return getJdbcTemplate().query(queryString.toString(), new GenericObjectMapper(new FaktDto()));
	}
	
}