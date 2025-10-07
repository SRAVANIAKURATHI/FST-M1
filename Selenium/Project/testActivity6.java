package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testActivity6 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	public void pageNavigation() {
		//navigate to the Jobs page.
		driver.findElement(By.id("menu-item-24")).click();
		
		//Search for a particular job and wait for listings to show
		driver.findElement(By.id("search_keywords")).sendKeys("IT");
		driver.findElement(By.className("search_submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'showing')]")));
		
		//Click and open any one of the jobs listed
		driver.findElement(By.xpath("//div/h3")).click();
		
		//Click the apply button and print the email to the console.
		driver.findElement(By.className("application_button")).click();
		System.out.println("Email: "+ wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("job_application_email"))).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
