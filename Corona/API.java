import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class API {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	private StringBuffer responseContent;
	
	public API () {
		responseContent = new StringBuffer();
	}
	
	public boolean testCountryAPIConnection(String country) {
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
				Globals.extractedCountryInfo = true;
			} else {
				Globals.extractedCountryInfo = false;
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
	
	public static boolean getCountryInfo(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);
		if (obj.has("country")) {
			JSONArray countryStatisticArray = (JSONArray) obj.get("latest_stat_by_country");
			// Globals.country = obj.getString("country");
			Globals.country_total_cases = countryStatisticArray.getJSONObject(0).getString("total_cases");
			Globals.country_total_deaths = countryStatisticArray.getJSONObject(0).getString("total_deaths");
			Globals.country_new_cases = countryStatisticArray.getJSONObject(0).getString("new_cases");
			Globals.country_active_cases = countryStatisticArray.getJSONObject(0).getString("active_cases");
			Globals.country_new_deaths = countryStatisticArray.getJSONObject(0).getString("new_deaths");
			Globals.country_total_recovered = countryStatisticArray.getJSONObject(0).getString("total_recovered");
			return true;
		}
		return false;
	}
	
	public static void getProvinceInfo(String responseBody, String province) {
		Globals.province_confirmed = 0;
		Globals.province_deaths = 0;
		JSONObject obj = new JSONObject(responseBody);
		// if(obj.has("data")) {
		JSONObject covidStats =  (JSONObject) obj.get("data");
		JSONArray covidStatsArray = (JSONArray) covidStats.get("covid19Stats");
		for (int i = 0; i < covidStatsArray.length(); i++) {
		    JSONObject jsonobject = covidStatsArray.getJSONObject(i);
		    String currentProvince = jsonobject.getString("province");
		    if(province.equals(currentProvince)) {
		    	// System.out.println(jsonobject.get("city") + " has " + jsonobject.get("deaths") + " deaths");
		    	// System.out.println(jsonobject.getInt("confirmed"));
		    	Globals.province_confirmed += jsonobject.getInt("confirmed");
		    	Globals.province_deaths += jsonobject.getInt("deaths");
		    }
		}
		// }
	}
	
	
	
}