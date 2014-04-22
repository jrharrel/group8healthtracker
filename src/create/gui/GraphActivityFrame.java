package create.gui;
//
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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GraphActivityFrame extends JFrame 
{	
	private StringPanel currentPanel;
	
	public boolean nextTextBox = false;
			
	public int answer = 0;
	
	public String opperand = "";
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_2;
	
	public GraphActivityFrame() 
	{
		getContentPane().setLayout(null);
		
		JLabel lblPulseRate = new JLabel("Blood Sugar");
		lblPulseRate.setBounds(30, 276, 96, 14);
		getContentPane().add(lblPulseRate);
		
		JLabel lblCalorieIntake = new JLabel("Pulse Rate");
		lblCalorieIntake.setBounds(30, 306, 96, 14);
		getContentPane().add(lblCalorieIntake);
		
		JLabel lblWeight = new JLabel("Calorie Intake");
		lblWeight.setBounds(30, 336, 96, 14);
		getContentPane().add(lblWeight);
		
		textField_9 = new JTextField();
		textField_9.setBounds(144, 273, 86, 20);
		textField_9.setColumns(10);
		getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBounds(145, 303, 86, 20);
		textField_10.setColumns(10);
		getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(144, 333, 86, 20);
		textField_11.setColumns(10);
		getContentPane().add(textField_11);
		
		JButton btnNewButton = new JButton("Submit All");
		btnNewButton.setBounds(121, 414, 109, 23);
		getContentPane().add(btnNewButton);
		
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
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(394, 376, 28, 23);
		getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(394, 336, 28, 23);
		getContentPane().add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(394, 296, 28, 23);
		getContentPane().add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(394, 256, 28, 23);
		getContentPane().add(checkBox_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 363, 86, 20);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		JLabel label_6 = new JLabel("Weight");
		label_6.setBounds(30, 363, 76, 14);
		getContentPane().add(label_6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Day");
		rdbtnNewRadioButton.setBounds(285, 414, 47, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMonth = new JRadioButton("Month");
		rdbtnMonth.setBounds(397, 414, 65, 23);
		getContentPane().add(rdbtnMonth);
		
		JRadioButton rdbtnWeek = new JRadioButton("Week");
		rdbtnWeek.setBounds(337, 414, 58, 23);
		getContentPane().add(rdbtnWeek);
		
		JButton btnNewButton_1 = new JButton("Graph");
		btnNewButton_1.setBounds(450, 151, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnGraph = new JButton("Graph");
		btnGraph.setBounds(450, 375, 89, 23);
		getContentPane().add(btnGraph);
		
		JButton btnNewButton_2 = new JButton("Sign Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(485, 427, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.setBounds(333, 227, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(52, 58, 341, 149);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Health Indicators");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(171, 22, 109, 14);
		getContentPane().add(lblNewLabel);
		
		currentPanel = new StringPanel();
	}
	
	public void start()
	{
		this.setLocation(650, 300);
		this.setSize(577,500);
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
