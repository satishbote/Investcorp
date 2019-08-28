package org.ejagruti.investcorp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBranchesPage {
	
	WebDriver driver=null;
	public SearchBranchesPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table//tr[4]//td[2]")
	WebElement _searchbranch;
	
	public String checkSearchedBranch()
	{
		return _searchbranch.getText();
	}
	
	
	public AdminHomePage GetAdminHomePageObject()
	{
		AdminHomePage ahp= new AdminHomePage(driver);
		return ahp;
	}

}
