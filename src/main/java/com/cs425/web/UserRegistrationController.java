package com.cs425.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserRegistrationController {
	
    
	@RequestMapping(value = "/userRegisteration", method = RequestMethod.POST)
	public String registrationPostReq() {
		//return "userRegisteration";
		return "Home";
	}
	
	@RequestMapping(value = "/userRegisteration", method = RequestMethod.GET)
	public String registrationGetReq() {
		//return "userRegisteration";
		return "Home";
	}
		
	
		
}
