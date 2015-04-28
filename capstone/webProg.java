import java.util.regex.Pattern;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import java.util.ArrayList;
/**
 * this class does the actual webscraping. You can have a visible browser or a invsible browser if you have phantomjs
 * 
 * @author (Adam Arato) 
 * @version (April 24)
 */
public class webProg
{
    private String html = "";
    private String url;
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;
    private String phantomFile = "phantomjs.exe";               // location of PhantomJS executable file
    private String screenshot1 = "C:\\tmp\\screenshot1.png";        // Location of 1st screenshot for phantomjs debugging purposes
    private String screenshot2 = "C:\\tmp\\screenshot2.png";    
    //this can make firefox visible or invisible
    final private boolean visible = false;
        /**
     * sets up the webdriver so that i can begin scraping
     */
    public webProg(String urlName){
        url = urlName;
        if (visible) {
            driver  = new FirefoxDriver();
        } else {
            File file = new File(phantomFile);
            String userAgent = "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0"; // Faking User Agent
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
            System.setProperty("phantomjs.page.settings.userAgent", userAgent);
            
            driver = new PhantomJSDriver();
            //Dimension arg0 = new Dimension(1300, 1100);
            //driver.manage().window().setSize(arg0);

        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //baseUrl = "http://finance.yahoo.com/";
        baseUrl = "http://www.tickertech.com/";
            //this.action();

    }
    //  public void main(){

    //}
    
        /**
     * This loops though every stock and sends a string to net to get the stock price of the ticker
     * 
     * @param ArrayList<string> this will take an array list of ticker symbols and get yu the stock price
     * @return     it will return the stock price of every ticker symbol typed in
     */
    public ArrayList<String> action3(ArrayList<String> stock){
        int bla = stock.size();
        boolean first = true;
        ArrayList<String> l = new ArrayList<String>();
        for(int i = 0; i<stock.size();i++){
            String s = stock.get(i);
            s.toUpperCase();
            l.add(this.net(s));
            first =false;

        }
        this.tearDown();
        return l;
    }

        /**
     * pulls the stock price based on the ticker symbol string passed in
     * 
     * @param  String this needs a ticker symbol
     * @return  String   returns the stock price as a string
     */
    public String net(String s){
        driver.get(baseUrl + "/");
        driver.findElement(By.name("ticker")).clear();
        //driver.findElement(By.xpath("/html/body/center/center/table[1]/tbody/tr[3]/td/table/tbody/tr/td[3]/span/input")).sendKeys("goog");
        driver.findElement(By.name("ticker")).sendKeys(s);
        driver.findElement(By.xpath("/html/body/center/center/table[1]/tbody/tr[3]/td/table/tbody/tr/td[5]/input")).click();
        String value = driver.findElement(By.xpath("/html/body/center/p[1]/table/tbody/tr/td/p[1]/table[2]/tbody/tr[2]/td[3]/font/b")).getText();
        return(s+" "+value+", ");
        /*
        websiteCatch w = new websiteCatch();
        w.getHtml(driver.getCurrentUrl());
        String cheack = w.getStockPrice();
        System.out.println(w.getStockPrice());
        */
    }

        /**
     * this closes the driver and quits all of the webscraper procces. It closes the firefox browser as well if it is used.
     * 
     * @param  none
     * @return  none 
     */
    public void tearDown(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}