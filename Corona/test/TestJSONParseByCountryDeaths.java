package test;

import src.API;
import src.SymptomsDisplay;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.Vector;

import org.junit.jupiter.api.Test;

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
	
	@Test
	public void testJSONParseByCountryDeaths() {
		API test = new API();
		test.testCountryAPIConnection("");
		
	}
	


}