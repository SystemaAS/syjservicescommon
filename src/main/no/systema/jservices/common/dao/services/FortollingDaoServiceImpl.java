package no.systema.jservices.common.dao.services;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FortollingDto;

public class FortollingDaoServiceImpl extends GenericDaoServiceImpl<FortollingDto> implements FortollingDaoService{

	@Override
	public List<FortollingDto> getStats(FortollingDto qDto) {  
		return getImportStatsNew(qDto);
	
	}

	private List<FortollingDto> getImportStatsNew(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtFromDate = qDto.getRegistreringsdato() + "0000";
		String sidtToDate =  qDto.getRegistreringsdato() + "1231";
		StringBuilder queryString = new StringBuilder();
		queryString.append( "SELECT  siavd avdeling,  sitdn deklarasjonsnr, sidt registreringsdato, sisg signatur,  siknk mottaker, sikns avsender, wvpreg reg_vareposter,  wvpoff off_vareposter, ");
		queryString.append("  		wie type,  wmerk edim,  sidtg deklarasjonsdato, wsvexr03 inputtype, wextref extern_referanse, wantdag antall_dager, silka avsender_land ");
		queryString.append(" FROM SADHAN   ");	
		queryString.append(" WHERE  (:registreringsdato IS NULL OR sidt >="+sidtFromDate+")");
		queryString.append(" AND    (:registreringsdato IS NULL OR sidt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append("    AND  (siavd IN ( :avdelingList ) )");
		}		
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append("    AND  (sisg IN ( :signaturList )) ");
		}
		
		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		
		logger.info("getImportStats list.size="+list.size());
		return list;
	}	
	
	
}