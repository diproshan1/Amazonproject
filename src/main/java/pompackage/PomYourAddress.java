package pompackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseAmazonYourAccount;
import dataProvider.testUtility;

public class PomYourAddress extends BaseAmazonYourAccount  {
	
	
	
	
	@FindBy( id="address-ui-widgets-countryCode-dropdown-nativeId") WebElement selectcountry;
	

	@FindBy (xpath="//h1[contains(text(),'Your Addresses')]") WebElement youraddresslogo;

	@FindBy (xpath="//a[contains(text(),'1-Click Settings')]") WebElement oneclicksetting;

	@FindBy (xpath="//a[contains(text(),'Change address on an open order')]") WebElement currentorderaddresschange;

	@FindBy (xpath="//div[@id='ya-myab-plus-address-icon']") WebElement addaddress;

	@FindBy (id="address-ui-widgets-enterAddressFullName") WebElement addressfullname;

	@FindBy (id="address-ui-widgets-enterAddressPhoneNumber") WebElement addressphonenumber;

	@FindBy (id="address-ui-widgets-enterAddressLine1") WebElement addresslineone;

	@FindBy (id="address-ui-widgets-enterAddressLine2") WebElement addresslinetwo;

	@FindBy (id="address-ui-widgets-enterAddressCity") WebElement addresscity;

	@FindBy (id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId") WebElement addressslectprovince;

	@FindBy (id="address-ui-widgets-enterAddressPostalCode") WebElement addresspostalcode;

	@FindBy (id="address-ui-widgets-use-as-my-default") WebElement addressdefaultcheckbox;

	@FindBy (id="address-ui-widgets-addr-details-gate-code") WebElement addressbuzzercode;

	@FindBy (id="dropdown1_0") WebElement deliveryoptions;

	@FindBy (xpath="//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input") WebElement addresssubmitbutton;

	@FindBy (xpath="//input[@name='address-ui-widgets-saveOriginalOrSuggestedAddress' and @type='submit']") WebElement confirmaddress;
	

	public PomYourAddress() {

		PageFactory.initElements(driver, this);
	}


	public String varifyyouraddresslogo() {
		String logo=	youraddresslogo.getText();
		return logo;
	}
	

	
	
	public void enteraddress(String country,String fullName, String phoneNumber,String addressLine1, String addressLine2,
			 String City,String Provience, String postalCode) {
		
		
		addaddress.click();
		
		Select countryselect = new Select(selectcountry);
		countryselect.selectByVisibleText(country);
		
		
		
		
		addressfullname.clear();
		addressfullname.sendKeys(fullName);
		
		addressphonenumber.clear();
		addressphonenumber.sendKeys(phoneNumber);
		
		
		addresslineone.clear();
		addresslineone.sendKeys(addressLine1);
		
		addresslinetwo.clear();
		addresslinetwo.sendKeys(addressLine2);
		
		addresscity.clear();
		addresscity.sendKeys(City);
		
		
		Select provienceselect = new Select (addressslectprovince);
		provienceselect.selectByValue(Provience);
		
		addresspostalcode.clear();
		addresspostalcode.sendKeys(postalCode);
		
		addressdefaultcheckbox.click();
		
		addresssubmitbutton.click();
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


    public void reconfirmaddress() {
    	
    	confirmaddress.click();
    }

}






