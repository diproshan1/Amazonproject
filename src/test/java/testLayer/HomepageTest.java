package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseAmazonYourAccount;
import pompackage.PomHomepage;
import pompackage.PomLogin;

public class HomepageTest extends BaseAmazonYourAccount {
	
	PomLogin Log;
	PomHomepage pomHomepage;
	

	   public HomepageTest() {
		   
		   super();
}
	   @BeforeMethod
	   public void initsetup() {
		   
		   initiation();
		   takeScreenshot("Homepage");
		   
		   Log = new PomLogin();
           Log.Login(prop.getProperty("username"));
         pomHomepage =  Log.Signing(prop.getProperty("password"));
           
           
	   }  
	   @Test(priority =1)
	   
	   public void verifyamazonlogotest() {
          pomHomepage.Amazonlogo();
          Assert.assertEquals("amazon.ca", "amazon.ca", "Test case is faild");
          
		 
	   }
	   
	   @Test(priority =2)
	   
	   public void hellomessage() {
		   
	boolean hello=   pomHomepage.Hellomessage();
		   Assert.assertTrue(hello, "Hello, testing");;
		   
	   }
	   
	   @Test(priority =3)
	   
	   public void Accountlisttest() {
		   
		   pomHomepage.Accountlist();
		   takeScreenshot("Accountlist");
		   
	   }
	   
	  @AfterMethod
	   
	   public void teardown() {
		   driver.quit();
	   }
}
