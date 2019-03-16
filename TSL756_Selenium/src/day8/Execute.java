package day8;

import org.testng.annotations.Test;

import util.Base;

import util.Base3;

public class Execute extends Base3 {
  @Test
  public void f() 
  {  
	  driver.get("http://127.0.0.1:8080/htmldb");
	  Login ln=new Login(driver);
	  SQL_command cmd=new SQL_command(driver);
	  ln.LoginProcess("sys", "Newuser123");
	  cmd.logout();
  }
}
