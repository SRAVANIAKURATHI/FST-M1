package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		WebDriver driver=null;
		try {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net");
		
		System.out.println("Page title: "+driver.getTitle());
		
		driver.findElement(By.className("card")).click();
		System.out.println("New Page title: "+driver.getTitle());
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			driver.close();
		}
	}	

}
