package org.ejagruti.investcorp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Active_CC_AccountsPage {
	
	WebDriver driver=null;
	public Active_CC_AccountsPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//table//td[@class='header']//center//b")
	WebElement _active_cc_accounts_report;

	@FindBy(xpath="//table//tr[last()]//td[last()]//b")
	WebElement _total_records;
	
	public boolean checkActiveCCAccountsPage()
	{
		_active_cc_accounts_report.isDisplayed();
		return true;
	}
	
	public void getTotalrecordsCount(String totalrecords)
	{
		
	}
	
	
	public AdminHomePage GetAdminHomePageObject()
	{
		AdminHomePage ahp= new AdminHomePage(driver);
		return ahp;
	}
	
}
