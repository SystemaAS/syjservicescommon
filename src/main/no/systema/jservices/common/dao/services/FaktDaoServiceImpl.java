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
		StringBuilder queryString = new StringBuilder("select f.faavd, f.faopd, sum(f.fabeln) sumfabeln, h.hedtop, f.fakda, f.faopko, h.trknfa ");
		queryString.append(" from  fakt f, headf h ");
		queryString.append(" where f.faavd  = h.heavd ");
		queryString.append(" and   f.faopd = heopd ");
		queryString.append(" and   h.hedtop > 0 ");
		queryString.append(" and   f.fadato > 0 ");
		queryString.append(" and   f.faavd > 0 ");
		queryString.append(" and   f.faopd > 0  ");
		queryString.append(" group by f.faopd, f.faavd , h.hedtop, f.fakda, f.faopko, h.trknfa ");
		queryString.append(" order by h.hedtop ");
		return getJdbcTemplate().query(queryString.toString(), new GenericObjectMapper(new FaktDto()));
	}
	
}