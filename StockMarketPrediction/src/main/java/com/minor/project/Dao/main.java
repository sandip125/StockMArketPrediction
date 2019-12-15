package com.minor.project.Dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minor.project.controller.graphController;
import com.minor.project.model.bank;
import com.minor.project.model.test;

import com.minor.project.traning.Training;

public class main {
Training t=new Training();
	
	List<Double> openList = new ArrayList<Double>(); 
    List<Double> highList = new ArrayList<Double>(); 
    List<Double> lowList = new ArrayList<Double>(); 
double output;
double error;
double[][][] weight=new double[100][100][100];
graphController gc=new graphController();

    List<Double> ltpList = new ArrayList<Double>(); 
	
	public void setTrained(String b,String f) throws FileNotFoundException,NullPointerException{
	
	test t1=new test();
        BufferedReader fileReader =null;
        final String delimiter = ","; 
        double[][][] weight1=new double[100][100][100];
       
        double output;
        double error;
       
   
     
        if(b.equalsIgnoreCase("one")) {
			
				fileReader= new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\minor_project\\Himalayan bank ltd.csv"));
			
			}else if(b.equalsIgnoreCase("two")) {
				
					fileReader= new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\minor_project\\Everest-data1.csv"));
			
			}else if(b.equalsIgnoreCase("three")){
				
					fileReader= new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\minor_project\\Nabil Bank1.csv"));
				
			}
			String line;
			try {
			
				while((line = fileReader.readLine()) != null){

				    String [] tokens = line.split(delimiter); 				               

				               if(!tokens[0].equalsIgnoreCase("Open")){ 
				                    openList.add(Double.parseDouble(tokens[0]));
				               }
				               
				               if(!tokens[1].equalsIgnoreCase("High")){ 
				                    highList.add(Double.parseDouble(tokens[1]));
				               }
				               
				               if(!tokens[2].equalsIgnoreCase("Low")){ 
				                    lowList.add(Double.parseDouble(tokens[2]));
				               }
				               
				               if(!tokens[3].equalsIgnoreCase("LTP")){ 
				                    ltpList.add(Double.parseDouble(tokens[3]));
				               }
				      
						}
				
				t.randomweight();
		t.randomweight1();
			for(int i=0;i<openList.size();i++) {
			
			output=	t.feedForward(openList.get(i), highList.get(i), lowList.get(i),ltpList.get(i),t.weight,t.w,f);
		error=t.calcError(output,f);
			t.backpropagation(openList.get(i),highList.get(i), lowList.get(i),ltpList.get(i), output,t.weight,t.w,f);
				t.predict(openList.get(i), highList.get(i), lowList.get(i),b,f);	
			
			}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
        finally {
        if(fileReader != null){
            
            
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
        } 
        
        }		
	}
	
	
}
