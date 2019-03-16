package day3;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Question2 {
	public static void main(String[] args) throws Exception {

		WebDriver driver = BrowserSetup.browserStart("chrome", "https://nseindia.com");

		FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book2.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		
		XSSFSheet sheet = book.getSheet("Sheet1");
		int icnt = 1;

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			
			System.out.println(icnt);
			String data = sheet.getRow(i).getCell(0).toString();
			
			System.out.print(data);
			
			Actions action = new Actions(driver);
			driver.manage().window().maximize();
	
			driver.findElement(By.id("keyword")).sendKeys(data);
			WebElement E = driver.findElement(By.xpath("//*[contains(text(),'"+data +"')]"));

			action.moveToElement(E).click(E).perform();

			BrowserSetup.getScreenShot("Question2"+i);
			
			 String face = driver.findElement(By.xpath("//*[@id=\"faceValue\"]")).getText();
		     System.out.println("FaceValue :  " + face);
		     
		 	sheet.getRow(i).createCell(1).setCellValue(face);
		 	
			FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book2.xlsx");
			book.write(op);
			//driver.navigate().back();
			icnt++;

		}
	}
}
