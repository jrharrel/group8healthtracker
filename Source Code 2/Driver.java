package create.gui;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.PrintWriter;


public class Driver 
{
	
	
	public static void main(String[] args)
	{
		SignInFrame frame = new SignInFrame();
		Database database = new DataBase();
		frame.start();
		frame.setDatabase();
		have the sign in frame hold a database.  
		All data is now available via signinframe
	}
	
}

