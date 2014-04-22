package create.gui;

class SubmitData 
{
	private String _user;
	private String _date;
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
	
	public SubmitData()
	{
		//do nothing
	}

	public SubmitData( String user, String date, double diastolic , double systolic , double bloodsugar, double pulseRate, double calorieIntake  
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
	
	public void setUser(String userPassed)
	{
		_user = userPassed;
	}

	// mm/dd/yyyy //
	public String getDate()
	{
		return _date ;
	}
	
	public void setDate(String datePassed)
	{
		_date = datePassed;
	}

	public double getDiastolic()
	{
		return _diastolic ;
	}
	
	public void setDiastolic(double passed)
	{
	 	_diastolic = passed;
	}

	public double getSystolic()
	{
		return _systolic ;
	}

	public void setSystolic(double passed)
	{
		_systolic = passed;
	}
	
	public double getBloodSugar()
	{
		return _bloodSugar;
	}
	
	public void setBloodSugar(double passed)
	{
		_bloodSugar = passed;
	}
	
	public double getPulseRate()
	{
		return _pulseRate;
	}
	
	public void setPulseRate(double passed)
	{
		_pulseRate = passed;
	}
	
	public double getCalorieIntake()
	{
		return _calorieIntake;
	}
	
	public void setCalorieIntake(double passed)
	{
		_calorieIntake = passed;
	}
	
	public double getWeight()
	{
		return _weight;
	}
	
	public void setWeight(double passed)
	{
		_weight = passed;
	}
	
	public double getWorkHours()
	{
		return _workHours;
	}
	
	public void setWorkHours(double passed)
	{
		_workHours = passed;
	}
	
	public double getSleepHours()
	{
		return _sleepHours;
	}
	
	public void setSleepHours(double passed)
	{
		_sleepHours = passed;
	}
	
	public double getCardio()
	{
		return _cardioInMinutes;
	}
	
	public void setCardio(double passed)
	{
		_cardioInMinutes = passed;
	}
	
	public double getStrengthTraining()
	{
		return _strengthTraining;
	}
	
	public void setStrengthTraining(double passed)
	{
		_strengthTraining = passed;
	}

	public String toString()
	{
		return "" + _user + _strengthTraining + _cardioInMinutes + _sleepHours + _workHours + _weight + _calorieIntake + _pulseRate + _bloodSugar + _systolic + _diastolic;	
	}

}