package day9;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExample 
{
	WebDriver driver;
	  DesiredCapabilities dc;
  @Test
  public void f() throws Exception 
  {
	  
	  driver.get("https://www.seleniumhq.org/");
	  Assert.assertEquals(driver.getTitle(), "Selenium - Web Browser Automation");
	
  }
  @org.testng.annotations.BeforeTest
  @Parameters("browser")
  public void BeforeTest(String browser) throws MalformedURLException 
  {
	  if(browser.equalsIgnoreCase("firefox"))
	  {
	   dc=DesiredCapabilities.firefox();
	  dc.setPlatform(Platform.WINDOWS);
	  dc.setBrowserName("firefox");
	  }
	  else if(browser.equalsIgnoreCase("chrome"))
	  {
		 dc=DesiredCapabilities.chrome();
		  dc.setPlatform(Platform.WINDOWS);
		  dc.setBrowserName("chrome");
	  }
	  driver =new RemoteWebDriver(new URL(" http://192.168.100.179:4444/wd/hub"), dc);
  	}
  @org.testng.annotations.AfterTest
  public void AfterTest()
  {
	  driver.quit();	
  }
	 
  }
  

