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
 * Write a description of class webdriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class webdriver
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
    //private String baseUrl;
    final private boolean visible = true;
    public webdriver(String urlName){
        url = urlName;
        if (visible) {
            driver  = new FirefoxDriver();
        } else {
            File file = new File(phantomFile);
            String userAgent = "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0"; // Faking User Agent
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
            System.setProperty("phantomjs.page.settings.userAgent", userAgent);
            DesiredCapabilities cap = DesiredCapabilities.phantomjs();           // Setting PhantomJS Capabilities
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "http://finance.yahoo.com/";
        //this.action();

    }
    //  public void main(){

    //}

    public void action2(ArrayList<String> stock){
        int bla = stock.size();
        boolean first = true;
        for(int i = 0; i<stock.size();i++){
            String s = stock.get(i);
            s.toUpperCase();
            websiteCatch w = new websiteCatch();
            if(first == true){
                driver.get(baseUrl + "/;_ylt=A0LEVi5h.DZVElcA1tsnnIlQ;_ylu=X3oDMTEzMW0yNTZkBHNlYwNzcgRwb3MDMQRjb2xvA2JmMQR2dGlkA1lIUzAwMV8x");
                driver.findElement(By.id("UHSearchBox")).click();
                driver.findElement(By.id("UHSearchBox")).clear();
                driver.findElement(By.id("UHSearchBox")).sendKeys(s+",");
                driver.findElement(By.id("UHSearchProperty")).click();

                w.getHtml(driver.getCurrentUrl());
                System.out.println(w.getStockPrice());
            }else{
                driver.findElement(By.id("mnp-search_box")).clear();
                driver.findElement(By.id("mnp-search_box")).sendKeys(s+",");
                driver.findElement(By.id("yucs-sprop_button")).click();
                w.getHtml(driver.getCurrentUrl());
                System.out.println(w.getStockPrice());

            }
        }
        this.tearDown();
    }

    public void action(){
        driver.get(baseUrl + "/;_ylt=A0LEVi5h.DZVElcA1tsnnIlQ;_ylu=X3oDMTEzMW0yNTZkBHNlYwNzcgRwb3MDMQRjb2xvA2JmMQR2dGlkA1lIUzAwMV8x");
        driver.findElement(By.id("UHSearchBox")).click();
        driver.findElement(By.id("UHSearchBox")).clear();
        driver.findElement(By.id("UHSearchBox")).sendKeys("GOOG,");
        driver.findElement(By.id("UHSearchProperty")).click();

        websiteCatch w = new websiteCatch();
        w.getHtml(driver.getCurrentUrl());
        System.out.println(w.getStockPrice());

        driver.findElement(By.id("mnp-search_box")).clear();
        driver.findElement(By.id("mnp-search_box")).sendKeys("YHOO,");
        driver.findElement(By.id("yucs-sprop_button")).click();
        w.getHtml(driver.getCurrentUrl());
        System.out.println(w.getStockPrice());
        //driver.findElement(By.id("yfs_l84_goog")).click();
        //String StockPrice = driver.findElement(By.id("yfs_l84_goog")).getText();
        this.tearDown();
    }

    public void tearDown(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}