package stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps 
{
	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginPage = new LoginPage();
	
	@Given("I open the login page")
	public void openLoginPage()
	{
		loginPage.openLoginPage();
	}
	
	@When("I login with {string} and {string}")
	public void loginWith(String user, String pass)
	{
		loginPage.login(user, pass);
	}
	
	@Then("I should see products displayed")
	public void verifyProductsDisplayed() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shelf-item")));
		Assert.assertTrue(firstProduct.isDisplayed(),"Products were not displayed after login!");
		Thread.sleep(6000);
	}
}
