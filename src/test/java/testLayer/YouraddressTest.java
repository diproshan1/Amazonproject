package testLayer;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonYourAccount;
import dataProvider.testUtility;
import pompackage.PomHomepage;
import pompackage.PomLogin;
import pompackage.PomYourAddress;

public class YouraddressTest extends BaseAmazonYourAccount{
	PomLogin Log;
	PomHomepage pomHomepage;
	
	PomYourAddress youraddress;
	
	String sheetName = "Address";
	
	
	
	public YouraddressTest() {
		
		super();
		
	}

	 @BeforeMethod
	   public void initsetup() {
		   
		   initiation();
		   
		   
		   Log = new PomLogin();
       Log.Login(prop.getProperty("username"));
 
       pomHomepage =  Log.Signing(prop.getProperty("password"));
       pomHomepage.clickonYourAddresslink();
       
       youraddress = new PomYourAddress();
       
       
}

	 @Test(priority=1)
	 
	 public void youraddresslogoisdisplayedTest() {
	   
		 
		 Assert.assertEquals(youraddress.varifyyouraddresslogo(), "Your Addresses", "test case fails- no logo is displyed");
		 
		
		 
	 }
	 
	@DataProvider
	 public Iterator<Object[]> addressdata(){
		 
		 ArrayList<Object[]> address = testUtility.getDataFromExcel();
		 
		 return address.iterator();
		 	 	 
		 
	 }
	 
	/* @DataProvider
	 public Object[][] addressdata() {
		 Object data[][]= testUtility.getTestData(sheetName);
		 
		 return data;
		 
	 }*/
	 
	 @Test (priority=2, dataProvider="addressdata")
	 
	 public void youraddressTest(String country, String fullName, String phoneNumber, String addressLine1, String addressLine2,
			 String City, String Provience, String postalCode){
		 
		 youraddress.enteraddress(country,fullName, phoneNumber, addressLine1, addressLine2, City, Provience, postalCode);
	 
		 youraddress.reconfirmaddress();
			
	 }
			 
	 
	
		 
		
	 
	 @AfterMethod
	 
	 public void teardown() {
		 
		 driver.quit();
	 }
	 
	 
	 
	 
	 
	 
	 
}
