import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Display implements ActionListener {
	JFrame frame;
	private JButton btnRefresh;
	private JTextArea textArea;
	private JTextField textField;
	private JTextArea textArea_1;

	/**
	 * Create the application.
	 */
	public Display() {
		frame = new JFrame();
		btnRefresh = new JButton("Search");
		textField = new JTextField();
		textArea = new JTextArea(14, 20);
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
		
		textArea_1 = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea_1, 11, SpringLayout.SOUTH, btnRefresh);
		springLayout.putConstraint(SpringLayout.WEST, textArea_1, 6, SpringLayout.EAST, textArea);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea_1, 230, SpringLayout.SOUTH, btnRefresh);
		springLayout.putConstraint(SpringLayout.EAST, textArea_1, -10, SpringLayout.EAST, frame.getContentPane());
		textArea_1.setBackground(UIManager.getColor("Button.background"));
		textArea_1.setRows(14);
		textArea_1.setColumns(20);
		frame.getContentPane().add(textArea_1);
		btnRefresh.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Globals.searchText = textField.getText();
		System.out.println(Globals.searchText);
		API api = new API();
		api.testConnection(Globals.searchText);
		textArea.append(Globals.totalCases+"\n");
		textArea_1.append(Globals.totalDeaths+"\n");
	}
}
