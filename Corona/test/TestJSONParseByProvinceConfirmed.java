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

class TestJSONParseByProvinceConfirmed {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	public static boolean extractedCountryInfo;


	public TestJSONParseByProvinceConfirmed() {
		responseContent = new StringBuffer();
	}
	public int testConnection(String province) {
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
			} else { // connection successful
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			return getProvinceInfo(responseContent.toString(), province);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Malformed URL Excpetion");
			return -1;
		} catch (java.net.SocketTimeoutException e) {
			System.out.println("server connection false");
			return -1;
		}

		catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Excpetion");
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unspecified exception");
			return -1;
		} finally {
			connection.disconnect();
		}
	}
	
	public static int getProvinceInfo(String responseBody, String province) {
		int province_confirmed = 0;
		int province_deaths = 0;
		JSONObject obj = new JSONObject(responseBody);

		JSONObject covidStats = (JSONObject) obj.get("data");
		JSONArray covidStatsArray = (JSONArray) covidStats.get("covid19Stats");
		for (int i = 0; i < covidStatsArray.length(); i++) {
			JSONObject jsonobject = covidStatsArray.getJSONObject(i);
			String currentProvince = jsonobject.getString("province");
			if (province.equals(currentProvince)) {
				province_confirmed += jsonobject.getInt("confirmed");
			}
		}
		return province_confirmed;
	}
	
	@Test
	public void JSONProvinceTest() {
		System.out.println("************************************************************");
		int getS = testConnection("California");
		System.out.println(getS);
		System.out.println("************************************************************");
		assertTrue(getS != -1 );
	}

}