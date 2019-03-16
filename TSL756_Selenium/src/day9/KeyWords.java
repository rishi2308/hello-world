package day9;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class KeyWords
{
	private static WebDriver driver;
	public KeyWords(WebDriver idriver)
	{
		this.driver= idriver;
	}

	public void open(String url)
	{
		driver.get(url);
	}

	public void type(String Locator,String text)
	{
		driver.findElement(element(Locator)).sendKeys(text);;
	}

	public void click(String Locator)
	{
		driver.findElement(element(Locator)).click();
	}

	public void dropdown(String Locator,String visibletext)
	{
		new Select(driver.findElement(element(Locator))).selectByVisibleText(visibletext);
	}

	public By  element(String Value) 
	{
		By B = null;
		if(Value.endsWith("_:linktext"))
			B = By.linkText(Value.split("_:")[0]);
		else if (Value.endsWith("_:xpath"))
			B = By.xpath(Value.split("_:")[0]);
		else if (Value.endsWith("_:id"))
			B = By.id(Value.split("_:")[0]);
		else if (Value.endsWith("_:name"))
			B = By.name(Value.split("_:")[0]);
		else if (Value.endsWith("_:css"))
			B = By.cssSelector(Value.split("_:")[0]);
		else
			System.out.println("invalid");
		return B;
	}

	public  void getScreenShot(String Name)
	{
		String timeStamp;
		TakesScreenshot  screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ss").format(new Date());
		try
		{
			FileHandler.copy(src, new File(".\\"+Name+timeStamp+".png"));
		}
		catch (IOException e)
		{
			System.out.println("Error");
		}	 	
	}

	public   WebDriver  browserStart(String name) 
	{
		if(name.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",".\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public  WebDriver  browserStart(String name, String url)
	{
		WebDriver driver =  browserStart(name);
		driver.get(url);
		return driver;	
	}
}
