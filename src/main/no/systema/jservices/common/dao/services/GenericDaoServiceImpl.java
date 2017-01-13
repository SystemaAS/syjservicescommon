package no.systema.jservices.common.dao.services;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.IDao;

public class GenericDaoServiceImpl<T> implements GenericDaoService<T>{

	private Class<T> type;
	private String tableName;
	private GenericObjectMapper mapper;

	public GenericDaoServiceImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
		tableName = type.getSimpleName().substring(0, type.getSimpleName().length() - 3);
		try {
			//TODO: Review the Mapper impl, make it full genreric
			mapper = new GenericObjectMapper((IDao) type.newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
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
						// string equality
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
