//import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.concurrent.TimeUnit;
//all imports from below coppied out of example
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
    //private String baseUrl;
    public webdriver(String urlName){
        url = urlName;
        driver = new FirefoxDriver();
        //baseUrl = "url";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.action();
    }

    //public void main(){

    //}

    public void action(){
        driver.get(url);
        driver.findElement(By.id("mnp-search_box")).clear();
        driver.findElement(By.id("mnp-search_box")).sendKeys("GOOG,");
        driver.findElement(By.id("yucs-sprop_button")).click();
        websiteCatch w = new websiteCatch(driver.getPageSource());
        System.out.println(w.getStockPrice());
        driver.findElement(By.id("mnp-search_box")).clear();
        driver.findElement(By.id("mnp-search_box")).sendKeys("YHOO,");
        driver.findElement(By.id("yucs-sprop_button")).click();
        w.updateHtml(driver.getPageSource());
        System.out.println(w.getStockPrice());
    }

}