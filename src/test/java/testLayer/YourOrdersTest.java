package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseAmazonYourAccount;
import pompackage.PomHomepage;
import pompackage.PomLogin;
import pompackage.PomYourOrders;

public class YourOrdersTest extends BaseAmazonYourAccount{
	
	PomLogin Log;
	PomHomepage pomHomepage;
	PomYourOrders yourorders;
	
	
	public YourOrdersTest() {
		
		super();
		
	}
	
	 @BeforeMethod
	   public void initsetup() {
		   
		   initiation();
		   
		   
		   Log = new PomLogin();
         Log.Login(prop.getProperty("username"));
       pomHomepage =  Log.Signing(prop.getProperty("password"));
	pomHomepage.clickonYourorderslink();
       yourorders = new  PomYourOrders();
               

}
	 @Test(priority =1)
	 
	 public void clickOnBuyAgaintabTest() {
		 yourorders.clickOnBuyagainTab();
		 
	 }
	 
	 @Test (priority=2)
	 
	 public void varifyyourorderlogoTest() {
		 
		Assert.assertTrue(yourorders.varifyyourorderlogo());
	
		 
	 }
	 
	 @Test (priority=3)
	 
	 public void buyitagiantabTest() {
		 
		 yourorders.clickOnBuyagainTab();
		 
	 }
	 
	 @Test (priority=4)
	 public void notyetshipedTest() {
		 
		 yourorders.clickOnNotShippedYetTab();
	 }
	 
	 @Test (priority=5)
	 public void cancleordersTest() {
		 
		 yourorders.clickOnCancelledOrdersTab();
	 }
	 
	 
	 @Test(priority=6)
	 public void dropdownorderhistoryTest() {
		 
		 yourorders.dropdownOrderhistory();
		 
		 takeScreenshot("dropdown");
	 }
	 @Test(priority=7)
	 
	 public void dropdownpast3monthTest() {
		 
		 yourorders.dropdownpast3month();
		 
		 takeScreenshot("3month");
		 
	 }
	 
	 @AfterMethod
	 
	 public void teardown() {
		 
		 driver.quit();
		 
	 }
}