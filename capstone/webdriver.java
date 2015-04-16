//import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxProfile;

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
    public webdriver(String urlName){
        url = urlName;
    }
    
    
    public void main(){
         WebDriver driver = new FirefoxDriver();
         driver.get(url);
    }
    
    
}