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
	// private static String country;
	private BufferedReader reader;
	private String line;
	private StringBuffer responseContent;
	
	public API () {
		responseContent = new StringBuffer();
	}
	
	public void testConnection(String country) {
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

			Globals.totalCases = parseJson(responseContent.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Malformed URL Excpetion");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Excpetion");
		} finally {
			connection.disconnect();
		}
	}
	
	public static String parseJson(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);
		if (obj.has("country")) {
			JSONArray countryStatisticArray = (JSONArray) obj.get("latest_stat_by_country");
			if (countryStatisticArray.length() == 0) {
				return "The specified country does not exist";
			} else {
				return "Country: " + obj.getString("country") + " has " + countryStatisticArray.getJSONObject(0).getString("total_cases");
			}
		}
		return "Please enter a country into the text field"; 
	}
	
}
