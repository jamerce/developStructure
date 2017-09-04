/*
 * 
 */
package org.cic.template.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * @author kait
 *
 */
public class PflagFileUtils {
	private static final Logger log = Logger.getLogger(PflagFileUtils.class);

	/**
	 * 取得副檔案名稱
	 * @param fileName
	 * @return
	 */
	public static String getExtName(String fileName){
		int len = fileName.lastIndexOf(".");
		if((len+1) == fileName.length()){
			len = fileName.length();
		}else{
			len = len+1;
		}
		return fileName.substring(len);
	}
	
	/**
	 * 
	 * @param newFileName
	 * @param oriFileName
	 * @param theExt - 指定副檔名
	 * @return
	 */
	public static String getConvertFileName(String newFileName, String oriFileName, String theExt){
		
		String ext = "";
		
		if(StringUtils.trimToNull(theExt) == null){
			//依據上傳的檔案其副檔名是什麼，就給什麼
			ext = oriFileName.substring(oriFileName.lastIndexOf("."));
		}else{
			ext = theExt;
		}
		
		String fileName = newFileName + "." + ext;
		return fileName;
	}
	
	/**
	 * 
	 * @param b
	 * @param outputFile
	 * @return
	 */
	public static File getFileFromBytes(byte[] b, String outputFile){
		BufferedOutputStream stream = null;
		File file = null;
		 try {
			 file = new File(outputFile);
			 FileOutputStream fstream = new FileOutputStream(file);
			 stream = new BufferedOutputStream(fstream);
			 stream.write(b);
			 
		 } catch (Exception e){
			 e.printStackTrace();
		 } finally {
			 if (stream != null) {
				 try{
					 stream.close();
				 } catch (IOException e1) {
					 e1.printStackTrace();
				 }
			 }
		 }
		 
		 return file;
	}
	
	/**
	 * 
	 * @param rootBeginPath
	 * @param filePathArray
	 * @throws Exception
	 */
	public static void createFolder(String rootBeginPath, String filePathArray[])throws Exception{

		if(filePathArray != null){
			String beginPath = "";
			for (String tmpPath : filePathArray) {
				beginPath += tmpPath + File.separator;
				makeFolder(rootBeginPath, beginPath);
	        }
		}
		
	}
	
	/**
	 * 
	 * @param beginPath
	 * @param folderName
	 */
	public static void makeFolder(String beginPath, String folderName){
		String newPath = beginPath += File.separator + folderName;
		File dirs = null;
		try {
				
			dirs = new File(newPath);
			if (!dirs.exists()) {
				dirs.mkdirs();
				dirs.setExecutable(true,false);
				dirs.setReadable(true,false);

				execCommand("/bin/chmod 775 -R " + newPath);
			}
							
		} catch (Exception e) {
            log.error(e.toString());
            //throw e;
            
        } finally{
        	dirs = null;
        }
	}
	
	/**
	 * 
	 * @param saveFilePath
	 * @param fileName
	 * @param fileByte
	 * @throws IOException
	 */
	public static void saveFile(String saveFilePath, String fileName, byte[] fileByte) throws IOException {

		String fullFilePath = "";
		
		FileOutputStream fos = null;
		BufferedOutputStream stream = null;
		try {
			File tmp = new File(saveFilePath);
			if (!tmp.exists()) {
				tmp.mkdirs();
				
				execCommand("/bin/chmod 775 -R " + saveFilePath);
			}
			tmp = null;

			fullFilePath = saveFilePath + File.separator + fileName;
			fos = new FileOutputStream(fullFilePath);

			stream = new BufferedOutputStream(fos);
            stream.write(fileByte);
			
		} catch (IOException e) {
			log.error(e);
			throw e;
		} finally{
			if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                	log.error(e);
                }
            }
			 
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					log.error(e);
				}
			}
			
			if(fullFilePath != null){
				execCommand("/bin/chmod 775 -R *.* " + fullFilePath);
			}
		}
	}
	
	/**
	 * 
	 * @param saveFilePath
	 * @param fileName
	 * @param srcFile
	 * @throws IOException
	 */
	public static void saveFile(String saveFilePath, String fileName, File srcFile) throws IOException {

		try {
			File tmp = new File(saveFilePath);
			if (!tmp.exists()) {
				tmp.mkdirs();
				
				execCommand("/bin/chmod 775 -R " + saveFilePath);
			}
			tmp = null;

			String fullFilePath = saveFilePath + File.separator + fileName;
			FileOutputStream fos = new FileOutputStream(fullFilePath);
			FileInputStream fis = new FileInputStream(srcFile);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			
			fos.close();
			fis.close();
			
			execCommand("/bin/chmod 775 -R *.* " + fullFilePath);
			
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * 
	 * @param data
	 * @param saveFilePath
	 * @param fileName
	 * @throws IOException
	 */
	public static void saveString2File(String data, String saveFilePath, String fileName) throws IOException {
		try {
			File tmp = new File(saveFilePath);
			if (!tmp.exists()) {
				tmp.mkdirs();
				
				execCommand("/bin/chmod 775 -R " + saveFilePath);
			}
			tmp = null;

			String fullFilePath = saveFilePath + File.separator + fileName;
			File file = new File(fullFilePath);
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.delete();
				file.createNewFile();
			}
			file.setExecutable(true,false);
			file.setReadable(true,false);
			file.setWritable(true,false);			
			
			FileOutputStream fos = new FileOutputStream(file, false);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			byte[] bytea = data.getBytes();
			bos.write(bytea);
			bos.flush();
			fos.close();

			execCommand("/bin/chmod 775 -R *.* " + fullFilePath);
			
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}
	
	public static String getFileExtName(String filename) {
		if(!filename.contains("."))
			return "";
		return filename.substring(filename.lastIndexOf("."),filename.length());
	}
	
	public static String getFileName(String filename){
		if(!filename.contains("."))
			return filename;
		return filename.substring(0,filename.lastIndexOf("."));
	}
	
	/**
	 * 組合檔案路徑
	 * @param rootBeginPath
	 * @param filePathArray
	 * @return
	 */
	public static String combineFullFilePath(String rootBeginPath, String filePathArray[]){
		String beginPath = "";
		for (String tmpPath : filePathArray) {
			beginPath += tmpPath + File.separator;
        }
		
		return rootBeginPath + File.separator + beginPath;
	}
	
	/**
	 * 先暫時把功能mark起來
	 * @param command
	 */
	private static void execCommand(String command){
		
		/*Process proc;
		try {
			proc = Runtime.getRuntime().exec(command);
			
			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "Error");           
			StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "Output");
			errorGobbler.start();
			outputGobbler.start();
			
		} catch (IOException e) {
			log.error(e);
		}*/
	}
}
