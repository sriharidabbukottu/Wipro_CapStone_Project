package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class SearchPage 
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	By searchBox = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/div[2]/div/input");
	By productTitles = By.cssSelector(".shelf-item__title");
	
	public void searchForProducts(String keyword) throws InterruptedException
	{
		WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		box.clear();
		box.sendKeys(keyword);
		box.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[class=\"px-4 py-1 bg-gray-100 border border-l-0 border-gray-300\"]")).click();
	}
	
	public boolean verifyResultsContain(String keyword)
	{
		List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles));
		for(WebElement r : results)
		{
			if(!r.getText().toLowerCase().contains(keyword.toLowerCase()))
			{
				return true;
			}
		}
		return false;
	}
}
