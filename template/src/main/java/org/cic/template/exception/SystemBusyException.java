package org.cic.template.exception;


public class SystemBusyException extends TrsException {

	
	private static final long serialVersionUID = -8814968322245538863L;

	
	public SystemBusyException() {
		super("系統忙碌中，請稍後再試");
	}

	/**
	 * @param message
	 */
	public SystemBusyException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SystemBusyException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SystemBusyException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemBusyException(String errCde, String errMessage) {
		super(errCde, errMessage);
	}
	
	public SystemBusyException(String errCde, String errMessage,Throwable cause) {
		super(errCde, errMessage,cause);
	}

}
