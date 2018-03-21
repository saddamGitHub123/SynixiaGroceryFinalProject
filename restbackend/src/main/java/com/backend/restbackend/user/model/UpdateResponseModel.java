package com.backend.restbackend.user.model;

import com.backend.restbackend.user.dto.Address;

public class UpdateResponseModel {
	
	private String Shop_ID;
	private String User_ID;
	private String Name;
	private String User_Name;
	private String Contact;
	private String Email;
	
	Address userAddress;
	
	public UpdateResponseModel() {}

	public UpdateResponseModel(String shop_ID, String user_ID, String name, String user_Name, String contact,
			String email, Address userAddress) {
		super();
		Shop_ID = shop_ID;
		User_ID = user_ID;
		Name = name;
		User_Name = user_Name;
		Contact = contact;
		Email = email;
		this.userAddress = userAddress;
	}

	public String getShop_ID() {
		return Shop_ID;
	}

	public void setShop_ID(String shop_ID) {
		Shop_ID = shop_ID;
	}

	public String getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	
	
	

}
