package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.*;

public class loginSteps extends BaseClass {
	@Given("the user is on the login page")
	public void openLoginPage() {
		driver.get("https://training-support.net/webelements/login-form");
		Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
	}

	@When("the user enters username and password")
	public void entercreds() {
		WebElement usernameFieldElement=driver.findElement(By.id("username"));
		WebElement passwordfieldElement=driver.findElement(By.id("password"));
		
		usernameFieldElement.clear();
		passwordfieldElement.clear();

		usernameFieldElement.sendKeys("admin");
		passwordfieldElement.sendKeys("password");
	}

	@When("the user enters {string} and {string}")
	public void entercredsAsParams(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("clicks the submit button")
	public void clickSubmit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	@Then("get the confirmation message and verify it")
	public void verifyLogin() {
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800")))
				.getText();
		Assertions.assertEquals("Welcome Back, Admin!", message);
	}

	@Then("get the confirmation text and verify message as {string}")
	public void verifyLoginFromParam(String expectedMessage) {
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800")))
				.getText();
		Assertions.assertEquals(expectedMessage, message);
	}
	
	@Then("get the error text and verify message as {string}")
	public void verifyconfirmationtext(String expmessage)
	{
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
		Assertions.assertEquals(expmessage, message);
	}
}
