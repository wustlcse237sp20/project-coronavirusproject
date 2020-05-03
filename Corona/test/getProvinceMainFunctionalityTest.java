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

class getProvinceMainFunctionalityTest {
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
	
	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	private StringBuffer responseContent;
	
	public getProvinceMainFunctionalityTest () {
		responseContent = new StringBuffer();
	}
	public static boolean extractedCountryInfo;
	
	public boolean testProvinceAPIConnection(String province) {
		// System.out.println("province" + province);
		try {
			URL url = new URL("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?");
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
			}
			getProvinceInfo(responseContent.toString(), province);
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
	public static void getProvinceInfo(String responseBody, String province) {
		province_confirmed = 0;
		province_deaths = 0;
		JSONObject obj = new JSONObject(responseBody);
		// if(obj.has("data")) {
		JSONObject covidStats =  (JSONObject) obj.get("data");
		JSONArray covidStatsArray = (JSONArray) covidStats.get("covid19Stats");
		for (int i = 0; i < covidStatsArray.length(); i++) {
		    JSONObject jsonobject = covidStatsArray.getJSONObject(i);
		    String currentProvince = jsonobject.getString("province");
		    if(province.equals(currentProvince)) {
		    	province_confirmed += jsonobject.getInt("confirmed");
		    	province_deaths += jsonobject.getInt("deaths");
		    }
		}
		// }
	}@Test
	void checkIfRunsTest() {
		assertEquals(true, testProvinceAPIConnection("Punjab"));
		System.out.println("************************************************************");
		System.out.println("Description: This test will pass indefinitely if no error in method, Not checking functionality");
		System.out.println("Green LIGHT: API is connected and no errors in compilation of method");
		System.out.println("API CONNECTTED SUCCESSDULLY");
		System.out.println("************************************************************");
	}

}
