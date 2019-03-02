/**
 * 
 */
package com.backend.restbackend.user.model;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.User_Data;

/**
 * @author Sk Saddam Hosan
 *
 */
public class UpdateUserShopResponse extends SuccResponse {
	
	User_Data userData;
	
	public UpdateUserShopResponse() {

	}

	

	/**
	 * @param userData
	 */
	public UpdateUserShopResponse(User_Data userData) {
		super();
		this.userData = userData;
	}

	/**
	 * @return the userData
	 */
	public User_Data getUserData() {
		return userData;
	}

	/**
	 * @param userData the userData to set
	 */
	public void setUserData(User_Data userData) {
		this.userData = userData;
	}
	
	

}
