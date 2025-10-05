package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Page title: " + driver.getTitle());

		WebElement dropdown = driver.findElement(By.xpath("//select[contains(@class,'h-80')]"));
		Select multiselect = new Select(dropdown);

		// Select the "HTML" option using the visible text.
		multiselect.selectByVisibleText("HTML");

		// Select the 4th, 5th and 6th options using the index.
		multiselect.selectByIndex(3);
		multiselect.selectByIndex(4);
		multiselect.selectByIndex(5);

		// Select the "Node" option using the value
		multiselect.selectByValue("nodejs");

		// Deselect the 5th option using index.
		multiselect.deselectByIndex(5);
		
		List<WebElement> selectedOptions = multiselect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

		System.out.println("The options in the dropdown are:");
		for (WebElement e : multiselect.getOptions())
			System.out.println(e.getText());

		driver.quit();

	}

}
