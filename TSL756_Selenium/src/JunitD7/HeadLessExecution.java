package JunitD7;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import util.BrowserSetup;

public class HeadLessExecution {
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		//driver=BrowserSetup.browserStart("chrome") ;
		//driver = new HtmlUnitDriver(true);
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
		//ChromeOptions op = new ChromeOptions();
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("--headless");
		op.addArguments("--start-maximized");
		//driver = new ChromeDriver(op);
		driver= new FirefoxDriver(op);
		driver.manage().window().maximize();
		
	}

	@Test
	public void test() {
		driver.get("http://google.com");
		//driver.findElement(By.linkText("Download")).click();
	 //assertEquals("Downloads", driver.getTitle());
	//assertTrue(driver.findElement(By.linkText("Maven users")).isDisplayed());
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		driver.quit();
	}
}
