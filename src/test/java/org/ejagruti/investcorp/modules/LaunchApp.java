package org.ejagruti.investcorp.modules;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.ejagruti.investcorp.pages.WelcomePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LaunchApp{
	
	public static WebDriver driver=null;
	public static DesiredCapabilities dc=null;
	//public static String driverPath = "D:/automation/AllDrivers";
	
	@Parameters({"LaunchApp"})
	@Test(description="LaunchApp functionality")
	public void execute(String testData) throws MalformedURLException
	{
		//System.out.println(testData);	
		
		String browser=testData.split(",")[0].split("=")[1];
		String url=testData.split(",")[1].split("=")[1];
		String remote=testData.split(",")[2].split("=")[1];
		String hubipaddress=testData.split(",")[3].split("=")[1];		
		
		//System.out.println(browser+" "+url);
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			dc=new DesiredCapabilities("firefox", "any", Platform.WINDOWS);
			if(remote.equalsIgnoreCase("n"))
			{
			//System.setProperty("webdriver.gecko.driver", "D:\\automation\\AllDrivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\AllDrivers\\geckodriver.exe");
			driver=new FirefoxDriver(dc);
			}
			else
			{				
				driver=new RemoteWebDriver(new URL("http://"+hubipaddress+":4444/wd/hub"),dc);
			}
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\automation\\AllDrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\AllDrivers\\chromedriver.exe");
			dc=new DesiredCapabilities("chrome", "any", Platform.WINDOWS);
			driver=new ChromeDriver(dc);
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			//System.setProperty("webdriver.ie.driver", "D:\\automation\\AllDrivers\\IEDriverServer_64bit_OS.exe");
			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\AllDrivers\\IEDriverServer_64bit_OS.exe");
			dc=new DesiredCapabilities("ie", "any", Platform.WINDOWS);
			driver=new InternetExplorerDriver();			
		}
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		
		WelcomePage wp=new WelcomePage(driver);
		boolean cl=wp.checkSignInLink();
		
		Assert.assertEquals(cl, true);
			
	
	
		
	}

}
