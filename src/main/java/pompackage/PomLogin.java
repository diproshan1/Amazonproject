package pompackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonYourAccount;


public class PomLogin extends BaseAmazonYourAccount {
	
	//object repository find element and create 
	
	@FindBy (xpath="//*[@id=\"ap_email\"]") WebElement user;
	
	@FindBy (xpath="//input[@id='continue']")WebElement continuebutton;
	
	@FindBy (xpath="//input[@id='ap_password']") WebElement pass;
	
	@FindBy (xpath= "//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/form/div/div[2]/div/div/label/div/label/input") WebElement remember;
	
	
	@FindBy (id="signInSubmit") WebElement signinbutton;
	
	@FindBy (xpath= "//*[@id=\"a-page\"]/div[1]/div[1]/div/a/i[1]") WebElement amazonlogo;
	
	// initiate page Element
	
	public PomLogin() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void Login (String username) {
		
		user.sendKeys(username);
		continuebutton.click();
		
	}
	
	public PomHomepage Signing (String password) {
		
		pass.sendKeys(password);
		remember.click();
		signinbutton.click();
		
     return new PomHomepage();
		
	}
	
	
	
   
	   
   
   
   
   
   public boolean amazonlogo() {
	   
	   return amazonlogo.isDisplayed();
	   
   }


}
