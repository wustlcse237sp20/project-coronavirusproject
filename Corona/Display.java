import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Display implements ActionListener {
	JFrame frame;
	private JButton btnRefresh;
	private JTextArea textArea;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public Display() {
		frame = new JFrame();
		btnRefresh = new JButton("Search");
		textField = new JTextField();
		textArea = new JTextArea(100, 140);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, btnRefresh, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnRefresh, -103, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnRefresh);
		
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, btnRefresh);
		springLayout.putConstraint(SpringLayout.EAST, textField, -7, SpringLayout.WEST, btnRefresh);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea.setBackground(SystemColor.window);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 10, SpringLayout.SOUTH, btnRefresh);
		frame.getContentPane().add(textArea);
		btnRefresh.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Globals.searchText = textField.getText();
		API api = new API();
		if (api.testConnection(Globals.searchText)) {
			if (Globals.extractedInfo) {
				textArea.append("\n");
				textArea.append("Country: " + Globals.country +"\n");
				textArea.append("Total cases: " + Globals.total_cases +"\n");
				textArea.append("Total deaths: " + Globals.total_deaths+"\n");
				textArea.append("New cases: " + Globals.new_cases+"\n");
				textArea.append("New deaths: " + Globals.new_deaths+"\n");
				textArea.append("Active cases: " + Globals.active_cases+"\n");
				textArea.append("Total recovered: " + Globals.total_recovered+"\n");
			} else {
				textArea.append("Please enter a valid country into the search bar\n");
			}
		} else {
			textArea.append("The specified country does not exist\n");
		}
	}

}
