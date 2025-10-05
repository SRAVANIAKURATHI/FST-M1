package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Page title: " + driver.getTitle());

		WebElement dropdown = driver.findElement(By.xpath("//select[contains(@class, 'h-10')]"));
		Select select = new Select(dropdown);

//			Select the second option using the visible text.
		select.selectByVisibleText("One");
		System.out.println(select.getFirstSelectedOption().getText());
//			Select the third option using the index.
		select.selectByIndex(2);
		System.out.println(select.getFirstSelectedOption().getText());
//			Select the fourth option using the value.
		select.selectByValue("three");
		System.out.println(select.getFirstSelectedOption().getText());
//			Get all the options and print them to the console.
		for (WebElement e : select.getOptions())
			System.out.println(e.getText());
//			Close the browser.
		driver.quit();

	}

}
