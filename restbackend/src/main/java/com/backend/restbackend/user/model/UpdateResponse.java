package com.backend.restbackend.user.model;
import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.User_Data;

public class UpdateResponse extends SuccResponse{
	
	UpdateResponseModel userData;

	public UpdateResponseModel getUserData() {
		return userData;
	}

	public void setUserData(UpdateResponseModel userData) {
		this.userData = userData;
	}

	public UpdateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
