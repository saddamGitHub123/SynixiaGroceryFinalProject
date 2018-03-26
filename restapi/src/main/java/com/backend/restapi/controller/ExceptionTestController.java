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
import com.backend.restbackend.dao.ExceptionClassDAO;
import com.backend.restbackend.exception.dto.ExceptionClassTest;
import com.backend.restbackend.exception.dto.UnknownColumnException;
import com.backend.restbackend.exception.model.ExceptionThrowingModel;

/**
 * @author Sk Saddam Hosan
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc
@RequestMapping("ExceptionHandler")
public class ExceptionTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionTestController.class);
	
	@Autowired
	ExceptionClassDAO exceptionClassDAO;
	
	
	/**
	 * this controller testing for custom exception 
	 **/

	@RequestMapping(value = "/custom/exception", method = RequestMethod.POST)
	public @ResponseBody ExceptionThrowingModel addCustomException(@RequestBody ExceptionClassTest exceptionClassTest) {
		logger.info("Entered addCustomException()  - Save some information ");
		ExceptionThrowingModel exceptionJson =null;
		try {
			
			
			if(exceptionClassDAO.save(exceptionClassTest)) {
				
				exceptionJson =new ExceptionThrowingModel(exceptionClassTest);
				
				exceptionJson.setStatus_code(JsonResponse.CODE__OK);
				exceptionJson.setStatus_message("Successfully Done");
				return exceptionJson;
			}
			else {
				exceptionJson =new ExceptionThrowingModel(exceptionClassTest);
				exceptionJson.setStatus_code(JsonResponse.CODE__EMPTY);
				exceptionJson.setStatus_message("Somthinng went wrong");
				return exceptionJson;
			}
			

		} catch (UnknownColumnException ex) {
			logger.error("addCustomException(): Error - " + ex);
			exceptionJson =new ExceptionThrowingModel(exceptionClassTest);
			exceptionJson.setStatus_code("400");
			exceptionJson.setStatus_message("Exception!! : "+ex);
			return exceptionJson;
		}
		catch (Exception e) {
			logger.error("addCustomException(): Error - " + e);
			exceptionJson.setStatus_code("400");
			exceptionJson.setStatus_message("Exception Throwing"+e);
			return exceptionJson;
		}

	}
	

}
