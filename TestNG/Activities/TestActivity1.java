package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@Test(priority = 1)
	public void pageTitleTest()
	{
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Training Support");
		
	}
	
	@Test(priority = 2)
	public void aboutusPageTest() {
		driver.findElement(By.linkText("About Us")).click();
		wait.until(ExpectedConditions.titleIs("About Training Support"));
		//Assert.assertEquals(driver.getTitle(),"About Training Support");
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
