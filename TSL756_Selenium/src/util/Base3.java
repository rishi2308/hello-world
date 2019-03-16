package util;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base3 {
	public WebDriver driver;
  @BeforeTest
  public void beforeTest() 
  {
	  driver = BrowserSetup.browserStart("chrome");
  }
  
  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
