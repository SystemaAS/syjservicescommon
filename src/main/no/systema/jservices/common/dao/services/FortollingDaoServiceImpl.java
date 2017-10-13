package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FortollingDto;
import no.systema.jservices.common.util.DateTimeManager;

public class FortollingDaoServiceImpl extends GenericDaoServiceImpl<FortollingDto> implements FortollingDaoService{

	DateTimeManager dm = new DateTimeManager();
	
	@Override
	public List<FortollingDto> getStats(FortollingDto qDto) {
		List<FortollingDto> impList = getImportStats(qDto);
		List<FortollingDto> expList = getExportStats(qDto);
		List<FortollingDto> impAndExpList =  new ArrayList<FortollingDto>();
		impAndExpList.addAll(impList);
		impAndExpList.addAll(expList);
		
		return impAndExpList;
	
	}

	private List<FortollingDto> getImportStats(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder(
							"SELECT  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, count(sv.svtdn) reg_vareposter,  max(sv.svln) off_vareposter, 'Import' type,  COALESCE(concat(e.kalle, e.anka), 'OK') edim ");
		queryString.append(" FROM (select shX.siavd avdeling, shX.sitdn deklarasjonsnr, shX.sidt registreringsdato, shX.sisg signatur,  shX.siknk mottaker ");
		queryString.append(" 	   	from SADH shX  ");
		queryString.append("      	where  (:registreringsdato IS NULL OR shX.sidt >= :registreringsdato )");
		queryString.append(" 		and   (:registreringsdato IS NULL OR shX.sidt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append("    and  (shX.siavd IN ( :avdelingList ) )");
		}		
		//queryString.append(" 		and   (:avdeling = 0 OR shX.siavd = :avdeling )");
		queryString.append(" 		and   (:deklarasjonsnr = 0 OR shX.sitdn = :deklarasjonsnr )");
		queryString.append(" 		and   shX.siavd > 0 "); //sanity check
		queryString.append(" 		and   shX.sitdn > 0 "); //sanity check
		queryString.append(" 		and   (:mottaker = 0 OR shX.siknk = :mottaker ) ");
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append("    and  (shX.sisg IN ( :signaturList )) ");
		}
		//queryString.append(" 		and   (:signatur IS NULL OR shX.sisg = :signatur)) as sh ");	
		queryString.append(" ) as sh ");
		queryString.append(" JOIN SADV sv  ");
		queryString.append("	 ON sh.avdeling = sv.svavd AND  sh.deklarasjonsnr = sv.svtdn ");
		queryString.append(" LEFT OUTER JOIN (select e.mavd mavd , e.mtdn mtdn, t.f4815 kalle, t.f0078a anka ");
		queryString.append(" 				  from EDIM e, TVINF t ");
		queryString.append(" 				  where e.mmn = t.fmn ");
		queryString.append(" 				  and   e.msr = 'R' and   e.m0065 = 'CUSRES' and   e.m1n07 = 'DME' ");
		queryString.append(" 				  and   t.f0078a in('950','954','972','999') ");
		queryString.append(" 				  and   t.f4815 in('NE','PP') ) e ");
		queryString.append("  	ON sh.avdeling = e.mavd AND sh.deklarasjonsnr = e.mtdn ");
		queryString.append(" group by  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, COALESCE(concat(e.kalle, e.anka), 'OK') ");
	
		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		logger.info("getImportStats list.size="+list.size());
		return list;
	}	

	private List<FortollingDto> getExportStats(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder(
							"SELECT  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, count(sv.svtdn) reg_vareposter,  max(sv.svln) off_vareposter, 'Export' type, COALESCE(concat(e.kalle, e.anka), 'OK') edim ");
		queryString.append(" FROM (select shX.seavd avdeling, shX.setdn deklarasjonsnr, shX.sedt registreringsdato, shX.sesg signatur,  shX.seknk mottaker ");
		queryString.append(" 	   	from SAEH shX  ");
		queryString.append("      	where  (:registreringsdato IS NULL OR shX.sedt >= :registreringsdato )");
		queryString.append(" 		and   (:registreringsdato IS NULL OR shX.sedt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append("    and  (shX.seavd IN ( :avdelingList ) )");
		}	
		//queryString.append(" 		and   (:avdeling = 0 OR shX.seavd = :avdeling )");
		queryString.append(" 		and   (:deklarasjonsnr = 0 OR shX.setdn = :deklarasjonsnr )");
		queryString.append(" 		and   shX.seavd > 0 "); //sanity check
		queryString.append(" 		and   shX.setdn > 0 "); //sanity check
		queryString.append(" 		and   (:mottaker = 0 OR shX.seknk = :mottaker ) ");
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append("    and  (shX.sesg IN ( :signaturList )) ");
		}		
		queryString.append(" ) as sh ");
		//queryString.append(" 		and   (:signatur IS NULL OR shX.sesg = :signatur)) as sh ");	
		queryString.append(" JOIN SAEV sv  ");
		queryString.append("	 ON sh.avdeling = sv.svavd AND  sh.deklarasjonsnr = sv.svtdn ");
		queryString.append(" LEFT OUTER JOIN (select e.mavd mavd , e.mtdn mtdn, t.f4815 kalle, t.f0078a anka ");
		queryString.append(" 				  from EDIM e, TVINF t ");
		queryString.append(" 				  where e.mmn = t.fmn ");
		queryString.append(" 				  and   e.msr = 'R' and   e.m0065 = 'CUSRES' and   e.m1n07 = 'DME' ");
		queryString.append(" 				  and   t.f0078a in('950','954','972','999') ");
		queryString.append(" 				  and   t.f4815 in('NE','PP') ) e ");
		queryString.append("  	ON sh.avdeling = e.mavd AND sh.deklarasjonsnr = e.mtdn ");
		queryString.append(" group by sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, COALESCE(concat(e.kalle, e.anka), 'OK') ");
	
		
		logger.info("About to run getExportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		logger.info("getExportStats list.size="+list.size());
		return list;
	}	
	
}