package no.systema.jservices.common.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.jdbc.core.RowMapper;

import no.systema.jservices.common.dto.ExludeMapping;

/**
 * This class transform as ResultSet into IDao
 * 
 * @author Fredrik Möller
 * @date Nov 21, 2016
 * 
 */
@SuppressWarnings("rawtypes")
public class GenericObjectMapper implements RowMapper {
	private static Logger logger = Logger.getLogger(GenericObjectMapper.class.getName());
	private IDao dao = null;
	private String className = null;

	/**
	 * This constructor passes the actual dao instanse to reflection-iteration
	 * on fields.
	 * 
	 * Note: Only simple structure is supported, no composite is managed. That must be done outside rowmapper
	 * 
	 * @param daoObj, the actual dao
	 */
	public GenericObjectMapper(IDao daoObj) {
		this.className = daoObj.getClass().getName();
	}

	public IDao mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			Class<?> clazz = Class.forName(className);
			dao = (IDao) clazz.newInstance();

			Class cl = Class.forName(dao.getClass().getCanonicalName());
			Field[] fields = cl.getDeclaredFields();
			List<Field> list = Arrays.asList(fields);
			String name = null;
			String value = null;
			int intValue;
			BigDecimal bigdecimalValue;
			for (Field field : list) {
				name = (String) field.getName();
				if (field.isAnnotationPresent(ExludeMapping.class)) {
					continue;
				}
				if (field.getType() == String.class) {
					try {
						field.setAccessible(true);
						value = rs.getString(name);
						if (value != null) {
							field.set(dao, value.trim());
						}
					} catch (Exception e) {
						// Usually when no column matches the JavaBean property...
						logger.info(e.getMessage() + e.toString() + "name="+name);
						continue;
					}
				} else if (field.getType() == Integer.class) {		
					try {
						field.setAccessible(true);
						intValue = rs.getInt(name);
						field.set(dao, intValue);
					} catch (Exception e) {
						// Usually when no column matches the JavaBean property...
						logger.info(e.getMessage() + e.toString() + "name="+name);
						continue;
					}	
				} else if (field.getType() == int.class) {		
					try {
						field.setAccessible(true);
						intValue = rs.getInt(name);
						field.set(dao, intValue);
					} catch (Exception e) {
						// Usually when no column matches the JavaBean property...
						logger.info(e.getMessage() + e.toString() + "name="+name);
						continue;
					}	
				} else if (field.getType() == BigDecimal.class) {		
					try {
						field.setAccessible(true);
						bigdecimalValue = rs.getBigDecimal(name);
						field.set(dao, bigdecimalValue);
					} catch (Exception e) {
						// Usually when no column matches the JavaBean property...
						logger.info(e.getMessage() + e.toString() + "name="+name);
						continue;
					}					
				} else {
					//logger.info("Type="+field.getType()+ " not supported.");
					break;				
				}
				
			}
		} catch (Exception e) {
			e.toString();
			logger.info(e.getMessage() + e.toString());
		}

		return dao;
	}

}
