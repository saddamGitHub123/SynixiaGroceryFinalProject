/**
 * 
 */
package com.backend.restbackend.exception.model;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.exception.dto.ExceptionClassTest;

/**
 * @author Sk Saddam Hosan
 */
public class ExceptionThrowingModel extends SuccResponse{
	
	ExceptionClassTest exceptionClassTest;
	public ExceptionThrowingModel() {}

	public ExceptionThrowingModel(ExceptionClassTest exceptionClassTest) {
		super();
		this.exceptionClassTest = exceptionClassTest;
	}

	public ExceptionClassTest getExceptionClassTest() {
		return exceptionClassTest;
	}

	public void setExceptionClassTest(ExceptionClassTest exceptionClassTest) {
		this.exceptionClassTest = exceptionClassTest;
	}
	
	

}
