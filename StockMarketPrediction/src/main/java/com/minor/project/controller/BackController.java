package com.minor.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BackController {
	
	@RequestMapping(value="/back",method=RequestMethod.GET)
	public String getBack() {
	
		return "home1";
	}
	@RequestMapping(value="/back",method=RequestMethod.POST)
	public String setBack(Model model,HttpSession session) {
	
		model.addAttribute("msg", "want to predict again");
		return "home1";
	}
}
