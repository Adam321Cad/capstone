 
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test1 {
	
	static WebDriver driver;									// Globally visible driver variable
	static String phantomFile = "phantomjs.exe";				// location of PhantomJS executable file
	static String screenshot1 = "C:\\tmp\\screenshot1.png";		// Location of 1st screenshot for phantomjs debugging purposes
	static String screenshot2 = "C:\\tmp\\screenshot2.png";		// Location of 1st screenshot for phantomjs debugging purposes
	
	public static void initDriverVisible(boolean visible){			// Choose if Firefox or PhantomJS(for headless browser) is required
		if (visible) {
			driver  = new FirefoxDriver();
		} else {
			 File file = new File(phantomFile);
			 String userAgent = "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0"; // Faking User Agent
			 System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		     System.setProperty("phantomjs.page.settings.userAgent", userAgent);
		     DesiredCapabilities cap = DesiredCapabilities.phantomjs(); 		  // Setting PhantomJS Capabilities
		     cap.setJavascriptEnabled(true);
		     String[] phantomArgs = new  String[] {
			    	    "--webdriver-loglevel=INFO"  //Logging off
			    	};
		     cap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		     cap.setCapability("phantomjs.page.settings.userAgent",userAgent); 

		     driver = new PhantomJSDriver(cap);
		     Dimension arg0 = new Dimension(1300, 1100);
			 driver.manage().window().setSize(arg0);
		}
	}

	public static void takeScreenshot(String fileName){			//Take screenshot for debugging when running phantomjs headless
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	FileUtils.copyFile(scrFile, new File(fileName));
        	} catch (IOException e) {
        		e.printStackTrace();
        		}
	}
	
	public static void scrapeUnited(){
		// Get initial webpage
		String baseUrl = "http://ual.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	    
	    // Wait until webpage appears by looking for a specific id on the page
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_ContentInfo_Booking1_btnSearchFlight")));	
	    
	    // Fill out field(s) and try to catch any error
	    try {
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_Origin_txtOrigin")).click();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_Origin_txtOrigin")).clear();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_Origin_txtOrigin")).sendKeys("ORD");
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_Destination_txtDestination")).click();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_Destination_txtDestination")).clear();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_Destination_txtDestination")).sendKeys("LON");
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_DepDateTime_Depdate_txtDptDate")).click();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_DepDateTime_Depdate_txtDptDate")).clear();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_DepDateTime_Depdate_txtDptDate")).sendKeys("05/05/2015");
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_RetDateTime_Retdate_txtRetDate")).click();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_RetDateTime_Retdate_txtRetDate")).clear();
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_RetDateTime_Retdate_txtRetDate")).sendKeys("05/15/2015");	    	
	    } catch(Exception e){e.printStackTrace();	    }
	    // Take screenshot to see if the fields are filled properly
	    takeScreenshot(screenshot1);
	    // Click to see the result and try to catch any error
	    try{
	    	driver.findElement(By.id("ctl00_ContentInfo_Booking1_btnSearchFlight")).click();
	    	} catch (Exception e) {e.printStackTrace();}
	    
	    // Take 2nd screenshot to see if the results are correct
	    takeScreenshot(screenshot2);
	    // Print lowest nonstop to Console
	    String price = driver.findElement(By.id("ctl00_ContentInfo_Results_spanNonStop")).getText();
	    System.out.println("Lowest Nonstop price is: " + price);
	}
	public static void scrapeYahoo(){
		// Get initial webpage
		String baseUrl = "http://finance.yahoo.com/";
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	    
	    // Wait until webpage appears by looking for a specific id on the page
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("UHSearchBox")));	
	    
	    // Fill out required webfield(s) and try to catch any error
	    try {
	    	driver.findElement(By.id("UHSearchBox")).click();
	    	driver.findElement(By.id("UHSearchBox")).clear();
	    	driver.findElement(By.id("UHSearchBox")).sendKeys("GOOG");  	
	    } catch(Exception e){e.printStackTrace();	    }
	    
	    // Take screenshot to see if the fields are filled properly
	    takeScreenshot(screenshot1);
	    
	    // Click to see the result and try to catch any error
	    try{
	    	driver.findElement(By.id("UHSearchProperty")).click();
	    	} catch (Exception e) {e.printStackTrace();}
	    
	    // Take 2nd screenshot to see if the results are correct
	    takeScreenshot(screenshot2);
	    
	    // Print lowest nonstop to Console
	    String price = driver.findElement(By.id("yfs_l84_goog")).getText();
	    System.out.println("Stock price is: " + price);
	}

	public static void main(String[] args) {
		// Setting true will show Firefox false will show phantomjs
		initDriverVisible(false);
		
		// Scrape your website
		scrapeYahoo();
		//scrapeUnited();
		
		//gracefully close the driver
        driver.close();
        driver.quit();
	}
}
