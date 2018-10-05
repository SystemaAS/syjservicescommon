package no.systema.jservices.common.dao.services;


import java.io.Writer;

import org.apache.log4j.Logger;

import no.systema.jservices.common.dao.MerknfDao;

public class MerknfDaoServiceImpl extends GenericDaoServiceImpl<MerknfDao> implements MerknfDaoService{
	private static final Logger logger = Logger.getLogger(GodsjfDaoServiceImpl.class.getName());
	
	@Override
	public int findById (String gogn, String gotrnr){
		int retval = 0;
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select count(1) ");
		sql.append(" from merknf ");
		//WHERE
		sql.append(" where gogn = ? ");
		sql.append(" and gotrnr = ? ");
		
		retval = super.getJdbcTemplate().queryForObject( sql.toString(), new Object[] { gogn, gotrnr }, Integer.class);
	
		return retval;
	}

}
