package pompackage;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonYourAccount;

public class PomYourPayment extends BaseAmazonYourAccount {
	
	public PomYourPayment() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//h2[contains(text(),'Your Payments')]") WebElement yourpaymentlink;
    @FindBy (xpath="//span[contains(text(),'Cards and accounts')]") WebElement cardandaccountlogo;
    @FindBy (xpath="//input[@class='a-button-input' and @type='submit']") WebElement addpaymentbutton;
    
    @FindBy (xpath="//*[@id=\"pp-xsotGM-23\"]/span/input") WebElement addcreditcard;
    
    @FindBy (xpath="//*[@id=\"pp-9S4M50-15\"]") WebElement cardnumber;
    
    @FindBy (xpath="//*[@id=\"pp-9S4M50-17\"]") WebElement nameoncard;
    
    @FindBy (xpath= "//*[@id=\"pp-9S4M50-21\"]/span/i") WebElement monthdropdown;
    
    @FindBy (xpath="//*[@id=\"pp-9S4M50-22\"]/span/i") WebElement yeardropdown;
    
    @FindBy (xpath="//*[@id=\"pp-9S4M50-24\"]/span/input") WebElement addyourcard;
    
    
    public void clickonyourpaymentlink() {
    	
    	yourpaymentlink.click();
    }
    
    public void varifycardaccountlogo() {
    	
    boolean cardlogo=	cardandaccountlogo.isDisplayed();
    	System.out.println(cardlogo);
    }
    
    public void addcard() {
    	
    	addcreditcard.click();
   /* 	Set<String> handler=    driver.getWindowHandles();
    	Iterator<String> it=handler.iterator();    
    	String parentwindowId=it.next();
    System.out.println("parent window id"+parentwindowId);	
    
    
    String childwindowId= it.next();
    System.out.println("Childwindow it"+ childwindowId);
    
    driver.switchTo().window(childwindowId);
    */
    
    driver.switchTo().alert().accept();
    
    	
    }
    
	
}
