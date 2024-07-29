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

import com.dao.IStudentDao;
import com.model.LoginStudent;
import com.model.Student;

@Controller
public class LoginController {
	
	
	@Autowired
	IStudentDao studentDao;
	
	@RequestMapping(path = "/login")
	public String getLogin() {
		return "login";
	}
	
	
	@RequestMapping(path = "/loginStudent", method = RequestMethod.POST)
	public String loginStudent(@ModelAttribute LoginStudent loginstudent,HttpSession session, Model m,HttpServletResponse response) {
		//System.out.println(loginstudent);
		String regnumber = null;
		Student s = studentDao.valiadteStudent(loginstudent);
		if(s!=null) {
			System.out.println(s.getRegnumber());
			regnumber = s.getRegnumber();
			session.setAttribute("regnumber", s.getRegnumber());
			Cookie regNumber = new Cookie("regnumber", regnumber);
			response.addCookie(regNumber);
			session.setAttribute("regnumber", s.getRegnumber());
			return "welcome";
		}
		else {
			String error = "Not a Valid Username or Password";
			m.addAttribute("error", error);
			return "login";
		}
	}
}
