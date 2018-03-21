package com.backend.restbackend.dao;

import java.util.List;

import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.dto.User1;
import com.backend.restbackend.user.dto.UserAddress;
import com.backend.restbackend.user.dto.User_Data;
import com.backend.restbackend.user.model.UpdateRequest;
import com.backend.restbackend.user.model.UpdateResponseModel;
import com.backend.restbackend.user.model.UpdateUserShopRequest;
import com.backend.restbackend.user.model.UpdateUserShopResponse;
import com.backend.restbackend.user.model.UserRequest;


/**
 * 
 * @author saddam
 *
 */

public interface UserDAO {
	
	
	/**
	 * crete method for geting list of shopid for add shopkeeper into database
	 * ***/
	
	 List<User> listOfShop(UserRequest userRequest);
	
	 
	 /**
	  * Add new Shop Keeper Details
	  * **/
	 boolean addShop(UserRequest userRequest);
	
	/**
	 * Update user and shopkeeper update 
	 * 
	 * **/
	
	 UpdateUserShopResponse updateUserShop(UpdateUserShopRequest updateRequest);
	// Address updateUserShop(UpdateUserShopRequest updateRequest);
	

	boolean register(User1 user);

	// List of product
	List<User1> list();

	
	
	// save image to database usign blob file
		//Test saveImage(Test test);
	
	//Show list of user
	
	List<UserAddress> listOfUser(UserRequest userRequest);
	
	
	
	/**
	 * For only one user details 
	 * **/
	
	UpdateResponseModel userDetailByShopIdAndUserId(UpdateRequest updateRequest);
	
	
	/**
	 * Getting all user details using shopID
	 * ***/
	
	List<UpdateResponseModel> userDetailsByShopID(UpdateRequest updateRequest);
	
}
