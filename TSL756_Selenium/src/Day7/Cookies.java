package Day7;

import java.util.Scanner;
import java.util.Set;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import util.Base;

public class Cookies extends Base {
  
	//WebDriver webDriver;
	//Scanner scanner = new Scanner(System.in);

	//System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
	//WebDriver webDriver = new ChromeDriver();// only parent methods are access
	@Test
  
  public void f() {
driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:1512520610394997120::NO:::");
//System.out.println("Enter UID");
//String userName = scanner.nextLine();
//webDriver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys("system");

System.out.println("Enter password");
//String pass = scanner.nextLine();
//webDriver.findElement(By.cssSelector("input[type = 'password']")).clear();

driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys("Newuser123");
driver.findElement(By.cssSelector("input[value='Login']")).click();
/*
if (driver.getTitle(). equals("Oracle"))
{
	driver.findElement(By.cssSelector("img[title='Logout']")).click();
	
	driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	System.out.println("Login Done");
}
else
{
	System.out.println("Login not Successful");
}*/

Set<Cookie> allCookies	= driver.manage().getCookies();
for(Cookie C:allCookies)
{
System.out.println("Cookie Name is" +C.getName());
System.out.println("Cookie Domain is" +C.getDomain());
System.out.println("Cookie Path is" +C.getPath());
System.out.println("Cookie Expiry is" +C.getExpiry());
System.out.println("Cookie Value is" +C.getValue());

}
System.out.println("deleting..........");
driver.manage().deleteAllCookies();
driver.navigate().refresh();
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

  }
}
