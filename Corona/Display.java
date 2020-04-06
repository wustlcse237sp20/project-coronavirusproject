import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Display implements ActionListener {
	JFrame frame;
	private JTextArea textArea;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnRefresh = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnRefresh, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnRefresh, -103, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnRefresh);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, btnRefresh);
		springLayout.putConstraint(SpringLayout.EAST, textField, -7, SpringLayout.WEST, btnRefresh);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea(100, 140);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 10, SpringLayout.SOUTH, btnRefresh);
		frame.getContentPane().add(textArea);
		btnRefresh.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.append(Globals.totalCases+"\n");
	}

}
