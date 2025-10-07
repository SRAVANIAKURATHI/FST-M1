package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity7 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	public void pageNavigation() throws InterruptedException {
		// Locate the navigation menu and click the menu item that says “Post a Job”
		driver.findElement(By.id("menu-item-26")).click();

		// Fill in the necessary details and click the button that says “Preview”.
		driver.findElement(By.id("create_account_email")).sendKeys("applyajob3@alchemy.com");
		String jobName = "Quality Engineer";
		driver.findElement(By.id("job_title")).sendKeys(jobName);

		WebElement dropdown = driver.findElement(By.id("job_type"));
		Select select = new Select(dropdown);
		select.selectByIndex(2);

		// switch to iframe
		Thread.sleep(2000);
		driver.switchTo().frame("job_description_ifr");
		WebElement editable = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));
		editable.clear();
		editable.sendKeys("This is just some description about job given by bot");
		driver.switchTo().defaultContent();

		driver.findElement(By.id("application")).sendKeys("postajob@alchemy.com");
		driver.findElement(By.id("company_name")).sendKeys("IBM");

		// click the button that says “Preview”.
		driver.findElement(By.xpath("//*[@id=\"submit-job-form\"]/p/input[4]")).click();

		// Click on the button that says “Submit Listing”
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_preview_submit_button"))).click();

		//Verify that the job listing was posted by visiting the jobs page.
		driver.findElement(By.linkText("click here")).click();
		assertEquals(driver.findElement(By.className("entry-title")).getText(), jobName);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
