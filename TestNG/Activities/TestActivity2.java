package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class TestActivity2 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
	}

	@Test
	public void testcase1() {
		assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}

	@Test
	public void testcase2() {
		driver.findElement(By.linkText("Black"));
	}

	@Test(enabled = false)
	public void testcase3() {
		System.out.println("This method is skipped and should not be shown");
	}

	@Test
	public void testcase4() {
		throw new SkipException("skipping the method");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
