package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class ConnectionFailedBecauseIncorrectInput {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	private StringBuffer responseContent;
	
	public ConnectionFailedBecauseIncorrectInput () {
		responseContent = new StringBuffer();
	}
	public boolean testCountryAPIConnection(String country) {
		try {
			URL url = new URL("https://coronavirus-monitor.p.rapidapi.com/coronavirus/latest_stat_by_country.php?country=" + country);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(5000);
			connection.setRequestProperty("X-RapidAPI-Key", "7a7f939378mshbdfd83ae56d2d66p1b4c72jsndbf6cfd52b50");
			int status = connection.getResponseCode();

			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
				System.out.println("Connection error");
				return false;
			} else { // connection successful

				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
				System.out.println("Connection Successful");
				return true;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Malformed URL Excpetion");
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Excpetion");
			return false;
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Unspecified exception");
			return false;
		} finally {
			connection.disconnect();
		}
	}

	@Test
	void testConnectionSuccess() {
		assertEquals(false, testCountryAPIConnection("Jackass"));
		System.out.println("************************************************************");
		System.out.println("Description: This test will pass if invalid input is entered and thus connection is not established");
		System.out.println("Green LIGHT: Incorrect Input Connection Failure");
		System.out.println("API FAILED TO CONNECT...ENTER VALID INPUT");
		System.out.println("************************************************************");
		
	}

}