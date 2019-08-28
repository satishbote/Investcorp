package org.ejagruti.investcorp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitywiseBranchesTotalPage {
	
	WebDriver driver=null;
	public CitywiseBranchesTotalPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//table//thead//tr[1]//td[1]//b")
	WebElement _citywise_branches_total_report;

	@FindBy(xpath="//table//tr[last()]//td[last()]//b")
	WebElement _total_records;
	
	public boolean checkCitywiseBranchesTotalPage()
	{
		_citywise_branches_total_report.isDisplayed();
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
