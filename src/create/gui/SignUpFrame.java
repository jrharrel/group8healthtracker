package create.gui;

import java.util.*;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class SignUpFrame extends JFrame 
{	
	
	public Random generator = new Random();
	private StringPanel currentPanel;
	
	// Variables used in Calculator
	
			// deciding which text box to put the data in
	public boolean nextTextBox = false;
			
	public int answer = 0;
	
	public String opperand = "";
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	public SignUpFrame() 
	{
		setTitle("Sign Up");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(45, 51, 76, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(45, 89, 76, 14);
		getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Create Acount");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean available = true;
				
				for (LoginRecord a : SignInFrame.accountsArrayList)
				{   
					if (a.getUserName().equals(txtUsername.getText()) )
					{	
						available = false; 
					}			
				}
								
				if (available &&  txtUsername.getText().equals("") || (!available))
				{
					JOptionPane.showMessageDialog ( 
						   null, "Cannot add account. Please check availability." ); 
				}
				else if (available && !txtUsername.getText().equals(""))
				{
					String userName = txtUsername.getText();
					String password = txtPassword.getText();
					
					boolean foundValidID = false;
					boolean neverReached = true;
					
					// this will always change.. need to initialize it to be able to use it. 
					int ID = 9999999;
					
					
						/*ID = generator.nextInt( 9999998 ) + 1;
						
						for (Account a : SignInFrame.accountsArrayList)
						{   
							if (a.getID() == ID )
							{	
								 neverReached = false;
							}			
						}
						
						if (neverReached)
						{
							foundValidID = true;
						}
						
					}
					while ( !foundValidID );
					*/
					
					txtUsername.setText("");
					txtPassword.setText("");
					
					Account accountToAdd = new Account(userName, password, ID);
					//SignInFrame.accountsArrayList.add(accountToAdd);
					LoginRecord recordToAdd = new LoginRecord(userName, password);
					
					SignInFrame.addLogin(recordToAdd);
					
					
					JOptionPane.showMessageDialog ( 
							   null, "Account Created" );
					
					dispose();
					
				
					

					//SignInFrame string = new SignInFrame();
					//string.start();
					//dispose();
					
					
					
				}			
				
				
				
			}
		});
		btnNewButton.setBounds(118, 151, 141, 23);
		getContentPane().add(btnNewButton);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(131, 48, 86, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnCheckAvailability = new JButton("Check Availability");
		btnCheckAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{// check availability
					
				boolean available = true;
				
				for (LoginRecord a : SignInFrame.accountsArrayList)
				{   
					if (a.getUserName().equals(txtUsername.getText()) )
					{	
						available = false;
						
						JOptionPane.showMessageDialog ( 
								   null, "Username Already in use." ); 
					}			
				}
								
				if (available &&  txtUsername.getText().equals(""))
				{
					JOptionPane.showMessageDialog ( 
						   null, "Cannot have empty Text Box." ); 
				}
				else if (available && !txtUsername.getText().equals(""))
				{
					JOptionPane.showMessageDialog ( 
							   null, "Username Available." ); 
				}
						
			}
		});
		btnCheckAvailability.setBounds(241, 47, 141, 23);
		getContentPane().add(btnCheckAvailability);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(131, 86, 86, 20);
		getContentPane().add(txtPassword);
		
		currentPanel = new StringPanel();
	}
	
	public void start()
	{
        this.setLocation(300, 200);
		this.setSize(530,250);
		this.setVisible(true);
	}

	private class SwingAction extends AbstractAction 
	{
		public SwingAction() 
		{
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) 
		{
			
		}
	}
}
