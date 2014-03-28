package create.gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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

public class StringFrame extends JFrame 
{	
	private StringPanel currentPanel;
	
	// Variables used in Calculator
	
			// deciding which text box to put the data in
	public boolean nextTextBox = false;
			
	public int answer = 0;
	
	public String opperand = "";
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();
	
	public StringFrame() 
	{
		setTitle("Health Project");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(159, 61, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 92, 86, 20);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ActivityFrame activityFrame = new ActivityFrame();
				activityFrame.start();
				dispose();
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
				dispose();
				
			}
		});
		btnCreateAccount.setBounds(317, 91, 128, 23);
		getContentPane().add(btnCreateAccount);
		currentPanel = new StringPanel();
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
