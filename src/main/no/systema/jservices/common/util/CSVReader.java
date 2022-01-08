package no.systema.jservices.common.util;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.*;

/**
 * This class takes a csv-file and parse lines into record
 * 
 * @author fredrikmoller
 * @date 2019-01-21
 *
 * @param <T> Output Object
 */
public class CSVReader<T> {
	private static final Logger logger = LoggerFactory.getLogger(CSVReader.class.getName());
	
	private Map<String, String> mappedNames;
	private CSVFormat format;
	
	/**
	 * Default constructor, mapping between cvs and object need to be same.
	 */
	public CSVReader() {}
	
	/**
	 * If cvs-labels do not correspond to record object <T>
	 * a Map with other name can be provided.
	 * 
	 * {@linkplain CSVFormat} is DEFAULT
	 * 
	 * @param mappedNames
	 */
	public CSVReader(Map<String, String> mappedNames) {
		this.mappedNames = mappedNames;
	}	

	/**
	 * If cvs-labels do not correspond to record object <T>
	 * a Map with other name can be provided. <br>
	 * 
	 * {@linkplain CSVFormat} can be set
	 * 
	 * @param mappedNames
	 * @param format 
	 */
	public CSVReader(Map<String, String> mappedNames, CSVFormat format) {
		this.mappedNames = mappedNames;
		this.format = format;
	}	
	
	
	/**
	 * On a provide Reader, e.g referencing a file and the target object a List of target objects is created.
	 * 
	 * @param clazz
	 * @param reader
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<T> getList(Class clazz, Reader reader) throws InstantiationException, IllegalAccessException {
        CSVParser csvParser;
        List<T> returnList = new ArrayList<T>();

        try {

			csvParser = new CSVParser(reader, format
	                .withFirstRecordAsHeader()
	                .withIgnoreHeaderCase()
	                .withTrim());
	
	        for (CSVRecord csvRecord : csvParser) {
	
	        	returnList.add(mapRow(csvRecord, clazz));
        	
	        }			
			
			
		} catch (IOException e) {
			logger.error("Error:", e);
		} catch (SQLException e) {
			logger.error("Error:", e);
		}
 
        return returnList;
		
	}
	
	public T mapRow(CSVRecord csvRecord, Class clazz) throws SQLException, InstantiationException, IllegalAccessException {
		T obj = (T) clazz.newInstance();
		
		try {

			Class cl = Class.forName(obj.getClass().getCanonicalName());
			Field[] fields = cl.getDeclaredFields();
			List<Field> list = Arrays.asList(fields);
			String name, mappedName = null;
			for (Field field : list) {
				if (field.getType() != String.class) {
					logger.info("Only type String.class is supported, type="+field.getType());
					break;
				}
	
				name = (String) field.getName();
				if (mappedNames != null) {
					name = mappedNames.get(name);
				}

				try {
					field.setAccessible(true);
					field.set(obj, csvRecord.get(name));
				} catch (Exception e) {
					// Usually when no column matches the JavaBean property...
					logger.info(e.getMessage() + e.toString() + "name="+name);
					continue;
				}
			}
		} catch (Exception e) {
			e.toString();
			logger.info(e.getMessage() + e.toString());
		}

		return obj;
	}
	
	private List<String> getHeaders(Class dao) {
		List<String> csvRecord = new ArrayList<String>();
		Class<?> recordClazz = dao;
		
		try {
			for (Method method : recordClazz.getDeclaredMethods()) {
				String methodName = method.getName();
				if (methodName.startsWith("get")) {
					String field = method.getName().replace("get", "").toLowerCase();
					if (!"keys".equals(field)) {
						csvRecord.add(field);
					}
				}
			}
		} catch (Throwable e) {
			logger.error("Error:", e);
		}

		return csvRecord;
	}		
	
	
}
