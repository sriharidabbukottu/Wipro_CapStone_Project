package stepdefs;

import io.cucumber.java.en.*;
import pages.LogoutPage;

public class LogoutSteps 
{
	LogoutPage logoutPage = new LogoutPage();
	
	@When("I log out")
	public void iLogOut()
	{
		logoutPage.logout();
	}
}
