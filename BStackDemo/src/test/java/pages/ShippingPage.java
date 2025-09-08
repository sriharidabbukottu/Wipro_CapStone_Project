package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class ShippingPage 
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	By firstName = By.id("firstNameInput");
	By lastName = By.id("lastNameInput");
	By addressLine1 = By.id("addressLine1Input");
	By province = By.id("provinceInput");
	By postCode = By.id("postCodeInput");
	By continueBtn = By.id("checkout-shipping-continue");
	By confirmationText = By.xpath("//*[@id=\"confirmation-message\"]");
	By continueShoppingBtn = By.xpath("//*[@id=\"checkout-app\"]/div/div/div/div/a/button");
	
	public void fillShippingForm(String fName, String lName, String addr, String state, String zip)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(addressLine1).sendKeys(addr);
		driver.findElement(province).sendKeys(state);
		driver.findElement(postCode).sendKeys(zip);
		driver.findElement(continueBtn).click();
	}
	
	public boolean isOrderConfirmed()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationText)).isDisplayed();
	}
	
	public void clickContinueShopping()
	{
		wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
	}
}
