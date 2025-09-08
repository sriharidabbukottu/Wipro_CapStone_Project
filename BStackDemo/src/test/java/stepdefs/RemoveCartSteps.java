package stepdefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.RemoveCartPage;

public class RemoveCartSteps 
{
	CartPage cartPage = new CartPage();
	RemoveCartPage removeCartPage = new RemoveCartPage();
	
	@When("I remove {string} from the cart")
	public void iRemoveProductFromTheCart(String productname)
	{
		removeCartPage.removeIphone12();
	}
	
	@Then("I should not see {string} in the cart")
	public void iShouldNotSeeProductInTheCart(String productName)
	{
		Assert.assertFalse(removeCartPage.isIphone12Present(), productName +" was still found in the cart!");
	}
}
