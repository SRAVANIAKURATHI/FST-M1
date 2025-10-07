package Activities;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity1 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		//Open a browser.
		driver = new FirefoxDriver();
		//Navigate to ‘https://alchemy.hguy.co/jobs’
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void verifyTitle() {
		//Get the title of the website.Make sure it matches “Alchemy Jobs – Job Board Application” exactly
		assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");

	}

	@AfterClass
	public void tearDown() {
		//close the browser.
		driver.close();
	}

}
