package com.backend.restbackend.user.model;

import java.util.List;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.User_Data;

public class UserDetailsResponse extends SuccResponse {

	
	List <UpdateResponseModel> userData;

	public List<UpdateResponseModel> getUserData() {
		return userData;
	}

	public void setUserData(List<UpdateResponseModel> userData) {
		this.userData = userData;
	}
	
	
}
