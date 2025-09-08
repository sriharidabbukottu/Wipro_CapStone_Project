package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class MultipleCartPage 
{
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    By iphone12AddToCart = By.xpath("//*[@id=\"1\"]/div[4]");
    By samsungAddToCart = By.xpath("//*[@id=\"10\"]/div[4]");
    By cartIcon = By.cssSelector("span.bag");
    By closeCartButton = By.cssSelector("div.float__close-btn");
    By iphone12InCart = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/p[2]");
    By samsungInCart = By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[3]/p[2]");

    public void addIphone12() 
    {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(iphone12AddToCart));
        button.click();
    }

    public void addSamsungGalaxy()
    {
        closeCartIfOpen();
    	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(samsungAddToCart));
        button.click();
    }
    
    public void closeCartIfOpen()
    {
    	try
    	{
    		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeCartButton));
    		closeBtn.click();
    	}
    	catch(Exception e)
    	{
    		
    	}
    }

    public void openCart() 
    {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public boolean isIphone12InCart() 
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(iphone12InCart)).isDisplayed();
    }

    public boolean isSamsungInCart() 
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(samsungInCart)).isDisplayed();
    }
}
