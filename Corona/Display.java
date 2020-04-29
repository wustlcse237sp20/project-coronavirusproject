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

public class Display implements ActionListener {
	JFrame frame;
	private JButton searchButton;
	private JButton top10;
	private JTextArea textArea;
	private JTextField textField;
	private JCheckBox regionType;

	/**
	 * Create the application.
	 */
	public Display() {
		frame = new JFrame();
		searchButton = new JButton("Search");
		searchButton.setBounds(283, 10, 85, 29);
		top10 = new JButton("Top cities");
		top10.setBounds(419, 10, 93, 29);
		textField = new JTextField();
		textField.setBounds(77, 10, 130, 26);
		textArea = new JTextArea(13, 20);
		textArea.setBounds(21, 6, 512, 77);
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
		frame.getContentPane().add(top10);
		frame.getContentPane().add(textField);
		
		textField.setColumns(10);
		textArea.setBackground(SystemColor.window);
		frame.getContentPane().add(textArea);

		searchButton.addActionListener(this);
		top10.addActionListener(this);
		
		JLabel regionLabel = new JLabel("Region");
		regionLabel.setBounds(21, 15, 61, 16);
		frame.getContentPane().add(regionLabel);
		
		JLabel description = new JLabel("If you would like to search for national information, leave the checkbox unchecked");
		description.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		description.setBounds(21, 38, 489, 16);
		frame.getContentPane().add(description);
		
		regionType = new JCheckBox("Province");
		regionType.setBounds(199, 11, 85, 23);
		frame.getContentPane().add(regionType);
		
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 66, 516, 213);
		frame.getContentPane().add(scroll);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		API api = new API();
		if (action.equals("Search")) { // They're looking for info on a specific region
			Globals.region = textField.getText();
			if(regionType.isSelected()) {
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
						textArea.append("Please enter a country into the search bar\n");
						textArea.append("----------------------------\n");
					}
				} else {
					textArea.append("Country not found. Please make sure specified country exists and is spelled correctly\n");
					textArea.append("----------------------------\n");
				}
			}
		} else { // They want to display top 10 provinces
			if (api.testProvinceAPIConnection("Top10")) { // Unused parameter
				int end = Globals.provinceArray.length - 1;
				for (int type = 0; type < 2; type++) {
					if (type == 0) {
						textArea.append("Top 10 cities by deaths\n");
						quickSort.sort(Globals.provinceArray, 0, end, false);
						for (int rank = 0; rank < 10; rank++) {
							textArea.append((rank+1) + ": " + Globals.provinceArray[end-rank].name +"\n");
							textArea.append("Total deaths: " + Globals.provinceArray[end-rank].deaths +"\n");
						}
					} else {
						textArea.append("Top 10 cities by confirmed cases\n");
						quickSort.sort(Globals.provinceArray, 0, end, true);
						for (int rank = 0; rank < 10; rank++) {
							textArea.append((rank+1) + ": " + Globals.provinceArray[end-rank].name +"\n");
							textArea.append("Total Confirmed Cases: " + Globals.provinceArray[end-rank].cases +"\n");
						}
					}
					textArea.append("----------------------------\n");
				}
			}
		}
	}
}

