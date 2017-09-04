package org.cic.template.web.exceptionhandle;

import org.apache.log4j.Logger;
import org.cic.template.web.util.BaseAction;

/**
 * 
 * @author kait
 *
 */
public class ExceptionHandleAction extends BaseAction  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ExceptionHandleAction.class);
	
	private final String NO_LOGIN = "noLogin";
	private final String NO_PERMISSION = "noPermission";
	private final String NO_SURE_IDENTITY = "noSureIdentity";
	private final String REDIRECT_URL = "redirectUrl";
    
	private String statusResult;
	
	public enum ExceptionType {
		noLogin, noPermission, noSureIdentity, redirectUrl
    }
	
	public String showException()throws Exception{
		
		return this.getExceptionType(statusResult);
	}

	public String getExceptionType(String type) {
		
        if (ExceptionType.noLogin.name().equals(type)) {
        	return ExceptionType.noLogin.toString();
        	
        } else if (ExceptionType.noPermission.name().equals(type)) {
        	return ExceptionType.noPermission.toString();
        	
        } else {
        	return ExceptionType.noPermission.toString();
        }
    }
	
	public String getStatusResult() {
		return statusResult;
	}


	public void setStatusResult(String statusResult) {
		this.statusResult = statusResult;
	}
	
	

	
}