package create.gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignInFrame extends JFrame 
{
	
	Database database = new Database();
	// creating an array list of accounts
	public static ArrayList<Account> accountsArrayList = new ArrayList<Account>();
	
	// variable used to see which user is logged in.
	public static String userCurrentltLoggedIn = "";
	
	public static String getUserCurrentlyLoggedIN()
	{
		return userCurrentltLoggedIn;
	}
	
	public static void setUserCurrentlyLoggedIN( String newUserCurrentlyLoggedIN )
	{
		userCurrentltLoggedIn = newUserCurrentlyLoggedIN;
	}
		
	private StringPanel currentPanel;
	
	public boolean nextTextBox = false;
			
	public int answer = 0;
	
	public String opperand = "";
	private JTextField txtAccountName;
	private JTextField txtPassword;
	private final Action action = new SwingAction();
	
	public SignInFrame() 
	{
		setTitle("Health Project");
		getContentPane().setLayout(null);
		
		txtAccountName = new JTextField();
		txtAccountName.setBounds(159, 61, 86, 20);
		getContentPane().add(txtAccountName);
		txtAccountName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(159, 92, 86, 20);
		getContentPane().add(txtPassword);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean loginSuccessful = false;
				
				String login = txtAccountName.getText();
				String password = txtPassword.getText();
				
				for (Account a : accountsArrayList)
				{   
					if (a.getAccountName().equals(login) && a.getPassword().equals(password) )
					{			
						loginSuccessful = true;
						userCurrentltLoggedIn = login;
						ActivityFrame activityFrame = new ActivityFrame();
						activityFrame.start();
						dispose();
					}			
				}
				
				if (!loginSuccessful)
				{
					JOptionPane.showMessageDialog ( 
							   null, "Incorrect Login or Password" ); 
					
					txtAccountName.setText("");
					txtPassword.setText("");
					
				}
				
			}
		});
		btnNewButton.setBounds(101, 138, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Account Name or ID :");
		lblNewLabel.setBounds(21, 64, 128, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(72, 95, 74, 14);
		getContentPane().add(lblPassword);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an Account ?");
		lblDontHaveAn.setBounds(317, 64, 144, 14);
		getContentPane().add(lblDontHaveAn);
		
		JButton btnCreateAccount = new JButton("Sign Up");
		btnCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SignUpFrame signUp = new SignUpFrame();
				signUp.start();
				
								
			}
		});
		btnCreateAccount.setBounds(317, 91, 128, 23);
		getContentPane().add(btnCreateAccount);
		currentPanel = new StringPanel();
		
		File file = new File("accounts.txt");
				
		if(!file.exists()) 
		{ 
			//if accounts file does not exist.. crate an accounts file
			try 
			{
				FileOutputStream out = new FileOutputStream("accounts.txt");
				out.close();
			} 
			catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		// HERE i definitely know there is a accounts textfile that exists.
		// need to read line by line to add accounts from txt file to memory.
		
		
				
	}
	
	private void setupFrame()
	{
		this.setContentPane(currentPanel);
		
	}
	
	public void start()
	{
		this.setLocation(650, 400);
		this.setSize(530,250);
		this.setVisible(true);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
