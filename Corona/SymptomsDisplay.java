import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class SymptomsDisplay implements ActionListener {

	JFrame frame;
	private JTextField ageTextField;
	private JTextField residenceCountryTextField;
	private JTextField weightTextField;
	private JTextField heightTextField;
	
	private JCheckBox feverCheckBox;
	private JCheckBox chckbxShortnessOfBreath;
	private JCheckBox chckbxLossOfSmelltase;
	private JCheckBox chckbxMusclePain;
	
	private JCheckBox coughCheckBox;
	private JCheckBox chckbxChills;
	private JCheckBox soreThroatCheckBox;
	private JCheckBox chckbxHeadache;
	
	private JComboBox visitedCheckList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SymptomsDisplay sympWindow = new SymptomsDisplay();
					sympWindow.frame.setVisible(true);
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
		
		ageTextField = new JTextField();
		ageTextField.setBounds(58, 151, 54, 26);
		frame.getContentPane().add(ageTextField);
		ageTextField.setColumns(10);
		
		JLabel lblSymptomsifAny = new JLabel("Symptoms");
		lblSymptomsifAny.setBounds(311, 225, 71, 16);
		frame.getContentPane().add(lblSymptomsifAny);
		
		feverCheckBox = new JCheckBox("Fever");
		feverCheckBox.setBounds(179, 275, 71, 23);
		frame.getContentPane().add(feverCheckBox);
		
		chckbxShortnessOfBreath = new JCheckBox("Shortness of Breath");
		chckbxShortnessOfBreath.setBounds(371, 275, 155, 23);
		frame.getContentPane().add(chckbxShortnessOfBreath);
		
		chckbxLossOfSmelltase = new JCheckBox("Loss of Smell/Taste");
		chckbxLossOfSmelltase.setBounds(179, 310, 161, 23);
		frame.getContentPane().add(chckbxLossOfSmelltase);
		
		chckbxMusclePain = new JCheckBox("Muscle Pain");
		chckbxMusclePain.setBounds(371, 310, 128, 23);
		frame.getContentPane().add(chckbxMusclePain);
		
		JLabel lblCheckAllThat = new JLabel("check all that apply");
		lblCheckAllThat.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblCheckAllThat.setBounds(296, 241, 88, 16);
		frame.getContentPane().add(lblCheckAllThat);
		
		visitedCheckList = new JComboBox();
		visitedCheckList.setBounds(265, 106, 130, 27);
		frame.getContentPane().add(visitedCheckList);
		
		JLabel lblCountryVisitedIn = new JLabel("Country last visited in 2020:");
		lblCountryVisitedIn.setBounds(24, 110, 185, 16);
		frame.getContentPane().add(lblCountryVisitedIn);
		
		residenceCountryTextField = new JTextField();
		residenceCountryTextField.setBounds(265, 61, 130, 26);
		frame.getContentPane().add(residenceCountryTextField);
		residenceCountryTextField.setColumns(10);
		Globals.country_visited = residenceCountryTextField.getText(); //this gives us user inout for country visited
		
		
		JLabel lblWeight = new JLabel("Weight(kg):");
		lblWeight.setBounds(192, 156, 88, 16);
		frame.getContentPane().add(lblWeight);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(275, 151, 54, 26);
		frame.getContentPane().add(weightTextField);
		weightTextField.setColumns(10);
		
		JLabel lblHeightm = new JLabel("Height(m):");
		lblHeightm.setBounds(388, 156, 71, 16);
		frame.getContentPane().add(lblHeightm);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(464, 151, 62, 26);
		frame.getContentPane().add(heightTextField);
		heightTextField.setColumns(10);
		
		
		coughCheckBox = new JCheckBox("Cough");
		coughCheckBox.setBounds(179, 345, 128, 23);
		frame.getContentPane().add(coughCheckBox);
		
		chckbxChills = new JCheckBox("Chills");
		chckbxChills.setBounds(371, 345, 128, 23);
		frame.getContentPane().add(chckbxChills);
		
		soreThroatCheckBox = new JCheckBox("Sore Throat");
		soreThroatCheckBox.setBounds(179, 380, 128, 23);
		frame.getContentPane().add(soreThroatCheckBox);
		
		chckbxHeadache = new JCheckBox("Headache");
		chckbxHeadache.setBounds(371, 380, 128, 23);
		frame.getContentPane().add(chckbxHeadache);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(233, 427, 200, 50);
		frame.getContentPane().add(submitButton);
		
		JButton backButton = new JButton("Muzz is Soft");
		backButton.setBounds(6, 6, 140, 26);
		frame.getContentPane().add(backButton);
		submitButton.addActionListener(this);
		
		backButton.addActionListener(this);
	
	}

	public double calculateBMI(String weight, String height) {
		int userWeight = toInt(weight);
		double userHeight = ((double) toInt(height)) / 100;
		double BMI = userWeight / (Math.pow(userHeight, 2));
		return BMI;
	}
	
	public int checkBMI(float BMI, int age) {
		if (age < 35) {
			if (BMI > 18 && BMI < 26) {
				System.out.println("You are in good shape brother or sister");
				return 1;
			}
			else {
				if (BMI > 26 && BMI < 45) {
					System.out.println("You are not in good shape");
					return 4;
				}
				else {
					return 5; 
				}
			}
		}
		else {
			if (BMI > 22 && BMI < 32) {
				System.out.println("You are in good shape brother or sister");
				return 1;
			}
			else {
				if (BMI > 33 && BMI < 47) {
					System.out.println("You are not in good shape");
					return 4;
				}
				else {
					return 5; 
				}
			}
		}
	}
	
	public int checkSoreThroat(Boolean input) {
		if(input) {
			return 5;
		}
		return 0;
	}
	
	public int checkShortnessOfBreath(Boolean input) {
		if(input) {
			return 5;
		}
		return 0;
	}
	
	
	
	public int toInt(String input) {
		return Integer.parseInt(input);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println(action);
		if (action.equals("Muzz is Soft")) {
			frame.dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Display window = new Display();
						window.frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if (action.equals("Submit")) {
			
			String countryResidence = residenceCountryTextField.getText();
			String age = ageTextField.getText();
			String weight = weightTextField.getText();
			String height = heightTextField.getText();
			Boolean fever = feverCheckBox.isSelected();
			Boolean lossOfSmell = chckbxLossOfSmelltase.isSelected();
			Boolean cough = coughCheckBox.isSelected();
			Boolean SoreThroat = soreThroatCheckBox.isSelected();
			Boolean ShortnessBreath = chckbxShortnessOfBreath.isSelected();
			Boolean musclePain = chckbxMusclePain.isSelected();
			Boolean chills = chckbxChills.isSelected();
			Boolean headache = chckbxHeadache.isSelected();
				
//			double BMIpp =  calculateBMI(weight, height);
			System.out.println(headache);
		}
		
	}
	
	
}
