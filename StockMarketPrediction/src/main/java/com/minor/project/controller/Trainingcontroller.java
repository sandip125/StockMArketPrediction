package com.minor.project.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.minor.project.Dao.main;
import com.minor.project.model.bank;
import com.minor.project.model.function;
import com.minor.project.model.test;
import com.minor.project.traning.Training;



@Controller
public class Trainingcontroller {

	//Training t=new Training();
	main m=new main();
	
	@RequestMapping(value="/train",method=RequestMethod.POST)
	public String setTrained(Model model,HttpSession session,bank b,test t1,function f) throws FileNotFoundException,NullPointerException{
	double p=0;	
		if(b.getC().equalsIgnoreCase("one")) {		
				m.setTrained("one",f.getF());
			}
		if(b.getC().equalsIgnoreCase("two")) {		
			m.setTrained("two",f.getF());
			}
		if(b.getC().equalsIgnoreCase("three")) {		
			m.setTrained("three",f.getF());
			}

if(!(t1.getOpen()==0 && t1.getHigh()==0 && t1.getLow()==0)) {
	p=Training.check(t1.getOpen(),t1.getHigh(),t1.getLow(),b.getC(),f.getF());
}

model.addAttribute("output", p);
		return "check";
	}
}
