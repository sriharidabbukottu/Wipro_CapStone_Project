package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class CheckoutPage 
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	By buyButton = By.cssSelector(".buy-btn");
	By checkoutHeader = By.id("checkout-shipping-continue");
	
	public void clickBuyButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(buyButton)).click();
	}
	
	public boolean isOnCheckoutPage()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutHeader)).isDisplayed();
	}
}
