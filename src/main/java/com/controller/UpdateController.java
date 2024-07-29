package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.IStudentDao;
import com.model.Student;

@Controller
public class UpdateController {
	
	
	@Autowired
	IStudentDao dao;
	
	String regnumber = null;
	
	@RequestMapping(path="/update")
	public String getUpdate(Model model,HttpServletRequest request,HttpSession session) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("regnumber")) regnumber = cookie.getValue();
			}
		}
		System.out.println(regnumber);
		Student s = dao.getStudentById(regnumber);
		model.addAttribute("Student",s);
		session.setAttribute("regnumber", s.getRegnumber());
		return "update";
	}
	@RequestMapping(path="/updateProcess", method = RequestMethod.POST)
	public String updateProcess(@ModelAttribute Student ustudent,HttpServletRequest request,HttpSession session) {
		ustudent.setRegnumber(regnumber);
		String s =dao.updateStudent(ustudent);
		if(s.equals("success")) {
			session.setAttribute("updatemsg", "Successfully Updated Details");
			return "welcome";
		}
		else {
			return "fail";
		}
	}
}
