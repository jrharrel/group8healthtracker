package create.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
	
	int workHours;
	int sleepHours;
	int cardioHours;
	int strengthHours;
	
	int bloodPressure;
	int bloodSugar;
	int pulseRate;
	int calorieIntake; 

	public Graphing(String datePassed)
	{
		System.out.println("Graphing made:");
		System.out.println("month: " + getMonth(datePassed)  + "\nday: "+ getDay(datePassed)  + "\nyear" + getYear(datePassed) );
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
		returnGraph2();
		timeFrame = _timeFrame;
		bloodPressureChecked = _bloodPressureChecked;
		bloodSugarChecked = _bloodSugarChecked;
		pulseRateChecked = _pulseRateChecked;
		calorieIntakeChecked = _calorieIntakeChecked;
		
		workHoursChecked = false;
		sleepHoursChecked = false;
		cardioChecked = false;
		strengthChecked = false;
		
		//returnGraph();
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
		//returnGraph();
	}
	
	
	public void returnGraph2() // udpdate to graph
	{
	        
	        /*int DMY = 1; // Day/Month/Year Selection
	                    // Day = 1, Month = 2, Year = 3
	        
	        if (DMY == 1)
	        {*/
	            DefaultPieDataset dataset = new DefaultPieDataset();
	            dataset.setValue("Week 1", 43.2);
	            dataset.setValue("Week 2", 27.9);
	            dataset.setValue("Week 3", 79.5);
	            dataset.setValue("Week 4", 19.2);
	     
	        
	        JFreeChart chart = ChartFactory.createPieChart(
	        "Time Spent On Cardio",
	        dataset,
	        true,
	        true,
	        false
	        );


	        
	        ChartFrame frame = new ChartFrame("Cardio Chart", chart);
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
