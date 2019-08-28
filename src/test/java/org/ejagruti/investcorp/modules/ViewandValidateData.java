package org.ejagruti.investcorp.modules;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ViewandValidateData {
	
	@Parameters({"ViewandValidateData"})
	@Test(description="View and Validate functionality")
	public void execute(String testData)
	{
		//System.out.println(testData);
		
		String query=testData.split(",")[0].split("=")[1];
		
		query=query.replace("#", ",").replace("$", "=");
				
		//String [] query=testData.split("=");
		//System.out.println(query);
		
	}

}
