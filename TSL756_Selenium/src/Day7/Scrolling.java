package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import util.Base;

public class Scrolling extends Base{
  @Test
  public void f() throws InterruptedException {
	  TakesScreenshot t = (TakesScreenshot)driver;
	
	  JavascriptExecutor  js = (JavascriptExecutor)driver;
	  
	  
	  driver.get("http://seleniumhq.org");
	  Thread.sleep(2000);
	  js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("Selenium blog")));
	  Thread.sleep(2000);
	
	  js.executeScript("window.scrollBy(0,-150)"); //horizontally and vertical by pixels
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //scrolldown
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); //scrollup
	  Thread.sleep(2000);
	  js.executeScript("arguments[0].click();", driver.findElement(By.linkText("Selenium blog")));
	  Thread.sleep(2000);
  }
}
