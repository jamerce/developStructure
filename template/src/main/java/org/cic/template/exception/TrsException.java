package org.cic.template.exception;

public class TrsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errCde;

	public String getErrCde() {
		return errCde;
	}

	public void setErrCde(String errCde) {
		this.errCde = errCde;
	}

	public TrsException(String message) {
		super(message);
	}

	public TrsException(Throwable throwable) {
		super(throwable);
	}

	public TrsException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public TrsException(String errCde, String errMessage) {
		super(errMessage);
		this.errCde = errCde;
	
	}
	
	public TrsException(String errCde, String message,Throwable throwable) {
		super(message, throwable);
		this.errCde = errCde;
		
	}
	
	public String toString() {
	        String s = getClass().getName();
	        String message = getLocalizedMessage();
	        return (message != null) ? message: s;
	}
	
	

}
