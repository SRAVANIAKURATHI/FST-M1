package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("Page title: " + driver.getTitle());
		
//		Find the button to open a CONFIRM alert and click it.
		driver.findElement(By.id("prompt")).click();

//		Switch the focus from the main window to the Alert box and get the text in it and print it.
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert text: "+alert1.getText());
		alert1.sendKeys("Awesome!");
//		Close the alert once with Ok 
		alert1.accept();
		System.out.println(driver.findElement(By.id("result")).getText());

//		Close the browser.
		driver.quit();
	}

}
