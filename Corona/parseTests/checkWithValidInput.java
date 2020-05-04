package parseTests;

import src.API;
import src.SymptomsDisplay;

import static org.junit.Assert.assertTrue;
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


public class checkWithValidInput {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	public static boolean extractedCountryInfo;
	
	@Test
	public void TestPakistan() {
		responseContent = new StringBuffer();
		API test = new API();
		String validInput = "Pakistan";
		boolean check = test.testCountryAPIConnection(validInput);
		assertTrue(check == true);
	}
	
	@Test
	public void TestVietnam() {
		responseContent = new StringBuffer();
		API test = new API();
		String validInput = "Vietnam";
		boolean check = test.testCountryAPIConnection(validInput);
		assertTrue(check == true);
	}
	
	@Test
	public void TestGermany() {
		responseContent = new StringBuffer();
		API test = new API();
		String validInput = "Germany";
		boolean check = test.testCountryAPIConnection(validInput);
		assertTrue(check == true);
	}
	
	@Test
	public void TestZimbabwe() {
		responseContent = new StringBuffer();
		API test = new API();
		String validInput = "Zimbabwe";
		boolean check = test.testCountryAPIConnection(validInput);
		assertTrue(check == true);
	}
	
}
