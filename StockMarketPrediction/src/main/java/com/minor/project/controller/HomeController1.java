package com.minor.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController1 {

	@RequestMapping(value="/homes",method=RequestMethod.GET)
	public String getHome() {
		
		return "home1";
	}
	
	@RequestMapping(value="/homes",method=RequestMethod.POST)
	public String setHome(Model model,HttpSession session) {
		
		return "home1";
	}
}
