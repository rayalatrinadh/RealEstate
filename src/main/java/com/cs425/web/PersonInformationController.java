package com.cs425.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs425.web.dao.InsertUserDetails;
import com.cs425.web.dao.PersonDao;
import com.cs425.web.model.Person;
import com.google.gson.Gson;

@Controller
public class PersonInformationController {
	
	@RequestMapping(value = "/getPersonInfoFromUser", method = RequestMethod.POST)
	public String getPersonInfo(Person person,Model model) throws SQLException {
		String name = person.getName();
		String emailId = person.getEmailID();
		System.out.println(person.getName());
		System.out.println(person.getEmailID());
		InsertUserDetails details = new InsertUserDetails();
		details.insertUserInfo(emailId,name);
		//return "welcome";
		//return "ShowInstructor";  
		 return "userRegisteration";
	}
	
	
	
	
	  @RequestMapping(value = "/getPersonInfoFromDBAjax", method =
	  RequestMethod.POST) public String getPersonInfoFromDb(Model model) throws
	  SQLException, ServletException, IOException {
		  
		  try {
			  List<Person>  personsList = PersonDao.getPersonDetailsFromDB();
//			  request.setAttribute("products", products); // Will be available as ${products} in JSP
//	          request.getRequestDispatcher("/WEB-INF/ShowInstructor.jsp").forward(request, response);
			  
//			  request.setAttribute("productsList", productsList);
//			  RequestDispatcher dispatcher = request.getRequestDispatcher("ShowInstructor.jsp");
//	          dispatcher.forward(request, response);
//			  
			    System.out.println("personsList : " + personsList);
			    //String json = new Gson().toJson(productsList);
			  
			    //System.out.println("json: " + json);
	            //response.setContentType("application/json");
	            //response.setCharacterEncoding("UTF-8");
	            //response.getWriter().write(json);
			    
			    model.addAttribute("personsList",personsList);
			  return "showTable";
			  
		  }catch (SQLException e) {
	            throw new ServletException("Cannot obtain products from DB", e);
	        }
		  
	}
	 

}
