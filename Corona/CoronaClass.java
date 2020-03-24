import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


//import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
public class CoronaClass {

	private static HttpURLConnection connection;
	
	public static void main(String[] args) {
		
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		String totalCases = new String("hi");
		try {
			URL url = new URL("https://coronavirus-monitor.p.rapidapi.com/coronavirus/united_states_stat_small.php");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(5000);
			connection.setRequestProperty("X-RapidAPI-Key", "7a7f939378mshbdfd83ae56d2d66p1b4c72jsndbf6cfd52b50");
			int status = connection.getResponseCode();
			
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			else { //connection successful
				
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			
			totalCases = parseJson(responseContent.toString());
			
			
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			connection.disconnect();
		}
		
		
////		
		JFrame f = new JFrame("COVID-19 Tracker");
		JLabel label = new JLabel();
		label.setText(totalCases);
		
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
	    f.add(label);
	    f.setVisible(true);
	    
	    
	    
	    

	}
	public static String parseJson(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);
		System.out.println("total cases:" + obj.getString("total_cases"));
		return "total cases:" + obj.getString("total_cases");
	}

}
