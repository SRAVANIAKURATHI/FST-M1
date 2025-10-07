package Activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity2 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void verifyWebsiteHeading() {
		//Get the heading of the webpage.Make sure it matches “Welcome to Alchemy Jobs” exactly.
		assertEquals("Welcome to Alchemy Jobs", driver.findElement(By.xpath("//h1[@class='entry-title']")).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
