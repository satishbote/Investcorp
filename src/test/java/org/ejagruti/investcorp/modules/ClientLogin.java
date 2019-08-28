package org.ejagruti.investcorp.modules;

import org.ejagruti.investcorp.pages.ClientHomePage;
import org.ejagruti.investcorp.pages.ClientLoginPage;
import org.ejagruti.investcorp.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClientLogin{
		
	@Parameters({"ClientLogin"})
	@Test(description="client login functionality")
	public void execute(String testData) throws InterruptedException
	{
		//System.out.println(testData);			
		String language=testData.split(",")[0].split("=")[1];
		String username=testData.split(",")[1].split("=")[1];
		String password=testData.split(",")[2].split("=")[1];
		
		//System.out.println(language+" "+username+" "+password);		
		
		WelcomePage wp=new WelcomePage(LaunchApp.driver);
		
		wp.clickOnSignin();
		
		ClientLoginPage clp=wp.GetClientLoginPageObject();
		//ClientLoginPage clp=new ClientLoginPage(LaunchApp.driver);
	
		Thread.sleep(7000);
		
		clp.selectlanguage(language);
		clp.enterUsername(username);
		clp.enterPassword(password);
		Thread.sleep(2000);
		clp.clickOnSigninButton();
		
		ClientHomePage chp=clp.GetClientHomePageObject();
		//ClientHomePage chp=new ClientHomePage(LaunchApp.driver);
		boolean logoutLink=chp.checkLogoutLink();
		Thread.sleep(5000);
		
		Assert.assertEquals(logoutLink,true);		
		//LaunchApp.driver.quit();	
		
	}

}
