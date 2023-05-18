package com.cs425.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs425.web.dao.InstructorDao;
import com.cs425.web.model.Instructor;

@Controller
public class GetInformationController {
	
	
	
	@RequestMapping(value = "/getInformation",method = RequestMethod.POST)
	public String getInformation(Locale locale,Model model,Instructor instructor) throws Exception{
		
		System.out.println(instructor.getID());
		String ID = instructor.getID();
		InstructorDao od1  =  new InstructorDao();
		Instructor ob1 = od1.getInstructor(ID);
		
		System.out.println("===================>> in GetInformationController.java  Instructor Object : " + ob1);
		model.addAttribute("Instructor",ob1);
		System.out.println("result : " + ob1);
		
		System.out.println("ob1.getID() :" + ob1.getID());
		System.out.println("ob.1getName() : " + ob1.getName());
		if(ob1.getID() == null) {
			System.out.println("id is null");
			return "InstructorNotFound";
		}
		
		System.out.println("user page requested, locale = " + locale);
		return "ShowInstructor";
	}
	
	
	/*
	 * @RequestMapping(value = "/getInformationAjax",method = RequestMethod.POST)
	 * public String getInformationAjax(Locale locale,Model model,Instructor
	 * instructor) throws Exception{
	 * 
	 * System.out.println(instructor.getID()); String ID = instructor.getID();
	 * InstructorDao od1 = new InstructorDao(); Instructor ob1 =
	 * od1.getInstructor(ID);
	 * 
	 * model.addAttribute("Instructor",ob1); System.out.println("result : " + ob1);
	 * 
	 * System.out.println("ob1.getID() :" + ob1.getID());
	 * System.out.println("ob.1getName() : " + ob1.getName()); if(ob1.getID() ==
	 * null) { System.out.println("id is null"); return "InstructorNotFound"; }
	 * 
	 * System.out.println("user page requested, locale = " + locale); return
	 * "ShowInstructor";
	 * 
	 * }
	 */
	
}
