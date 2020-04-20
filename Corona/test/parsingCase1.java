/*
 * 
 * IGNORE THIS TESTING CASE
 * ADD TO IT LATER FOR THIRD ITERATION
 * READ FROM FILE MAYBE 
 * 
 * 
 * package test;
 

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
		String actual = "{\"name\":\"mkyong\",\"id\":1,\"age\":37}";
		return parseJsonCase1(actual);
	}
	
	public static String parseJsonCase1(String responseBody) {
		JSONObject obj = new JSONObject(responseBody);

		JSONArray country = (JSONArray) obj.get( "name");
		System.out.println(country);
		return country.toString();
	}
	@Test
	public void testUpperCaseItaly() {
		

		assertTrue("mkyoung" == getS);
	}
	
	
	

}
*/