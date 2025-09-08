package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class RemoveCartPage
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	
	By cartIcon = By.cssSelector("span.bag");
	By closeCartButton = By.cssSelector("div.float-cart__close-btn");
	By iphone12DeleteBtn = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
	
	public void openCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	}
	
	public void closeCartIfOpen()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(closeCartButton)).click();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void removeIphone12()
	{
		wait.until(ExpectedConditions.elementToBeClickable(iphone12DeleteBtn)).click();
	}
	
	public boolean isIphone12Present()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='title' and text()='iPhone 12']")));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
