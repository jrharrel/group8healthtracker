package create.gui;

public class Account 
{
	private String _accountName;
	private String _password;
	private int _ID;
	
	public Account( String accountName , String password , int ID)
	{
		_accountName = accountName;
		_password = password;
		_ID = ID;
	}
	
	public String getAccountName()
	{
		return _accountName;
	}
	public String getPassword()
	{
		return _password;
	}
	public int getID()
	{
		return _ID;
	}
	
	public void setAccountName( String newAccountName )
	{
		_accountName = newAccountName;
	}
	
	public void setPassword( String newPassword )
	{
		_password = newPassword;
	}
	
	public void setID( int newID )
	{
		_ID = newID;
	}
	
	public String toString()
	{
		return "Account Name: " + _accountName + "\n" + 
	           "Password:     " + _password + "\n" + 
			   "ID:           " + _ID + "\n";
			 
	}
	
	
	

	

}
