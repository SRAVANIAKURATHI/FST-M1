package Activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity5 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void pageNavigation() {
		//Find the navigation bar.Select the menu item that says “Jobs” and click it.
		driver.findElement(By.id("menu-item-24")).click();
		//Read the page title and verify that you are on the correct page
		assertEquals("Jobs – Alchemy Jobs", driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
