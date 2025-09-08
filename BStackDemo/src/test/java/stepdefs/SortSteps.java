package stepdefs;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.SortPage;

public class SortSteps 
{
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage();
    SortPage sortPage = new SortPage();

    @When("I sort products by {string}")
    public void iSortProductsBy(String option) throws InterruptedException
    {
        sortPage.sortBy(option);
    }

    @Then("I should see products arranged in ascending order of price")
    public void iShouldSeeProductsArrangedAscending() 
    {
        List<Double> prices = sortPage.getProductPrices();
        List<Double> sorted = prices.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(prices, sorted, "Products are not sorted in ascending order!");
    }

    @Then("I should see products arranged in descending order of price")
    public void iShouldSeeProductsArrangedDescending() 
    {
        List<Double> prices = sortPage.getProductPrices();
        List<Double> sorted = prices.stream().sorted((a, b) -> Double.compare(b, a)).collect(Collectors.toList());
        Assert.assertEquals(prices, sorted, "Products are not sorted in descending order!");
    }
}
