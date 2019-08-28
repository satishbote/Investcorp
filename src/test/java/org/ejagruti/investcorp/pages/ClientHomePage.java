package org.ejagruti.investcorp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientHomePage {
	
	WebDriver driver=null;
	public ClientHomePage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[.='Logout']")
	WebElement _logout;
	
	
	public boolean checkLogoutLink()
	{
		
		_logout.isDisplayed();
		return true;
	}
	
	
	public WelcomePage GetWelcomePageObject()
	{
		
		WelcomePage wp=new WelcomePage(driver);
		return wp;
	}
	
	
}
