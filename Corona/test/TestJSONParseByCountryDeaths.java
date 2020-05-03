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


public class TestJSONParseByCountryDeaths {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	public static boolean extractedCountryInfo;
	
	public TestJSONParseByCountryDeaths() {
		responseContent = new StringBuffer();
	}
	
	
	public String testConnection(String country) {
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
			return JSONParseByCountryDeaths(responseContent.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Malformed URL Excpetion");
			return "NO";
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Excpetion");
			return "NO";
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Unspecified exception");
			return "NO";
		} finally {
			connection.disconnect();
		}
	}
	/*
	 * */

	public static String JSONParseByCountryDeaths (String responseBody) {
		JSONObject obj = new JSONObject(responseBody);
		if (obj.has("country")) {
			JSONArray countryStatisticArray = (JSONArray) obj.get("latest_stat_by_country");
			
			String country_total_deaths = countryStatisticArray.getJSONObject(0).getString("total_deaths");
			System.out.println(country_total_deaths);
			return country_total_deaths;
		}
		return "404";
	}
	

	
	@Test
	public void testJSONParseByCountryDeaths() {
		System.out.println("************************************************************");
		String getS = testConnection("Pakistan");
		System.out.println("************************************************************");
		assertTrue(getS != "404" );
		
	}
	


}