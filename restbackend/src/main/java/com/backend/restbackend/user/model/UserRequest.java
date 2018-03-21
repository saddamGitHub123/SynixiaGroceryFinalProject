/**
 * 
 */
package com.backend.restbackend.user.model;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.Address;
import com.backend.restbackend.user.dto.User;

/**
 * @author Sk Saddam Hosan
 *
 */
public class UserRequest extends SuccResponse{
	
	private String Shop_ID;
	
	User userDetails;
	Address userAddress;

	public UserRequest() {}
	
	/**
	 * @param shop_ID
	 * @param userDetails
	 * @param userAddress
	 */
	public UserRequest(String shop_ID, User userDetails, Address userAddress) {
		super();
		Shop_ID = shop_ID;
		this.userDetails = userDetails;
		this.userAddress = userAddress;
	}
	
	//@JsonIgnore
	public String getShop_ID() {
		return Shop_ID;
	}
	public void setShop_ID(String shop_ID) {
		Shop_ID = shop_ID;
	}
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	
	
	

}
