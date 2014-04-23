package create.gui;

public class SubmitData 
{
	private String _user;
	private int _date;
	private double _diastolic;
	private double _systolic;
	private double _bloodSugar;
	private double _pulseRate;
	private double _calorieIntake;
	private double _weight;
	private double _workHours;
	private double _sleepHours;
	private double _cardioInMinutes;
	private double _strengthTraining;
	
	public SubmitData( String user, int date, double diastolic , double systolic , double bloodsugar, double pulseRate, double calorieIntake  
			, double weight, double workhours, double sleephours, double cardio, double strength)
	{
		_user = user;
		_date = date;
		_diastolic = diastolic;
		_systolic = systolic;
		_bloodSugar = bloodsugar;
		_pulseRate = pulseRate;
		_calorieIntake = calorieIntake;
		_weight = weight;
		_workHours = workhours;
		_sleepHours = sleephours;
		_strengthTraining = strength;
		
	}
	
	public String getUser()
	{
		return _user;
	}
	
	
	// mm/dd/yyyy //
	public int getDate()
	{
		return _date ;
	}

	public double getDiastolic()
	{
		return _diastolic ;
	}
	
	public double getSystolic()
	{
		return _systolic ;
	}
	
	public double getBloodSugar()
	{
		return _bloodSugar;
	}
	public double getPulseRate()
	{
		return _pulseRate;
	}
	public double getCalorieIntake()
	{
		return _calorieIntake;
	}
	public double getWeight()
	{
		return _weight;
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
		return _cardioInMinutes;
	}
	public double getStrengthTraining()
	{
		return _strengthTraining;
	}
	
	public String toString()
	{
		return "" + _strengthTraining + _cardioInMinutes + _sleepHours + _workHours + _weight + _calorieIntake + _pulseRate + _bloodSugar + _systolic + _diastolic;	
	}

}
