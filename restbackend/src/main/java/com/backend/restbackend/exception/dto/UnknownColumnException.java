/**
 * 
 */
package com.backend.restbackend.exception.dto;

/**
 * @author Sk Saddam Hosan
 */
public class UnknownColumnException extends RuntimeException {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownColumnException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
