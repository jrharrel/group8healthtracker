package create.gui;

public class HealthIndicator 
{
	private double _diastolic;
	private double _systolic;
	private double _bloodSugar;
	private double _pulseRate;
	private double _calorieIntake;
	private double _weight;

	public HealthIndicator()
	{
		_diastolic = 0.0;
		_systolic = 0.0;
		_bloodSugar = 0.0;
		_pulseRate = 0.0;
		_calorieIntake = 0.0;
		_weight = 0.0;
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
	
	public void setSystolic( double newSystolic )
	{
		_systolic = newSystolic;
	}
	
	public void setDiastolic( double newDiastolic )
	{
		_diastolic = newDiastolic;
	}
	
	public void setBloodSugar( double newBloodSugar )
	{
		_bloodSugar = newBloodSugar;
	}

	public void setPulseRate( double newPulseRate )
	{
		_pulseRate = newPulseRate;
	}
	
	public void setCalorieIntake( double newCalorieIntake )
	{
		_calorieIntake = newCalorieIntake;
	}
	
	public void setWeight( double newWeight )
	{
		_weight = newWeight;
	}
	
	public String toString()
	{
		return "Blood Pressure:   " + _systolic + " \\ " + _diastolic + "\n" + 
			   "Blood Sugar:      " + _bloodSugar + "\n" + 
			   "Pulse Rate:       " + _pulseRate + "\n" + 
	           "Calorie Intake:   " + _calorieIntake + "\n"+
	           "Weight:           " + _weight + "\n";
	}

}
