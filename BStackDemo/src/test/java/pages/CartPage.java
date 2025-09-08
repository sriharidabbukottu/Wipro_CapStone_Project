package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class CartPage 
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	By cartIcon = By.cssSelector("span.bag");
	
	public By addToCartButton(String productName) 
	{
	    return By.xpath("//*[@id=\"1\"]/div[4]");
	}
	
	public By productInCart(String productName)
	{
		return By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]");
	}
	
	public void addProductToCart(String productName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/main/div[2]/div[1]/small")));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton(productName)));
		button.click();
	}
	
	public void openCart() 
	{
		WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		icon.click();
	}
	
	public boolean isProductInCart(String productName)
	{
		WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(productInCart(productName)));
		return item.isDisplayed();
	}
}
