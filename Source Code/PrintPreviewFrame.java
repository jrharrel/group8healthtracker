package create.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.print.PrinterException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import java.awt.Toolkit;
 


public class PrintPreviewFrame extends JFrame 
{					
	private StringPanel currentPanel;
	
	public boolean nextTextBox = false;
			
	public int answer = 0;
	
	public String opperand = "";
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();
	
	public PrintPreviewFrame() 
	{
		getContentPane().setLayout(null);
		
		final JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setBounds(10, 43, 559, 437);
		getContentPane().add(jTextArea1);
		
		// this is used to get the current user that is logged in so w know what txt file to read from
		String currentUser = SignInFrame.getUserCurrentlyLoggedIN();
				
		String fileName = "" + currentUser+".txt";
				
		try 
		{
			String textLine;
			FileReader fr = new FileReader("jadeswanson.txt");
			BufferedReader reader = new BufferedReader(fr);
			String line;
			while ((line = reader.readLine()) != null)
			{
			    if (!line.startsWith(">"))
			    {
			        jTextArea1.append(line + "\n");
			    }
			} 
		}
		catch (IOException ioe) 
		{
			System.err.println(ioe);		
		}
		
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{// this is to print
				try 
				{
					boolean complete = jTextArea1.print();
					
					if ( complete )
					{
						JOptionPane.showMessageDialog(null,"Done printing" , "Information", JOptionPane.INFORMATION_MESSAGE );
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Printing" , "Printer", JOptionPane.ERROR_MESSAGE );
					}				
				}
				catch (PrinterException e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
								
			}
		});
		btnNewButton.setBounds(379, 9, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				jTextArea1.setText("");
				dispose();
			}
		});
		btnNewButton_1.setBounds(480, 9, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		currentPanel = new StringPanel();
	}
	
	public void start()
	{
		this.setLocation(300, 150);
		this.setSize(595,529);
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
