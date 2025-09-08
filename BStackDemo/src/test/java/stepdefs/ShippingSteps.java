package stepdefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ShippingPage;

public class ShippingSteps 
{
	LoginPage loginPage = new LoginPage();
	CartPage cartPage = new CartPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	ShippingPage shippingPage = new ShippingPage();
	
	@When("I enter shipping details")
	public void iEnterShippingDetails()
	{
		shippingPage.fillShippingForm("Hari", "Krishna", "Ram Nager", "Andhra Pradesh", "523226");
	}
	
	@Then("I should see the order confirmation")
	public void iShouldSeeTheOrderConfirmation() throws InterruptedException
	{
		Assert.assertTrue(shippingPage.isOrderConfirmed(),"Order confirmation not visible!");
		Thread.sleep(5000);
	}
	
	@And("I click on continue shopping")
	public void iClickOnContinueShopping()
	{
		shippingPage.clickContinueShopping();
	}
}
