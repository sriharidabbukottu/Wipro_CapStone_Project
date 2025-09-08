package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.CartPage;

public class cartSteps 
{
	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginPage = new LoginPage();
	CartPage cartPage = new CartPage();
	
	@Given("I am logged in as {string} with password {string}")
	public void iAmLoggedIn(String user, String pass)
	{
		loginPage.openLoginPage();
		loginPage.login(user);
	}
	
	@When("I add {string} to the cart")
	public void iAddProductToCart(String productName)
	{
		cartPage.addProductToCart(productName);
		cartPage.openCart();
	}
	
	@Then("I should see {string} in the cart")
	public void iShouldSeeProductInCart(String productName) throws InterruptedException
	{
		Assert.assertTrue(cartPage.isProductInCart(productName),"Product "+productName+" was not found in the cart!");
	}
}
