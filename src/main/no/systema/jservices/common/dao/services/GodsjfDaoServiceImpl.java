package no.systema.jservices.common.dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import no.systema.jservices.common.dao.GodsjfDao;
import no.systema.jservices.common.dao.GenericObjectMapper;


public class GodsjfDaoServiceImpl extends GenericDaoServiceImpl<GodsjfDao> implements GodsjfDaoService{
	private static final Logger logger = Logger.getLogger(GodsjfDaoServiceImpl.class.getName());
	
	@Override
	public List<GodsjfDao> findDefault(String currentYear, String fromDay) {
		StringBuilder queryString = new StringBuilder("SELECT * from godsjf ");
		queryString.append(" where substr(GOGN,1,4) = ? and substr(GOGN,10,3) > ? ");
		queryString.append(" order by GOGN desc ");
		logger.info(queryString.toString());
		logger.info("PARAMS currentYear:" + currentYear + " fromDay:" + fromDay);
		
		return super.getJdbcTemplate().query( queryString.toString(), new Object[] { currentYear, fromDay  }, new GenericObjectMapper(new GodsjfDao()));
		
	}

	/*
	private JdbcTemplate jdbcTemplate = null;                                                            
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}          
	public JdbcTemplate getJdbcTemplate() {return this.jdbcTemplate;}
	*/
}
