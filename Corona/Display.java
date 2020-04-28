import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class Display implements ActionListener {
	JFrame frame;
	private JButton searchButton;
	private JTextArea textArea;
	private JTextField textField;
	private JCheckBox searchType;

	/**
	 * Create the application.
	 */
	public Display() {
		frame = new JFrame();
		searchButton = new JButton("Search");
		searchButton.setBounds(425, 10, 85, 29);
		textField = new JTextField();
		textField.setBounds(77, 10, 130, 26);
		textArea = new JTextArea(13, 20);
		textArea.setBounds(2, 2, 512, 157);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 516, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(searchButton);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textArea.setBackground(SystemColor.window);
		frame.getContentPane().add(textArea);

		searchButton.addActionListener(this);
		
		JLabel regionLabel = new JLabel("Country");
		regionLabel.setBounds(21, 15, 61, 16);
		frame.getContentPane().add(regionLabel);
		
		JLabel description = new JLabel("If you would like to search for national information, leave the checkbox field unchecked\"");
		description.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		description.setBounds(21, 38, 489, 16);
		frame.getContentPane().add(description);
		
		searchType = new JCheckBox("Province");
		searchType.setBounds(199, 11, 85, 23);
		frame.getContentPane().add(searchType);
		
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 66, 516, 213);
		frame.getContentPane().add(scroll);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Globals.region = textField.getText(); 
		API api = new API();
		
		if(searchType.isSelected()) {
			if (api.testProvinceAPIConnection(Globals.region)) {
				if (Globals.province_confirmed == 0) {
					textArea.append("Province not found. Please make sure specified country exists and is spelled correctly (Case sensitive)\n");
					textArea.append("----------------------------\n");
				} else {
					textArea.append("Province: " + Globals.region +"\n");
					textArea.append("Confirmed cases: " + Globals.province_confirmed +"\n");
					textArea.append("Deaths: " + Globals.province_deaths+"\n");
					textArea.append("----------------------------\n");
				}
			} else {
				textArea.append("Province not found. Please make sure specified Province exists and is spelled correctly\n");
				textArea.append("----------------------------\n");
			}
		}
		else {
			if (api.testCountryAPIConnection(Globals.region)) {
				if (Globals.extractedCountryInfo) {
					textArea.append("Country: " + Globals.region +"\n");
					textArea.append("Total cases: " + Globals.country_total_cases +"\n");
					textArea.append("Total deaths: " + Globals.country_total_deaths+"\n");
					textArea.append("New cases: " + Globals.country_new_cases+"\n");
					textArea.append("New deaths: " + Globals.country_new_deaths+"\n");
					textArea.append("Active cases: " + Globals.country_active_cases+"\n");
					textArea.append("Total recovered: " + Globals.country_total_recovered+"\n");
					textArea.append("----------------------------\n");
				} else {
					textArea.append("Please enter a valid country into the search bar\n");
					textArea.append("----------------------------\n");
				}
			} else {
				textArea.append("Connection Failed. Please make sure specified country exists and is spelled correctly\n");
				textArea.append("----------------------------\n");
			}
		}
	}
}

