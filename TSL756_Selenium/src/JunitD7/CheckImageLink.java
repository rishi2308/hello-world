package JunitD7;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowserSetup;

public class CheckImageLink {
 static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		driver=BrowserSetup.browserStart("chrome") ;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		driver.quit();
	}

	@Test
	public void test() {
	driver.get("https://google.com");
	List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
	allLinks.addAll(driver.findElements(By.tagName("img")));
	for(WebElement E: allLinks)
	{
		String url=E.getAttribute("href");
		try {
			Proxy proxy = new Proxy(Proxy.Type.HTTP,
					new InetSocketAddress("192.168.100.1",8081));
			
			URL U = new URL(url);	
			URLConnection C = U.openConnection(proxy);
			HttpURLConnection HC = (HttpURLConnection)C; //http is child of url
			HC.connect();
			int code = HC.getResponseCode(); // for getting status
			
			if(code == 200)
			{
				System.out.println(url+"Working");
			}
			else
			{
				System.out.println(url+"Not Working");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}

	}

	
	
	


