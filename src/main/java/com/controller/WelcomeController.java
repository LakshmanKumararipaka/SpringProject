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
import com.dao.IWelcome;
import com.model.Welcome;

@Controller
public class WelcomeController {

	@Autowired
	IStudentDao studentdao;
	
	@Autowired
	IWelcome welcomedao;

	/*
	 * @RequestMapping(path="/welcome") public String showWelcome(@ModelAttribute
	 * Welcome welcome,Model m) { System.out.println(welcome); return "welcome"; }
	 */

	

	@RequestMapping(path = "/welcome")
	public String showWelcome() {

		return "welcome";
	}

	/*
	 * @RequestMapping(path="/logoutProcess",method=RequestMethod.POST) public
	 * String logoutProcess(@ModelAttribute Welcome welcome,HttpSession
	 * session,Model m,HttpServletRequest request) {
	 * 
	 * //welcome.setRegnumber(session.getAttribute("regnumber").toString());
	 * //welcome.setRegnumber(m.getAttribute("regnumber").toString());
	 * //System.out.println(welcome); //String regnumber = null;
	 * 
	 * Cookie[] cookies = request.getCookies(); if(cookies!=null) { for(Cookie
	 * cookie:cookies) { if(cookie.getName().endsWith("regnumber")) regnumber =
	 * cookie.getValue(); } }
	 * 
	 * 
	 * studentdao.deleteStudent(regnumber); return "logout"; }
	 */
	
	@RequestMapping(path="/submitProcess",method = RequestMethod.POST)
	public String submitProcess(@ModelAttribute Welcome welcome,HttpServletRequest request,HttpSession session) {
		String regnumber = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("regnumber")) regnumber = cookie.getValue();
			}
		}
		welcome.setRegnumber(regnumber);
		
		//System.out.println(welcome);
		int score =  welcomedao.getMarks(welcome);
		if(score>1) {
			welcome.setRemarks("pass");
			session.setAttribute("remarks", "2/2");
		}
		else if(score==1) {
			welcome.setRemarks("fail");
			session.setAttribute("remarks", "1/2");
		}
		else {
			welcome.setRemarks("fail");
			session.setAttribute("remarks","0/2");
		}
		session.setAttribute("regnumber", regnumber);
		welcomedao.save(welcome);
		
		return "logout";
		
	}
}
