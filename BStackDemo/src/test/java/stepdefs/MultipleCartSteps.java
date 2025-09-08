package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MultipleCartPage;

public class MultipleCartSteps {

    MultipleCartPage multipleCartPage = new MultipleCartPage();

    @When("I add iPhone 12 and Samsung Galaxy S20 to the cart")
    public void iAddTwoProductsToTheCart() {
        multipleCartPage.addIphone12();
        multipleCartPage.addSamsungGalaxy();
        multipleCartPage.openCart();
    }

    @Then("I should see iPhone 12 and Samsung Galaxy S20 in the cart")
    public void iShouldSeeBothProductsInTheCart() {
        Assert.assertTrue(multipleCartPage.isIphone12InCart(), "iPhone 12 was not found in cart!");
        Assert.assertTrue(multipleCartPage.isSamsungInCart(), "Samsung Galaxy S20 was not found in cart!");
    }
}
