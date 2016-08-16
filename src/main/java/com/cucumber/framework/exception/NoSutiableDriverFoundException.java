package com.cucumber.framework.exception;

/**
 * @author rsr
 *
 * Jul 22, 2016
 */
public class NoSutiableDriverFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSutiableDriverFoundException(String message) {
		super(message);
	}
	
	public NoSutiableDriverFoundException(){
		this("");
	}

}
