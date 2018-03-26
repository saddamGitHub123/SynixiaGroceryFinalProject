/**
 * 
 */
package com.backend.restbackend.exception.dto;

/**
 * @author Sk Saddam Hosan
 */
public class BackEndSQLException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BackEndSQLException(String message, Throwable cause) {
        super(message, cause);
    }

}
