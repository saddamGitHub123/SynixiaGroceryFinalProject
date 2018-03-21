package com.backend.restapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.backend.restbackend.common.ApiErrors;
import com.backend.restbackend.common.JsonResponse;
import com.backend.restbackend.dao.UserDAO;
import com.backend.restbackend.user.dto.Address;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.dto.User_Data;
import com.backend.restbackend.user.model.UpdateRequest;
import com.backend.restbackend.user.model.UpdateResponse;
import com.backend.restbackend.user.model.UpdateResponseModel;
import com.backend.restbackend.user.model.UpdateUserShopRequest;
import com.backend.restbackend.user.model.UpdateUserShopResponse;
import com.backend.restbackend.user.model.UserDetailsResponse;
import com.backend.restbackend.user.model.UserRequest;
import com.backend.restbackend.user.model.UserResponse;
import com.backend.restbackend.user.model.UserResponseModel;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc
@RequestMapping(value ="/user")
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	/**
	 * Add user using shop_id and user details
	 * */
	
	@RequestMapping(value ="/add/details", method = RequestMethod.POST)
	public @ResponseBody UserResponse addUserDetails(@RequestBody UserRequest userRequest) {
		
		logger.debug("Entering addUserDetails() in user conroller ");
		try {	
	User user = userRequest.getUserDetails();
	Address address = userRequest.getUserAddress();
	UserResponse userResponse = null;
	UserResponseModel userResponseModel = null;
	
	//UserAddress userAddress= null;
	String Shop = "Shop_";
	String User = "User_";
	
	
	/**
	 * This is for ShopKeeper add the new Shopkeeper
	 * **/
	
	/**
	 * check  how many shopkeeper are exist in our database
	 * if not empty shopkeeper then add as 1st shopkeeper
	 * if exist some shopkeeper then add and create new shopkeeper 
	 * **/
	
	    if(userRequest.getShop_ID() == null || userRequest.getShop_ID().isEmpty()) {
	    	
	    	logger.debug(" Adding Shopkeeper into database ");
	    	
	    	//check how many uique shopid or get list of shopID from database
	    	List<User> shopList = userDAO.listOfShop(userRequest);
	    	
	    	// check user name ,phoner number and email already save into database or not
	    				for (int j = 0; j < shopList.size(); j++) {
	    					if (shopList.get(j).getUser_Name() == user.getUser_Name() ||
	    							shopList.get(j).getContact() == user.getContact() || 
	    							shopList.get(j).getEmail() == user.getEmail()) {
	    						
	    						userResponse = new UserResponse(null,null);
	    						userResponse.setStatus_code("400");
	    						userResponse.setStatus_message("already username or phone number or email exisit");
	    						logger.error("already username or phone number or email exisit");
	    						// allProduct.setProductData(null);
	    						return userResponse;

	    					}
	    				}
	    	
	    	
	    	System.out.println(shopList.size());
	    	
	    	
	    	userRequest.setShop_ID(Shop + (shopList.size()) );
	    	
	    	//Add new Shopkeeper Details
	    	if(userDAO.addShop(userRequest)) {
	    		
	    		user.setShop_ID(Shop + (shopList.size()));
	    		//userResponse.setStatus_code("200");
	    		//userResponse.setStatus_message("Successfully Add ShopKeeper");
	    		userResponseModel = new UserResponseModel(user.getShop_ID(),user.getUser_ID(), user.getName(),user.getUser_Name(), 
	    				               user.getContact(),user.getEmail());
	    		userResponse = new UserResponse(userResponseModel,address);
	    		userResponse.setStatus_code("200");
	    		userResponse.setStatus_message("Successfully Add ShopKeeper");
	    		return userResponse;
	    	}
	    	else {
	    		userRequest.setStatus_code("400");
	    		userRequest.setStatus_message("Shopkeeper Empty");
	    		return null;
	    	}
	    	
	    }
	    else {
	    	logger.debug(" Adding User into database ");
	    	
	    	/**
	    	 * Add user 
	    	 * **/
	    	
	    	//check how many uique userID or get list of userID from database
	    	List<User> shopList = userDAO.listOfShop(userRequest);
	    	int size =  shopList.size();
	        System.out.println(shopList.size());
	        
	      
	        
	        
	        
	        if (shopList.get(size-1).getUser_ID() == null || shopList.size() == 0) {
	        	System.out.println("1st user add");
	        	
	        	user.setUser_ID(User + (size-1));
	        	
	        	if(userDAO.addShop(userRequest)) {
	        		user.setUser_ID(User + (size-1));
	        		
    	    		userResponseModel = new UserResponseModel(userRequest.getShop_ID(),user.getUser_ID(), user.getName(),user.getUser_Name(), 
				               user.getContact(),user.getEmail());
		      userResponse = new UserResponse(userResponseModel,address);
		      userResponse.setStatus_code("200");
      		  userResponse.setStatus_message("Successfully Add ShopKeeper");
    	    		return userResponse;
	        		
	        	}else {
		    		
		    		userResponse = new UserResponse(null,null);
		    		userResponse.setStatus_code("400");
		    		userResponse.setStatus_message("Shopkeeper Empty");
		    		return userResponse;
		    	}
	        }
	        else {
	        	System.out.println("2nd or 3rd user add");
	        	
	        	user.setUser_ID(User + (size-1));
                if(userDAO.addShop(userRequest)) {
                	user.setUser_ID(User + (size-1));
    	    		
    	    		 userResponseModel = new UserResponseModel(userRequest.getShop_ID(),user.getUser_ID(), user.getName(),user.getUser_Name(), 
				               user.getContact(),user.getEmail());
		      userResponse = new UserResponse(userResponseModel,address);
		      userResponse.setStatus_code("200");
		      userResponse.setStatus_message("Successfully Add ShopKeeper");
    	    		return userResponse;
	        		
	        	}
                else {
                
    	    		userResponse = new UserResponse(null,null);
    	    		userResponse.setStatus_code("400");
            userResponse.setStatus_message("Shopkeeper Empty");
		    		return userResponse;
    	    	}
	        }
	    	
	    }

		}catch (RuntimeException re)
		{
			logger.error("get failed", re);
			throw re;
		}
		finally
		{
			/*if (sessionFactory != null)
			{
				sessionFactory.close();
			}*/
		
	    }
	}
	
	
	/**
	 * update user and shopkeeper  
	 * **/

	@RequestMapping(value ="/update/details", method = RequestMethod.POST)
	public @ResponseBody UpdateUserShopResponse updateUserDetails(@RequestBody UpdateUserShopRequest updateRequest) {
		
		logger.debug("Entering updateUserAndShopkeeperDetails() in user conroller ");
		try {
			//UpdateUserShopResponse updateUser = null;
			//User user = updateRequest.getUserDetails();
		   //Address address = updateRequest.getUserAddress();
			
			UpdateUserShopResponse updateUser = userDAO.updateUserShop(updateRequest);
			
			System.out.println(updateUser);
			
			if (updateUser != null) {
			
			updateUser.setStatus_code("200");
			updateUser.setStatus_message("successfully update user");
			return updateUser;
			}
			return updateUser;
			
		}catch (RuntimeException re)
		{
			logger.error("get failed", re);
			throw re;
		}
		finally
		{
			/*if (sessionFactory != null)
			{
				sessionFactory.close();
			}*/
		
	    }
		}
	
	
	

	/**
	 * API Get a user details usig userid and shopid
	 */

	@RequestMapping(value = "/details/shopid/userid", method = RequestMethod.POST)
	public @ResponseBody UpdateResponse getUserDetails(@RequestBody UpdateRequest updateRequest,
			HttpServletRequest request) {

		logger.info("Entered getUserDetails()  - one user details ");
		UpdateResponse updateResponse = new UpdateResponse();
		try {

			UpdateResponseModel user = userDAO.userDetailByShopIdAndUserId(updateRequest);

			if (user.getShop_ID() == null || user.getUser_ID() == null) {

				updateResponse.setStatus_code(JsonResponse.CODE__EMPTY);
				updateResponse.setStatus_message("shopid and userid is empty");
				// updateResponse.setRequest_Type("Product Is Not Exist ");
				// allProduct.setProductData(updateData);
				return updateResponse;
			} else {
				updateResponse.setStatus_code(JsonResponse.CODE__OK);
				updateResponse.setStatus_message("Successfully Authenticated");
				updateResponse.setUserData(user);
				logger.info("Returning updateUserList and Address");
				return updateResponse;
			}
		} catch (Exception e) {
			logger.error("listOfProductByShopId(): Error - " + e);
			updateResponse.setStatus_code(JsonResponse.CODE__EMPTY);
			updateResponse.setStatus_message("Something wrong!! userDetailByShopIdAndUserId() in userDAOImpl");
			return updateResponse;
		}

	}
	
	
	/**
	 * Get All user list using shopID
	 */

	@RequestMapping(value = "/details/shopid", method = RequestMethod.POST)
	public @ResponseBody UserDetailsResponse getAllUserDetailsByShopId(@RequestBody UpdateRequest updateRequest,
			HttpServletRequest request) {

		logger.info("Entered getUserDetails()  - one user details ");

		// String shopid = updateRequest.getShop_ID();
		UserDetailsResponse updateResponse = new UserDetailsResponse();

		try {

			List<UpdateResponseModel> user = userDAO.userDetailsByShopID(updateRequest);

			if (user.isEmpty()) {

				updateResponse.setStatus_code(JsonResponse.CODE__EMPTY);
				updateResponse.setStatus_message(ApiErrors.ERROR__NO_USER_EXIST);
				// updateResponse.setRequest_Type("Product Is Not Exist ");
				// allProduct.setProductData(updateData);
				return updateResponse;
			}

			updateResponse.setStatus_code(JsonResponse.CODE__OK);
			updateResponse.setStatus_message("Successfully Authenticated");
			updateResponse.setUserData(user);
			logger.info("Returning updateUserList and Address");
			return updateResponse;
		} catch (Exception e) {
			logger.error("listOfProductByShopId(): Error - " + e);
			updateResponse.setStatus_code(JsonResponse.CODE__UNKNOWN_ERROR);
			updateResponse.setStatus_message(JsonResponse.CODE__ERROR);
			return updateResponse;
		}
	}

	
	
	
	
	
}
