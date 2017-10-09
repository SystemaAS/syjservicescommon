package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

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

	public List<FaktDto> getStats(FaktDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String hedtopFromDate = qDto.getRegistreringsdato() + "00"; // e.g. 201601 -> 20160000		
		String hedtopToDate = qDto.getRegistreringsdato() + "31"; // e.g. 201601 -> 20161231
		
		//String hedtopToDate = dm.getCurrentDate_ISO();
		//StringBuilder queryString = new StringBuilder("select t.tupro, t.tubilk, f.faavd, f.faopd, sum(f.fabeln) sumfabeln, h.hedtop, f.fakda, f.faopko, h.trknfa ");
		StringBuilder queryString = new StringBuilder("select t.tupro, t.tubilk, h.heavd avdeling, f.faopd, f.fabeln, h.hedtop registreringsdato, f.fakda, f.faopko, h.trknfa mottaker, f.fask, f.favk ");
		queryString.append(" from  fakt f, headf h, turer t ");
		//queryString.append(" from  ttfakt f, ttheadf h, ttturer t ");  //==Toten data!!
		queryString.append(" where t.tupro = h.hepro ");
		queryString.append(" and f.faavd  = h.heavd ");
		queryString.append(" and   f.faopd = heopd ");
		queryString.append(" and   (:avdeling = 0 OR h.heavd = :avdeling )");
		queryString.append(" and   h.hedtop >= ").append(hedtopFromDate);
		queryString.append(" and   h.hedtop <= ").append(hedtopToDate);
		queryString.append(" and   f.faavd > 0 ");
		queryString.append(" and   f.faopd > 0  ");
		queryString.append(" and   f.faopko = 'O' "); 
		queryString.append(" and   (:signatur IS NULL OR h.hesg = :signatur) ");
		queryString.append(" and   (:mottaker = 0 OR h.trknfa = :mottaker )");
		queryString.append(" and   (:favk IS NULL OR f.favk = :favk )");
		//queryString.append(" group by t.tupro, t.tubilk, f.faopd, f.faavd , h.hedtop, f.fakda, f.faopko, h.trknfa ");
		//queryString.append(" order by t.tupro ");

		logger.info("About to run queryString.toString()="+queryString.toString());
		List<FaktDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FaktDto()));
		logger.info("returning list with size="+list.size());
		
		return list;
		
	}
	
}