package org.ejagruti.investcorp.modules;

import org.ejagruti.investcorp.pages.AdminHomePage;
import org.ejagruti.investcorp.pages.AdminLoginPage;
import org.ejagruti.investcorp.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminLogin {
	
	@Parameters({"AdminLogin"})
	@Test(description="AdminLogin functionality")
	public void execute(String testData) throws InterruptedException
	{		
		//System.out.println(testData);
		
		String language=testData.split(",")[0].split("=")[1];
		String username=testData.split(",")[1].split("=")[1];
		String password=testData.split(",")[2].split("=")[1];
		
		//System.out.println(language+" "+username+" "+password );
		
		WelcomePage wp=new WelcomePage(LaunchApp.driver);
		wp.clickOnAdminPanel();
		
		AdminLoginPage alp=wp.GetAdminLoginPageObject();
		//AdminLoginPage alp=new AdminLoginPage(LaunchApp.driver);
		Thread.sleep(7000);
		alp.selectlanguage(language);
		alp.enterUsername(username);
		alp.enterPassword(password);
		Thread.sleep(2000);
		alp.clickOnSigninButton();
		
		AdminHomePage ahp=alp.GetAdminHomePageObject();
		//AdminHomePage ahp=new AdminHomePage(LaunchApp.driver);
		boolean logoutlink=	ahp.checkLogoutLink();
		
		Thread.sleep(5000);
		Assert.assertEquals(logoutlink, true);		
		//LaunchApp.driver.close();	 
	}
	
	
}
