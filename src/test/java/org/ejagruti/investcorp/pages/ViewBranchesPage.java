package org.ejagruti.investcorp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class ViewBranchesPage {
	
	WebDriver driver=null;
	public ViewBranchesPage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table//tr[1]//td[1]")
	WebElement _viewbranches;
	
	@FindBy(xpath="//table//td[@title][1]")
	List <WebElement> _toptenbranchesid;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement _searchtext;
	
	@FindBy(xpath="//select[@id='searchdropdown']")
	WebElement _searchdropdown;

	
	@FindBy(xpath="//img[@src='images/search.jpg']")
	WebElement _search;
	
	
	public boolean checkViewBranchesPage()
	{
		_viewbranches.isDisplayed();
		return true;
	}
	public String [] getTopTenBranchesId()
	{
		String[] allIDs=new String[_toptenbranchesid.size()];
		for(int i=0;i<_toptenbranchesid.size();i++)
		{
			WebElement bid=_toptenbranchesid.get(i);
			allIDs[i]=bid.getText();
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
	
	public SearchBranchesPage GetSearchBranchesPageObject()
	{
		SearchBranchesPage sbp= new SearchBranchesPage(driver);
		return sbp;
	}

}
