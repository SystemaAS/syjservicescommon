package no.systema.jservices.common.util;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
	public List<File> getValidFilesInDirectory(String pathString, String excludeDir01, String excludeDir02) {
			List<File> retval = new ArrayList<File>();
			// A local class (a class defined inside a block, here a method).
			class MyFilter implements FileFilter {
				@Override
				public boolean accept(File file) {
				return !file.isHidden() && !file.getName().contains(excludeDir01) && !file.getName().contains(excludeDir02);
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
		  	}*/
			return retval;
	}
	/**
	 * moves or copies a file to a destination
	 * @param fileAbsolutePath
	 * @param targetDirectory
	 * @param move
	 * @throws Exception
	 */
	public void moveCopyFiles(String fileAbsolutePath, String targetDirectory, boolean move) throws Exception{
		if(move){
			System.out.println(Paths.get(fileAbsolutePath) + " " + Paths.get(targetDirectory + Paths.get(fileAbsolutePath).getFileName().toString()));
			Path temp = Files.move( Paths.get(fileAbsolutePath), Paths.get(targetDirectory + Paths.get(fileAbsolutePath).getFileName().toString()));
		}else{
			System.out.println(Paths.get(fileAbsolutePath) + " " + Paths.get(targetDirectory + Paths.get(fileAbsolutePath).getFileName().toString()));
			Path temp = Files.copy( Paths.get(fileAbsolutePath), Paths.get(targetDirectory + Paths.get(fileAbsolutePath).getFileName().toString()));
		}
	}
}
