package create.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Graphing {
	//
	String currentDate = "";
	ArrayList<SubmitData> userData = new ArrayList<SubmitData>();
	
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
	
	
	
	
}
