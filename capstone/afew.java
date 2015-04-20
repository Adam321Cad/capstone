 

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class afew {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://finance.yahoo.com/");
		selenium.start();
	}

	@Test
	public void testAfew() throws Exception {
		selenium.open("/q;_ylt=ArKgGKUzAqv4q6unJ83hXuEnv7gF?uhb=uhb2&fr=uh3_finance_vert_gs&type=2button&s=BAC%2C");
		selenium.type("id=mnp-search_box", "YHOO,");
		selenium.click("id=yucs-sprop_button");
		selenium.waitForPageToLoad("30000");
		String exact:YHOO: Summary for Yahoo! Inc.- Yahoo! Finance = selenium.getTitle();
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
