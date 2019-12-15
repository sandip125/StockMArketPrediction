package com.minor.project.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minor.project.Dao.UserDao;
import com.minor.project.Dao.UserDaoImpl;
import com.minor.project.model.User;



@Controller
public class LoginController {
	@Autowired
	UserDao udao;
	
	@RequestMapping(value="/userlogin", method=RequestMethod.GET)
	public String getlogin() {
		
		return "login";
	}
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	public String login(@ModelAttribute User u,Model model,HttpServletRequest req,HttpSession session) {
		
		if(udao.login(u.getUsername(), u.getPassword())) {
			
			session.setMaxInactiveInterval(5*60);
			model.addAttribute("activeuser", u.getUsername());
			return "home1";
		}else {
			model.addAttribute("error", "login failed!");
			return "login";
		}
		
		
		
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
	/* Getting session and then invalidating it */
	
	session.invalidate();
	
	
	return "home";
}
}
