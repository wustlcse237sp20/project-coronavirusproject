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


public class checkWithInvalidInput {

	private static HttpURLConnection connection;
	private BufferedReader reader;
	private String line;
	StringBuffer responseContent;
	public static boolean extractedCountryInfo;
	
	@Test
	public void TestAmerica() {
		responseContent = new StringBuffer();
		API test = new API();
		String inValidInput = "America";
		boolean check = test.testCountryAPIConnection(inValidInput);
		assertTrue(check == false);
	}
	
	@Test
	public void TestRandomName() {
		responseContent = new StringBuffer();
		API test = new API();
		String inValidInput = "John";
		boolean check = test.testCountryAPIConnection(inValidInput);
		assertTrue(check == false);
	}
	
	
	@Test
	public void TestSpecialCharacters() {
		responseContent = new StringBuffer();
		API test = new API();
		String inValidInput = "1!24/.,></';";
		boolean check = test.testCountryAPIConnection(inValidInput);
		assertTrue(check == false);
	}
	
}
