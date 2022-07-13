package pompackage;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseAmazonYourAccount;

public class PomYourOrders extends BaseAmazonYourAccount {
	
	
	@FindBy (xpath="//h1[contains(text(),'Your Orders')]") WebElement yourorderlogo;
	
	@FindBy (xpath="//li[contains(text(),'Orders')]") WebElement oderstab;
	
	@FindBy (xpath="//*[@id=\"a-page\"]/section/div/div[3]/ul/li[2]/a") WebElement buyagaintab;
	
	@FindBy (xpath= "//a[contains(text(),'Not Yet Shipped')]") WebElement notyetshippedtab;
	
	@FindBy (xpath="//a[contains(text(),'Cancelled Orders')]") WebElement cancelledorderstab;
	
	@FindBy (xpath="//span[@class='a-dropdown-prompt']") WebElement oderhistorydropdown;
	
	@FindBy (xpath="//a[@data-value='{\"stringVal\":\"months-3\"}']") WebElement past3month;
	
	
	
	public PomYourOrders() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean varifyyourorderlogo() {
		
		 return yourorderlogo.isDisplayed();
		
	}
	
	public void clickOnOrdresTab() {
		
		oderstab.click();
		
	}
	
	public void clickOnBuyagainTab() {
		buyagaintab.click();
		
	}
	
	public void clickOnNotShippedYetTab() {
		notyetshippedtab.click();
		
	}
	public void clickOnCancelledOrdersTab() {
		cancelledorderstab.click();
		
	}
	public void dropdownOrderhistory() {
		
		oderhistorydropdown.click();
		
		String orderhistory= oderhistorydropdown.getText();
		
		System.out.println(orderhistory);
		
		
		
	}
	
	public void dropdownpast3month() {
		oderhistorydropdown.click();
		past3month.click();
	}
	
		
		
	
		
	   /* Select select = new Select(oderhistorydropdown);
		
		select.selectByVisibleText("the past 30 days");
		
		select.selectByVisibleText("past 30 days");
		
		select.selectByVisibleText("2022");
		*/
		
	}
	


