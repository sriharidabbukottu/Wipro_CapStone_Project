package stepdefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.SearchPage;

public class SearchSteps 
{
	SearchPage searchPage = new SearchPage();
	
	@When("I search for {string}")
	public void iSearchFor(String keyword) throws InterruptedException
	{
		searchPage.searchForProducts(keyword);
	}
	
	@Then("I should see products related to {string}")
	public void iShouldSeeProductsRelatedTo(String keyword)
	{
		Assert.assertTrue(searchPage.verifyResultsContain(keyword),"Not all products match the search keyword: "+keyword);
	}
}
