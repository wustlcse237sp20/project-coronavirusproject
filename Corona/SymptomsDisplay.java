import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;



public class SymptomsDisplay implements ActionListener {

	JFrame frame;
	private JTextField ageTextField;
	private JTextField residenceTextField;
	private JTextField weightTextField;
	private JTextField heightTextField;
	
	private JCheckBox chckbxFever;
	private JCheckBox chckbxShortnessOfBreath;
	private JCheckBox chckbxLossOfSmelltaste;
	private JCheckBox chckbxMusclePain;
	
	private JCheckBox chckbxCough;
	private JCheckBox chckbxChills;
	private JCheckBox chckbxSoreThroat;
	private JCheckBox chckbxHeadache;
	private JCheckBox chckbxConditionsApply;
	
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
		lblPersonalInformation.setBounds(192, 1, 200, 26);
		frame.getContentPane().add(lblPersonalInformation);
		
		JLabel lblCountry = new JLabel("What city are you currently residing in: ");
		lblCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCountry.setBounds(24, 66, 190, 16);
		frame.getContentPane().add(lblCountry);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(24, 156, 33, 16);
		frame.getContentPane().add(lblAge);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(58, 151, 54, 26);
		frame.getContentPane().add(ageTextField);
		ageTextField.setColumns(10);
		
		JLabel lblSymptomsifAny = new JLabel("Symptoms");
		lblSymptomsifAny.setBounds(96, 200, 71, 16);
		frame.getContentPane().add(lblSymptomsifAny);
		
		chckbxFever = new JCheckBox("Fever");
		chckbxFever.setBounds(6, 234, 71, 23);
		frame.getContentPane().add(chckbxFever);
		
		chckbxShortnessOfBreath = new JCheckBox("Shortness of Breath");
		chckbxShortnessOfBreath.setBounds(174, 234, 155, 23);
		frame.getContentPane().add(chckbxShortnessOfBreath);
		
		chckbxLossOfSmelltaste = new JCheckBox("Loss of Smell/Taste");
		chckbxLossOfSmelltaste.setBounds(6, 269, 161, 23);
		frame.getContentPane().add(chckbxLossOfSmelltaste);
		
		chckbxMusclePain = new JCheckBox("Muscle Pain");
		chckbxMusclePain.setBounds(174, 273, 128, 23);
		frame.getContentPane().add(chckbxMusclePain);
		
		JLabel lblCheckAllThat = new JLabel("check all that apply");
		lblCheckAllThat.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblCheckAllThat.setBounds(79, 213, 88, 16);
		frame.getContentPane().add(lblCheckAllThat);
		
		visitedCheckList = new JComboBox();
		visitedCheckList.setBounds(423, 106, 130, 27);
		frame.getContentPane().add(visitedCheckList);
		
		JLabel lblCountryVisitedIn = new JLabel("If you have visited another country in 2020, please select the most recent one");
		lblCountryVisitedIn.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCountryVisitedIn.setBounds(24, 110, 381, 16);
		frame.getContentPane().add(lblCountryVisitedIn);
		
		residenceTextField = new JTextField();
		residenceTextField.setBounds(226, 60, 130, 26);
		frame.getContentPane().add(residenceTextField);
		residenceTextField.setColumns(10);
		// Globals.country_visited = residenceCountryTextField.getText(); //this gives us user inout for country visited
		
		
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
		
		
		chckbxCough = new JCheckBox("Cough");
		chckbxCough.setBounds(6, 304, 128, 23);
		frame.getContentPane().add(chckbxCough);
		
		chckbxChills = new JCheckBox("Chills");
		chckbxChills.setBounds(174, 308, 128, 23);
		frame.getContentPane().add(chckbxChills);
		
		chckbxSoreThroat = new JCheckBox("Sore Throat");
		chckbxSoreThroat.setBounds(6, 339, 128, 23);
		frame.getContentPane().add(chckbxSoreThroat);
		
		chckbxHeadache = new JCheckBox("Headache");
		chckbxHeadache.setBounds(174, 343, 128, 23);
		frame.getContentPane().add(chckbxHeadache);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(174, 427, 200, 50);
		frame.getContentPane().add(submitButton);
		
		JButton backButton = new JButton("Home");
		backButton.setBounds(6, 6, 140, 26);
		frame.getContentPane().add(backButton);
		
		JLabel lblConditions = new JLabel("Prexisting Conditions");
		lblConditions.setBounds(386, 200, 140, 16);
		frame.getContentPane().add(lblConditions);
		
		JLabel lblConditionsCaption = new JLabel("If any condition applies, check the box below");
		lblConditionsCaption.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblConditionsCaption.setBounds(341, 213, 216, 16);
		frame.getContentPane().add(lblConditionsCaption);
		
		JLabel lblLung = new JLabel("- Chronic Lung Disease");
		lblLung.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblLung.setBounds(341, 263, 216, 16);
		frame.getContentPane().add(lblLung);
		
		JLabel lblAsthma = new JLabel("- Asthma");
		lblAsthma.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblAsthma.setBounds(341, 278, 216, 16);
		frame.getContentPane().add(lblAsthma);
		
		JLabel lblNursingHome = new JLabel("- Living in a nursing home");
		lblNursingHome.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblNursingHome.setBounds(341, 294, 216, 16);
		frame.getContentPane().add(lblNursingHome);
		
		JLabel lblHeart = new JLabel("- Hear disease");
		lblHeart.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblHeart.setBounds(341, 311, 216, 16);
		frame.getContentPane().add(lblHeart);
		
		JLabel lblImmunocompromised = new JLabel("- Immunocompromised");
		lblImmunocompromised.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblImmunocompromised.setBounds(341, 329, 216, 16);
		frame.getContentPane().add(lblImmunocompromised);
		
		JLabel lblObesity = new JLabel("- Severe Obesity");
		lblObesity.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblObesity.setBounds(341, 349, 216, 16);
		frame.getContentPane().add(lblObesity);
		
		JLabel lblDiabetes = new JLabel("- Diabetes");
		lblDiabetes.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblDiabetes.setBounds(341, 368, 216, 16);
		frame.getContentPane().add(lblDiabetes);
		
		JLabel lblKidney = new JLabel("- Kidney disease");
		lblKidney.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblKidney.setBounds(341, 234, 216, 16);
		frame.getContentPane().add(lblKidney);
		
		JLabel lblLiver = new JLabel("- Liver disease");
		lblLiver.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblLiver.setBounds(341, 250, 216, 16);
		frame.getContentPane().add(lblLiver);
		
		chckbxConditionsApply = new JCheckBox("Condition(s) applies to me");
		chckbxConditionsApply.setBounds(341, 392, 216, 23);
		frame.getContentPane().add(chckbxConditionsApply);
		
		submitButton.addActionListener(this);
		backButton.addActionListener(this);
	
	}

	public int checkBMI(String weight, String height, int age) {
		int userWeight = toInt(weight);
		double userHeight = ((double) toInt(height)) / 100;
		double BMI = userWeight / (Math.pow(userHeight, 2));
		if (age < 35) {
			if (BMI > 18 && BMI < 26) {
				System.out.println("You are in a healthy condition");
				return 1;
			}
			else {
				if (BMI > 26 && BMI < 45) {
					// System.out.println("You are not in a healthy condition");
					return 4;
				}
				else {
					return 5; 
				}
			}
		}
		else {
			if (BMI > 22 && BMI < 32) {
				System.out.println("You are in a healthy condition");
				return 1;
			}
			else {
				if (BMI > 33 && BMI < 47) {
					System.out.println("You are not in a healthy condition");
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
		int value = 0;
		try {
			value = Integer.parseInt(input);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("The age entered is not a number");
		}
		return value;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println(action);
		if (action.equals("Home")) {
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
		} else if (action.equals("Submit")) {
			
			String city = residenceTextField.getText();
			String age = ageTextField.getText();
			String weight = weightTextField.getText();
			String height = heightTextField.getText();

			boolean soreThroat = chckbxSoreThroat.isSelected();
			boolean fever = chckbxFever.isSelected();
			boolean shortBreath = chckbxShortnessOfBreath.isSelected();
			boolean musclePain = chckbxMusclePain.isSelected();
			boolean cough = chckbxCough.isSelected();
			boolean chills = chckbxChills.isSelected();
			boolean headache = chckbxHeadache.isSelected();
			boolean smellTaste = chckbxLossOfSmelltaste.isSelected();
			boolean conditions = chckbxConditionsApply.isSelected();

		}
		
	}
}

