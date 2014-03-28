package create.gui;

public class Activity 
{
	private double _workHours;
	private double _sleepHours;
	private double _cardioInMinutes;
	private double _strengthTraining;

	public Activity()
	{
		_workHours = 0.0;
		_sleepHours = 0.0;
		_cardioInMinutes = 0.0;
		_strengthTraining = 0.0;
	}
	
	public double getWorkHours()
	{
		return _workHours;
	}
	public double getSleepHours()
	{
		return _sleepHours;
	}
	public double getCardio()
	{
		return _workHours;
	}
	public double getStrengthTraining()
	{
		return _strengthTraining;
	}
	
	public void setWorkHours( double newWorkHours )
	{
		_workHours = newWorkHours;
	}
	
	public void setSleepHours( double newSleepHours )
	{
		_sleepHours = newSleepHours;
	}
	
	public void setCardio( double newCardio )
	{
		_cardioInMinutes = newCardio;
	}
	
	public void setStringTraining( double newStrengthHours )
	{
		_strengthTraining = newStrengthHours;
	}
	
	public String toString()
	{
		return "Work Hours:        " + _workHours + "\n" + 
	           "Sleep Hours:       " + _sleepHours + "\n" + 
			   "Cardio In Minutes: " + _cardioInMinutes + "\n" + 
	           "Strength Training: " + _strengthTraining + "\n";
	}

}
