package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity3 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://training-support.net/webelements/login-form");
	}

	@Test(priority = 1)
	public void pageTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");
	}

	@Test(priority = 2)
	public void logintest() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		username.sendKeys("admin");
		password.sendKeys("password");

		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		String loginMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800"))).getText();
		Assert.assertEquals("Welcome Back, Admin!", loginMessage);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
