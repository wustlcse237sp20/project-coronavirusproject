package test;

import src.API;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckAPI {

	API api = new API();
	
	@Test
	public void testCountryConnection() {
		assertEquals(true, api.testCountryAPIConnection("Italy"));
		assertEquals(true, api.testCountryAPIConnection("italy"));
		assertEquals(true, api.testCountryAPIConnection("Pakistan"));
		assertEquals(true, api.testCountryAPIConnection("pakistan"));
		assertEquals(true, api.testCountryAPIConnection("Venezuela"));
		assertEquals(true, api.testCountryAPIConnection("venezuela"));
		assertEquals(false, api.testCountryAPIConnection("gibberish"));
	}
	
	@Test
	public void testProvinceConnection() {
		assertEquals(true, api.testProvinceAPIConnection("New York"));
		assertEquals(false, api.testCountryAPIConnection("new york"));
		assertEquals(true, api.testCountryAPIConnection("Florida"));
		assertEquals(false, api.testCountryAPIConnection("florida"));
		assertEquals(true, api.testCountryAPIConnection("Beijing"));
		assertEquals(false, api.testCountryAPIConnection("beijing"));
		assertEquals(false, api.testCountryAPIConnection("gibberish"));
	}
		
}
