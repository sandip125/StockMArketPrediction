package com.minor.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minor.project.Dao.UserDao;
import com.minor.project.model.User;


@Controller
public class SignupConntroller {
	@Autowired
	private UserDao udao;
	
	@RequestMapping(value="/usersignup",method=RequestMethod.GET)
	public String getsignup() {
		return "signup";
	}
	
	@RequestMapping(value="/usersignup",method=RequestMethod.POST)
	public String save(@ModelAttribute User u,Model model,HttpSession session,HttpServletRequest req) throws Exception{
	try {	
		udao.signup(u);
		return "login";
			}
	catch(Exception e) {
			model.addAttribute("Error", "Duplicate data");
			return "signup";
	}
	
		
	}
}
