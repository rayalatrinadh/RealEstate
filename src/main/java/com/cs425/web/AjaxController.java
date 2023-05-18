package com.cs425.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class AjaxController implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "/getInformationAjax",method = RequestMethod.POST)
	public void getInformationAjaxPOST(@RequestBody String name,HttpServletResponse response) throws ServletException, IOException{
		
		 
		//get the data from the JspAjax call
		String variableAjax=  name;
		System.out.println("-------------> type of the variableAjax : "+variableAjax.getClass());
	     System.out.println("controller variable is  " + variableAjax);
		
		
		//forming the data to send to view.
		JSONObject obj = new JSONObject();
	    obj.put("name","nameFromControllerAjax");
	    obj.put("num",new Integer(200));
	      
		response.setContentType("application/json");
		response.getWriter().write(obj.toString());
		
	}
}
