package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseAmazonYourAccount;
import pompackage.PomLogin;

public class LoginTest extends BaseAmazonYourAccount {
	PomLogin Log;
	
   public LoginTest() {
	   
	   super();
	   
   }
	
   @BeforeMethod
   public void initsetup() {
	   
	   initiation();
	   Log = new PomLogin();
	   
	   
   }

   @Test (priority=2)
   
   public void loginTest() {
	   
	   Log.Login(prop.getProperty("username"));
	   Log.Signing(prop.getProperty("password"));
	   
	   
   }
	
   
   
  @Test (priority = 1)
   
   public void logovarify() {
	    boolean logo=Log.amazonlogo();
	    Assert.assertTrue(logo);
	   
	   
   }
   
  @AfterMethod
   
   public void teardown() {
	   
	   driver.quit();
   }
   
   
   
   
   
   
}
