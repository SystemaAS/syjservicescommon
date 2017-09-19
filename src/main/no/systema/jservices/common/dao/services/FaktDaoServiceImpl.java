package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.FaktDao;
import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FaktDto;
import no.systema.jservices.common.util.DateTimeManager;

public class FaktDaoServiceImpl extends GenericDaoServiceImpl<FaktDao> implements FaktDaoService{

	/*
	  Database   SYSDPEDF 
	 Tabellnavn: 
	TTHEADF  
	TTFAKT     
	TTTURER
	TTKOSBU 
	 */
	DateTimeManager dm = new DateTimeManager();
	
	
	@Override
	public List<FaktDao> getYear(int year) {
		int qYear = year * 10000; // e.g. 2016 -> 20160000
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fadato" + GREATER_THEN, qYear);
		return findAll(params);
	}

	public List<FaktDto> getYearSumGroupAvdOpdDato(int fromYear) {
		String hedtopFromDate = fromYear + "0000"; // e.g. 2016 -> 20160000		
		String hedtopToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder("select t.tupro, t.tubilk, f.faavd, f.faopd, sum(f.fabeln) sumfabeln, h.hedtop, f.fakda, f.faopko, h.trknfa ");
		//queryString.append(" from  fakt f, headf h, turer t ");
		queryString.append(" from  ttfakt f, ttheadf h, ttturer t ");  //==Toten data!!
		queryString.append(" where t.tupro = h.hepro ");
		queryString.append(" and f.faavd  = h.heavd ");
		queryString.append(" and   f.faopd = heopd ");
		queryString.append(" and   h.hedtop >= ").append(hedtopFromDate);
		queryString.append(" and   h.hedtop <= ").append(hedtopToDate);
		queryString.append(" and   f.faavd > 0 ");
		queryString.append(" and   f.faopd > 0  ");
		queryString.append(" and   f.faopko = 'O' ");
		queryString.append(" group by t.tupro, t.tubilk, f.faopd, f.faavd , h.hedtop, f.fakda, f.faopko, h.trknfa ");
		queryString.append(" order by t.tupro ");

		logger.info("Abut to run queryString.toString()="+queryString.toString());
		List<FaktDto> list = null;
		list=  getJdbcTemplate().query(queryString.toString(), new GenericObjectMapper(new FaktDto()));
		logger.info("returning list with size="+list.size());
		
		return list;
		
	}
	
}