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


public class JSONTesting1 {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	public static String country;
	public static String country_total_cases;
	public static String country_total_deaths;
	public static String country_new_cases;
	public static String country_active_cases;
	public static String country_new_deaths;
	public static String country_total_recovered;
	
	public static String province; 
	public static int province_confirmed;
	public static int province_deaths;
	
	public static boolean extractedCountryInfo;
	
	public JSONTesting1 () {
		responseContent = new StringBuffer();
	}
	
	
	public boolean testConnection(String country) {
		System.out.println(country);
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

			if (getCountryInfo(responseContent.toString())) {
				extractedCountryInfo = true;
			} else {
				extractedCountryInfo = false;
			}
			return true;

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
	/*
	 * */

	public static boolean getCountryInfo(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);
		if (obj.has("country")) {
			JSONArray countryStatisticArray = (JSONArray) obj.get("latest_stat_by_country");
			// Globals.country = obj.getString("country");
			country_total_cases = countryStatisticArray.getJSONObject(0).getString("total_cases");
			country_total_deaths = countryStatisticArray.getJSONObject(0).getString("total_deaths");
			country_new_cases = countryStatisticArray.getJSONObject(0).getString("new_cases");
			country_active_cases = countryStatisticArray.getJSONObject(0).getString("active_cases");
			country_new_deaths = countryStatisticArray.getJSONObject(0).getString("new_deaths");
			country_total_recovered = countryStatisticArray.getJSONObject(0).getString("total_recovered");
			return true;
		}
		return false;
	}
	
	public static String checkJSONParseAllCountryStats(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);
		System.out.println(obj);
		if (obj.has("country")) {
			JSONArray countryStatisticArray = (JSONArray) obj.get("latest_stat_by_country");
			// Globals.country = obj.getString("country");
			String country_total_cases = countryStatisticArray.getJSONObject(0).getString("total_cases");


			System.out.println(country_total_cases);
			return country_total_cases;
		}
		return "NONEBABY";
	}
	
	@Test
	public void testJSONParseAllCountryStats() {
		
		boolean getS = testConnection("Pakistan");
		
		
	}
	


}