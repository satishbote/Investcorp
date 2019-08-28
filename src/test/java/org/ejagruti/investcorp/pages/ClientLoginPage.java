package org.ejagruti.investcorp.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientLoginPage {
	
	WebDriver driver=null;
	public ClientLoginPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@value='en']")
	WebElement _englishlanguage;
	@FindBy(xpath="//input[@value='ur']")
	WebElement _urdulanguage;
	@FindBy(xpath="//input[@value='hn']")
	WebElement _hindilanguage;
	@FindBy(xpath="//input[@value='jp']")
	WebElement _japneaselanguage;
	@FindBy(xpath="//input[@value='ch']")
	WebElement _chineaselanguage;
	@FindBy(xpath="//input[@value='sp']")
	WebElement _spanishlanguage;
	@FindBy(xpath="//input[@placeholder='Username']")	
	WebElement _username;	
	@FindBy(xpath="//input[@placeholder='Password']")	
	WebElement _password;
	@FindBy(xpath="//input[@name='submit']")
	WebElement _signin;
	
	
	public void selectlanguage(String language)
	{
		if(language.equalsIgnoreCase("english"))
			_englishlanguage.click();
		if(language.equalsIgnoreCase("urdu"))
			_urdulanguage.click();
		if(language.equalsIgnoreCase("hindi"))
			_hindilanguage.click();
		if(language.equalsIgnoreCase("japnease"))
			_japneaselanguage.click();
		if (language.equalsIgnoreCase("chinease"))
			_chineaselanguage.click();
		if(language.equalsIgnoreCase("spanish"))
			_spanishlanguage.click();		
	}
	
	public void enterUsername(String uname)
	{
		_username.sendKeys(uname);
		
	}
	
	
	public void enterPassword(String pass)
	{
		_password.sendKeys(pass);
	}
	
	public void clickOnSigninButton()
	{
		_signin.click();
		
	}
	
	public WelcomePage GetWelcomePageObject()
	{
		
		WelcomePage wp=new WelcomePage(driver);
		return wp;
	}
	
	public ClientHomePage GetClientHomePageObject()
	{
		ClientHomePage chp= new ClientHomePage(driver);
		return chp;
	}
	
}
