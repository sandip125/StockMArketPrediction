package com.minor.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelpController {

	@RequestMapping(value="/help",method=RequestMethod.GET)
	public String getHelp() {
		
		return "help";
	}
	
	@RequestMapping(value="/help",method=RequestMethod.POST)
	public String setHelp(Model model,HttpSession session) {
		
		return "help";
	}
}
