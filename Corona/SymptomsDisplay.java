import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class SymptomsDisplay  {

	JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SymptomsDisplay window = new SymptomsDisplay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SymptomsDisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 666, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("Risk of Exposure");
		lblPersonalInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblPersonalInformation.setBounds(278, 6, 200, 26);
		frame.getContentPane().add(lblPersonalInformation);
		
		JLabel lblCountry = new JLabel("Where are you currently residing: ");
		lblCountry.setBounds(24, 66, 222, 16);
		frame.getContentPane().add(lblCountry);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(24, 156, 33, 16);
		frame.getContentPane().add(lblAge);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 151, 54, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSymptomsifAny = new JLabel("Symptoms");
		lblSymptomsifAny.setBounds(311, 225, 71, 16);
		frame.getContentPane().add(lblSymptomsifAny);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Fever");
		chckbxNewCheckBox.setBounds(179, 275, 71, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxShortnessOfBreath = new JCheckBox("Shortness of Breath");
		chckbxShortnessOfBreath.setBounds(371, 275, 155, 23);
		frame.getContentPane().add(chckbxShortnessOfBreath);
		
		JCheckBox chckbxLossOfSmelltase = new JCheckBox("Loss of Smell/Taste");
		chckbxLossOfSmelltase.setBounds(179, 310, 161, 23);
		frame.getContentPane().add(chckbxLossOfSmelltase);
		
		JCheckBox chckbxMusclePain = new JCheckBox("Muscle Pain");
		chckbxMusclePain.setBounds(371, 310, 128, 23);
		frame.getContentPane().add(chckbxMusclePain);
		
		JLabel lblCheckAllThat = new JLabel("check all that apply");
		lblCheckAllThat.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblCheckAllThat.setBounds(296, 241, 88, 16);
		frame.getContentPane().add(lblCheckAllThat);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(265, 106, 130, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblCountryVisitedIn = new JLabel("Country last visited in 2020:");
		lblCountryVisitedIn.setBounds(24, 110, 185, 16);
		frame.getContentPane().add(lblCountryVisitedIn);
		
		textField = new JTextField();
		textField.setBounds(265, 61, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight(kg):");
		lblWeight.setBounds(192, 156, 88, 16);
		frame.getContentPane().add(lblWeight);
		
		textField_2 = new JTextField();
		textField_2.setBounds(275, 151, 54, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHeightm = new JLabel("Height(m):");
		lblHeightm.setBounds(388, 156, 71, 16);
		frame.getContentPane().add(lblHeightm);
		
		textField_3 = new JTextField();
		textField_3.setBounds(464, 151, 62, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Cough");
		chckbxNewCheckBox_1.setBounds(179, 345, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxChills = new JCheckBox("Chills");
		chckbxChills.setBounds(371, 345, 128, 23);
		frame.getContentPane().add(chckbxChills);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Sore Throat");
		chckbxNewCheckBox_2.setBounds(179, 380, 128, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxHeadache = new JCheckBox("Headache");
		chckbxHeadache.setBounds(371, 380, 128, 23);
		frame.getContentPane().add(chckbxHeadache);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(233, 427, 200, 50);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("Muzz is Soft");
		btnNewButton.setBounds(6, 6, 140, 26);
		frame.getContentPane().add(btnNewButton);
		btnSubmit.addActionListener(new Action());
	
	}
	
	static class Action implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			
			System.out.println("hello");
			
		}
	}
	
	
}
