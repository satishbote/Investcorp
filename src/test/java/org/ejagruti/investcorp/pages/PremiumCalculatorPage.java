package org.ejagruti.investcorp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PremiumCalculatorPage {
	
	WebDriver driver=null;
	public PremiumCalculatorPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//table//th[.='Premium Calculator']//center")
	WebElement _premium_calculator;
	
	@FindBy(xpath="//select[@id='idpolicyname']")
	WebElement _policyname_dropdown;
	
	
	@FindBy(xpath="//select[@id='idpolicytenure']")
	WebElement _policytenure_dropdown;
	
	
	@FindBy(xpath="//select[@id='idadults']")
	WebElement _totaladults_dropdown;

	
	@FindBy(xpath="//select[@id='idchilds']")
	WebElement _totalchilds_dropdown;

	
	@FindBy(xpath="//select[@id='idcitytype']")
	WebElement _citytype_dropdown;
	
	
	@FindBy(xpath="//select[@id='idagegroup']")
	WebElement _agegroup_dropdown;
	
	
	@FindBy(xpath="//select[@id='idemployee']")
	WebElement _is_investcorp_employee_dropdown;
	
	
	@FindBy(xpath="//input[@id='idsi']")
	WebElement _sumassured;
	
	@FindBy(xpath="//button[contains(text(),'Calculate')]")
	WebElement _calculate_button;
	
	@FindBy(xpath="//div[@id='totalpremium']//div")
	WebElement _totalpremium;
	
	@FindBy(xpath="//div[@id='premiumafterdiscount']//div")
	WebElement _premium_afterdiscount;
	
	@FindBy(xpath="//div[@id='finalpremium']//div")
	WebElement _finalpremium;
	
	
	public boolean checkPremiumCalculatorlPage()
	{
		_premium_calculator.isDisplayed();
		return true;
	}
	
	public AdminHomePage GetAdminHomePageObject()
	{
		AdminHomePage ahp= new AdminHomePage(driver);
		return ahp;
	}
	
		
}

