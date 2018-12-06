package no.systema.jservices.common.dao.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.HeadfDao;
import no.systema.jservices.common.dto.HeadfDto;

public class HeadfDaoServiceImpl extends GenericDaoServiceImpl<HeadfDao> implements HeadfDaoService {
	protected static final Logger logger = Logger.getLogger(HeadfDaoServiceImpl.class.getName());

	@Override
	public List<HeadfDto> get(HeadfDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		int fromDate = fromDate(qDto.getHedtop(), qDto.getDftdg());
		StringBuilder queryString = new StringBuilder();
		queryString.append(" SELECT heavd, heopd , hedtop ,hedtr, henas , henak, hesg , hent , hevkt , hem3 , helks ,  hepns , helkk , hepnk, ");
		queryString.append(" heot, heur, hepro, hegn, hest, hepk3, hepk4, hepos1, hepos2");
		queryString.append(" FROM headf ");
		queryString.append(" WHERE (:heavd = 0 OR heavd = :heavd ) ");
		queryString.append(" AND   (:heopd = 0 OR heopd = :heopd ) ");
		
		if (qDto.getHeavd() > 0 && qDto.getHeopd() > 0) {
			logger.info("heavd and heopd delivered, no more in where-clause");
		} else {
			queryString.append(" AND   (:hedtop = 0 OR hedtop >= :hedtop )");
			queryString.append(" AND   (:henas IS NULL OR henas like :henas ) ");
			queryString.append(" AND   (:henak IS NULL OR henak like :henak ) ");
			queryString.append(" AND   (:hesg  IS NULL OR hesg  like :hesg ) ");
			queryString.append(" AND   (:helks IS NULL OR helks = :helks ) ");
			queryString.append(" AND   (:hepns IS NULL OR hepns = :hepns ) ");
			queryString.append(" AND   (:helkk IS NULL OR helkk = :helkk ) ");
			queryString.append(" AND   (:hepnk IS NULL OR hepnk = :hepnk ) ");
			queryString.append(" AND   (:hest IS NULL OR hest = :hest ) ");
			queryString.append(" AND   (:heur IS NULL OR heur = :heur ) ");
			queryString.append(" AND   (:hegn IS NULL OR hegn like :hegn ) ");
			//queryString.append(" AND   (:hepos1 IS NULL OR hepos1 like :hepos1 ) ");
			//queryString.append(" AND   (:hepos2 = 0 OR hepos2 >= :hepos2 )");
			
			
			if(qDto.getHedtop() == 0) {  //Only if date not delivered
				queryString.append(" AND  hedtop >= "+fromDate);
			}
		}
		
		queryString.append(" ORDER BY hedtop DESC ");		
		
		logger.info("queryString="+queryString.toString());
		
		return namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new HeadfDto()));

	}

	
	
	private int fromDate(int hedtop, int dftdg) {
		String hedstopAsString = String.valueOf(hedtop);  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(hedstopAsString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, -dftdg);  // number of days withdraw
		hedstopAsString = sdf.format(c.getTime()); 
		
		return Integer.valueOf(hedstopAsString.toString());
		
	}
	
	@Override
	public HeadfDao find(int heavd, int heopd) {
		HeadfDao qDao = new HeadfDao();
		qDao.setHeavd(heavd);
		qDao.setHeopd(heopd);
		return find(qDao);
	}

	@Override
	public HeadfDao create(HeadfDao dao) {
		int teopdn = tellDaoService.getExistingTeopdnAndIncrement(dao.getHeavd());
		dao.setHeopd(teopdn); 
		return super.create(dao);
	}
	
	@Override
	public void delete(Object id) {
		HeadfDao dao = (HeadfDao) id;
		super.delete(id);
		tellDaoService.substractTeopdn(dao.getHeavd());
	}
	
	private TellDaoService tellDaoService = null;                                                            
	public void setTellDaoService( TellDaoService tellDaoService) {this.tellDaoService = tellDaoService;}          
	public TellDaoService getTellDaoService() {return this.tellDaoService;}	
	
	
}
