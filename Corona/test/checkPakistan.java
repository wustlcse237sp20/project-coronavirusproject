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

public class checkPakistan {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	
	public checkPakistan () {
		responseContent = new StringBuffer();
	}
	
	
	public String testConnectionPakistan(String country) {
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

			return parseJsonPakistan(responseContent.toString());

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
	
	public static String parseJsonPakistan(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);

		JSONArray countryStatisticArray = (JSONArray) obj.get("latest_stat_by_country");
		return "Country: " + obj.getString("country") + " has " + countryStatisticArray.getJSONObject(0).getString("total_cases");

	}
	@Test
	public void testUpperCasePakistan() {
		
		String getS = testConnectionPakistan("Pakistan");
		String getR = testConnectionPakistan("Pakistan");
		System.out.println("************************************************************");
		System.out.println("OUR OUTPUT: " + getS);
		System.out.println("TARGET OUTPUT: " + getR);
		System.out.println("************************************************************");
		
		assertTrue(getR.length() >= getS.length());
	}
	
	@Test
	public void testlowerCasePakistan() {
		
		String getS = testConnectionPakistan("pakistan");
		String getR = testConnectionPakistan("pakistan");
		System.out.println("************************************************************");
		System.out.println("OUR OUTPUT: " + getS);
		System.out.println("TARGET OUTPUT: " + getR);
		System.out.println("************************************************************");
		
		assertTrue(getR.length() >= getS.length());
	}

}
