package day9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Base3;
import util.Excel;

public class Hybrid extends Base3 
{
  @Test(dataProvider="dp")
  public void f(String key,String Locator,String data)
  {
	  KeyWords Key = new KeyWords(driver);
	  switch (key)
	  {
	  case"openUrl":
		  Key.open(data);
		  break;
	  case"type":
		  Key.type(Locator, data);
	  break;
	  case "click":
	  Key.click(Locator);
	  break;
	  case "getScreenShot":
		  Key.getScreenShot(data);
		  
	  }
  }
  @DataProvider
  public Object[][]dp()
  {
	  Excel ex = new Excel("C:\\Users\\vshadmin\\Desktop\\keywords.xlsx");
	  Object data[][]= new Object [ex.rowCount("Sheet1")][3];
	  for(int i =0 ;i<ex.rowCount("Sheet1");i++)
	  {
		  data[i][0]= ex.Read("Sheet1", i+1, 0);
		  data[i][1]= ex.Read("Sheet1", i+1, 1);
		  data[i][2]= ex.Read("Sheet1", i+1, 2);
	  }
	  
	  return data;
  }
}
