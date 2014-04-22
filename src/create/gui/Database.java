package create.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.PrintWriter;

class Database{	

	 List<LoginRecord> loginArray = new ArrayList<LoginRecord>();
	 List<SubmitData> dataArray = new ArrayList<SubmitData>();
	 FileReader databaseReader;
	 FileWriter databaseWriter = new FileWriter();

	public Database() {
	//this will be the createLoginData method
	
	int loginArrayPosition = 0;
	int loginArrayReaderPosition = 0;
	
	File loginFile = new File("login.txt");
	File dataFile = new File("database.txt");

        try {
		  		LoginRecord currentRecord = new LoginRecord();
            Scanner readScanner = new Scanner(loginFile);
            while (readScanner.hasNextLine()) {
				
			       String line = readScanner.nextLine();
					 String currentUser = "";
					 String currentPw = "";		 
					
					if(line.charAt(0) == 'H') //always skip the first line
						{
						line = readScanner.nextLine();
						}
					
					if(line.charAt(0) == 'U')
					 	{
						currentRecord = new LoginRecord();
					 	currentUser = line.substring(6); //six is the location of username
						currentRecord.setUserName(currentUser);
					 	}
					else if(line.charAt(0) == 'P')
					 	{
					 	currentPw = line.substring(4); //four is the location of pw
						currentRecord.setPassword(currentPw);
						
						loginArray.add(currentRecord);
						
						loginArrayPosition++;
					 	}
					else if(line.charAt(0) == 'E') //add an empty record
						{
							//do nothing
						}
					
            }
            readScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

			  try {
			  SubmitData currentRecord = new SubmitData();
           Scanner dataScanner = new Scanner(dataFile);
            
				while (dataScanner.hasNextLine()) {
      
					 String dataUser = "";
					 String currentDate = "";
					 String diastolic = "";
					 String systolic = "";
					 String bloodSugar = "";
					 String pulseRate = "";
					 String calorieIntake = "";
					 String weight = "";
					 String sleepHours = "";
					 String workHours = "";
					 String cardioInMinutes = "";		 
					 String strengthTraining = "";
					 
					 String line = dataScanner.nextLine();
					 if(line.length() == 0)
							{
								line = " ";
							}
					
					if(line.charAt(0) == 'D') //always skip the first line
						{
							line = dataScanner.nextLine();
							
							if(line.length() == 0)
							{
								line = " ";
							}
						}
					
					if(line.charAt(0) == '1')
					 	{
						currentRecord = new SubmitData();
					 	dataUser = line.substring(8); //8 is the location of username
						currentRecord.setUser(dataUser);
					 	}
					else if(line.charAt(0) == '2')
					 	{
					 	currentDate = line.substring(8); //8 is the location of pw
						currentRecord.setDate(currentDate);
						
					 	}
					else if(line.charAt(0) == '3') //add an empty record
						{
							diastolic = line.substring(13);
							currentRecord.setDiastolic(Double.parseDouble(diastolic));
						}
					else if(line.charAt(0) == '4') //add an empty record
						{
							systolic = line.substring(12);
							currentRecord.setSystolic(Double.parseDouble(systolic));
						}
					else if(line.charAt(0) == '5') //add an empty record
						{
							bloodSugar = line.substring(14);
							currentRecord.setBloodSugar(Double.parseDouble(bloodSugar));
						}
					else if(line.charAt(0) == '6') //add an empty record
						{
							pulseRate = line.substring(13);
							currentRecord.setPulseRate(Double.parseDouble(pulseRate));
						}
					else if(line.charAt(0) == '7') //add an empty record
						{
							calorieIntake = line.substring(17);
							currentRecord.setCalorieIntake(Double.parseDouble(calorieIntake));
						}
					else if(line.charAt(0) == '8') //add an empty record
						{
							weight = line.substring(10);
							currentRecord.setWeight(Double.parseDouble(weight));
						}
					else if(line.charAt(0) == '9') //add an empty record
						{
							workHours = line.substring(13);
							currentRecord.setWorkHours(Double.parseDouble(workHours));
						}
					else if(line.charAt(0) == 'a') //add an empty record
						{
							sleepHours = line.substring(14);
							currentRecord.setSleepHours(Double.parseDouble(sleepHours));
						}
					else if(line.charAt(0) == 'b') //add an empty record
						{
							cardioInMinutes = line.substring(19);
							currentRecord.setCardio(Double.parseDouble(cardioInMinutes));
						}
					else if(line.charAt(0) == 'c') //add an empty record
						{
							strengthTraining = line.substring(20);
							currentRecord.setStrengthTraining(Double.parseDouble(strengthTraining));
							
							dataArray.add(currentRecord);
							//last field of record therefore add record to arraylist
						}
            }
 
            dataScanner.close();
				
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		  
		  			databaseReader = new FileReader(dataArray);
					databaseReader.setLoginPieces(loginArray);
		  
		  
		  String loginFileString = "Heatlh Indicator DataBase Start";
		  
		  for(int i = 0; i < loginArray.size(); i++)
		  {
		  loginFileString += loginArray.get(i);
		  }
		 
		 	updateDatabase();	 
	
	}//end main Once this method has been called there should a an array and string composed of login.txt

	public void updateDatabase()
	{
		databaseWriter.writeLoginData("login.txt", loginArray);
		databaseWriter.writeDatabaseData("database.txt",dataArray);
	}
	
	public void addToLogin(LoginRecord recordPassed ) //This is for when logins are created
	{
		loginArray.add(recordPassed);
		databaseReader.setLoginPieces(loginArray);
	}
	
	public void addToData(SubmitData recordPassed)	//This is for when data is Submitted
	{
		dataArray.add(recordPassed);
		databaseReader.setDataPieces(dataArray);
	}


}//end class

class FileReader //The file reader actually is a passed an array of DataRecords
{

	List<SubmitData> dataPieces = new ArrayList<SubmitData>();
	List<LoginRecord> loginPieces = new ArrayList<LoginRecord>();
	
	public FileReader(List<SubmitData> dataPassed)
	{
		dataPieces = dataPassed;
		System.out.println("called");
		getUserRecords("Brent");
	}
	public void setLoginPieces(List<LoginRecord> passed)
	{
		loginPieces = passed;
	}
	
	public void setDataPieces( List<SubmitData> passed)
	{
		dataPieces = passed;
	}
	
	
	public ArrayList<SubmitData> getUserRecords(String userRequested)
	{
		ArrayList<SubmitData> dataToPass = new ArrayList<SubmitData>();
		for(int i = 0; i<dataPieces.size(); i++)
		{
			if(dataPieces.get(i).getUser().equals(userRequested)) //Find all records for user
			{
				dataToPass.add(dataPieces.get(i));
				System.out.print(i);
			}	
		}
		
		return dataToPass;
	}//end getUserRecords
	

	
}

class FileWriter //Filewriter is called everytime data is added into an array
{

 public void writeLoginData(String fileName,List<LoginRecord> arrayToWrite)
	 {
		File testFile = new File(fileName);	 
	 	try
		{
	 		PrintWriter dataWriter = new PrintWriter(testFile);
			dataWriter.println("Heatlh Indicator DataBase Start");

			for(LoginRecord recordInArray : arrayToWrite)
			{			
				dataWriter.println("User: " + recordInArray.getUserName());
				dataWriter.println("Pw: " + recordInArray.getPassword());
			}
			dataWriter.println("EOF");
				dataWriter.close();
				
	 	}catch(Exception e)
		{
		System.out.println("NO");
		}
	 }//end writeData
	 
	 public void writeDatabaseData(String fileName, SubmitData recordToWrite)
	 {
	 	List<SubmitData> arrayToPass = new ArrayList<SubmitData>();
		arrayToPass.add(recordToWrite);
		writeDatabaseData(fileName, arrayToPass);
	 }
	 
	 public void writeDatabaseData(String fileName,List<SubmitData> arrayToWrite)
	 {
		File testFile = new File(fileName);	 
	 	try
		{
	 		PrintWriter dataWriter = new PrintWriter(testFile);
			dataWriter.println("DataBase Start");

			for(SubmitData recordInArray : arrayToWrite)
			{			
				dataWriter.println("1 user: " + recordInArray.getUser());
				dataWriter.println("2 date: " + recordInArray.getDate());
				dataWriter.println("3 diastolic: " + recordInArray.getDiastolic());
				dataWriter.println("4 systolic: " + recordInArray.getSystolic());
				dataWriter.println("5 bloodSugar: " + recordInArray.getBloodSugar());
				dataWriter.println("6 pulseRate: " + recordInArray.getPulseRate());
				dataWriter.println("7 calorieIntake: " + recordInArray.getCalorieIntake());
				dataWriter.println("8 weight: " + recordInArray.getWeight());
				dataWriter.println("9 workHours: " + recordInArray.getWorkHours());
				dataWriter.println("a sleepHours: " + recordInArray.getSleepHours());
				dataWriter.println("b cardioInMinutes: " + recordInArray.getCardio());
				dataWriter.println("c strengthTraining: " + recordInArray.getStrengthTraining());
					
			}
			dataWriter.println("EOF");
				dataWriter.close();
				
	 	}catch(Exception e)
		{
		System.out.println("NO");
		}
	 }//end writeDatabaseData
}


class LoginRecord 
{
	public LoginRecord(String user, String pw)
	{
		userName = user;
		password = pw;
	}
	
	public LoginRecord()
	{
		userName = null;
		password = null;
	}
	public String userName;
	public String password;
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setUserName(String userGiven)
	{
		userName = userGiven;
	}
	
	public void setPassword(String passwordGiven)
	{
		password = passwordGiven;
	}
	
	public String toString()
	{
		String recordString = "";
		recordString = userName;
		recordString = recordString + "\n"+ password + "\n";
		return recordString;
	}
	
}

class Token //The token holds the login array and authenticates
{
	boolean validated = false;
	boolean userExists = false;
	private String currentUser = "";
	List<LoginRecord> users = new ArrayList<LoginRecord>();
	
	public Token(List<LoginRecord> dataPassed)
	{
		users = dataPassed;
	}

	public void setCurrentUser(String userPassed)
	{
		currentUser = userPassed;
	}

	public String getCurrentUser()
	{
		return currentUser;
	}
	
	public boolean getValidated()
	{
		return validated;
	}
	
	public boolean getUserExists()
	{
		return userExists;
	}
	
	public boolean authenticate(String userPassed, String passwordPassed)
	{
		setCurrentUser(userPassed);
		String passwordOfUser = "";
		
		for(int i = 0; i<users.size(); i++) //Try to Authenticate
		{
			if(currentUser.equals(users.get(i).getUserName()))
			{
				userExists = true;
				passwordOfUser = users.get(i).getPassword();
			}else
			{
				userExists = false;
			}
			
			if(userExists)
			{
				if(passwordPassed.equals(passwordOfUser))
				{
					validated = true;
					return true;
				}else
				{
					validated = false;
				}
				return false;
			}
		} //end for
		return false;
	}//end authenticate

}

