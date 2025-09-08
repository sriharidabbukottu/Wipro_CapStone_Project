package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class LogoutPage 
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	By logoutButton = By.xpath("//span[text()='Logout']");
	
	public void logout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
	}
	
}
