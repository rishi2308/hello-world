package in.lnt.day1;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OracleCSS {

	public static void main(String[] args) throws InterruptedException {

		Scanner scanner = new Scanner(System.in);

		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();// only parent methods are access
		webDriver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:1512520610394997120::NO:::");
		{
			System.out.println("Enter UID");
			String userName = scanner.nextLine();
			webDriver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
			
			webDriver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(userName);
			System.out.println("Enter password");
			String pass = scanner.nextLine();
			webDriver.findElement(By.cssSelector("input[type = 'password']")).clear();
		
			webDriver.findElement(By.cssSelector("input[type = 'password']")).sendKeys(pass);
			webDriver.findElement(By.cssSelector("input[value='Login']")).click();
			Thread.sleep(4000);
			if (webDriver.getTitle(). equals("Oracle"))
			{
				webDriver.findElement(By.cssSelector("img[title='Logout']")).click();
				Thread.sleep(4000);
				webDriver.findElement(By.cssSelector("a.htmldbInstruct")).click();
				System.out.println("Login Done");
			}
			else
			{
				System.out.println("Login not Successful");
			}
			}

	}
}