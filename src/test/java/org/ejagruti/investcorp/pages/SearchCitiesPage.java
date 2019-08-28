package org.ejagruti.investcorp.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCitiesPage {
	
	WebDriver driver=null;
	
	public SearchCitiesPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//table//td[1]//span")
	WebElement _searchcity;
	
	public String  checkSearchedCity()
	{
		return _searchcity.getText();
	}
	
	
	public AdminHomePage GetAdminHomePageObject()
	{
		AdminHomePage ahp= new AdminHomePage(driver);
		return ahp;
	}
	
}
