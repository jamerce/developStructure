/*
 * ==========================================
 * 
 * ==========================================
 */
package org.cic.template.web.util;

import java.io.FileInputStream;

/**
 * 
 * @author kait
 *
 */
public class DownloadFileVo {

	private String fullFilePath; //filePath + fileName
	private String filePath;
	private String fileName;
	private FileInputStream fileInputStream;
	
	public String getFullFilePath() {
    	return fullFilePath;
    }
	public void setFullFilePath(String fullFilePath) {
    	this.fullFilePath = fullFilePath;
    }
	public String getFilePath() {
    	return filePath;
    }
	public void setFilePath(String filePath) {
    	this.filePath = filePath;
    }
	public String getFileName() {
    	return fileName;
    }
	public void setFileName(String fileName) {
    	this.fileName = fileName;
    }
	public FileInputStream getFileInputStream() {
    	return fileInputStream;
    }
	public void setFileInputStream(FileInputStream fileInputStream) {
    	this.fileInputStream = fileInputStream;
    }
	
	
}
