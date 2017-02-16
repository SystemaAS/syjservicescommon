package no.systema.jservices.common.dao.services;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.IDao;

/**
 * This class is taking av {@link IDao} as argument. Delivering some convenience methods on Dao, just extend this class for your use case.
 * Dao must represent table and columnname as is in database.
 * 
 * @author Fredrik Möller
 * @date Jan 18, 2017
 *
 * @param <T>, A dao implementing {@link IDao}
 */
public class GenericDaoServiceImpl<T> implements GenericDaoService<T>{
	private static final Logger logger = Logger.getLogger(GenericDaoServiceImpl.class.getName());
	private Class<T> type;
	private String tableName;
	private String tableAlias;
	private GenericObjectMapper mapper;

	public GenericDaoServiceImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
		tableName = type.getSimpleName().substring(0, type.getSimpleName().length() - 3);
		tableAlias = tableName.substring(0, 3);  //all good things are three..
		try {
			mapper = new GenericObjectMapper((IDao) type.newInstance());
		} catch (InstantiationException e) {
			logger.info("Error:",e);
		} catch (IllegalAccessException e) {
			logger.info("Error:",e);
		}
	}

	@Override
	public List<T> findAll(Map<String, Object> params) {
	    StringBuilder queryString = new StringBuilder("SELECT * from ");
	    queryString.append(tableName);
		queryString.append(this.getQueryClauses(params, null));
	    
	    return jdbcTemplate.query(queryString.toString(), mapper);
	}
	
	@Override
	public List<T> findAllInFirma(Map<String, Object> params) {
	    StringBuilder queryString = new StringBuilder("SELECT ").append(tableAlias).append(".* from ");
	    queryString.append(tableName).append(" ").append(tableAlias).append(", firm f ");
	    queryString.append("where ");
	    queryString.append(tableAlias).append(".firma=").append("f.fifirm ");
		queryString.append(this.getQueryClausesInFirma(params, null));
	    
	    return jdbcTemplate.query(queryString.toString(), mapper);
	}

	
	@Override
	public T findInFirma(Object id) {
		IDao dao = (IDao )id;
		Map<String, Object> params = dao.getKeys();
		List<T> list =findAllInFirma( params) ;
		if (list.size() ==1) {
			return list.get(0);
		}
		return null;
	}
	

	@Override
	public boolean existInFirma(Object id) {
		T t = findInFirma(id);
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
	    int count = jdbcTemplate.queryForInt(queryString.toString());
		return count;
	}         	
		
	@Override
	public int countAll(Map<String, Object> params) {
		StringBuilder queryString = new StringBuilder("SELECT count(*) from ");
		queryString.append(tableName);
		queryString.append(this.getQueryClauses(params, null));
		int count = jdbcTemplate.queryForInt(queryString.toString());
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
						queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
					} else {
						queryString.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
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
				queryString.append(tableAlias).append(".");

				if (entry.getValue() instanceof Boolean) {
					queryString.append(entry.getKey()).append(" = ").append(entry.getValue()).append(" ");
				} else {
					if (entry.getValue() instanceof Number) {
						queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
					} else {
						queryString.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
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
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public void delete(Object id) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public T find(Object id) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public T update(T t) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public List<T> findAll(String sql, RowMapper<T> mapper, Object... args) {
		return jdbcTemplate.query(sql, mapper, args);
	}


	private JdbcTemplate jdbcTemplate = null;                                                            
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}          
	public JdbcTemplate getJdbcTemplate() {return this.jdbcTemplate;}

}
