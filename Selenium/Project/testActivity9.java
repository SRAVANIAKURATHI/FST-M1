package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity9 {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@Test
	public void createJobListingBG() {
		// Navigate to ‘https://alchemy.hguy.co/jobs/wp-admin’ and log in
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();

		// Locate the left hand menu and click the menu item that says “Job Listings”.
		driver.findElement(By.xpath("//div[text()='Job Listings']")).click();

		// Locate the “Add New” button and click it.
		driver.findElement(By.className("page-title-action")).click();

		driver.findElement(By.xpath("//div[@class='components-modal__header']/button")).click();

		// Fill in the necessary details
		String jobName = "Test Engineer2";
		driver.findElement(By.id("post-title-0")).sendKeys(jobName);
		driver.findElement(By.id("_company_name")).sendKeys("IBM");
		driver.findElement(By.id("_job_location")).sendKeys("Hyderabad");

		// Click the “Publish” button
		driver.findElement(By.xpath("//button[text()='Publish…']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Publish']"))).click();

		// Verify that the job listing was created
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Job"))).click();
		assertEquals(jobName, driver.findElement(By.className("entry-title")).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}
}
