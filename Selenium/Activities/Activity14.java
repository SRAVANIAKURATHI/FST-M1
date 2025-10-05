package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/tables");
		System.out.println("Page title: " + driver.getTitle());

//			Using xpaths on the table:
		List<WebElement> columns = driver.findElements(By.xpath("//thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

//			Find the number of rows and columns in the table and print them.
		System.out.println("Number of rows are " + rows.size() + " and number of coulmns are " + columns.size());
//			Find and print the Book Name in the 5th row.
		System.out.println("The book name in the 5th row is "
				+ driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
//			Click the header of the Price column to sort it in ascending order.
		driver.findElement(By.xpath("//table/thead/tr/th[text()='Price']")).click();
//			Find and print the Book Name in the 5th row again.
		System.out.println("The book name in the 5th row is "
				+ driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
//			Close the browser.
		driver.quit();
	}

}
