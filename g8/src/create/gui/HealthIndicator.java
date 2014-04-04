package create.gui;

public class HealthIndicator 
{
	private double _bloodPressure;
	private double _bloodSugar;
	private double _pulseRate;
	private double _calorieIntake;
	private double _weight;

	public HealthIndicator()
	{
		_bloodPressure = 0.0;
		_bloodSugar = 0.0;
		_pulseRate = 0.0;
		_calorieIntake = 0.0;
		_weight = 0.0;
	}
	
	public double getBloodPressure()
	{
		return _bloodPressure;
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
	
	public void setBloodPressure( double newBloodPressure )
	{
		_bloodPressure = newBloodPressure;
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
		return "Blood Pressure:   " + _bloodPressure + "\n" + 
	           "Blood Sugar:      " + _bloodSugar + "\n" + 
			   "Pulse Rate:       " + _pulseRate + "\n" + 
	           "Calorie Intake:   " + _calorieIntake + "\n"+
	           "Weight:           " + _weight + "\n";
	}

}
