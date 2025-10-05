package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity3 {

	public static void main(String[] args) {
		WebDriver driver = null;

		driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form");

		System.out.println("page Title: " + driver.getTitle());
//			Find the username field using any locator and enter "admin" into it.
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
//			Find the password field using any locator and enter "password" into it.
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
//			Find the "Log in" button using any locator and click it.
		driver.findElement(By.xpath("//button[@data-svelte-h='svelte-gtkoxm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'text-emerald-500')]")));
		System.out.println("New page Title: " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		driver.quit();

	}

}
