package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		System.out.println("Page title: " + driver.getTitle());

		System.out.println("The 3rd heading is: "
				+ driver.findElement(By.xpath("//h3[contains(@class, 'text-orange-600')]")).getText());
		System.out.println("The color of 5th header is "
				+ driver.findElement(By.xpath("//h5[contains(@class, 'text-purple-600')]")).getCssValue("Color"));
		
		System.out.println("The class of purple button is "+driver.findElement(By.xpath("//button[contains(@class,'text-purple-900')]")).getAttribute("class"));
		System.out.println("Slate button's text: "+driver.findElement(By.xpath("//button[contains(@class,'text-slate-900')]")).getText());
		driver.quit();
	}

}
