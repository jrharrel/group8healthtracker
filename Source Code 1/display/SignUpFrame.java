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

public class SignUpFrame extends JFrame 
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
	private JTextField textField_2;
	private JTextField textField_3;
	
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
				StringFrame string = new StringFrame();
				string.start();
				dispose();
				
			}
		});
		btnNewButton.setBounds(118, 151, 141, 23);
		getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 48, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCheckAvailability = new JButton("Check Availability");
		btnCheckAvailability.setBounds(241, 47, 141, 23);
		getContentPane().add(btnCheckAvailability);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, 86, 86, 20);
		getContentPane().add(textField_3);
		
		currentPanel = new StringPanel();
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
