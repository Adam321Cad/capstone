import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
    //private String baseUrl;
    public webdriver(String urlName){
        url = urlName;
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "http://finance.yahoo.com/";
        this.action();

    }
    //public void main(){

    //}

    public void alt(){
        driver.get(baseUrl + "/;_ylt=A0LEVjxD0jdVyHQAi6gnnIlQ;_ylu=X3oDMTByMG04Z2o2BHNlYwNzcgRwb3MDMQRjb2xvA2JmMQR2dGlkAw--");
        driver.findElement(By.id("UHSearchBox")).click();
        driver.findElement(By.id("UHSearchBox")).clear();
        driver.findElement(By.id("UHSearchBox")).sendKeys("GOOG,");
        driver.findElement(By.id("UHSearchProperty")).click();
        driver.findElement(By.id("mnp-search_box")).clear();
        driver.findElement(By.id("mnp-search_box")).sendKeys("YHOO,");
        driver.findElement(By.id("yucs-sprop_button")).click();
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