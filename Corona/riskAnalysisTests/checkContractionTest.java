package riskAnalysisTests;

import src.API;
import src.SymptomsDisplay;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class checkContractionTest {
	
	
	@Test
	public void testContraction() {
		SymptomsDisplay test = new SymptomsDisplay();
		Vector<Boolean> symptoms = new Vector<Boolean>(8);
		Vector<Boolean> conditions = new Vector<Boolean>(9);
		Vector<Double> returnV = new Vector<Double>(2);
		String[] infectedCities = {"new york city", "cook", "nassau", "suffolk", "westchester", "los angeles", "wayne", "bergen", "hudson", "philadelphia"};
		String[] infectedCountries = {"usa", "italy", "spain", "germany", "china"};
		
		symptoms.add(true);	//soreThroat
		symptoms.add(true); //chckbxFever
		symptoms.add(true); //chckbxShortnessOfBreath
		symptoms.add(true); //chckbxMusclePain
		symptoms.add(true); //chckbxCough
		symptoms.add(true); //chckbxChills
		symptoms.add(true); //chckbxHeadache
		symptoms.add(true); //chckbxLossOfSmelltaste
		
		conditions.add(true); //chckbxKidneyDisease
		conditions.add(true); //chckbxLiverDisease
		conditions.add(true); //chckbxLungDisease
		conditions.add(true); //chckbxAsthma
		conditions.add(true); //chckbxNursingHome
		conditions.add(true); //chkbxHeart
		conditions.add(true); //chckbxImmunocompromised
		conditions.add(true); //chckbxObesity
		conditions.add(true); //chckbxDiabetes
		
		returnV =  test.riskScore(22, "Lahore", "Pakistan", symptoms, infectedCities, infectedCountries, conditions);
		assertEquals(returnV.get(0),69.27);
		
	}
	
	@Test
	public void testContraction2() {
		SymptomsDisplay test = new SymptomsDisplay();
		Vector<Boolean> symptoms = new Vector<Boolean>(8);
		Vector<Boolean> conditions = new Vector<Boolean>(9);
		Vector<Double> returnV = new Vector<Double>(2);
		String[] infectedCities = {"new york city", "cook", "nassau", "suffolk", "westchester", "los angeles", "wayne", "bergen", "hudson", "philadelphia"};
		String[] infectedCountries = {"usa", "italy", "spain", "germany", "china"};
		
		symptoms.add(true);	//soreThroat
		symptoms.add(true); //chckbxFever
		symptoms.add(true); //chckbxShortnessOfBreath
		symptoms.add(true); //chckbxMusclePain
		symptoms.add(true); //chckbxCough
		symptoms.add(true); //chckbxChills
		symptoms.add(true); //chckbxHeadache
		symptoms.add(true); //chckbxLossOfSmelltaste
		
		conditions.add(true); //chckbxKidneyDisease
		conditions.add(true); //chckbxLiverDisease
		conditions.add(true); //chckbxLungDisease
		conditions.add(true); //chckbxAsthma
		conditions.add(true); //chckbxNursingHome
		conditions.add(true); //chkbxHeart
		conditions.add(true); //chckbxImmunocompromised
		conditions.add(true); //chckbxObesity
		conditions.add(true); //chckbxDiabetes
		
		returnV =  test.riskScore(22, "New York City", "usa", symptoms, infectedCities, infectedCountries, conditions);
		assertEquals(returnV.get(0),82.78);
	}
	
	@Test
	public void testContractionCityCompare() {
		//For the same symptoms, more affected city will have high risk
		SymptomsDisplay test = new SymptomsDisplay();
		Vector<Boolean> symptoms = new Vector<Boolean>(8);
		Vector<Boolean> conditions = new Vector<Boolean>(9);
		Vector<Double> returnV = new Vector<Double>(2);
		Vector<Double> returnW = new Vector<Double>(2);
		
		String[] infectedCities = {"new york city", "cook", "nassau", "suffolk", "westchester", "los angeles", "wayne", "bergen", "hudson", "philadelphia"};
		String[] infectedCountries = {"usa", "italy", "spain", "germany", "china"};
		
		symptoms.add(true);	//soreThroat
		symptoms.add(false); //chckbxFever
		symptoms.add(true); //chckbxShortnessOfBreath
		symptoms.add(false); //chckbxMusclePain
		symptoms.add(true); //chckbxCough
		symptoms.add(false); //chckbxChills
		symptoms.add(true); //chckbxHeadache
		symptoms.add(false); //chckbxLossOfSmelltaste
		
		conditions.add(true); //chckbxKidneyDisease
		conditions.add(false); //chckbxLiverDisease
		conditions.add(true); //chckbxLungDisease
		conditions.add(false); //chckbxAsthma
		conditions.add(true); //chckbxNursingHome
		conditions.add(false); //chkbxHeart
		conditions.add(true); //chckbxImmunocompromised
		conditions.add(false); //chckbxObesity
		conditions.add(true); //chckbxDiabetes
		
		returnV =  test.riskScore(22, "New York City", "usa", symptoms, infectedCities, infectedCountries, conditions);
		returnW = test.riskScore(22, "Paris", "France", symptoms, infectedCities, infectedCountries, conditions);
		assertTrue(returnV.get(0) > returnW.get(0));
	}

}
