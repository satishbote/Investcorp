package org.ejagruti.investcorp.modules;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PremiumCalculator {
	
	
	@Parameters({"PremiumCalculator"})
	@Test(description="Premium Calculator functionality")
	public void execute(String testData)
	{
		//System.out.println(testData);
		
			@SuppressWarnings("unused")
			String xlsPath=testData.split(",")[0].split("=")[1];
			
			//System.out.println(xlsPath);
			
			//System.out.println(xlsPath);
		
		//String [] xlsPath=testData.split("=");
		
		
	}
	

}
