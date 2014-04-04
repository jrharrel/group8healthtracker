import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.PrintWriter;


class Database{	

	public static void main(String[] args) {
	//this will be the createLoginData method
	
	
	List<LoginRecord> loginArray = new ArrayList<LoginRecord>();
	int loginArrayPosition = 0;
	int loginArrayReaderPosition = 0;
	LoginRecord currentRecord = new LoginRecord();
	File loginFile = new File("login.txt");

        try {
 
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
						
						loginArray.add(new LoginRecord());
						}
					
            }
            readScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		  
		  String loginFileString = "Heatlh Indicator DataBase Start";
		  
		  for(int i = 0; i <= loginArrayPosition; i++)
		  {
		  loginFileString += loginArray.get(i);
		  }
		  
		  FileWriter tester = new FileWriter();
		  tester.writeLoginData("test.txt", loginArray);
		  

	
	//make an array of login records to check login

	//use a UserRecord to store and retrieve data

	//
	
	}//end main Once this method has been called there should a an array and string composed of login.txt
	
   
	
		
	 
 
}//end class

class FileWriter
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



