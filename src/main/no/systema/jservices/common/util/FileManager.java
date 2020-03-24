package no.systema.jservices.common.util;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * File manager for listing purposes
 * 
 * @author oscardelatorre
 * @date 2020-Mars
 */
public class FileManager {
	public static final boolean MOVE_FLAG = true;
	public static final boolean COPY_FLAG = false;
	public static final boolean TIME_STAMP_SUFFIX_FLAG = true;
	
	
	DateFormat dateFormat = new SimpleDateFormat("_yyyymmdd_HHmmss_");
	
	/**
	 * Creates path if it does not exist
	 * @param path
	 */
	public void secureTargetDir(String path){
		if(Files.exists(Paths.get(path))){
			//OK
		}else{
			new File(path).mkdir();
		}
		
	}
	
	/**
	 * Only valid directory and valid files. No recursive sub-directories
	 * @param pathString
	 * @return
	 */
	public List<File> getValidFilesInDirectory(String pathString) {
			List<File> retval = new ArrayList<File>();
			//System.out.println(pathString);
			// A local class (a class defined inside a block, here a method).
			class MyFilter implements FileFilter {
				@Override
				public boolean accept(File file) {
					//only valid files in root directory (no subdirectories )	
					return !file.isHidden() && file.isFile();
				}
			}
			File directory = new File(pathString);
			File[] files = directory.listFiles(new MyFilter());
			if(files!=null && files.length > 0){
				retval = Arrays.asList(files);
			}
			/*DEBUG 
		  	for (File fileLoop : files) {
		    	System.out.println(fileLoop.getAbsolutePath());
		  	}
		  	*/
			return retval;
	}
	/**
	 * moves or copies a file to a destination
	 * @param fileAbsolutePath
	 * @param targetDirectory
	 * @param move
	 * @throws Exception
	 */
	public void moveCopyFiles(String fileAbsolutePath, String targetDirectory, boolean move, boolean timeStampSuffixFlag) throws Exception{
		final long now = Clock.systemUTC().millis();
		Date timeStamp = new Date(now);
		String timeStampSuffixStr = this.dateFormat.format(timeStamp);
		//add time-stamp to target file name if applicable
		String targetFile = Paths.get(fileAbsolutePath).getFileName().toString();
		if(timeStampSuffixFlag){ 
			targetFile = targetFile + timeStampSuffixStr + timeStamp.getTime(); 
		}
		
		if(move){
			System.out.println(Paths.get(fileAbsolutePath) + " " + Paths.get(targetDirectory + Paths.get(targetFile)));
			Path temp = Files.move( Paths.get(fileAbsolutePath), Paths.get(targetDirectory + Paths.get(targetFile)));
		}else{
			System.out.println(Paths.get(fileAbsolutePath) + " " + Paths.get(targetDirectory + Paths.get(targetFile)));
			Path temp = Files.copy( Paths.get(fileAbsolutePath), Paths.get(targetDirectory + Paths.get(targetFile)));
		}
	}
	/**
	 * 
	 * @param fileAbsolutePath
	 * @param targetDirectory
	 * @param move
	 * @param newFileName
	 * @param timeStampSuffixFlag
	 * @throws Exception
	 */
	public void moveCopyFiles(String fileAbsolutePath, String targetDirectory, boolean move, String newFileName, boolean timeStampSuffixFlag) throws Exception{
		final long now = Clock.systemUTC().millis();
		Date timeStamp = new Date(now);
		String timeStampSuffixStr = this.dateFormat.format(timeStamp);
		//add time-stamp to target file name if applicable
		if(timeStampSuffixFlag){ newFileName = newFileName + timeStampSuffixStr + timeStamp.getTime(); }
		
		if(move){
			System.out.println(Paths.get(fileAbsolutePath) + " " + Paths.get(targetDirectory + Paths.get(newFileName)));
			Path temp = Files.move( Paths.get(fileAbsolutePath), Paths.get(targetDirectory + Paths.get(newFileName)));
		}else{
			System.out.println(Paths.get(fileAbsolutePath) + " " + Paths.get(targetDirectory + Paths.get(newFileName)));
			Path temp = Files.copy( Paths.get(fileAbsolutePath), Paths.get(targetDirectory + Paths.get(newFileName)));
		}
	}
}
