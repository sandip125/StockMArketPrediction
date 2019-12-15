	package com.minor.project.traning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.jboss.logging.Message.Format;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.minor.project.model.bank;
import com.minor.project.model.function;
import com.minor.project.model.test;

public class Training {
	public	int inputNeuron=3;
	public	int hidNeuron=3;
	public	static int outNeuron=1;
	public	static double p;
	public static	double h[]=new double[100];
	public static	double inp[]=new double[100];
	public  static double weight[][][]=new double[100][100][100];
public static	double sandip=0;
	public static	double ho;
	public static	double o;
	public static double close;
	public static double learningrate=0.1;
	public static double w[][]=new double [100][100];
	bank b=new bank();
	
	
	public double Error;

	 public static int asmin=0;
	public double momentum=0.9;
	//public String tes;
//public double max;
//public double min;
		

	public void randomweight() {
		
		/*for(int i=0;i<inputNeuron;i++) {
		
		for(int j=0;j<hidNeuron;j++) {
			
			for(int k=0;k<outNeuron;k++) {
				weight[i][j][k]=rand.nextDouble()-0.5;
				
			}
			//w[i][j]=rand.nextDouble()-0.5;
		}
	}*/

	weight[0][0][0]=0.4;
	weight[0][1][0]=-0.3;
	weight[0][2][0]=0.2;
	weight[1][0][0]=0.1;
	weight[1][1][0]=-0.02;
	weight[1][2][0]=0.05407000332;
	weight[2][0][0]=-0.43000020002384;
	weight[2][1][0]=-0.44400005664500013352;
	weight[2][2][0]=0.200600179356;



	/*for(int i=0;i<inputNeuron;i++) {
			for(int k=0;k<outNeuron;k++) {
				for(int j=0;j<hidNeuron;j++) {



	//System.out.println(weight[i][j][k]);

				}}
	}*/
	//return weight;
	}

	public void randomweight1() {
		
		/*for(int i=0;i<inputNeuron;i++) {
			
		for(int k=0;k<hidNeuron;k++) {
			w[i][k]=rand.nextDouble()-0.5;
		}
		}*/
		
		/*for(int i=0;i<inputNeuron;i++) {
			
				for(int k=0;k<hidNeuron;k++) {



	System.out.println("w"+w[i][k]);

				}}*/
		w[0][0]=-0.03110000030598;
		w[1][0]=-0.1333000000034013789;
		w[2][0]=0.2344237988;

	}

		
		public double calcError(double o,String f) {
			
			 Error= Math.pow((1-sigmoid(o,f)),2)*sigmoid(o,f);

			return Error;
			
			
		}
		
		public double feedForward(double  openList, double  highList, double  lowList,double ltpList,double[][][] weight,double[][] w,String f){
		o=0;	
			
			
			inp[0]=openList;
			inp[1]=highList;
			inp[2]=lowList;		
			for(int i=0;i<3;i++) {
						for(int k=0;k<1;k++) {
							for(int j=0;j<3;j++) {
								//System.out.println(weight[j][i][k]);
		
									h[i]=+inp[j]*weight[j][i][k];
							
									//System.out.println(inp[j]*(2088-370)+370);	
							// System.out.println(sigmoid(h[i]));
							
							}
												}
						
		}
			for(int k=0;k<1;k++) {
							for(int j=0;j<3;j++) {
								
								//System.out.println(w[j][k]);
						o=+sigmoid(h[j],f)*w[j][k];
						//System.out.println(""+sigmoid(h[j]));
						//System.out.println(w[j][k]);
						
								}
							
						}
					//System.out.println(sigmoid(o));
						//add bias 2 
						
					return o;
	}
	public static double sigmoid(double x,String f) {
		
	
		if(f.equalsIgnoreCase("one")) {
			ho=1/(1+Math.exp(-x));
		}
		else if(f.equalsIgnoreCase("two")) {
			ho=Math.tanh(x);
		}
		else if(f.equalsIgnoreCase("three")) {
			ho=Math.log(1+Math.exp(x));
		}
			return ho;
	}

	 public void backpropagation(double openList,double highList,double lowList,double  ltpList,double o,double[][][] weight,double[][] w,String f) {	
		
		
		 
		 inp[0]=openList;
		 inp[1]=highList;
		 inp[2]=lowList;
		 double dw[][]=new double[100][100];
		  double e[][]=new double [100][100];
		   double dweight[][]=new double[100][100];
		  
		 for(int i=0;i<3;i++) {
			 for(int k=0;k<1;k++) {
					//System.out.println(w[i][k]);
				 dw[i][k]= learningrate*sigmoid(h[i],f)*calcError(o,f);	//change in weight h layer & o layer
			
			
				}
			}
		 
			for(int i=0;i<3;i++) {
				for(int k=0;k<1;k++) {
					//System.out.println(dw[i][k]+" "+(momentum*(ltpList-1)));
					w[i][k]=+(dw[i][k]+(momentum*(ltpList-1))); //update weight in h layer & o layer
				//System.out.println(w[i][k]);
				}
				
				
			}
			
				for(int k=0;k<1;k++) {
				for(int j=0;j<3;j++) {
					//System.out.println(weight[j][i][k]);
					
						e[j][k]=calcError(o,f)*w[j][k];
						
					}
				}
				
				
				for(int k=0;k<1;k++) {
					for(int j=0;j<3;j++) {
						//System.out.println(weight[j][i][k]);
						dweight[j][k]=learningrate*e[j][k]*inp[j];
						//System.out.println(dweight[j][i][k]);
					}
					
				}
				
			for(int i=0;i<3;i++) {
				for(int k=0;k<1;k++) {
				for(int j=0;j<3;j++) {
			//	System.out.println(weight[j][i][k]);
						weight[j][i][k]=+(dweight[j][k]+(momentum*(ltpList-1)));	//update weight in i layer & h layer
						//System.out.println(weight[j][i][k]);	
						//System.out.println(weight[j][i][k]);
				}
					
				}
				
			}
	 
		}
	 public static double predict(double openList, double highList, double lowList,String check,String f) {
	o=0;
	 double dn=0;
	 double l=0;
	
		inp[0]=openList;
			inp[1]=highList;
			inp[2]=lowList;	
			//System.out.println(inp[0]+""+inp[1]+""+inp[2]);
			for(int i=0;i<3;i++) {
				for(int k=0;k<1;k++) {
			 for(int j=0;j<3;j++) {
				//System.out.println(""+inp[j]);
				// System.out.println(weight[j][i][k]);
				 h[i]=+weight[j][i][k]*inp[j]; // feedforward
				
				 //System.out.println(sigmoid(h[i]));
		 }
			 }
		 }
		
		 for(int k=0;k<1;k++) {
			 for(int j=0;j<3;j++) {
				
						//System.out.println(sigmoid(h[j]));

					 o=+w[j][k]*sigmoid(h[j],f);
			//System.out.println(w[j][k]);	 
			 }
			 
		 }
		 if(check.equalsIgnoreCase("one")) {
		 
			 dn=sigmoid(o,f)*(1695-385)+385;
			 
			 System.out.println(asmin+" "+dn);  //show output sigmoid
				asmin++;
				
		 }

		 if(check.equalsIgnoreCase("two")) {
			
			 dn=sigmoid(o,f)*(3795-504)+504;
			

			 System.out.println(asmin+" "+dn);  //show output sigmoid
				asmin++;
						 }

		 if(check.equalsIgnoreCase("three")) {
			 
			 dn=sigmoid(o,f)*(2750-682)+682;
			
			 System.out.println(asmin+" "+dn);  //show output sigmoid
				asmin++;
		 }
	
		return dn;
		}
	 public static double check(double openList,double lowList,double highList,String bb,String f)throws NullPointerException {
		 test t1=new test();
		 bank b=new bank();
		 Training t=new Training();
			double open;
			double high;
			double low;
			double dn;
			
			//System.out.println(b.getC());
			if(bb.equalsIgnoreCase("one")) {
				for(int k=0;k<1;k++) {
					 for(int j=0;j<3;j++) {
				//System.out.println(w[j][k]);
					 }}
				 open=(openList-385)/(1695-385);
				 high=(highList-385)/(1695-385);
				 low=(lowList-385)/(1695-385);
				 sandip= predict(open,high, low,"one",f);
				 
			 }
			
			else if(bb.equalsIgnoreCase("two")) {
				///System.out.println(w);
				 open=(openList-504)/(3795-504);
				 high=(highList-504)/(3795-504);
				 low=(lowList-504)/(3795-504);
			sandip=predict(open, high, low, "two",f);
				 
				 }
				 
				 

			else if(bb.equalsIgnoreCase("three")){
				////System.out.println(w);
				 open=(openList-682)/(2750-682);
				 low=(highList-682)/(2750-682);
				 high=(lowList-682)/(2750-682);
				sandip=predict(open, high, low, "three",f);
				 
				 }
			
			
		
			
			return sandip;
			
		}
	 public void writeTrainedDatainFile(List<Double> predictedList,List<Date> DateList,List<Double> ltpList1)
	 {
		    try {
			    BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/user/Desktop/newFile.csv"));
				
			  for(int i=-1;i<predictedList.size();i++){
				
				  if(i==-1){
					  	out.write("Date"+","+"LTP"+","+"actualLTP"+"\n");
		
				  }else{
					 
					  Date date=DateList.get(i);
				  	DateFormat dateFormat=new SimpleDateFormat("mm/dd/yyyy");
				  	String strDate = dateFormat.format(date);	
				  	out.write(strDate+","+predictedList.get(i)+","+ltpList1.get(i)+"\n");
				  		}		
	                      }
	                 
		            out.close();
	     	}
		    
		    catch (Exception e) {
			   System.out.println("write error");
		    }
			
	      
	 }

		
	}
	 

	 

