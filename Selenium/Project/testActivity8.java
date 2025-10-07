package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity8 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@Test
	public void pageNavigation() {
		//Find the username field of the login form and enter the username into that field
		driver.findElement(By.id("user_login")).sendKeys("root");
		
		//Find the password field of the login form and enter the password into that field.
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		
		//Find the login button and click it.
		driver.findElement(By.id("wp-submit")).click();
		
		//Verify that you have logged in.
		assertEquals("Dashboard ‹ Alchemy Jobs — WordPress", driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
