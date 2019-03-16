package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SQL_command
{

	WebDriver driver;
	public SQL_command(WebDriver driver)
	{
		this.driver=driver;
	}	
	private By e_logout=By.linkText("Logout");
	public void logout()
	{
		driver.findElement(e_logout).click();
	}
}
