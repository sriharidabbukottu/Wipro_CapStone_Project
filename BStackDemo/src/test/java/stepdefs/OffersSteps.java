package stepdefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.OffersPage;

public class OffersSteps 
{
	OffersPage offersPage = new OffersPage();
	
	@When("I go to the offers page")
	public void iGoToTheOffersPage()
	{
		offersPage.gotoOffersPage();
	}
	
	@Then("I should see the offers page displayed")
	public void iShouldSeeTheOffersPageDisplayed()
	{
		Assert.assertTrue(offersPage.isOffersPageDisplayed(),"Offers page is not displayed!");
	}
}
