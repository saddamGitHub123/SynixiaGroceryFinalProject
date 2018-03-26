/**
 * 
 */
package com.backend.restapi.controller;

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

import com.backend.restbackend.common.JsonResponse;
import com.backend.restbackend.dao.LoginDAO;
import com.backend.restbackend.exception.dto.BackEndSQLException;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.model.LoginResponse;
import com.backend.restbackend.user.model.UserResponseModel;



/**
 * @author Sk Saddam Hosan
 *
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc
@RequestMapping("login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	public LoginDAO loginDAO;
	
	@RequestMapping(value = "/user/shop", method = RequestMethod.POST)
	public @ResponseBody LoginResponse loginUser(@RequestBody User loginuser) {

		logger.info("User & Shopkeeper Entered loginUser() in LoginController  - Post username and password for USER");
		LoginResponse loginResponse = new LoginResponse() ;
		
		try {
			// Create main class Object			
			UserResponseModel userDetails = loginDAO.checkLogin(loginuser);
			if (userDetails == null) {
				loginResponse.setData(userDetails);
				loginResponse.setStatus_code(JsonResponse.CODE__EMPTY);
				loginResponse.setStatus_message(JsonResponse.USER__NAME_PSW_NOT_FOUND);
				logger.error("User name and password not found");
				
				return loginResponse;
			}
			else {

				loginResponse.setData(userDetails);
				loginResponse.setStatus_code(JsonResponse.CODE__OK);
			    loginResponse.setStatus_message(JsonResponse.USER__NAME_PSW_FOUND);
				logger.debug("User name and password  found");
				return loginResponse;
			}

		} catch (BackEndSQLException ex) {
			logger.error("loginUser(): Error - " + ex);
			//loginResponse.setData(userDetails);
			loginResponse.setStatus_code(JsonResponse.CODE__EMPTY);
			loginResponse.setStatus_message("Exception!! : " + ex);
			return loginResponse;
		}catch (Exception e) {
			logger.error("loginUser(): Error - " + e);
			loginResponse.setStatus_code(JsonResponse.CODE__EMPTY);
			loginResponse.setStatus_message("Exception Throwing"+e);
			return loginResponse;
		}
	}
	

}
