package day9;
import org.testng.annotations.Test;
import util.Base3;

public class ExecuteKey extends Base3 
{
  @Test
  public void f() 
  {
	  KeyWords Key = new KeyWords(driver);
	  Key.open("http://opensource-demo.orangehrmlive.com/");
	  Key.type("txtUsername_name", "admin");
	  Key.type("txtPassword_id","admin123" );
	  Key.click("//*[@type='submit']_xpath");
	  Key.click("//*[@id='welcome']_xpath");
	  Key.click("Logout_linktext");
	  Key.getScreenShot("Key");
  }
}
