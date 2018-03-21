/**
 * 
 */
package com.backend.restbackend.user.model;

import com.backend.restbackend.common.SuccResponse;

/**
 * @author Sk Saddam Hosan
 *
 */
public class UpdateUserShopResponse extends SuccResponse {
	
	UpdateResponseModel userData;
	
	public UpdateUserShopResponse() {

	}

	public UpdateUserShopResponse(UpdateResponseModel userData) {
		super();
		this.userData = userData;
	}

	public UpdateResponseModel getUserData() {
		return userData;
	}

	public void setUserData(UpdateResponseModel userData) {
		this.userData = userData;
	}

	

	
	

}
