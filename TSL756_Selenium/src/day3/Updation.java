package day3;


	import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	import util.BrowserSetup;


	public class Updation
	{
		public static void main(String[] args) throws Exception {

			WebDriver driver = BrowserSetup.browserStart("chrome",
					"http://127.0.0.1:8080/htmldb/f?p=4550:11:1512520610394997120::NO:::");
			{		FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");

				XSSFWorkbook book = new XSSFWorkbook(inFile);

				XSSFSheet sheet = book.getSheet("Sheet1");

				for (int i = 0; i <= sheet.getLastRowNum(); i++) {
					String data = sheet.getRow(i).getCell(0).toString();
					System.out.print(data);
					driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
					driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(data);
				
					String data1 = sheet.getRow(i).getCell(1).toString();
					System.out.println("  " + data1);
					driver.findElement(By.cssSelector("input[type = 'password']")).clear();
					driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys(data1);
					
					driver.findElement(By.cssSelector("input[value='Login']")).click();
					
					if (driver.getTitle().equals("Oracle")) {
						driver.findElement(By.cssSelector("img[title='Logout']")).click();
						driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
						sheet.getRow(i).createCell(3).setCellValue("Pass");
						System.out.println("Login Done");
						FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
						book.write(op);
					} 
						else {
							sheet.getRow(i).createCell(3).setCellValue("Fail");
						System.out.println("Login not Successful");
						FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
						book.write(op);
					}
					
				

				}

			}
		}
	}


