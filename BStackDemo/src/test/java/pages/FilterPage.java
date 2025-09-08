package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class FilterPage 
{
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	By appleCheckbox = By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div[1]/label/span");
	By samsungCheckbox = By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div[2]/label/span");
	By productTitles = By.cssSelector(".shelf-item__title");
		
	public void applyAppleFilter()
	{
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(appleCheckbox));
		if(!checkbox.isSelected())
		{
			checkbox.click();
		}
	}
	
	public void applySamsungFilter()
	{
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(samsungCheckbox));
		if(!checkbox.isSelected())
		{
			checkbox.click();
		}
	}
	
	public boolean verifyAppleSamsungResults()
	{
		List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles));
		for(WebElement r : results)
		{
			String name = r.getText().toLowerCase();
			if(!(name.contains("iphone") || name.contains("samsung")))
			{
				System.out.println("Found unrelated products: "+r.getText());
				return false;
			}
			else
			{
				System.out.println("Valid product: "+r.getText());
			}
		}
		return true;
	}
}
