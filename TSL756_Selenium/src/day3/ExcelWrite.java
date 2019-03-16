package day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite
{
public static void main(String[] args) throws Exception {

FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");

	XSSFWorkbook book = new XSSFWorkbook(inFile);

	XSSFSheet sheet = book.getSheet("Sheet1");
	
sheet.createRow(5).createCell(5).setCellValue("kuoi");
	sheet.createRow(1).createCell(1).setCellValue("ABCD");
	
	FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
	book.write(op);
}
}
