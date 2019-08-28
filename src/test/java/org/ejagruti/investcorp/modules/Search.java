package org.ejagruti.investcorp.modules;

import org.ejagruti.investcorp.pages.AdminHomePage;
import org.ejagruti.investcorp.pages.AdminLoginPage;
import org.ejagruti.investcorp.pages.SearchBranchesPage;
import org.ejagruti.investcorp.pages.SearchCitiesPage;
import org.ejagruti.investcorp.pages.ViewBranchesPage;
import org.ejagruti.investcorp.pages.ViewCitiesPage;
import org.ejagruti.investcorp.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Search {
	
	
	@Parameters({"Search"})
	@Test(description="Search functionality")
	public void execute(String testData) throws InterruptedException
	{
		//System.out.println(testData);
		
		String search_txt=testData.split(",")[0].split("=")[1];
		String select_column=testData.split(",")[1].split("=")[1];
		String functionality=testData.split(",")[2].split("=")[1];
		
		//System.out.println(search_txt+" "+select_column+" "+functionality);
		
		WelcomePage wp=new WelcomePage(LaunchApp.driver);
		AdminLoginPage alp=wp.GetAdminLoginPageObject();
		AdminHomePage ahp=alp.GetAdminHomePageObject();
		
		if(functionality.equalsIgnoreCase("branch"))
		{
			
			ViewBranchesPage vbp=ahp.GetViewBranchesPageObject();
			
			vbp.enterSearchText(search_txt);
			vbp.selectValFromDropdown(select_column);
			vbp.clickOnSearchImage();
			
			Thread.sleep(2000);
			
			SearchBranchesPage sbp=vbp.GetSearchBranchesPageObject();
			String search=sbp.checkSearchedBranch();
			Assert.assertEquals(search, search_txt);
		}
		
		else if(functionality.equalsIgnoreCase("city"))
		{	
			
			ViewCitiesPage vcp=ahp.GetViewCitiesPageObject();
			
			vcp.enterSearchText(search_txt);
			vcp.selectValFromDropdown(select_column);
			vcp.clickOnSearchImage();
			
			Thread.sleep(2000);
			
			SearchCitiesPage scp=vcp.GetSearchCitiesPageObject();
			String search=scp.checkSearchedCity();
			Assert.assertEquals(search, search_txt);
		}
	}

}
