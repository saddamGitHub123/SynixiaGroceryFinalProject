/**
 * 
 */
package com.backend.restbackend.dao;

import com.backend.restbackend.exception.dto.BackEndSQLException;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.model.UserResponseModel;

/**
 * @author Sk Saddam Hosan
 *
 */
public interface LoginDAO {
	
	/**
	 * login validation 
	 * **/
	
	UserResponseModel checkLogin(User loginuser) throws BackEndSQLException;

}
