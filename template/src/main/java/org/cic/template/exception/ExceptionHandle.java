/*
 * 2014-03-12 kait init
 */
package org.cic.template.exception;

import java.sql.SQLException;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * Exception 訊息處理器
 * @author kait
 *
 */
public class ExceptionHandle {

	/**
	 * 
	 * @param exceptionMsg
	 * @return
	 */
	public static String msgForPageView(String exceptionMsg){
		
		String processedMsg = exceptionMsg;
		
		if(exceptionMsg.indexOf("Exception:") != -1){
			processedMsg = exceptionMsg.substring(exceptionMsg.indexOf("Exception:")+10);
		}
		
		return processedMsg;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	public static String msgForPageView(Exception e){
		
		String exceptionMsg = "";
		if(e instanceof SQLException 
				|| e instanceof com.microsoft.sqlserver.jdbc.SQLServerException
				|| e instanceof org.springframework.jdbc.BadSqlGrammarException){
			exceptionMsg = "資料處理有誤，請待片刻再進行操作或聯絡客服中心，協助解決!";
		} else {
			exceptionMsg = e.toString();
		}
		
		if(exceptionMsg.indexOf("Exception:") != -1){
			exceptionMsg = exceptionMsg.substring(exceptionMsg.indexOf("Exception:")+10);
		}
		
		return exceptionMsg;
	}
}
