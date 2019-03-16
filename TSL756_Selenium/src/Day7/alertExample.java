package Day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base;

public class alertExample extends Base {
  @Test
  public void f() throws InterruptedException {
	  
	  
	  driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
	  driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[1]")).click();
	  String txt = driver.switchTo().alert().getText();
	  Thread.sleep(2000);//to get the text from alert
	  driver.switchTo().alert().accept();; //to click on the alert
	  System.out.println(txt);
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[2]")).click();
	  Alert a=driver.switchTo().alert();
	  Thread.sleep(5000);
	  System.out.println(a.getText());
	  a.accept();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[3]")).click();
	  String txt1 = driver.switchTo().alert().getText(); //to get the text from alert
	  Thread.sleep(2000);
	  driver.switchTo().alert().sendKeys("Rishi");//to click on the alert
	  driver.switchTo().alert();
	 
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	 // driver.switchTo().alert().dismiss();
  }
}
