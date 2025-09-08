package stepdefs;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.FilterPage;

public class FilterSteps 
{
	FilterPage filterPage = new FilterPage();
	
	@When("I filter products by the following brands:")
	public void iFilterProductsByTheFollowingBrands(DataTable dataTable)
	{
		filterPage.applyAppleFilter();
		filterPage.applySamsungFilter();
	}
	
	@Then("I should see only products from the following brands:")
	public void iShouldSeeOnlyProductsFromTheFollowingBrands(DataTable dataTable)
	{
		Assert.assertTrue(filterPage.verifyAppleSamsungResults(),"Filter did not correctly apply for Apple and Samsung!");
	}
}
