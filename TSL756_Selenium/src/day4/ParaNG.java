package day4;

import org.testng.annotations.Test;

import util.BrowserSetup;
import util.Excel;
import util.MyConnection;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


public class ParaNG {
	WebDriver driver;
	Connection conn;
	
	@Test
	public void Login() throws Exception {
	  
		conn=MyConnection.getMyConnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select uname,pass from EXCEL");
		
		while(rs.next())
		{
			String name=rs.getString(1);
			System.out.println(name);		
			 driver.findElement(By.xpath("//*[@id=\"P11_USERNAME\"]")).sendKeys(name);
		
			String pass=rs.getString(2);
			System.out.println(pass);	
			 driver.findElement(By.xpath("//*[@id=\"P11_PASSWORD\"]")).sendKeys(pass);
			
			  driver.findElement(By.xpath("//*[@value='Login']")).click();
			
			  if (driver.getTitle().equals("Oracle"))
				{	  System.out.println("Hjgfj");
				  PreparedStatement pstmt = conn.prepareStatement("update  excel set status='success' where uname='"+name+ "'");
				  
			//  	pstmt.setString(1,"login successful");
				  	pstmt.executeUpdate();
				    driver.findElement(By.xpath("//*[@id=\"wwvFlowForm\"]/a[4]")).click();
					  driver.findElement(By.xpath("//*[@id=\"R322068013750423668\"]/a")).click();  
					
				}
				else
				{
					System.out.println("login fail");
					PreparedStatement pst=conn.prepareStatement("update excel set status='failed' where uname='"+name+"'" );
					System.out.println(pst);
					System.out.println("HHH");
					int row = pst.executeUpdate();
					System.out.println("order created " + row);
					
					
			
				}
//			  driver.findElement(By.linkText("Logout")).click();
//			  driver.findElement(By.partialLinkText("Log")).click();  	  
		} 
  }
 /*
  @DataProvider
  public Object[][] dp() throws IOException
  {
	  	Object data[][]=new Object[4][2];
	  	Excel excel=new Excel("C:\\Users\\vshadmin\\Documents\\Book11.xlsx");
	  	
		for(int i=0;i<=excel.rowCount("Sheet1");i++)
		{
			data[i][0]=excel.Read("Sheet1",i , 0);
			data[i][1]=excel.Read("Sheet1",i , 1);
		}
	  return data;
  }*/
 /*
  @AfterMethod
  public void afterMethod(ITestResult result)
  {
	  System.out.println(ITestResult.FAILURE);
	  System.out.println(ITestResult.SUCCESS);
	  System.out.println(ITestResult.SKIP);
	  if(result.getStatus()==ITestResult.FAILURE);
	  {
		  System.out.println("Take SS");
		  BrowserSetup.getScreenShot(result.getName());
	  }
  }*/
  
  @BeforeTest
  public void beforeTest() {
	  
	  driver = BrowserSetup.browserStart("Chrome","http://127.0.0.1:8080/htmldb");
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
