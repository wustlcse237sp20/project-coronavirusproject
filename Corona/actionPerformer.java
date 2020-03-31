import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class actionPerformer implements ActionListener {
	
	JFrame f;
	final JTextArea textArea;
	final JButton button;
	
	public actionPerformer() {
		f = new JFrame("COVID-19 Tracker");
		textArea = new JTextArea(100, 140);
		button = new JButton("Refresh");
	}
	
	public void displayGUI() {
		f.setSize(1000, 1000);
		f.setLocation(300, 200);
		f.getContentPane().add(BorderLayout.CENTER, textArea);
		f.getContentPane().add(BorderLayout.SOUTH, button);
		f.setVisible(true);
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.append(Globals.totalCases+"\n");
	}

}
