package org.ejagruti.investcorp.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	WebDriver driver=null;
	public WelcomePage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[.='Sign In']")
	WebElement _clientsignin;
	
	@FindBy(xpath="//a[.='Admin Panel']")
	WebElement _adminsignin;
	 
	
	
	public void clickOnSignin()
	{
		//_clientsignin.sendKeys(Keys.ENTER);
		_clientsignin.click();
	}
	
	public void clickOnAdminPanel()
	{
		_adminsignin.click();
		
	}
	
	public boolean checkSignInLink()
	{
		_clientsignin.isDisplayed();
		return true;
	}
	
	public ClientLoginPage GetClientLoginPageObject()
	{
		
		ClientLoginPage clp=new ClientLoginPage(driver);
		return clp;
	}
	
	public AdminLoginPage GetAdminLoginPageObject()
	{
		AdminLoginPage alp=new AdminLoginPage(driver);
		return alp;
	}
}
