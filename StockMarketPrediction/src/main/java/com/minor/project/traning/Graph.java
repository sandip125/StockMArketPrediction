package com.minor.project.traning;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph extends JFrame{
	public int i=0;
	public int c;
	  private static final long serialVersionUID = 1L;
	  public  Graph(String title,List<Double> ltpList,List<Double> ltpList1,List<Date> DateList1,String b){
	    super(title);
	    // Create dataset
	   DefaultCategoryDataset dataset = createDataset(ltpList,ltpList1,DateList1,b);
	    // Create chart
	    JFreeChart chart = ChartFactory.createLineChart(
	       
	    		"Stock Market Prediction ",// Chart title
	        "Date", // X-Axis Label
	        "LTP", // Y-Axis Label
	        dataset
	        );
	    CategoryPlot plot=(CategoryPlot) chart.getPlot();
	    plot.getRenderer().setSeriesPaint(1,Color.BLUE);
	    plot.getRenderer().setSeriesPaint(0,Color.RED);
	   
	    ChartPanel panel = new ChartPanel(chart);
	    chart.getPlot().setBackgroundPaint(Color.BLACK);
	    setContentPane(panel);
	   
	    	
	  }
	  private DefaultCategoryDataset createDataset(List<Double> ltpList,List<Double> ltpList1,List<Date> DateList1,String b) {
		String series1 = "LTP";
		String series2 = "Predicted LTP";

	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    

	  

	     

		do{
			
		
			Date date=DateList1.get(i);
		    DateFormat dateFormat=new SimpleDateFormat("mm-dd");
		  String strDate = dateFormat.format(date);	
		 
		  if(b.equalsIgnoreCase("one")) {
			  
			    dataset.addValue(((ltpList.get(i)*(1695-385))+385), series1,strDate);
			  
			    dataset.addValue(ltpList1.get(i),series2, strDate);
				  }
				  if(b.equalsIgnoreCase("two")) {
					  dataset.addValue(((ltpList.get(i)*(3795-504))+504), series1,strDate);
					  
					    dataset.addValue((ltpList1.get(i)),series2, strDate);
				  }
				  if(b.equalsIgnoreCase("three")) {
					  dataset.addValue(((ltpList.get(i)*(2750-682))+682), series1,strDate);
					  
					    dataset.addValue((ltpList1.get(i)),series2, strDate);
				  }
	    
	i++;
		}while(i<ltpList.size());
	    return dataset;
	
	
	    
	}  
	  }
	    

	  


