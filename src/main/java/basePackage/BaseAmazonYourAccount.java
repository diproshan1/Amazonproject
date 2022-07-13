package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtility;
//step 1
public class BaseAmazonYourAccount {
	
	/*browser info
	 * url info
	 * login info
	 * if info change than base class fail, so create configuration file
	 *  
	 * 
	 */
	public static Properties prop;
	public static WebDriver driver;
	
	public BaseAmazonYourAccount() {
		
	
	try {
	FileInputStream file = new FileInputStream("C:\\Users\\dipro\\eclipse-workspace\\AmazonYouraccount\\src\\main\\java\\com\\configurationfile\\config.properties");
	prop = new Properties();
	
	prop.load(file);
	
	}
	catch (FileNotFoundException e ) {
		
		e.printStackTrace();;
		
	}
    catch (IOException a) {
    	a.printStackTrace();
    }
}
	
	//Step 2
	
	public static void initiation() {
		// driver path
		//maximize page load m implicit getting url
		
     String browsername=		prop.getProperty("browser");
     
     if (browsername.equals("chrome")) {
    	 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	 	driver = new ChromeDriver();
    	 	
    	 	
     }
     else if (browsername.equals("Firefox")) {
    	 System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    	 driver = new FirefoxDriver();
    	 
     }
         driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtility.timepage, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtility.implicitwait, TimeUnit.SECONDS);
		
	}
     public static void takeScreenshot(String fileName) {
    	 
    	 // take screenshot and store it as a file formate:
    	 
    	  File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 
    	  // now copy the screenshot to desire location using copyfile method:
    	  try {
    	  FileUtils.copyFile(file, new File("C:\\Users\\dipro\\eclipse-workspace\\AmazonYouraccount\\src\\main\\java\\screenshots\\Screenshots/"+
    	  fileName+".jpg"));
    	  }
    	  
    	  catch( IOException e) {
    		  
    		  e.printStackTrace();
    		  
    	  }
     }
}
