package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.IRegistrationNumberDao;
import com.dao.IStudentDao;
import com.dao.RegistrationNumberDao;
import com.model.Student;
import com.model.Welcome;

@Controller
public class RegisterController {
	
	@Autowired
	private IStudentDao studentdao;
	
	@Autowired
	private IRegistrationNumberDao regnumberdao;
	
	private String regnumber;
	

	public String getRegnumber() {
		return regnumber;
	}

	public void setRegnumber(String regnumber) {
		this.regnumber = regnumber;
	}
	
	
	

	@RequestMapping(path = "/register")
	public String getRegister(HttpSession session) {
		String regnumber=regnumberdao.getRegistrationNumber();
		session.setAttribute("regnumber", regnumber);
		this.regnumber =regnumber;
		return "register";
	}
	
	@RequestMapping(path = "/registerStudent", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student,HttpSession session,HttpServletResponse response) {
		student.setRegnumber(regnumber);
		//System.out.println(student);
		
		studentdao.saveStudent(student);
		//String message = "Welcome"+student.getFirstname();
		session.setAttribute("successmsg","Successfully Registered");
		/*
		 * ModelAndView mv = new ModelAndView("welcome"); Welcome welcome = new
		 * Welcome(); welcome.setRegnumber(student.getRegnumber());
		 */
		
		return "login";
		
	}
}
