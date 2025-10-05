package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);

		driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("Page title: " + driver.getTitle());

		WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));

//		Left click on the Cargo.lock button, move the cursor to the Cargo.toml button and then click it. 
		builder.click(cargoLock).pause(1000).moveToElement(cargoToml).click(cargoToml).pause(1000).build().perform();
//		Print the confirmation text at the end of the sequence.
		System.out.println(driver.findElement(By.id("result")).getText());
//		Double click on the src button. Then right click on the target button and select open. 
		builder.doubleClick(srcButton).pause(1000).contextClick(targetButton).pause(1000).perform();
		builder.click(driver.findElement(By.xpath("//span[text()='Open']"))).pause(1000).build().perform();

//		Print the confirmation text at the end of the sequence.
		System.out.println(driver.findElement(By.id("result")).getText());

		driver.quit();

	}

}
