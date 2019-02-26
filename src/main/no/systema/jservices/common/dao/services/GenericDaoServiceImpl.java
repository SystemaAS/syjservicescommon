package no.systema.jservices.common.dao.services;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.IDao;

/**
 * This class is taking a {@link IDao} as argument. Delivering some convenience methods on Dao, just extend this class for your use case.
 * Dao must represent table and columnname as-is in database.
 * 
 * Does not support 2FC, hence the trailing WITH NONE is jdbc create/update.
 * 
 * @author Fredrik Möller
 * @date Jan 18, 2017
 *
 * @param <T>, A dao implementing {@link IDao}
 */
public abstract class GenericDaoServiceImpl<T> implements GenericDaoService<T>{
	protected static final Logger logger = Logger.getLogger(GenericDaoServiceImpl.class.getName());
	private Class<T> type;
	private String tableName;
	private String tableAlias;
	private GenericObjectMapper mapper;
	private Field[] fields;
	private Method[] methods;

	/** %  */
	protected static CharSequence WILD_CARD = "%";
	/** NOT NULL  */
	protected static String NOT_NULL = "NOT NULL";
	/** >  */
	protected static String GREATER_THEN = " > ";
	/** <  */
	protected static String LESS_THEN = " < ";
	/** =>  */
	protected static String GREATER_AND_EQUALS_THEN = " >= ";

	/** map for query params, used in implementing classes.*/
	protected Map<String, Object> params = new HashMap<String, Object>();
	

	public GenericDaoServiceImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
		tableName = type.getSimpleName().substring(0, type.getSimpleName().length() - 3);
		tableAlias = tableName.substring(0, 3);  //all good things are three..
		fields = type.getDeclaredFields();
		methods = type.getDeclaredMethods();
		
		try {
			mapper = new GenericObjectMapper((IDao) type.newInstance());
		} catch (InstantiationException e) {
			logger.error("Error:",e);
		} catch (IllegalAccessException e) {
			logger.error("Error:",e);
		}
	}

	@Override
	public List<T> findAll(Map<String, Object> params) {
	    StringBuilder queryString = new StringBuilder("SELECT * from ");
	    queryString.append(tableName);
		queryString.append(this.getQueryClauses(params, null));
		logger.info(queryString.toString());
		
		return jdbcTemplate.query(queryString.toString(), mapper);
	}
	
	@Override
	public List<T> findAllRRN(Map<String, Object> params) {
		StringBuilder queryString = new StringBuilder();
	    queryString.append("SELECT RRN(").append(tableName).append(") rrn ,").append(tableName).append(".* FROM ");
	    queryString.append(tableName);
		queryString.append(this.getQueryClauses(params, null));
		logger.info(queryString.toString());
		
		return jdbcTemplate.query(queryString.toString(), mapper);
	}
	
	@Override
	public List<T> findAll(Map<String, Object> params, String numberOfRows) {
	    StringBuilder queryString = new StringBuilder("SELECT * from ");
	    queryString.append(tableName);
		queryString.append(this.getQueryClauses(params, null));
		queryString.append(" FETCH FIRST " + numberOfRows + " ROWS ONLY ");
		logger.info(queryString.toString());
		return jdbcTemplate.query(queryString.toString(), mapper);
	}
	
	/**
	 * In case special order by -clause is required
	 */
	@Override
	public List<T> findAll(Map<String, Object> params, StringBuffer orderByClause) {
	    StringBuilder queryString = new StringBuilder("SELECT * from ");
	    queryString.append(tableName);
		queryString.append(this.getQueryClauses(params, null));
		queryString.append(" " + orderByClause.toString());
		logger.info(queryString.toString());
		return jdbcTemplate.query(queryString.toString(), mapper);
	}
	
	
	@Override
	public List<T> findAllDistinct(String columnName) {
	    StringBuilder queryString = new StringBuilder("SELECT distinct " + columnName + " from ");
	    queryString.append(tableName);
		logger.info(queryString.toString());
		return jdbcTemplate.query(queryString.toString(), mapper);
	}
	
	@Override
	public List<T> findWhere(String clause) {
	    StringBuilder queryString = new StringBuilder("SELECT * from ");
	    queryString.append(tableName);
	    queryString.append(" where "); queryString.append(clause);	
		logger.info(queryString.toString());
		return jdbcTemplate.query(queryString.toString(), mapper);	    
	}	
	
	
	@Override
	public List<T> findAllInFirma(Map<String, Object> params, String firmaColumnName) {
	    StringBuilder queryString = new StringBuilder("SELECT ").append(tableAlias).append(".* from ");
	    queryString.append(tableName).append(" ").append(tableAlias).append(", firm f ");
	    queryString.append("where ");
	    queryString.append(tableAlias).append("."+firmaColumnName+"=").append("f.fifirm ");
		queryString.append(this.getQueryClausesInFirma(params, null));
		logger.info(queryString.toString());
	    return jdbcTemplate.query(queryString.toString(), mapper);
	}

	
	@Override
	public T findInFirma(Object id, String  firmaColumnName) {
		IDao dao = (IDao )id;
		Map<String, Object> params = dao.getKeys();
		List<T> list =findAllInFirma( params, firmaColumnName) ;
		if (list.size() ==1) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public T find(Object id) {
		IDao dao = (IDao )id;
		Map<String, Object> params = dao.getKeys();
		List<T> list =findAll( params) ;
		if (list.size() ==1) {
			return list.get(0);
		}
		return null;		
		
	}
	
	
	@Override
	public T findByRRN(int rrn) {
	    StringBuilder queryString = new StringBuilder();
	    queryString.append("SELECT RRN(").append(tableName).append(") rrn ,").append(tableName).append(".* FROM ");
	    queryString.append(tableName);
	    queryString.append(" where RRN(").append(tableName).append(") =").append(rrn) ;	
		logger.info(queryString.toString());
		return (T) jdbcTemplate.queryForObject(queryString.toString(), mapper);	    	
		
	}	
	
	@Override
	public boolean existInFirma(Object id, String firmaColumnName) {
		T t = findInFirma(id, firmaColumnName);
		if (t != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean exist(Object id) {
		T t = find(id);
		if (t != null) {
			return true;
		} else {
			return false;
		}
	}	
	
		
	@Override
	public int countAll() {
	    StringBuilder queryString = new StringBuilder("SELECT count(*) from ");
	    queryString.append(tableName);
	    int count = jdbcTemplate.queryForObject(queryString.toString(), Integer.class);
		return count;
	}         	
		
	@Override
	public int countAll(Map<String, Object> params) {
		StringBuilder queryString = new StringBuilder("SELECT count(*) from ");
		queryString.append(tableName);
		queryString.append(this.getQueryClauses(params, null));
		int count = jdbcTemplate.queryForObject(queryString.toString(), Integer.class);
		return count;
	}

	private String getQueryClauses(final Map<String, Object> params, final Map<String, Object> orderParams) {
		StringBuilder queryString = new StringBuilder();
		if ((params != null) && !params.isEmpty()) {
			queryString.append(" where ");
			for (final Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() instanceof Boolean) {
					queryString.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" ");
				} else {
					if (entry.getValue() instanceof Number) {
						//> or =>
						if (String.valueOf(entry.getKey()).contains(GREATER_THEN) || String.valueOf(entry.getKey()).contains(GREATER_AND_EQUALS_THEN)) {
							queryString.append(entry.getKey()).append(entry.getValue());
						} else {
							queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
						}
					} else {
						//wild card , %
						if (String.valueOf(entry.getValue()).contains(WILD_CARD)) {
							queryString.append("LOWER("+ entry.getKey()+")").append(" LIKE LOWER('").append(entry.getValue()).append("')");
							//not null
						} else if (String.valueOf(entry.getValue()).equals(NOT_NULL)) {
							 queryString.append("NULLIF(").append(entry.getKey() + ",").append(" '') ").append(" IS NOT NULL");  //NULLIF(<key>, '') IS NOT NULL
						} else { 
							queryString.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
						}
					}
				}
				if (it.hasNext()) {
					queryString.append(" and ");
				}
			}
		}
		if ((orderParams != null) && !orderParams.isEmpty()) {
			queryString.append(" order by ");
			for (final Iterator<Map.Entry<String, Object>> it = orderParams.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				queryString.append(entry.getKey()).append(" ");
				if (entry.getValue() != null) {
					queryString.append(entry.getValue());
				}
				if (it.hasNext()) {
					queryString.append(", ");
				}
			}
		}
		return queryString.toString();
	}
	
	
	private String getQueryClausesInFirma(final Map<String, Object> params, final Map<String, Object> orderParams) {
		StringBuilder queryString = new StringBuilder();
		if ((params != null) && !params.isEmpty()) {
			queryString.append(" and ");
			for (final Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
//				queryString.append(tableAlias).append(".");

				if (entry.getValue() instanceof Boolean) {
					queryString.append(tableAlias).append(".");
					queryString.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" ");
				} else {
					if (entry.getValue() instanceof Number) {
						//> or =>
						if (String.valueOf(entry.getKey()).contains(GREATER_THEN) || String.valueOf(entry.getKey()).contains(GREATER_AND_EQUALS_THEN)) {
							queryString.append(tableAlias).append(".");
							queryString.append(entry.getKey()).append(entry.getValue());
						} else {
							queryString.append(tableAlias).append(".");
							queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
						}
					} else {
						//wild card , %
						if (String.valueOf(entry.getValue()).contains(WILD_CARD)) {
							queryString.append("LOWER(").append(tableAlias).append(".").append(entry.getKey()+")");
							queryString.append(" LIKE LOWER('").append(entry.getValue()).append("')");
							//not null
						} else if (String.valueOf(entry.getValue()).equals(NOT_NULL)) {
							queryString.append(tableAlias).append(".");
							queryString.append("NULLIF(").append(entry.getKey() + ",").append(" '') ").append(" IS NOT NULL");  //NULLIF(<key>, '') IS NOT NULL
						} else { 
							queryString.append(tableAlias).append(".");
							queryString.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
						}
					}
				}
				if (it.hasNext()) {
					queryString.append(" and ");
				}
			}
		}
		if ((orderParams != null) && !orderParams.isEmpty()) {
			queryString.append(" order by ");
			for (final Iterator<Map.Entry<String, Object>> it = orderParams.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				queryString.append(entry.getKey()).append(" ");
				if (entry.getValue() != null) {
					queryString.append(entry.getValue());
				}
				if (it.hasNext()) {
					queryString.append(", ");
				}
			}
		}
		return queryString.toString();
	}
	

	@Override
	public T create(T t) {
		IDao dao = (IDao) t;
		logger.debug("create:IDao="+ReflectionToStringBuilder.toString(dao));
		Map<String, Object> keys = dao.getKeys();
		if (exist(dao)) {
			String errMsg = "::create::Record already exist in " + tableName + " on keys=" + keys;
			logger.error(errMsg);
			throw new DuplicateKeyException(errMsg);
		}
		Object[] values = new Object[fields.length-1];
		StringBuilder debugFieldValue = new StringBuilder();
		int ret = 0;
		int i = 0;
		Class<?> returnType = null;
		Object value = "";

		StringBuilder createString = new StringBuilder("INSERT into ");
		createString.append(tableName);
		createString.append(" ( ");
		
		for (Method method : methods) {
			String getter = method.getName();
			if (getter.startsWith("get")) {
				returnType = method.getReturnType();
				String field = method.getName().replace("get", "");
				if (returnType.equals(String.class) || returnType.equals(Integer.class) || returnType.equals(int.class) || returnType.equals(BigDecimal.class) ) {
					if (!"keys".equals(field)) {
						createString.append(field + ",");
						try {
							value = (Object) method.invoke(t);

							if (returnType.equals(String.class) ) {
								values[i++] = (value == null) ? "" : value;
							} else {
								values[i++] = (value == null) ? 0 : value;
							}
							
							debugFieldValue.append(field + ":{"+value+"}"+'\n');
							//logger.info(field + " " + value);
						} catch (Exception e) {
							logger.info("Error:", e);
						}
					}
				} else  {
					logger.info("returnType not handled, field="+field);
				}
			}
		}

		createString.deleteCharAt(createString.length() - 1); // Remove last ,
		createString.append(" ) ");
		createString.append(" VALUES ( ");

		for (int ii = 1; ii < fields.length; ii++) {
			createString.append(" ?,");
		}
		createString.deleteCharAt(createString.length() - 1); // Remove last ,
		createString.append(" ) ");
		//https://www-01.ibm.com/support/docview.wss?uid=swg21676715
		createString.append(" WITH NONE ");
		
		try {
			
			ret = jdbcTemplate.update(createString.toString(), values);
			logger.debug("create executed. createString="+createString+" on params="+keys);
			
		} catch (DataAccessException e) { //RuntimeException
			logger.error("Error:", e);
			logger.info("Error, string="+createString.toString());
			logger.info("debugFieldValue="+debugFieldValue.toString());
			throw e;
		}
		
		if (ret != 1) {
			t = null;
		}

		return t;
		
	}
	
	@Override
	public T createWithoutDulicateCheck(T t) {
		IDao dao = (IDao) t;
		logger.debug("create:IDao="+ReflectionToStringBuilder.toString(dao));
		Map<String, Object> keys = dao.getKeys();
		Object[] values = new Object[fields.length-1];
		StringBuilder debugFieldValue = new StringBuilder();
		int ret = 0;
		int i = 0;
		Class<?> returnType = null;
		Object value = "";

		StringBuilder createString = new StringBuilder("INSERT into ");
		createString.append(tableName);
		createString.append(" ( ");
		
		for (Method method : methods) {
			String getter = method.getName();
			if (getter.startsWith("get")) {
				returnType = method.getReturnType();
				String field = method.getName().replace("get", "");
				if (returnType.equals(String.class) || returnType.equals(Integer.class) || returnType.equals(int.class) || returnType.equals(BigDecimal.class) ) {
					if (!"keys".equals(field)) {
						createString.append(field + ",");
						try {
							value = (Object) method.invoke(t);
							values[i++] = (value == null) ? "" : value;
							debugFieldValue.append(field + ":{"+value+"}"+'\n');
							//logger.info(field + " " + value);
						} catch (Exception e) {
							logger.info("Error:", e);
						}
					}
				} else  {
					logger.info("returnType not handled, field="+field);
				}
			}
		}

		createString.deleteCharAt(createString.length() - 1); // Remove last ,
		createString.append(" ) ");
		createString.append(" VALUES ( ");

		for (int ii = 1; ii < fields.length; ii++) {
			createString.append(" ?,");
		}
		createString.deleteCharAt(createString.length() - 1); // Remove last ,
		createString.append(" ) ");
		//https://www-01.ibm.com/support/docview.wss?uid=swg21676715
		createString.append(" WITH NONE ");
		logger.debug(createString.toString());
		logger.debug(values);
		
		
		try {
	
			ret = jdbcTemplate.update(createString.toString(), values);

		} catch (DataAccessException e) { //RuntimeException
			logger.error("Error:", e);
			logger.info("Error, string="+createString.toString());
			logger.info("debugFieldValue="+debugFieldValue.toString());
			throw e;
		}
		
		if (ret != 1) {
			t = null;
		}

		return t;
		
	}

	@Override
	public void delete(Object id) {
		IDao dao = (IDao) id;
		Map<String, Object> params = dao.getKeys();
		StringBuilder deleteString = new StringBuilder("DELETE from ");
		deleteString.append(tableName);
		deleteString.append(this.getQueryClauses(params, null));

		int ret = 0;		
		
		try {
			ret = jdbcTemplate.update(deleteString.toString());
			logger.debug("delete executed. deleteString="+deleteString+" on params="+params);
		} catch (Exception e) {
			logger.error("Error:", e);
			logger.error("Error, string=" + deleteString.toString());
			//Not compiling throw e;
		}
		
		if (ret != 1) {
			logger.error("Row not found for DELETE!");
			logger.error("Error, string=" + deleteString.toString());
			throw new DataAccessResourceFailureException("Row not found for DELETE on key/value:"+params.keySet().toString() +"/"+params.values()) ;
		}	

	}
	
	@Override
	public void deleteAll(Map<String, Object> params) {
		StringBuilder deleteString = new StringBuilder("DELETE from ");
		deleteString.append(tableName);
		deleteString.append(this.getQueryClauses(params, null));

		int ret = 0;		
		
		try {
			ret = jdbcTemplate.update(deleteString.toString());
			logger.debug("deleteAll executed. deleteString="+deleteString+" on params="+params);
		} catch (Exception e) { 
			logger.error("Error:", e);
			logger.error("Error, string=" + deleteString.toString());
			//Not compiling -->throw e;
		}
		
		if (ret == 0) {
			logger.info("Rows not found for DELETE");
			logger.info("Info, string=" + deleteString.toString());
		}			

	}	

	@Override
	public T update(T t) {
		IDao dao = (IDao) t;
		logger.debug("update:IDao="+ReflectionToStringBuilder.toString(dao));
		Map<String, Object> keys = dao.getKeys();
		if (!exist(dao)) {
			logger.error("::update::Record does not exist in " + tableName + " on keys=" + keys);
			return null;
		}
		Object[] values = new Object[fields.length - 1];
		StringBuilder debugFieldValue = new StringBuilder();
		StringBuilder updateString = new StringBuilder("UPDATE ");
		updateString.append(tableName);
		updateString.append(" SET ");

		int ret = 0;		
		int i = 0;
		Class<?> returnType = null;
		Object value = null;
		for (Method method : methods) {
			String getter = method.getName();
			if (getter.startsWith("get")) {
				returnType = method.getReturnType();
				String field = method.getName().replace("get", "");
				if (returnType.equals(String.class) || returnType.equals(Integer.class) || returnType.equals(int.class) || returnType.equals(BigDecimal.class)) {
					if (!"keys".equals(field)) {
						updateString.append(field + " = ? ,");
						try {
							value = (Object) method.invoke(t);

							if (returnType.equals(String.class) ) {
								values[i++] = (value == null) ? "" : value;
							} else {
								values[i++] = (value == null) ? 0 : value;
							}
							
							debugFieldValue.append(field + ":{"+value+"}"+'\n');
						} catch (Exception e) {
							logger.error("Error:", e);
						}
					} else {
						keys.put(field, value);
					}
				} else  {
					logger.info("returnType not handled, field="+field+", continues..");
				}
			}
		}

		updateString.deleteCharAt(updateString.length() - 1); // Remove last ,
		updateString.append(addKeys(keys));
		//https://www-01.ibm.com/support/docview.wss?uid=swg21676715
		updateString.append(" WITH NONE ");
		
		logger.debug("updateString="+updateString.toString());
		logger.debug("debugFieldValue="+debugFieldValue.toString());
		
		try {
			ret = jdbcTemplate.update(updateString.toString(), values);
		} catch (DataAccessException e) { //RuntimeException
			logger.error("Error:", e);
			logger.error("Error, string="+updateString.toString());
			logger.error("debugFieldValue="+debugFieldValue.toString());
			throw e;
		}
		
		if (ret != 1) {
			t = null;
		}		
		
		return t;

	}
	
	private String addKeys(Map<String, Object> keys) {
		StringBuilder whereKeysString = new StringBuilder();
		if ((keys != null) && !keys.isEmpty()) {
			whereKeysString.append(" where ");
			for (final Iterator<Map.Entry<String, Object>> it = keys.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() instanceof Boolean) {
					whereKeysString.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" ");
				} else {
					if (entry.getValue() instanceof Number) {
						whereKeysString.append(entry.getKey()).append(" = ").append(entry.getValue());
					} else {
						whereKeysString.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
					}
				}
				if (it.hasNext()) {
					whereKeysString.append(" and ");
				}
			}
		}
		
		return whereKeysString.toString();

	}

	@Override
	public List<T> findAll(String sql, RowMapper<T> mapper, Object... args) {
		return jdbcTemplate.query(sql, mapper, args);
	}
	
	/** 
	 * Special case to avoid all columns been updated. Only the counter.
	 * The special case of this method is that the counter column to increase is also the key to the table.
	 * The counter returned will be ready to use in a specific target table...
	 * 
	 * @param idName the column of id field
	 * @param value	the original value (before adding the value of 1)
	 * @return
	 */
	public int updateCounterColumn(String idName, Integer value) {
		int ret = 0;
		int newSeed = value+1;
		//IDao dao = (IDao) t;
		//logger.debug("update:IDao="+ReflectionToStringBuilder.toString(dao));
		
		StringBuilder debugFieldValue = new StringBuilder();
		StringBuilder updateString = new StringBuilder("UPDATE ");
		updateString.append(tableName);
		updateString.append(" SET " + idName + "= " + newSeed);
		updateString.append(" WHERE " + idName + " = " + value );
		//System.out.println(updateString.toString());
		logger.debug("updateString CNFF counter="+updateString.toString());
		//logger.debug("debugFieldValue="+debugFieldValue.toString());
		
		try {
			ret = jdbcTemplate.update(updateString.toString());
		} catch (DataAccessException e) { //RuntimeException
			//e.printStackTrace();
			logger.error("Error:", e);
			logger.error("Error, string="+updateString.toString());
			logger.error("debugFieldValue="+debugFieldValue.toString());
			throw e;
		}
		
		if (ret != 1) {
			ret = -1;
		}		
		
		return ret;

	}


	private JdbcTemplate jdbcTemplate = null;                                                            
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}          
	public JdbcTemplate getJdbcTemplate() {return this.jdbcTemplate;}

}
