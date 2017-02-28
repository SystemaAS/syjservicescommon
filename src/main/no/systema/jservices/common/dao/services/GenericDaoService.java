package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import no.systema.jservices.common.dao.IDao;

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

	/**
	 * Find all T on delivered args.
	 * 
	 * Including a hardwired join on firma. Use this when table FIRM is needed.
	 * 
	 * NOTE: Assuming that your dao's firma id is namned <b>firma</b> !
	 * 
	 * @param params, String = columnname, Object = any value
	 * @return a List of T
	 */
	public List<T> findAllInFirma(Map<String, Object> params);	
	
	
	/**
	 * Count all T on delivered args.
	 * 
	 * @param params, String = columnname, Object = any value
	 * @return int
	 */
	public int countAll(Map<String, Object> params);
	
	/**
	 * Count all T 
	 * 
	 * @return int
	 */
	public int countAll();

	/**
	 * Check if T id exist.
	 * 
	 * Including a hard-wired join on firma. Use this when table FIRM is needed.
	 * 
	 * NOTE: Assuming that your dao's firma id is namned <b>firma</b> !
	 * 
	 * @param id, Object is needs to be implementing {@link IDao}
	 * @return true, if exist, else return false.
	 */
	public boolean existInFirma(Object id);
	
	
	/**
	 * Check if T id exist.
	 * 
	 * @param id, Object must implemented {@link IDao}
	 * @return true, if exist, else return false.
	 */	
	public boolean exist(Object id);

	/**
	 * Insert delivered T into corresponding table.
	 * 
	 * No checks on keys.
	 * 
	 * @param t, populated IDao
	 * @return created T
	 */
	public T create(T t);

	public void delete(Object id);

	public T find(Object id);


	/**
	 * Find T on delivered id.
	 * 
	 * Including a hardwired join on firma. Use this when table FIRM is needed.
	 * 
	 * NOTE: Assuming that your dao's firma id is namned <b>firma</b> !
	 * 
	 * @return a T, if found
	 */	
	public T findInFirma(Object id);

	/**
	 * A full update on delivered IDao.
	 * Respecting all fields
	 * 
	 * @param t, populated IDao
	 * @return the updated IDao
	 */
	public T update(T t);  	
	
}
