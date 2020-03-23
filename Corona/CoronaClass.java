import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
	
public class CoronaClass {

	public static void main(String[] args) {
		JFrame f = new JFrame("COVID-19 Tracker");
	    f.setSize(1000, 1000);
	    f.setLocation(300,200);
	    final JTextArea textArea = new JTextArea(100, 140);
	    f.getContentPane().add(BorderLayout.CENTER, textArea);
	    final JButton button = new JButton("Refresh");
	    f.getContentPane().add(BorderLayout.SOUTH, button);
	    button.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            textArea.append("Update information\n");

	        }
	    });

	    f.setVisible(true);

	}

}
