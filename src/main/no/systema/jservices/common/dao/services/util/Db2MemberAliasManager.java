package no.systema.jservices.common.dao.services.util;

import org.springframework.jdbc.core.JdbcTemplate;

public class Db2MemberAliasManager {

	
	public void createAlias(JdbcTemplate jdbcTemplate, String library, String alias, String memberTable, String member) throws Exception{
		String createAlias = "Create alias " + library + "." + alias + " for " + library + "." + memberTable + "(" + member + ")";
		jdbcTemplate.execute(createAlias);
	}
	public void dropAlias(JdbcTemplate jdbcTemplate, String library, String alias) throws Exception{
		String createAlias = "drop alias " + library + "." + alias;
		jdbcTemplate.execute(createAlias);
	}
}
