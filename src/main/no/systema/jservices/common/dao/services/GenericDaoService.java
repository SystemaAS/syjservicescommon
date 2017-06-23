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
	 * @param sql sql including ... = ? setup
	 * @param mapper RowMapper, e.g. GeneringObjectMapper
	 * @param args args targeting = ? in sql
	 * @return a List of T
	 */
	public List<T> findAll(String sql, RowMapper<T> mapper, Object... args);
	
	/**
	 * Find all T on delivered args.
	 * 
	 * @param params String = columnname, Object = any value. Accepts wildcard %. If params==null, no where-clause is added.
	 * @return a List of T
	 */
	public List<T> findAll(Map<String, Object> params);
	
	/**
	 * Find all T on delivered args.
	 * Used when distinct values (single) are to be used. Usually when the table must deliver one-and-only sql-distinct value
	 * @param params String = columnname, Object = any value. Accepts wildcard %. If params==null, no where-clause is added.
	 * @return a List of T
	 */
	public List<T> findAllDistinct(String columnName);
	
	/**
	 * Find all T on delivered clause. Exclude where in arg
	 * 
	 * @param params String any valid DB2 syntax
	 * @return a List of T
	 */
	public List<T> findWhere(String clause);	
	
	/**
	 * Find all T on delivered args.
	 * 
	 * Including a hardwired join on firma. Use this when table FIRM is needed.  Accepts wildcard %.If params==null, no where-clause is added.
	 * 
	 * @param params String = columnname, Object = any value.
	 * @param firmaColumnName String name of the column in T that represents firma
	 * @return a List of T
	 */
	public List<T> findAllInFirma(Map<String, Object> params, String firmaColumnName);	
	
	
	/**
	 * Count all T on delivered args.
	 * 
	 * @param params String = columnname, Object = any value, If params==null, no where-clause is added.
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
	 * @param id Object is needs to be implementing {@link IDao}
	 * @param firmaColumnName String name of the column in T that represents firma
	 * @return true if exist, else return false.
	 */
	public boolean existInFirma(Object id, String firmaColumnName);
	
	
	/**
	 * Check if T id exist.
	 * Object must implemented {@link IDao}
	 * 
	 * @param id
	 * @return true if exist, else return false.
	 */	
	public boolean exist(Object id);

	/**
	 * Insert delivered T into corresponding table.
	 * 
	 * @param t populated IDao
	 * @return created T
	 */
	public T create(T t);

	/**
	 * Delete object.
	 * 
	 * @param id, actual T
	 */
	public void delete(Object id);
	
	/**
	 * Delete all T on delivered args.
	 * 
	 * @param params, String = columnname, Object = any value
	 */
	public void deleteAll(Map<String, Object> params);	
	
	/**
	 * Find T on provided keys.
	 * 
	 * @param id, the, with keys, populated T
	 * @return T, if found, else null
	 */
	public T find(Object id);


	/**
	 * Find T on delivered id.
	 * 
	 * Including a hardwired join on firma. Use this when table FIRM is needed.
	 * 
	 * @param Object
	 * @param firmaColumnName String name of the column in T that represents firma
	 * 
	 * @return a T if found
	 */	
	public T findInFirma(Object id, String firmaColumnName);

	/**
	 * A full update on delivered IDao.
	 * Respecting all fields
	 * 
	 * @param t populated IDao
	 * @return the updated IDao
	 */
	public T update(T t);  	
	
}
