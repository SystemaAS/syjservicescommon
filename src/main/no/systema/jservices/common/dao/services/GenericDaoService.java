package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public interface GenericDaoService<T> {

	/**
	 * Find all T on delivered args.
	 * 
	 * (Implementation respecting the legacy way using jdbctemplate)
	 * 
	 * @param sql, sql including ... = ? setup
	 * @param mapper, RowMapper, e.g. GeneringObjectMapper
	 * @param args, args targeting = ? in sql
	 * @return a List of T
	 */
	public List<T> findAll(String sql, RowMapper<T> mapper, Object... args);
	
	/**
	 * Find all T on delivered args.
	 * 
	 * @param params, String = columnname, Object = any value
	 * @return a List of T
	 */
	public List<T> findAll(Map<String, Object> params);
	
	public int countAll(Map<String, Object> params);
	
	public int countAll();

	public T create(T t);

	public void delete(Object id);

	public T find(Object id);

	public T update(T t);  	
	
}
