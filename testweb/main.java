
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class main
{

    public static void main(String[] args){
        WebDriver driver  = new FirefoxDriver();
        String baseUrl;
        boolean acceptNextAlert = true;
        StringBuffer verificationErrors = new StringBuffer();
        baseUrl = "http://finance.yahoo.com/";
        driver.get(baseUrl + "/;_ylt=A0LEVi5h.DZVElcA1tsnnIlQ;_ylu=X3oDMTEzMW0yNTZkBHNlYwNzcgRwb3MDMQRjb2xvA2JmMQR2dGlkA1lIUzAwMV8x");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("UHSearchBox")).click();
        driver.findElement(By.id("UHSearchBox")).clear();
        driver.findElement(By.id("UHSearchBox")).sendKeys("GOOG,");
        driver.findElement(By.id("UHSearchProperty")).click();
        driver.findElement(By.id("yfs_l84_goog")).click();
        String StockPrice = driver.findElement(By.id("yfs_l84_goog")).getText();
        driver.quit();

    }
}