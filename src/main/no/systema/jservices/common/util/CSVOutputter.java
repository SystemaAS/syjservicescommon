package no.systema.jservices.common.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.*;

import no.systema.jservices.common.dao.IDao;

/**
 * This class takes a List of Objects and generate csv.
 * 
 * @author Fredrik Möller
 * @date May, 12, 2017
 */
public class CSVOutputter<T> {
	private static final Logger logger = LoggerFactory.getLogger(CSVOutputter.class.getName());

	/**
	 * Read all objects and create a String in csv format.
	 * 
	 * @param objects List of {@link IDao}
	 * @return String as csv records
	 */
	public String writeAsString(List<T> objects) {
		StringWriter stringWriter = new StringWriter();
		CSVPrinter csvFileprinter = null;
		try {
			for (T dao : objects) {
				if (csvFileprinter == null) {
					csvFileprinter = new CSVPrinter(stringWriter, CSVFormat.EXCEL);
					csvFileprinter.printRecord(getHeaders(dao));
				}
				
				List<String> cvsRecord = getPopulatedCvsRecord(dao);
				csvFileprinter.printRecord(cvsRecord);
			}

			csvFileprinter.flush();
			csvFileprinter.close();

		} catch (IOException e) {
			logger.error("Error when writing to StringWriter, error:", e);
		}

		return stringWriter.toString();
	}

	/**
	 * Read all objects and put then in the full path fileName.
	 * 
	 * @param fileName the full path filename
	 * @param objects List of {@link IDao}
	 */
	public void writeToCVSFile(String fileName, List<T> objects) {
		CSVPrinter csvFileprinter = null;
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			for (T dao : objects) {
				if (csvFileprinter == null) {
					csvFileprinter = new CSVPrinter(writer, CSVFormat.EXCEL);
					csvFileprinter.printRecord(getHeaders(dao));
				}
				
				List<String> cvsRecord = getPopulatedCvsRecord(dao);
				csvFileprinter.printRecord(cvsRecord);
			}

			csvFileprinter.flush();
			csvFileprinter.close();
			fileWriter.close();
			writer.close();

		} catch (IOException e) {
			logger.error("Error when writing to file, error:", e);
		}
	}
	
	private List<String> getPopulatedCvsRecord(T dao) {
		List<String> csvRecord = new ArrayList<String>();
		Class<?> recordClazz = dao.getClass();		
		Class<?> returnType = null;
		
		try {
			for (Method method : recordClazz.getDeclaredMethods()) {
				String methodName = method.getName();
				if (methodName.startsWith("get")) {
					returnType = method.getReturnType();
					if (returnType.equals(String.class)) {
						String value = (String) method.invoke(dao);
						if (value != null) {
							value = value.trim();
						}
						csvRecord.add(value);
					} else if (returnType.equals(int.class)) {
						int value = (Integer) method.invoke(dao);
						csvRecord.add(String.valueOf(value));
					}
				}
			}
		} catch (Throwable e) {
			logger.error("Error:", e);
		}

		return csvRecord;
	}
	
	private List<String> getHeaders(T dao) {
		List<String> csvRecord = new ArrayList<String>();
		Class<?> recordClazz = dao.getClass();
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
