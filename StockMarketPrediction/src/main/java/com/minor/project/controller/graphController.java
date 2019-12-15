package com.minor.project.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.minor.project.Dao.main;
import com.minor.project.model.bank;
import com.minor.project.model.function;
import com.minor.project.model.test;
import com.minor.project.traning.Graph;
import com.minor.project.traning.Training;

@Controller
public class graphController {




@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String getfile(Model model,HttpSession session,bank b,test t1,function f) throws IOException, ParseException {
	Training t=new Training();
	main m=new main();
	
	BufferedReader fileReader =null;
	double dn = 0;
	List<Double> openList = new ArrayList<Double>(); 
    List<Double> highList = new ArrayList<Double>(); 
    List<Double> lowList = new ArrayList<Double>(); 
    List<Double> ltpList = new ArrayList<Double>(); 
    List<Date> dateList=new ArrayList<Date>();
    List<Double> predictedList= new ArrayList<Double>();

    final String delimiter = ","; 
    
double output;
double error;



	if(b.getC().equalsIgnoreCase("one")) {		
		m.setTrained("one",f.getF());
		try {
			fileReader= new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\minor_project\\datas\\Himalayan\\testCSV\\Himalayan_12_month.csv"));
		}catch(Exception e) {
			model.addAttribute("msg", "chup lag");
		}
			}


	if(b.getC().equalsIgnoreCase("two")) {		
		m.setTrained("two",f.getF());
		try {
			fileReader= new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\minor_project\\datas\\Everest\\testCSV\\12months-everest.csv"));
		}catch(Exception e) {
	model.addAttribute("msg", "chup lag");
			}
		}


	if(b.getC().equalsIgnoreCase("three")) {		
		m.setTrained("three",f.getF());
		try {
			fileReader= new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\minor_project\\datas\\Nabil\\testCSV\\Nabil_12_month.csv"));
		}catch(Exception e) {
			model.addAttribute("msg", "chup lag");
			}
		}
		
		String line;
			try {
				
				
			//
				while((line = fileReader.readLine()) != null){
					//System.out.println("sandip");
				    String [] tokens = line.split(delimiter); 
				   

	                if(!tokens[0].equalsIgnoreCase("Date")){  //we do not parse the column heading -->Date
	                Date dateField = new SimpleDateFormat("mm/dd/yyyy").parse(tokens[0]); //parsing string date field to java.util.Date
	                   dateList.add(dateField); //adding date to list
	                }

				               

				               if(!tokens[1].equalsIgnoreCase("Open")){ 
				                    openList.add(Double.parseDouble(tokens[1]));
				                    //System.out.println("asmin");
				               }
				               
				               if(!tokens[2].equalsIgnoreCase("High")){ 
				                    highList.add(Double.parseDouble(tokens[2]));
				                  //  System.out.println("fata");
				               }
				               
				               if(!tokens[3].equalsIgnoreCase("Low")){ 
				                    lowList.add(Double.parseDouble(tokens[3]));
				                    //System.out.println("alxi");
				               }
				               
				               if(!tokens[4].equalsIgnoreCase("LTP")){ 
				                    ltpList.add(Double.parseDouble(tokens[4]));
				                    //System.out.println("gadha");
				               }
				            
				  
				}}catch(Exception e) {
					e.printStackTrace();
				}//int z=0;
			
			for(int z=0;z<openList.size();z++){
					
dn=Training.predict(openList.get(z),highList.get(z), lowList.get(z),b.getC(),f.getF());
					predictedList.add(dn);
				
			}
				t.writeTrainedDatainFile(predictedList ,dateList,ltpList);
			

		        
			
			
			
		
	
	
	model.addAttribute("user", "training successfull");

	model.addAttribute("output",predictedList);
	
	if(b.getC().equalsIgnoreCase("one")) {
	Graph example = new Graph("Stock MArket Prediction",ltpList,predictedList,dateList,"one");
	example.setAlwaysOnTop(true);
    example.pack();
    example.setSize(1200, 1000);
    example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    example.setVisible(true);
	} if(b.getC().equalsIgnoreCase("two")){
		Graph example = new Graph("Stock MArket Prediction",ltpList,predictedList,dateList,"two");
		example.setAlwaysOnTop(true);
	    example.pack();
	    example.setSize(1200, 1000);
	    example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    example.setVisible(true);
	}if(b.getC().equalsIgnoreCase("three")) {
		Graph example = new Graph("Stock MArket Prediction",ltpList,predictedList,dateList,"three");
		example.setAlwaysOnTop(true);
	    example.pack();
	    example.setSize(1200, 1000);
	    example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    example.setVisible(true);
	}
	
	 return"check";








}
}
