package org.ejagruti.investcorp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	WebDriver driver=null;
	
	public AdminHomePage(WebDriver obj)
	{
		driver=obj;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[.='Logout']")
	WebElement _logout;
	
	@FindBy(xpath="//span[contains(text(),'View / Edit')]")
	WebElement _viewedit;
	
	@FindBy(xpath="//a[.='Branches']")
	WebElement _branches;
	@FindBy(xpath="//a[.='Cities']")
	WebElement _cities;
	
	@FindBy(xpath="//span[contains(text(),'Reports')]")
	WebElement _reports;
	
	@FindBy(xpath="//a[.='City Wise Branches Total']")
	WebElement _city_wise_branches_total;
	@FindBy(xpath="//a[.='Active CC Accounts Total As Per CC Type']")
	WebElement _active_cc_accounts_total_as_per_cc_type;
	
	@FindBy(xpath="//a[.='Insurance']")
	WebElement _insurance;
	@FindBy(xpath="//a[.='Premium Calculator']")
	WebElement _premium_calculator;
	
	
	
	public boolean checkLogoutLink()
	{
		_logout.isDisplayed();
		return true;
	}
	
	/*public void mouseOverMenu(String menu)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement( By.xpath("//span[contains(text(),\'"+menu+"\')]"))).build().perform();
	}
	
	public void clickOnSubMenu(String submenu)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement( By.xpath("//a[.=\'"+submenu+"\']"))).click().build().perform();
	}*/
	
	
	
	public void mouseOverViewEdit()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_viewedit).build().perform();
		
	}
	
	public void clickOnBranches()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_branches).click().build().perform();		
	}
	
	public void clickOnCities()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_cities).click().build().perform();
	}
	
	public void mouseOverReports()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_reports).build().perform();
		
	}
	
	public void clickOnCitiwiseBranchesTotal()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_city_wise_branches_total).click().build().perform();
		
	}
	
	public void clickOnActive_CC_Accounts_Total()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_active_cc_accounts_total_as_per_cc_type).click().build().perform();
		
	}
	
	public void mouseOverInsurance()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_insurance).build().perform();
		
	}
	
	public void clickOnPremiumCalculator()
	{
		Actions action=new Actions(driver);
		action.moveToElement(_premium_calculator).click().build().perform();
	}
	
	
	
	
	
	public ViewBranchesPage GetViewBranchesPageObject()
	{
		
		ViewBranchesPage vbp=new ViewBranchesPage(driver);
		return vbp;
	}
	
	public ViewCitiesPage GetViewCitiesPageObject()
	{
		ViewCitiesPage vcp= new ViewCitiesPage(driver);
		return vcp;		
	}
	
	public CitywiseBranchesTotalPage GetCitywiseBranchesTotalPageObject()
	{
		CitywiseBranchesTotalPage cbt=new CitywiseBranchesTotalPage(driver);
		return cbt;
	}
	
	public Active_CC_AccountsPage GetActiveCCAccountsPageObject()
	{
		Active_CC_AccountsPage accap=new Active_CC_AccountsPage(driver);
		return accap;
	}
	
	public PremiumCalculatorPage GetPremiumCalculatorPageObject()
	{
		PremiumCalculatorPage pcp=new PremiumCalculatorPage(driver);
		return pcp;
	}
	
	
	public WelcomePage GetWelcomePageObject()
	{
		
		WelcomePage wp=new WelcomePage(driver);
		return wp;
	}
	

	
}
