package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestActivity4DemoOne {
	 @Test
	    public void firstTestCase() {
	        System.out.println("I'm in first test case from demoOne Class");
	    }

	    @Test
	    public void secondTestCase() {
	        System.out.println("I'm in second test case from demoOne Class");
	    }
}
