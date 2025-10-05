package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/login-form");

			System.out.println("page Title: " + driver.getTitle());
//			Find the username field using any locator and enter "admin" into it.
			driver.findElement(By.id("username")).sendKeys("admin");
//			Find the password field using any locator and enter "password" into it.
			driver.findElement(By.name("password")).sendKeys("password");
//			Find the "Log in" button using any locator and click it.
			driver.findElement(By.xpath("//button[@data-svelte-h='svelte-gtkoxm']")).click();
			Thread.sleep(5000);
			System.out.println("New page Title: " + driver.getTitle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
