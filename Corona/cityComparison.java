public class cityComparison {
	String checkCity1;
	String checkCity2;
	
	String province1;
	String province2;
	String city1Population;
	String city2Population;
	
	String cases1;
	String cases2; 
	public cityComparison() {
		/*checkCity1 = Globals.travelCity1;
		checkCity2 = Globals.travelCity2;
		
		province1 = Globals.travelProvince1;
		province2 = Globals.travelProvince2;
		city1Population = Globals.travelCity1Population;
		city2Population = Globals.travelCity2Population;
		
		cases1 = Globals.travelCity1Cases;
		cases2 = Globals.travelCity2Cases;
		*/
		checkCity1 = "New York City";
		checkCity2 = "Los Angeles";
		
		province1 = "New York";
		province2 = "Arkansas";
		city1Population = "8399631";
		city2Population = "3993458";
		
		cases1 = "167357";
		cases2 = "23182";
	}
	
	
	public String getCity1() {
		return this.checkCity1;
	}
	
	public String getCity2() {
		return this.checkCity2;
	}
	
	public String getProvince1() {
		return this.province1;
	}
	
	
	public String getProvince2() {
		return this.province1;
	}
	
	public int parseInt(String s) {
		try
	    {
	      // the String to int conversion happens here
	      int i = Integer.parseInt(s.trim());
	      return i;
	    }
	    catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	      return -1;
	    }
	}
	
	//parse city cases retrieved as string and convert into integers
	public int getCityCases(String cases) {
		int cityCases = parseInt(cases);	
		return cityCases;
	}
	
	//parse city population retrieved as string and convert into integers
	public int getCityPopulation(String population) {
		int cityPop = parseInt(population);
		return cityPop;
	}
	
	public float checkCasesByPopulation(int over, int under) {
		float cityCases = (float) over;
		float cityPopulation = (float) under;
		float caseRatio = cityCases / cityPopulation;
		return caseRatio;
	}
	
	public void travelSafeDeterminer() {
		String city1 = getCity1();
		String city2 = getCity2();
		
		int cases1 = getCityCases(this.cases1);
		int cases2 = getCityCases(this.cases2);
		int pop1 = getCityPopulation(this.city1Population);
		int pop2 = getCityPopulation(this.city2Population);
		
		float checker1 = checkCasesByPopulation(cases1, pop1);
		float checker2 = checkCasesByPopulation(cases2, pop2);
		
		if (checker1 > checker2) {
			float oneInCase1 = (pop1/cases1);
			oneInCase1 = (float) Math.floor(oneInCase1);
			
			float oneInCase2 = (pop2/cases2);
			oneInCase2 = (float) Math.floor(oneInCase2);
			/* System.out.println(city1 + " is not safer than " + city2);
			System.out.println("1 in every " + oneInCase1 + " people have coronaVirus in " + city1);
			System.out.println("1 in every " + oneInCase2 + " people have coronaVirus in " + city2);
			System.out.println("The cases by population ratio is much higher in " + city1 + " than in " + city2); */
		}
		else if (checker2 > checker1) {
			float oneInCase1 = (pop1/cases1);
			oneInCase1 = (float) Math.floor(oneInCase1);
			
			float oneInCase2 = (pop2/cases2);
			oneInCase2 = (float) Math.floor(oneInCase2);
			/* System.out.println(city2 + " is not safer than " + city1);
			System.out.println("1 in every " + oneInCase2 + " people have coronaVirus in " + city2);
			System.out.println("1 in every " + oneInCase1 + " people have coronaVirus in " + city1);
			System.out.println("The cases by population ratio is much higher in " + city2 + " than in " + city1); */
		}
		else {
			// System.out.println("Both cities are equally hazardous. Therefore, it would be better of you remained where you are.");
		}
	}
	public void main(String[] args) {
		int m = getCityCases(cases1);
		System.out.println(m);
		return;
	}
	
}

