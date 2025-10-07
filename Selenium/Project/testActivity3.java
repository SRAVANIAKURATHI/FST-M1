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

public class testActivity3 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void getHeaderImageUrl(){
		//Get the url of the header image
		String imageUrl= wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img"))).getAttribute("src");
		//Print the url to the console.
		System.out.println("Image URL: " + imageUrl);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
