/**
 * 
 */
package com.backend.restbackend.dao;

import com.backend.restbackend.user.dto.User;

/**
 * @author Sk Saddam Hosan
 *
 */
public interface LoginDAO {
	
	/**
	 * login validation 
	 * **/
	
	User checkLogin(User loginuser);

}
