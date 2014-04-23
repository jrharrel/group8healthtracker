package create.gui;

import java.util.Date;
import java.util.Calendar;
import java.util.Date;

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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.awt.Component;

import javax.swing.Box;


//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

import javax.swing.JMenu;

public class ActivityFrame extends JFrame 
{	
	String currentUser;
	Graphing chartGrapher;
	
	
	public void setCurrentUser(String userPassed)
	{
		currentUser = userPassed;
	}
	
	private StringPanel currentPanel;
	public boolean nextTextBox = false;
			
	public int answer = 0;
	
	Database database = new Database();
	
	public String opperand = "";
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();
	private JTextField txtWorkHours;
	private JTextField txtSleepHours;
	private JTextField txtCardioInMinutes;
	private JTextField txtStrengthTraining;
	private JTextField txtBloodSugar;
	private JTextField txtPulseRate;
	private JTextField txtCalorieIntake;
	private JTextField txtWeight;
	private JTextField txtSystolic;
	private JTextField txtDiastolic;
	
	
	public ActivityFrame() 
	{
		
		
		Date currentDate = new Date();
		Calendar testCalendar = Calendar.getInstance();
		testCalendar.setTime(currentDate);
		String currentDatePassed =   (testCalendar.get(Calendar.MONTH)+ 1) + "/" + testCalendar.get(Calendar.DAY_OF_MONTH)+ "/" + 
		testCalendar.get(Calendar.YEAR);
		
		chartGrapher = new Graphing(currentDatePassed);
		 
		getContentPane().setLayout(null);
		
		JLabel lblWorkHours = new JLabel("Work Hours");
		lblWorkHours.setBounds(43, 72, 114, 14);
		getContentPane().add(lblWorkHours);
		
		JLabel lblSleepHours = new JLabel("Sleep Hours");
		lblSleepHours.setBounds(30, 102, 114, 14);
		getContentPane().add(lblSleepHours);
		
		JLabel lblCardioInMinutes = new JLabel("Cardio in minutes");
		lblCardioInMinutes.setBounds(30, 132, 114, 14);
		getContentPane().add(lblCardioInMinutes);
		
		JLabel lblStrengthTraining = new JLabel("Strength Training");
		lblStrengthTraining.setBounds(30, 162, 130, 14);
		getContentPane().add(lblStrengthTraining);
		
		JLabel lblPulseRate = new JLabel("Blood Sugar");
		lblPulseRate.setBounds(30, 309, 96, 14);
		getContentPane().add(lblPulseRate);
		
		JLabel lblCalorieIntake = new JLabel("Pulse Rate");
		lblCalorieIntake.setBounds(30, 339, 96, 14);
		getContentPane().add(lblCalorieIntake);
		
		JLabel lblWeight = new JLabel("Calorie Intake");
		lblWeight.setBounds(30, 369, 96, 14);
		getContentPane().add(lblWeight);
		
		txtWorkHours = new JTextField();
		txtWorkHours.setBounds(144, 69, 86, 20);
		getContentPane().add(txtWorkHours);
		txtWorkHours.setColumns(10);
		
		txtSleepHours = new JTextField();
		txtSleepHours.setBounds(145, 99, 86, 20);
		txtSleepHours.setColumns(10);
		getContentPane().add(txtSleepHours);
		
		txtCardioInMinutes = new JTextField();
		txtCardioInMinutes.setBounds(145, 129, 86, 20);
		txtCardioInMinutes.setColumns(10);
		getContentPane().add(txtCardioInMinutes);
		
		txtStrengthTraining = new JTextField();
		txtStrengthTraining.setBounds(144, 159, 86, 20);
		txtStrengthTraining.setColumns(10);
		getContentPane().add(txtStrengthTraining);
		
		txtBloodSugar = new JTextField();
		txtBloodSugar.setBounds(144, 306, 86, 20);
		txtBloodSugar.setColumns(10);
		getContentPane().add(txtBloodSugar);
		
		txtPulseRate = new JTextField();
		txtPulseRate.setBounds(145, 336, 86, 20);
		txtPulseRate.setColumns(10);
		getContentPane().add(txtPulseRate);
		
		txtCalorieIntake = new JTextField();
		txtCalorieIntake.setBounds(144, 366, 86, 20);
		txtCalorieIntake.setColumns(10);
		getContentPane().add(txtCalorieIntake);
		
		final JCheckBox checkBoxWorkHours = new JCheckBox("");
		checkBoxWorkHours.setBounds(393, 32, 28, 23);
		getContentPane().add(checkBoxWorkHours);
		
		final JCheckBox checkBoxSleepHours = new JCheckBox("");
		checkBoxSleepHours.setBounds(393, 72, 28, 23);
		getContentPane().add(checkBoxSleepHours);
		
		final JCheckBox checkBoxCardio = new JCheckBox("");
		checkBoxCardio.setBounds(393, 112, 28, 23);
		getContentPane().add(checkBoxCardio);
		
		final JCheckBox checkBoxStrength = new JCheckBox("");
		checkBoxStrength.setBounds(393, 152, 28, 23);
		getContentPane().add(checkBoxStrength);
		
		JLabel label = new JLabel("Work Hours");
		label.setBounds(291, 35, 96, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Sleep Hours");
		label_1.setBounds(291, 75, 96, 14);
		getContentPane().add(label_1);
		
		JLabel lblCardio = new JLabel("Cardio");
		lblCardio.setBounds(291, 115, 47, 14);
		getContentPane().add(lblCardio);
		
		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setBounds(291, 155, 58, 14);
		getContentPane().add(lblStrength);
		
		JLabel lblBloodPressure_1 = new JLabel("Blood Pressure");
		lblBloodPressure_1.setBounds(291, 259, 96, 14);
		getContentPane().add(lblBloodPressure_1);
		
		JLabel lblBloodSugar = new JLabel("Blood Sugar");
		lblBloodSugar.setBounds(291, 299, 96, 14);
		getContentPane().add(lblBloodSugar);
		
		JLabel lblPulseRate_1 = new JLabel("Pulse Rate");
		lblPulseRate_1.setBounds(291, 339, 78, 14);
		getContentPane().add(lblPulseRate_1);
		
		JLabel lblCalorieIntake_1 = new JLabel("Calorie Intake");
		lblCalorieIntake_1.setBounds(291, 379, 96, 14);
		getContentPane().add(lblCalorieIntake_1);
		
		final JCheckBox checkBoxCalorieIntake = new JCheckBox("");
		checkBoxCalorieIntake.setBounds(394, 376, 28, 23);
		getContentPane().add(checkBoxCalorieIntake);
		
		final JCheckBox checkBoxPulseRate = new JCheckBox("");
		checkBoxPulseRate.setBounds(394, 336, 28, 23);
		getContentPane().add(checkBoxPulseRate);
		
		final JCheckBox checkBoxBloodSugar = new JCheckBox("");
		checkBoxBloodSugar.setBounds(394, 296, 28, 23);
		getContentPane().add(checkBoxBloodSugar);
		
		final JCheckBox checkBoxBloodPressure = new JCheckBox("");
		checkBoxBloodPressure.setBounds(394, 256, 28, 23);
		getContentPane().add(checkBoxBloodPressure);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(144, 396, 86, 20);
		txtWeight.setColumns(10);
		getContentPane().add(txtWeight);
		
		JLabel label_6 = new JLabel("Weight");
		label_6.setBounds(30, 396, 76, 14);
		getContentPane().add(label_6);

		final JRadioButton radWeekActivity = new JRadioButton("Week");
		final JRadioButton radDayActivity = new JRadioButton("Day");
		final JRadioButton radWeekHealthIndicator = new JRadioButton("Week");		
		final JRadioButton radMonthHealthIndicator = new JRadioButton("Month");		
		final JRadioButton radDayHealthIndicator = new JRadioButton("Day");
		final JRadioButton radMonthActivity = new JRadioButton("Month");
		
		radDayHealthIndicator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( radDayHealthIndicator.isSelected() )
				{
					radWeekHealthIndicator.setSelected(false);
					radMonthHealthIndicator.setSelected(false);
					
				}
			}
		});
		radDayHealthIndicator.setBounds(285, 414, 47, 23);
		getContentPane().add(radDayHealthIndicator);

		radMonthHealthIndicator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( radMonthHealthIndicator.isSelected() )
				{
					radWeekHealthIndicator.setSelected(false);
					radDayHealthIndicator.setSelected(false);
					
				}
			}
		});
		radMonthHealthIndicator.setBounds(397, 414, 65, 23);
		getContentPane().add(radMonthHealthIndicator);

		radWeekHealthIndicator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( radWeekHealthIndicator.isSelected() )
				{
					radDayHealthIndicator.setSelected(false);
					radMonthHealthIndicator.setSelected(false);
					
				}
			}
		});
		radWeekHealthIndicator.setBounds(337, 414, 58, 23);
		getContentPane().add(radWeekHealthIndicator);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(254, -16, 12, 524);
		getContentPane().add(verticalStrut);
		radDayActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( radDayActivity.isSelected() )
				{
					radWeekActivity.setSelected(false);
					radMonthActivity.setSelected(false);
					
				}
			}
		});
		radDayActivity.setBounds(285, 188, 47, 23);
		getContentPane().add(radDayActivity);
		
		
		radWeekActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( radWeekActivity.isSelected() )
				{
					radDayActivity.setSelected(false);
					radMonthActivity.setSelected(false);
					
				}
			}
		});
		radWeekActivity.setBounds(337, 188, 58, 23);
		getContentPane().add(radWeekActivity);
		
	
		radMonthActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if ( radMonthActivity.isSelected() )
				{
					radDayActivity.setSelected(false);
					radWeekActivity.setSelected(false);
					
				}
			}
		});
		radMonthActivity.setBounds(397, 188, 65, 23);
		getContentPane().add(radMonthActivity);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(260, 225, 350, 12);
		getContentPane().add(horizontalStrut);
		
		JLabel lblNewLabel_2 = new JLabel("Health Indicators");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(30, 233, 130, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblActivities = new JLabel("Activities");
		lblActivities.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblActivities.setBounds(30, 31, 76, 14);
		getContentPane().add(lblActivities);
		
		txtSystolic = new JTextField();
		txtSystolic.setColumns(10);
		txtSystolic.setBounds(144, 275, 40, 20);
		getContentPane().add(txtSystolic);
		
		txtDiastolic = new JTextField();
		txtDiastolic.setColumns(10);
		txtDiastolic.setBounds(190, 275, 40, 20);
		getContentPane().add(txtDiastolic);
		
		JLabel label_2 = new JLabel("Blood Pressure");
		label_2.setBounds(30, 278, 96, 14);
		getContentPane().add(label_2);
		
		JLabel lblSys = new JLabel("Sys");
		lblSys.setBounds(154, 258, 28, 14);
		getContentPane().add(lblSys);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(197, 259, 28, 14);
		getContentPane().add(lblDia);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("   File");
		menuBar.add(mnNewMenu);
		
		JMenuItem submitAllMenuItem = new JMenuItem("  Submit All");
		
		submitAllMenuItem.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent arg0) 
			{// action to submit data
				
				JOptionPane.showMessageDialog ( 
						   null, "You have successfully submitted all of your data." ); 
			
				// This variable is used to know which user is currently logged in 
				// for writing the data to the correct users text file.
				String userLoggedIn = SignInFrame.getUserCurrentlyLoggedIN();
				Date currentDate = new Date();
				Calendar testCalendar = Calendar.getInstance();
				testCalendar.setTime(currentDate);
				String dateToPass =   (testCalendar.get(Calendar.MONTH)+ 1) + "/" + testCalendar.get(Calendar.DAY_OF_MONTH)+ "/" + 
						testCalendar.get(Calendar.YEAR);
				
			
				
				SubmitData newSubmitDataObject = new SubmitData( userLoggedIn ,
						                                       dateToPass, 
						                                    checkString(txtDiastolic),
						                       				checkString(txtSystolic),
						                       				checkString(txtBloodSugar),
						                       				checkString(txtPulseRate),
						                       				checkString(txtCalorieIntake),
						                       				checkString(txtWeight),
						                       				checkString(txtWorkHours),
						                       				checkString(txtSleepHours),
						                       				checkString(txtCardioInMinutes),
						                       				checkString(txtStrengthTraining) );
				// send this record to DataBase
				
				database.addToData(newSubmitDataObject);
			
			}
			
		});
		mnNewMenu.add(submitAllMenuItem);
		
		JMenuItem graphActivitiesMenuItem = new JMenuItem("  Graph Activities");
		graphActivitiesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chartGrapher.setUserData(database.databaseReader.getUserRecords(currentUser));
				//chartGrapher.returnGraph(timeframe, booleans); //booleans set the items to be graphed
				//TRA
				
			}
		});
		mnNewMenu.add(graphActivitiesMenuItem);
		
		JMenuItem graphHealthIndicatorsMenuItem = new JMenuItem("  Graph Health Indicators");
		graphHealthIndicatorsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chartGrapher.setUserData(database.databaseReader.getUserRecords(currentUser));
				//chartGrapher.returnGraph(timeframe, booleans);
			}
		});
		mnNewMenu.add(graphHealthIndicatorsMenuItem);
		
		
		
		JMenuItem printPreviewMenuItem = new JMenuItem("  Print Preview");
		printPreviewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PrintPreviewFrame preview = new PrintPreviewFrame();
				preview.start();
			}
		});
		printPreviewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mnNewMenu.add(printPreviewMenuItem);
		
		JMenuItem signOutMenuItem = new JMenuItem("  Sign Out");
		signOutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SignInFrame.setUserCurrentlyLoggedIN("");
				
				SignInFrame newFrame = new SignInFrame();
				newFrame.start();
				
				dispose();
			}
		});
		mnNewMenu.add(signOutMenuItem);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmClearAll = new JMenuItem("Clear All");
		mntmClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
// this is used to set the activity frame to its default setting
				
				txtWorkHours.setText("");
				txtSleepHours.setText("");
				txtCardioInMinutes.setText("");
				txtStrengthTraining.setText("");
				txtSystolic.setText("");
				txtDiastolic.setText("");
				txtBloodSugar.setText("");
				txtPulseRate.setText("");
				txtCalorieIntake.setText("");
				txtWeight.setText("");
				checkBoxWorkHours.setSelected(false);
				checkBoxSleepHours.setSelected(false);
				checkBoxCardio.setSelected(false);
				checkBoxStrength.setSelected(false);
				checkBoxBloodPressure.setSelected(false);
				checkBoxBloodSugar.setSelected(false);
				checkBoxPulseRate.setSelected(false);
				checkBoxCalorieIntake.setSelected(false);
				radDayActivity.setSelected(true);
				radWeekActivity.setSelected(false);
				radMonthActivity.setSelected(false);
				radDayHealthIndicator.setSelected(true);
				radWeekHealthIndicator.setSelected(false);
				radMonthHealthIndicator.setSelected(false);
			}
		});
		mnEdit.add(mntmClearAll);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpContents = new JMenuItem("Help Contents");
		mntmHelpContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				// show this message when the user clicks on help
				JOptionPane.showMessageDialog ( 
						   null, "\nPlease Visit Our Website: \n\nhttps://www.healthTracker.org/" );
			}//
		});
		mnHelp.add(mntmHelpContents);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		
		currentPanel = new StringPanel();
	}
	
	public void start()
	{
		this.setLocation(300, 150);
		this.setSize(595,529);
		this.setVisible(true);
	}
	
	public double checkString(JTextField fieldSent){
		double blank = -1.0;
		if(fieldSent.getText().equals("")) {
	        return blank;
	    }else {
	    	
	    	try {
	    		return Double.parseDouble( fieldSent.getText() );
	    	} catch (NumberFormatException e) {
	    	    
	    	    return -1;
	    	}
	    	
	    }
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
