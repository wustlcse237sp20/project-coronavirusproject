import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

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
		btnRefresh.setBounds(196, 10, 85, 29);
		textField = new JTextField();
		textField.setBounds(54, 10, 130, 26);
		textArea = new JTextArea(14, 20);
		textArea.setBounds(2, 46, 240, 180);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnRefresh);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea.setBackground(SystemColor.window);
		frame.getContentPane().add(textArea);
		btnRefresh.addActionListener(this);
		
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 46, 450, 233);
		frame.getContentPane().add(scroll);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Province");
		rdbtnNewRadioButton.setBounds(309, 11, 122, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
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
			} else {
				textArea.append("Please enter a valid country into the search bar\n");
			}
		} else {
			textArea.append("Failed Connections, make sure specified country exists.\n");
		}
	}
}
