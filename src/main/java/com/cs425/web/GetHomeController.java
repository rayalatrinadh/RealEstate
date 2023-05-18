package com.cs425.web;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Controller
public class GetHomeController {
	//private static final Logger LOGGER = Logger.getLogger(GetHomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "welcome"; // will route to the welcome page : 3nadh
		//return "Home";
	}
	
	

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException{ RequestDispatcher rd =
	 * request.getRequestDispatcher("ShowInstructor.jsp"); rd.forward(request,
	 * response); }
	 * 
	 */

	
//	  @RequestMapping(value = "/user",method = RequestMethod.POST) public String
//	  user(Locale locale,Model model) {
//	  System.out.println("response page requested, locale = " + locale); return
//	  "ShowInstructor"; }
	 

}
