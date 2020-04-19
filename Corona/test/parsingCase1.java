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

public class parsingCase1 {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	
	public parsingCase1 () {
		responseContent = new StringBuffer();
	}
	
	
	public String testConnectionItaly(String country) {
		String country1 = "{'country':'italy','latest_stat_by_country':[{'id':'1054413','country_name':'Italy','total_cases':'178,972','new_cases':'3,047','active_cases':'108,257','total_deaths':'23,660','new_deaths':'433','total_recovered':'47,055','serious_critical':'2,635','region':null,'total_cases_per1m':'2,960','record_date':'2020-04-19 18:36:01.549','deaths_per1m':'391','total_tests':'1,356,541','total_tests_per1m':'22,436'}";
		return parseJsonCase1(country1);
	}
	
	public static String parseJsonCase1(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);

		JSONArray country = (JSONArray) obj.get( "name");
		System.out.println(country);
		return country.toString();
	}
	@Test
	public void testUpperCaseItaly() {
		
		String getS = testConnectionItaly("{ name:John, age:30, car : null }");
		System.out.println("OUR OUTPUT: " + "John");
		System.out.println("TARGET OUTPUT: " + getS);
		
		assertTrue(19 >= getS.length());
	}
	
	
	

}
