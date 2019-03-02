package com.backend.restbackend.user.model;
import com.backend.restbackend.user.dto.User_Data;

import com.backend.restbackend.common.SuccResponse;


public class UpdateResponse extends SuccResponse{
	
	User_Data userData;

	public User_Data getUserData() {
		return userData;
	}

	public void setUserData(User_Data userData) {
		this.userData = userData;
	}

	public UpdateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
