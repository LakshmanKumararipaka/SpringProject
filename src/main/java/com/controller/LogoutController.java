package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.IStudentDao;

@Controller
public class LogoutController {
	
	@Autowired
	IStudentDao studentdao;
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String getLogout() {
		return "logout";
	}
	
	@RequestMapping(value="/logoutProcess",method=RequestMethod.POST)
	public String logoutProcess(HttpSession session) {
		
		session.setAttribute("logoutmsg", "Successfully Logged out");
		return "login";
	}
	
	@RequestMapping(value="/deleteProcess",method=RequestMethod.POST)
	public String deleteProcess(HttpServletRequest request) {
		String regnumber = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("regnumber")) regnumber = cookie.getValue();
			}
		}
		studentdao.deleteStudent(regnumber);
		
		return "delete";
	}
	
}
