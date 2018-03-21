/**
 * 
 */
package com.backend.restbackend.user.model;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.Address;

/**
 * @author Sk Saddam Hosan
 *
 */
public class UserResponse extends SuccResponse {
	
	
	UserResponseModel userDetails ;
	Address userAddress;
	
	UserResponse(){}
	public UserResponse(UserResponseModel userDetails, Address userAddress) {
		super();
		this.userDetails = userDetails;
		this.userAddress = userAddress;
	}
	public UserResponseModel getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserResponseModel userDetails) {
		this.userDetails = userDetails;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	
	

}
