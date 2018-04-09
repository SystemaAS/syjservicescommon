package no.systema.jservices.common.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Log4jUtils {

	
	/**
	 * Simple formatter for Files in catalina.home/logs/
	 * 
	 * @param fileName
	 * @return content in File
	 * @throws IOException
	 */
	public static String getLog4jData(String fileName) throws IOException {
		String logPath = System.getProperty("catalina.home") + "/logs/";
		File fileToView = FileUtils.getFile(logPath + fileName);
		
		return FileUtils.readFileToString(fileToView);
		
	}
	
}
