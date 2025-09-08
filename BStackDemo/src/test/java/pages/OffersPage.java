package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class OffersPage 
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	By offersLink = By.id("offers");
	By offersHeader = By.xpath("//*[@id=\"__next\"]/main");
	
	public void gotoOffersPage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(offersLink)).click();
	}
	
	public boolean isOffersPageDisplayed()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(offersHeader)).isDisplayed();
	}
}
