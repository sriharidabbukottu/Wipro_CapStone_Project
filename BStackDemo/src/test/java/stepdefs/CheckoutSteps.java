package stepdefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutSteps 
{
	LoginPage loginPage = new LoginPage();
	CartPage cartPage = new CartPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	
	@Given("I have added {string} to the cart")
	public void iHaveAddedProductToCart(String productName)
	{
		cartPage.addProductToCart(productName);
		cartPage.openCart();
		Assert.assertTrue(cartPage.isProductInCart(productName),productName+"not found in cart!");
	}
	
	@When("I proceed to checkout")
	public void iProceedToCheckout()
	{
		checkoutPage.clickBuyButton();
	}
	
	@Then("I should see the checkout page")
	public void iShouldSeeCheckoutPage()
	{
		Assert.assertTrue(checkoutPage.isOnCheckoutPage(),"Checkout page did not load!");
	}
}
