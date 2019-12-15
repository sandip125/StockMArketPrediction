package com.minor.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String getContact() {
		
		return "contact";
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.POST)
	public String setContact(Model model,HttpSession session) {
		
		model.addAttribute("msg", "thank You!");
		return "contact";
	}
}
