package Activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity4 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void verifyWebsiteSecondHeading() {
		//Get the second heading on the page.Make sure it matches “Quia quis non” exactly.
		assertEquals("Quia quis non", driver.findElement(By.tagName("h2")).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
