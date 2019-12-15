package com.minor.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String getAbout() {
		
		return "about";
	}
	
	@RequestMapping(value="/about",method=RequestMethod.POST)
	public String setAbout(Model model,HttpSession session) {
		
		return "about";
	}
}
