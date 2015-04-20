 

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class hgef {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://finance.yahoo.com/");
		selenium.start();
	}

	@Test
	public void testHgef() throws Exception {
		selenium.open("/");
		selenium.click("id=UHSearchBox");
		selenium.type("id=UHSearchBox", "YHOO,");
		selenium.click("id=UHSearchProperty");
		selenium.waitForPageToLoad("30000");
		boolean price = selenium.isElementPresent("id=yfs_l84_yhoo");
		if(price == true){
		    selenium."//div[@class='errorblock']").getAttribute("id=yfs_l84_yhoo"");
		  } else{
		      System.out.println("nope");
	}
}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
