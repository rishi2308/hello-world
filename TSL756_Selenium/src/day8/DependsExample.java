package day8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import util.*;

public class DependsExample extends Base {
 // WebDriver driver;
	@Test
  public void f1() 
  {
//	  System.out.println("in test f1");
//	  Assert.assertTrue(true);
		driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
  }
	@Test(dependsOnMethods="f1")
  public void f2() 
  {
	 /* System.out.println("in test f2");
	  Assert.assertEquals("LNT", "LNTTT");*/
		
		boolean dis=driver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(dis);
  }
	@Test(dependsOnMethods="f2")
  public void f3() 
  {
	  /*System.out.println("in test f3");
	  Assert.assertEquals("LNT", "LNT");*/
		String data="MODI";
		driver.findElement(By.name("q")).sendKeys(data);
		driver.findElement(By.name("btnK")).click();
		Assert.assertEquals(driver.getTitle(), data+" - Google Search");
  }
}
