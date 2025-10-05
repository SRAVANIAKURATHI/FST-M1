package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/tables");
		System.out.println("Page title: " + driver.getTitle());

//			Using xpaths on the table:
		List<WebElement> columns = driver.findElements(By.xpath("//thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

//			Find the number of rows and columns in the table and print them.
		System.out.println("Number of rows are " + rows.size() + " and number of coulmns are " + columns.size());

//			Find and print all the cell values in the third row of the table.
		System.out.println(
				"The cell values in third row are " + driver.findElement(By.xpath("//table/tbody/tr[3]")).getText());

//			Find and print the cell value at the second row second column.
		System.out.println("The cell value at the second row second column is "
				+ driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
//			Close the browser.
		driver.quit();
	}

}
