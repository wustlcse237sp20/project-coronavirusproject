package test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class checkVenezuela {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	
	public checkVenezuela () {
		responseContent = new StringBuffer();
	}
	
	
	public String testConnectionVenezuela(String country) {
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
			} else { // connection successful

				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}

			return parseJsonVenezuela(responseContent.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Malformed URL Excpetion");
			return "0";
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Excpetion");
			return "0";
		} finally {
			connection.disconnect();
		}
	}
	
	public static String parseJsonVenezuela(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);

		JSONArray countryStatisticArray = (JSONArray) obj.get("latest_stat_by_country");
		return "Country: " + obj.getString("country") + " has " + countryStatisticArray.getJSONObject(0).getString("total_cases");

	}
	@Test
	public void testUpperCaseVenezuela() {
		
		String getS = testConnectionVenezuela("Venezuela");
		String getR = testConnectionVenezuela("Venezuela");
		System.out.println("OUR OUTPUT: " + getS);
		System.out.println("TARGET OUTPUT: " + getR);
		
		assertTrue(getR.length() >= getS.length());
	}
	
	@Test
	public void testlowerCaseVenezuela() {
		
		String getS = testConnectionVenezuela("venezuela");
		String getR = testConnectionVenezuela("venezuela");
		System.out.println("OUR OUTPUT: " + getS);
		System.out.println("TARGET OUTPUT: " + getR);
		
		assertTrue(getR.length() >= getS.length());
	}
	
	

}
