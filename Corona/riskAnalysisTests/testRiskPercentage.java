package riskAnalysisTests;

import src.API;
import src.SymptomsDisplay;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class testRiskPercentage {
	
	@Test
	public void testRiskPecentage() {
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
		assertTrue(returnV.get(0) < 100.0);
		assertTrue(returnV.get(1) < 100.0);
	}
	
	@Test
	void test() {
		
	}

}
