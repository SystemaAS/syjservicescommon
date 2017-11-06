package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.FaktDao;
import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FaktDWDto;
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

	
/*	
select t.tupro OK (behövs ej)
t.tubilk, OK
h.heavd avdeling, OK 
f.faopd, OK (behövs ej)
f.fabeln, OK
h.hedtop registreringsdato, OK
f.fakda, OK
f.faopko, OK (behövs ej)
h.trknfa mottaker, OK (behövs ej)
f.fask, OK
f.favk OK

	h.hedtop registreringsdato --> PERI       SONET        6  0       6         1        Begge    PERIODE                   
	  Felttekst . . . . . . . . . . . . . . . . :  PERIODE                                   
	h.heavd avdeling --> AVD        SONET        4  0       4         7        Begge    AVD                    
	  Felttekst . . . . . . . . . . . . . . . . :  AVD                                       
	t.tubilk -->  BILKOD     TEGN            3       3        11        Begge    BILKODE                   
	  Felttekst . . . . . . . . . . . . . . . . :  BILKODE                                   
	  ID for kodet tegnsett  . . . :                 277                                     
	f.fakda --> OMSKOST    TEGN            1       1        14        Begge    OMS/KOSTNAD               
	  Felttekst . . . . . . . . . . . . . . . . :  OMS/KOSTNAD                               
	  ID for kodet tegnsett  . . . :                 277                                     
	f.fask --> INTEXT     TEGN            1       1        15        Begge    INERN/EKSTERN             
	  Felttekst . . . . . . . . . . . . . . . . :  INERN/EKSTERN                             
	  ID for kodet tegnsett  . . . :                 277                                     
	? -->  STATUS     TEGN            1       1        16        Begge    O=OVER/BANK=ÅPEN          
	  Felttekst . . . . . . . . . . . . . . . . :  O=OVER/BANK=ÅPEN                          
	  ID for kodet tegnsett  . . . :                 277                                     
	f.favk --> VAREK      TEGN            3       3        17        Begge    VAREKODE                  
	        Felttekst . . . . . . . . . . . . . . . . :  VAREKODE                            
	     ID for kodet tegnsett  . . . :                 277                               
	f.fabeln --> SUMLIN     SONET        9  0       9        20        Begge    SUM ANT LINJER      
	     Felttekst . . . . . . . . . . . . . . . . :  SUM ANT LINJER                      
	? -->    BELOP      SONET       13  2      13        29        Begge    SUM FRAKT VEKT      
	     Felttekst . . . . . . . . . . . . . . . . :  SUM FRAKT VEKT    	
*/	
	
	
	
	public List<FaktDto> getStats(FaktDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String hedtopFromDate = null;
		String hedtopToDate = null;
		if (isOverview(qDto)) {
			hedtopFromDate = qDto.getRegistreringsdato() + "0100"; //incl. jan, e.g 2016 -> 20160100
			hedtopToDate = qDto.getRegistreringsdato() + "1231";   //incl. jan, e.g 2016 -> 20161231
		} else {  //details
			hedtopFromDate = qDto.getRegistreringsdato() + "00"; // e.g. 201601 -> 20160100	
			hedtopToDate = qDto.getRegistreringsdato() + "31";   // e.g. 201601 -> 20160131
		}
		
		StringBuilder queryString = new StringBuilder("select t.tupro, t.tubilk, h.heavd avdeling, f.faopd, f.fabeln, h.hedtop registreringsdato, f.fakda, f.faopko, h.trknfa mottaker, f.fask, f.favk ");
		queryString.append(" from  fakt f, headf h, turer t ");
		//queryString.append(" from  ttfakt f, ttheadf h, ttturer t ");  //==Toten data!!
		queryString.append(" where t.tupro = h.hepro ");
		queryString.append(" and f.faavd  = h.heavd ");
		queryString.append(" and   f.faopd = heopd ");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append(" and  (h.heavd IN ( :avdelingList ) )");
		}
		queryString.append(" and   h.hedtop >= ").append(hedtopFromDate);
		queryString.append(" and   h.hedtop <= ").append(hedtopToDate);
		queryString.append(" and   f.faavd > 0 ");
		queryString.append(" and   f.faopd > 0  ");
		queryString.append(" and   f.faopko = 'O' "); 
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append(" and   (h.hesg IN ( :signaturList ) ) ");
		}

		queryString.append(" and   (:mottaker = 0 OR h.trknfa = :mottaker )");

		if (!qDto.getFavkList().isEmpty()) {
			if (qDto.getFavkexcl() == null) {
				queryString.append(" and   ( f.favk IN ( :favkList ) )");
			} else {
				queryString.append(" and   ( f.favk NOT IN ( :favkList ) )");
			}
		}

		logger.info("About to run queryString.toString()="+queryString.toString());
		List<FaktDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FaktDto()));
		logger.info("returning list with size="+list.size());
		
		return list;
		
	}

	private boolean isOverview(FaktDto qDto) {
		if (qDto.getRegistreringsdato().length() == 4) {
			return true;
		} else {
			return false;			
		}
	}


	@Override
	public List<FaktDWDto> getStatsFromDW(FaktDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String hedtopFromDate = qDto.getRegistreringsdato() + "01"; //incl. jan, e.g 2016 -> 201601
		String hedtopToDate = qDto.getRegistreringsdato() + "12"; //incl. jan, e.g 2016 -> 201612
		
		StringBuilder queryString = new StringBuilder("select  d.bilkod, d.avd avdeling,  d.sumlin,  d.belop, d.peri registreringsdato, d.omskost, d.intext, d.varek ");
		queryString.append(" from  dwsumper d ");
		queryString.append(" where   d.peri  >= ").append(hedtopFromDate);
		queryString.append(" and   d.peri  <= ").append(hedtopToDate);
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append(" and  (d.avd IN ( :avdelingList ) )");
		}
		//queryString.append(" and   f.faavd > 0 "); Not needed?
		//queryString.append(" and   f.faopko = 'O' "); Not needed?
		/*if (!qDto.getSignaturList().isEmpty()) {
			queryString.append(" and   (h.hesg IN ( :signaturList ) ) "); Not needed?
		}*/

		//queryString.append(" and   (:mottaker = 0 OR h.trknfa = :mottaker )");  Not needed?

		if (!qDto.getFavkList().isEmpty()) {
			if (qDto.getFavkexcl() == null) {
				queryString.append(" and   ( d.varek IN ( :favkList ) )");
			} else {
				queryString.append(" and   ( d.varek NOT IN ( :favkList ) )");
			}
		}

		logger.info("About to run queryString.toString()="+queryString.toString());
		List<FaktDWDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FaktDWDto()));
		logger.info("returning list with size="+list.size());
		
		return list;
	}
	
}