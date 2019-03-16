package day9;
import org.testng.annotations.Test;

import util.Base3;
public class Execute extends Base3 {
  @Test
  public void F()
  {
	  LoginFactory LF=new LoginFactory(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LF.LoginProcess("sys","Newuser123");
  }
   
  @Test
  public void LinkTest()
  {
	  LinkCHeck link=new LinkCHeck(driver);
	  driver.get("http://newtours.demoaut.com");
	link.CheckLink(); 
  
  }
}
