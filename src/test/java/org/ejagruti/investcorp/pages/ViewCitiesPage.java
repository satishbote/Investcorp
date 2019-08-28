package org.ejagruti.investcorp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ViewCitiesPage {
	
	WebDriver driver=null;
	public ViewCitiesPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table//tr[1]//td[1]")
	WebElement _viewcities;
	
	@FindBy(xpath="//table//td[@title][1]")
	List <WebElement> _toptencitiesid;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement _searchtext;
	
	@FindBy(xpath="//select[@id='searchdropdown']")
	WebElement _searchdropdown;
		
	
	@FindBy(xpath="//img[@src='images/search.jpg']")
	WebElement _search;
	
	
	public boolean checkViewCitiesPage()
	{
		_viewcities.isDisplayed();
		return true;
	}
	
	
	public String [] getTopTenCitiesId()
	{
		String[] allIDs=new String[_toptencitiesid.size()];
		for(int i=0;i<_toptencitiesid.size();i++)
		{
			WebElement cid=_toptencitiesid.get(i);
			allIDs[i]=cid.getText();
		}
		return allIDs;
	}
	
	public void enterSearchText(String searchtext)
	{
		_searchtext.sendKeys(searchtext);
		
	}
	
	public void selectValFromDropdown(String selectcolumn)
	{
		
			Select select=new Select(_searchdropdown);
			select.selectByVisibleText(selectcolumn);
		
	}
	
	
	public void clickOnSearchImage()
	{
		_search.click();
	}
	
	public AdminHomePage GetAdminHomePageObject()
	{
		AdminHomePage ahp= new AdminHomePage(driver);
		return ahp;
	}
	
	public SearchCitiesPage GetSearchCitiesPageObject()
	{
		SearchCitiesPage scp= new SearchCitiesPage(driver);
		return scp;
	}

}
