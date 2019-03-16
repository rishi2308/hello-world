package day3;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {

	public static void main(String[] args)throws Exception {
		FileInputStream inFile = new FileInputStream("D:\\Selenium_Testing\\Selenium_Testing\\Book1.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
			String data = sheet.getRow(i).getCell(0).toString();
			System.out.print(data);
			
			String data1 = sheet.getRow(i).getCell(1).toString();
			System.out.println("  "+data1);
		}
		
	}
	
}
