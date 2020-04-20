import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class Display implements ActionListener {
	JFrame frame;
	private JButton btnRefresh;
	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField2;

	/**
	 * Create the application.
	 */
	public Display() {
		frame = new JFrame();
		btnRefresh = new JButton("Search");
		btnRefresh.setBounds(425, 10, 85, 29);
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
		frame.getContentPane().add(btnRefresh);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea.setBackground(SystemColor.window);
		frame.getContentPane().add(textArea);
		btnRefresh.addActionListener(this);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(21, 15, 61, 16);
		frame.getContentPane().add(lblCountry);
		
		JLabel province = new JLabel("Province");
		province.setBounds(224, 15, 61, 16);
		frame.getContentPane().add(province);
		
		textField2 = new JTextField();
		textField2.setBounds(283, 10, 130, 26);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		JLabel lblIfYouWould = new JLabel("If you would like to display national cases, leave the 'Province' field empty");
		lblIfYouWould.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblIfYouWould.setBounds(87, 38, 346, 16);
		frame.getContentPane().add(lblIfYouWould);
		
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 66, 516, 213);
		frame.getContentPane().add(scroll);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Globals.country = textField.getText(); 
		Globals.province = textField2.getText();
		API api = new API();
		
		if(Globals.province.equals("")) {
			// System.out.println("click");
			// api.testCountryAPIConnection(Globals.country);
			if (api.testCountryAPIConnection(Globals.country)) {
				if (Globals.extractedCountryInfo) {
					textArea.append("\n");
					textArea.append("Country: " + Globals.country +"\n");
					textArea.append("Total cases: " + Globals.country_total_cases +"\n");
					textArea.append("Total deaths: " + Globals.country_total_deaths+"\n");
					textArea.append("New cases: " + Globals.country_new_cases+"\n");
					textArea.append("New deaths: " + Globals.country_new_deaths+"\n");
					textArea.append("Active cases: " + Globals.country_active_cases+"\n");
					textArea.append("Total recovered: " + Globals.country_total_recovered+"\n");
				} else {
					textArea.append("Please enter a valid country into the search bar\n");
				}
			} else {
				textArea.append("Connection Failed. Please make sure specified country exists and is spelled correctly\n");
			}
		}
		else {
			if (api.testProvinceAPIConnection(Globals.province)) {
				if (Globals.province_confirmed == 0) {
					textArea.append("Country not found. Please make sure specified country exists and is spelled correctly (Case sensitive)\n");
				} else {
					textArea.append("\n");
					textArea.append("Province: " + Globals.province +"\n");
					textArea.append("Confirmed cases: " + Globals.province_confirmed +"\n");
					textArea.append("Deaths: " + Globals.province_deaths+"\n");
				}
			} else {
				textArea.append("Connection Failed. Please make sure specified Province exists and is spelled correctly\n");
			}
		}
	}
}

