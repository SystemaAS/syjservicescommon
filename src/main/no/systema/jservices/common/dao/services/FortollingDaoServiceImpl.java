package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FortollingDto;
import no.systema.jservices.common.util.DateTimeManager;

public class FortollingDaoServiceImpl extends GenericDaoServiceImpl<FortollingDto> implements FortollingDaoService{

	DateTimeManager dm = new DateTimeManager();
	
	//TODO remove
	public List<FortollingDto> getStats(int fromYear, int avd, String sign, int kundenr) {
		String sidtFromDate = fromYear + "0000"; // e.g. 2016 -> 20160000		
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder("select sh.siavd avdeling, sh.sitdn deklarasjonsnr, sh.sidt registreringsdato, sh.sisg signatur, count(sv.svtdn) reg_vareposter ");
		queryString.append(" from sadh sh, sadv sv ");  
		queryString.append(" where sv.svavd = sh.siavd ");  
		queryString.append(" and sv.svtdn = sh.sitdn ");  		
		queryString.append(" and   sh.sidt >= ").append(sidtFromDate);
		queryString.append(" and   sh.sidt <= ").append(sidtToDate);	
		queryString.append(" and   sh.siavd > 0 ");
		queryString.append(" and   sh.sitdn > 0 ");
		queryString.append(" group by  sh.siavd, sh.sitdn, sh.sidt, sh.sisg ");
		queryString.append(" order by sh.siavd ");
		
		logger.info("About to run getStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  getJdbcTemplate().query(queryString.toString(), new GenericObjectMapper(new FortollingDto()));
		
		return list;
	
	}

	
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
						    "select sh.siavd avdeling, sh.sitdn deklarasjonsnr, sh.sidt registreringsdato, sh.sisg signatur, sh.siknk mottaker ,count(sv.svtdn) reg_vareposter, max(sv.svln) off_vareposter,'Export' type");
		queryString.append(" from  sadh sh, sadv sv ");  
		queryString.append(" where sv.svavd = sh.siavd ");  
		queryString.append(" and   sv.svtdn = sh.sitdn ");  		
		queryString.append(" and   (:registreringsdato IS NULL OR sh.sidt >= :registreringsdato )");
		queryString.append(" and   (:registreringsdato IS NULL OR sh.sidt <="+sidtToDate+")");
		queryString.append(" and   (:avdeling = 0 OR sh.siavd = :avdeling )");
		queryString.append(" and   (:deklarasjonsnr = 0 OR sh.sitdn = :deklarasjonsnr )");
		queryString.append(" and   sh.siavd > 0 "); //sanity check
		queryString.append(" and   sh.sitdn > 0 "); //sanity check
		queryString.append(" and   (:mottaker = 0 OR sh.siknk = :mottaker )");
		queryString.append(" and   (:signatur IS NULL OR sh.sisg = :signatur) ");
		queryString.append(" group by  sh.siavd, sh.sitdn, sh.sidt, sh.sisg, sh.siknk ");
	
		
		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		return list;
	}	

	private List<FortollingDto> getExportStats(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder(
							"select sh.seavd avdeling, sh.setdn deklarasjonsnr, sh.sedt registreringsdato, sh.sesg signatur, sh.seknk mottaker ,count(sv.svtdn) reg_vareposter, max(sv.svln) off_vareposter, 'Import' type");
		queryString.append(" from  saeh sh, saev sv ");  
		queryString.append(" where sv.svavd = sh.seavd ");  
		queryString.append(" and   sv.svtdn = sh.setdn ");  		
		queryString.append(" and   (:registreringsdato IS NULL OR sh.sedt >= :registreringsdato )");
		queryString.append(" and   (:registreringsdato IS NULL OR sh.sedt <="+sidtToDate+")");
		queryString.append(" and   (:avdeling = 0 OR sh.seavd = :avdeling )");
		queryString.append(" and   (:deklarasjonsnr = 0 OR sh.setdn = :deklarasjonsnr )");
		queryString.append(" and   sh.seavd > 0 "); //sanity check
		queryString.append(" and   sh.setdn > 0 "); //sanity check
		queryString.append(" and   (:mottaker = 0 OR sh.seknk = :mottaker )");
		queryString.append(" and   (:signatur IS NULL OR sh.sesg = :signatur) ");
		queryString.append(" group by  sh.seavd, sh.setdn, sh.sedt, sh.sesg, sh.seknk ");  
	
		
		logger.info("About to run getExportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		return list;
	}	
	
	
	
	
	
	
	
}