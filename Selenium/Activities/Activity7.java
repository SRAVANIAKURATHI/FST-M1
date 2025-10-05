package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");

		System.out.println("Page title: " + driver.getTitle());

		WebElement inputbox = driver.findElement(By.id("textInput"));
		System.out.println("Is input box enabled?  " + inputbox.isEnabled());

		driver.findElement(By.id("textInputButton")).click();
		System.out.println("Is input box enabled?  " + inputbox.isEnabled());

		inputbox.sendKeys("Entered random value");
		System.out.println(inputbox.getDomProperty("value"));

		driver.quit();
	}

}
