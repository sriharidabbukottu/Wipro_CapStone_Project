package stepdefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps 
{

    LoginPage loginPage = new LoginPage();

    @Given("I open the login page")
    public void iOpenTheLoginPage()
    {
        loginPage.openLoginPage();
    }

    @When("I login as {string} with password {string}")
    public void iLoginAsWithPassword(String username, String password) 
    {
        loginPage.login(username);
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() 
    {
        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Login was not successful");
    }

    @Then("I should see locked user error")
    public void iShouldSeeLockedUserError() 
    {
        Assert.assertTrue(loginPage.isLockedUserError(),
                "Locked user error message not displayed!");
    }
}
