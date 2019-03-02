package com.backend.restbackend.user.model;

import java.util.List;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.User_Data;

public class UserDetailsResponse extends SuccResponse {

	
	List <User_Data> userData;

	public List<User_Data> getUserData() {
		return userData;
	}

	public void setUserData(List<User_Data> userData) {
		this.userData = userData;
	}
	
	
}
