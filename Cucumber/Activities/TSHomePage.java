package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TSHomePage extends BaseClass{
	@Given("user is on the TS homepage")
	public void openHomePage()
	{
		driver.get("https://training-support.net");
		Assertions.assertEquals(driver.getTitle(), "Training Support");
	}
	
	@When("the user clicks on the About Us link")
	public void clickAboutUSLink()
	{
		driver.findElement(By.linkText("About Us")).click();
	}
	
	@Then("they are redirected to another page")
	public void verifyPageredirect()
	{
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("About US")));
		wait.until(ExpectedConditions.titleIs("About Training Support"));
		Assertions.assertEquals(driver.getTitle(), "About Training Support");
	}
}
