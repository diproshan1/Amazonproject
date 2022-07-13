package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonYourAccount;

public class PomHomepage extends BaseAmazonYourAccount {

	// object repository for homepage after login 
	
	@FindBy (xpath="//a[@id=\"nav-logo-sprites\"]") WebElement Amazonlogo;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span/span") WebElement AccountList;
	
	@FindBy (xpath="//*[@id=\"nav-al-container\"]") WebElement Listmenu;
	
	@FindBy (xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]") WebElement Hellomessage;
	
	@FindBy (xpath="//span[contains(text(),'Your Account')]") WebElement youraccountmenu;
	// this bottom line is very important to initialize the test
	
	@FindBy (xpath="//h2[contains(text(),'Your Orders')]") WebElement YourordersLink;
	
	@FindBy (xpath= " //h2[contains(text(),'Login & security')]") WebElement LoginandSecuritylink;
	
	@FindBy(xpath="//h2[contains(text(),'Prime')]") WebElement Primelink;
	
	@FindBy(xpath=" //h2[contains(text(),'Your Addresses')]") WebElement YourAddresslink;
	
	@FindBy (xpath= "//h2[contains(text(),'Your Payments')]") WebElement YourPaymentlink;
	
	@FindBy (xpath= "//h2[contains(text(),'Gift cards')]") WebElement GiftCardlink;
	
	
  public PomHomepage() {
	  PageFactory.initElements(driver, this);
  }
	
	public String Amazonlogo(){
		
	 return driver.getTitle();
		
	}
	
	public boolean Hellomessage() {
		
		return Hellomessage.isDisplayed();
		
	}
	
	public  void youraccountmenu() {
		
		youraccountmenu.click();;
		
	}
	
	public void Accountlist() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(AccountList).build().perform();
	    action.moveToElement(Listmenu).build().perform();
	    
	   WebElement list= driver.findElement(By.partialLinkText("Your Account"));
		list.isDisplayed();
		System.out.println(list);
	
	}
	
	public PomYourOrders clickonYourorderslink() {
		YourordersLink.click();
		return new PomYourOrders();
		
		
	}
	
	public PomLoginandSecurity clickonLoginandSecuritylink() {
		
		LoginandSecuritylink.click();
		
		return new PomLoginandSecurity();
	}
	
	public PomPrime clickonPrimelink() {
		Primelink.click();
		
		return new PomPrime();
	}
	
	
	public PomYourAddress clickonYourAddresslink() {
		
		YourAddresslink.click();
		
		return new PomYourAddress();
		
	}
	
	
	
	
	
	
}
