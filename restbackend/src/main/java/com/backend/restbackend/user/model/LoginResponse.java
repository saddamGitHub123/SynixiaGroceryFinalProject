/**
 * 
 */
package com.backend.restbackend.user.model;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.User;

/**
 * @author Sk Saddam Hosan
 *
 */
public class LoginResponse extends SuccResponse{
	
	public UserResponseModel Data;

	/**
	 * @return the data
	 */
	/*public User getData() {
		return Data;
	}*/

	/**
	 * @param data the data to set
	 */
	public void setData(UserResponseModel data) {
		Data = data;
	}


	
	
	

}
