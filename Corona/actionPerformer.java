
/*
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class actionPerformer implements ActionListener {
	
<<<<<<< HEAD
	JFrame f;
	final JTextArea textArea;
	final JButton button;
	
	public actionPerformer() {
		f = new JFrame("COVID-19 Tracker");
		textArea = new JTextArea(100, 140);
		button = new JButton("Refresh");
	}
	
	public void displayGUI() {
=======
	JFrame f = new JFrame("COVID-19 Tracker");
	final JTextArea textArea = new JTextArea(100, 140);
	final JButton button = new JButton("Refresh");
	JComboBox combobox;
	
	public actionPerformer() {
		combobox = new JComboBox(new Object[] {});
>>>>>>> 28422aeed5a6b3952d4eaf01fcc05d243c37fd85
		f.setSize(1000, 1000);
		f.setLocation(500, 500);
		f.getContentPane().add(BorderLayout.CENTER, textArea);
		f.getContentPane().add(BorderLayout.SOUTH, button);
		f.setVisible(true);
		button.addActionListener(this);
		
		//f.add(combobox);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.append(Globals.totalCases+"\n");
	}

}
*/