package create.gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

public class Graphing {
	////
	String currentDate = "";
	ArrayList<SubmitData> userData = new ArrayList<SubmitData>();
	
	int timeFrame = 0;
	
	public final int DAY = 0;
	public final int WEEK = 1;
	public final int MONTH = 2;
	
	boolean workHoursChecked = false;
	boolean sleepHoursChecked = false;
	boolean cardioChecked = false;
	boolean strengthChecked = false;

	boolean bloodPressureChecked = false;
	boolean bloodSugarChecked = false;
	boolean pulseRateChecked = false;
	boolean calorieIntakeChecked = false;
	
	double hoursLeft= 0;
	int workHours = 0;
	int sleepHours = 0;
	double cardioHours = 0;
	double strengthHours = 0;
	
	int bloodPressure = 0;
	int bloodSugar = 0;
	int pulseRate = 0;
	int calorieIntake = 0; 
	ChartFrame frame;
	
	
	public Graphing(String datePassed)
	{
		System.out.println("Graphing made:");
		System.out.println("month: " + getMonth(datePassed)  + "\nday: "+ getDay(datePassed)  + "\nyear" + getYear(datePassed) );
		currentDate = datePassed;
	}
	
	
	public void setCurrentDatePassed(String datePassed)
	{
		currentDate = datePassed;
	}
		
	public void setUserData(ArrayList<SubmitData> dataPassed)
	{
		userData = dataPassed;
	}
	
	public int getDay(String dateToChange)
	{
		String dayToConvert = "";
		boolean builtWord = false;
		int wordCounter = 0;
		int dayToReturn;
		
		for(int i = 0; i<dateToChange.length(); i++)
		{
			if(dateToChange.charAt(i) != '/' && !builtWord)
			{
				if(wordCounter == 1)
				dayToConvert += dateToChange.charAt(i);
			}else
			{
				wordCounter++;
				if(wordCounter>1)
				builtWord = true;
			}
		}
		
		dayToReturn = Integer.parseInt(dayToConvert);
		return dayToReturn;
	}
	
	public int getMonth(String dateToChange)
	{
		boolean builtWord = false;
		int monthToReturn;
		String monthToConvert = "";
		
		for(int i = 0; i<dateToChange.length(); i++)
		{
			if(dateToChange.charAt(i) != '/' && !builtWord)
			{
				monthToConvert += dateToChange.charAt(i);
			}else
			{
				builtWord = true;
			}
		}
		
		monthToReturn = Integer.parseInt(monthToConvert);
		return monthToReturn;	
		}
	
	public int getYear(String dateToChange)
	{
		String yearToConvert = "";
		boolean builtWord = false;
		int wordCounter = 0;
		int yearToReturn;
		
		for(int i = 0; i<dateToChange.length(); i++)
		{
			if(dateToChange.charAt(i) != '/' && !builtWord)
			{
				if(wordCounter == 2)
				yearToConvert += dateToChange.charAt(i);
			}else
			{
				wordCounter++;
			}
		}
		
		yearToReturn = Integer.parseInt(yearToConvert);
		return yearToReturn;
	}
		
	public void graphHealth(int _timeFrame,boolean _bloodPressureChecked,boolean _bloodSugarChecked, boolean _pulseRateChecked,boolean _calorieIntakeChecked )
	{
		
		timeFrame = _timeFrame;
		bloodPressureChecked = _bloodPressureChecked;
		bloodSugarChecked = _bloodSugarChecked;
		pulseRateChecked = _pulseRateChecked;
		calorieIntakeChecked = _calorieIntakeChecked;
		
		workHoursChecked = false;
		sleepHoursChecked = false;
		cardioChecked = false;
		strengthChecked = false;
		
		returnLineGraph();
	}
	
	public void graphActivity(int _timeFrame,boolean _workHoursChecked,boolean _sleepHoursChecked, boolean _cardioChecked,boolean _strengthChecked )
	{
		bloodPressureChecked = false;
		bloodSugarChecked = false;
		pulseRateChecked = false;
		calorieIntakeChecked = false;
		
		workHoursChecked = _workHoursChecked;
		sleepHoursChecked = _sleepHoursChecked;
		cardioChecked = _cardioChecked;
		strengthChecked = _strengthChecked;
		

	  
		timeFrame = _timeFrame;	
		returnPieChart();
	}
	

	public double addLinePoint(SubmitData dataPassed)
	{
		if(bloodPressureChecked )
    	{
    		return dataPassed.getDiastolic()/dataPassed.getSystolic();
 
    	}
    	if(bloodSugarChecked )
    	{
    		return dataPassed.getBloodSugar();
    	}
    	
    	if(pulseRateChecked)
    	{
    		return dataPassed.getPulseRate();
    	}
	
    	if(calorieIntakeChecked)
    	{
    		System.out.println( "\n" +dataPassed.getCalorieIntake());
    		return dataPassed.getCalorieIntake();
    	}
    	System.out.println("nothing is checked");
    	return 0;
	}
	

    
    public void returnLineGraph() 
    {
    	 String chartTitle = "Title";
  	   String lineCategory = "Category";
  	   String xValue = "Time Elapsed";
  	   String yValue = "Y";
    	double valueToAdd = 0;
    	
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    	if(bloodPressureChecked )
    	{
    		chartTitle = "Blood Pressure";
    		yValue = "Systolic/Diastolic";
    	
    		
    	}
    	if(bloodSugarChecked )
    	{
    		chartTitle = "Blood Sugar";
    		yValue = "Sugars";
    	}
    	
    	if(pulseRateChecked)
    	{
    		chartTitle = "PulseRate";
    		yValue = "BPMS";
    	}
	
    	if(calorieIntakeChecked)
    	{
    		chartTitle = "Calorie Intake";
    		yValue = "Calories";
    	}
    	
   
    int dayCounter = 0;
    double valueToPass = 0;
    
    if(timeFrame == DAY)
    {
    	for(SubmitData a : userData)
    	{
    		if(a.getDate().equals(currentDate))
    		{
    			dayCounter++;
    			dataset.addValue(addLinePoint(a), lineCategory, "Day " + dayCounter);
    		
    		}
    	}
    	hoursLeft = hoursLeft - workHours - sleepHours - cardioHours - strengthHours;
    }
    if(timeFrame == WEEK)
    {
    	
    		for(SubmitData a : userData)
    		{
    			if((getMonth(a.getDate()) == getMonth(currentDate) &&
    					(getDay(a.getDate()) - getDay(currentDate)) >= -7 &&
    					(getDay(a.getDate()) - getDay(currentDate)) <= 0 ))
    			{
    				dayCounter++;
    				valueToPass = addLinePoint(a);
    				if(valueToPass >= 0)
        			dataset.addValue(valueToPass, lineCategory, "Day " + dayCounter);
    			}
    			
    		}  
    }
    if(timeFrame == MONTH)
    {
    		
	for(SubmitData a : userData)
	{
		if(getMonth(a.getDate()) == getMonth(currentDate) && getYear(a.getDate()) == getYear(currentDate))
		{
			dayCounter++;
			valueToPass = addLinePoint(a);
			if(valueToPass >= 0)
			dataset.addValue(valueToPass, lineCategory, "Day " + dayCounter);
		}
		
	}
    	
    	
    }
    
    	
   
    //Columns shall be the dates, rows shall be the bpms.... values are where they lie
    JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, xValue, yValue, dataset); //Where each
       
    //JFreeChart barChart = ChartFactory.createBarChart("test", "cat", "axis", dataset);
 
    ChartFrame frame = new ChartFrame("Cardio Chart", lineChart);
    
    frame.pack();
    frame.setVisible(true);
    }

    public void addActivityNumbers(SubmitData recordPassed)
    {
    	   	if (workHoursChecked)
    	   	{
    	   		workHours += recordPassed.getWorkHours();
    	   	}
   			if (sleepHoursChecked)
   			{
   				sleepHours += recordPassed.getSleepHours();
   			}
   			if (cardioChecked)
   			{
   				System.out.println("Called");
   				cardioHours = recordPassed.getCardio();
   				System.out.println(cardioHours);
   			}
   			if (strengthChecked)
   			{
   				strengthHours = recordPassed.getStrengthTraining();
   			}
        	
   			hoursLeft += 24;
    }
	public void returnPieChart() // udpdate to graph
	{	
			hoursLeft = 0;
			workHours = 0;
			sleepHours = 0;
			cardioHours = 0;
			strengthHours = 0;
			
			
	        if(timeFrame == DAY)
	        {
	        	for(SubmitData a : userData)
	        	{
	        		if(a.getDate().equals(currentDate))
	        		{
	        			
	        			addActivityNumbers(a);
	        			hoursLeft +=24;
	        		}
	        	}
	        	hoursLeft = hoursLeft - workHours - sleepHours - cardioHours - strengthHours;
	        }
	        if(timeFrame == WEEK)
	        {
	        	
	        		for(SubmitData a : userData)
	        		{
	        			if((getMonth(a.getDate()) == getMonth(currentDate) &&
	        					(getDay(a.getDate()) - getDay(currentDate)) >= -7 &&
	        					(getDay(a.getDate()) - getDay(currentDate)) <= 0 ))
	        			{
	        				addActivityNumbers(a);
	        				hoursLeft +=24;
	        			}
	        			
	        		}
	        		hoursLeft = hoursLeft - workHours - sleepHours - cardioHours - strengthHours;
	       
	        }
	        if(timeFrame == MONTH)
	        {

    		for(SubmitData a : userData)
    		{
    			if(getMonth(a.getDate()) == getMonth(currentDate) && getYear(a.getDate()) == getYear(currentDate))
    			{
    				addActivityNumbers(a);
    				hoursLeft +=24;
    			}
    		
    			
    		}
    		hoursLeft = hoursLeft - workHours - sleepHours - cardioHours - strengthHours;
	        	
	        	
	        }

	            DefaultPieDataset dataset = new DefaultPieDataset();
	            
	        	if (workHoursChecked)
	    	   	{
	        		dataset.setValue("Work", workHours);
	    	   	}
	   			if (sleepHoursChecked)
	   			{
	   			 dataset.setValue("Sleep", sleepHours);
	   			}
	   			if (cardioChecked)
	   			{
	   			 dataset.setValue("Cardio", cardioHours);
	   			}
	   			if (strengthChecked)
	   			{
	   				dataset.setValue("Strength", strengthHours);
	   			}
	            
	           dataset.setValue("Hours Left", hoursLeft);
	           
	        
	        JFreeChart chart = ChartFactory.createPieChart(
	        "Time Spent On Cardio",
	        dataset,
	        true,
	        true,
	        false
	        );

	        frame = new ChartFrame("Activity Chart", chart);
	        frame.pack();
	        frame.setVisible(true);
	        }
	       
	
	
	public void returnGraph()
	{
		//update the chart
		if(timeFrame == MONTH)
		{
			for(SubmitData a : userData)
			{
				if(getMonth(a.getDate()) == getMonth(currentDate))
				{
					//add all the records for this month
				}
			}
		}else if(timeFrame == WEEK)
		{
			for(SubmitData a : userData)
			{
				if  (getMonth(a.getDate()) == getMonth(currentDate) &&
					(getDay(a.getDate()) - getDay(currentDate)) >= -7 &&
					(getDay(a.getDate()) - getDay(currentDate)) <= 0 )
				{
					//add all the records for this week
				}
			}
		}else
		{
			timeFrame = DAY;
			for (SubmitData a : userData)
			{
				//return a chart for the day
			}	
		}	
		//set visible
	}
}
