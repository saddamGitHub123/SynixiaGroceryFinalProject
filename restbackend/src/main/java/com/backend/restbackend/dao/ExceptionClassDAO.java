/**
 * 
 */
package com.backend.restbackend.dao;

import com.backend.restbackend.exception.dto.ExceptionClassTest;
import com.backend.restbackend.exception.dto.UnknownColumnException;

/**
 * @author Sk Saddam Hosan
 */
public interface ExceptionClassDAO {

	boolean save(ExceptionClassTest exceptionClassTest) throws UnknownColumnException;
}
