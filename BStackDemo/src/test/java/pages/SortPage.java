package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class SortPage 
{
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By sortDropdown = By.cssSelector("select");
    By priceElements = By.cssSelector(".val > b");

    public void sortBy(String option) throws InterruptedException 
    {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        dropdown.click();
        driver.findElement(By.cssSelector("option[value='"+option+"']")).click();
        Thread.sleep(2000);
    }

    public List<Double> getProductPrices()
    {
    	List<WebElement> priceWebElements = driver.findElements(priceElements);
        List<Double> prices = new ArrayList<>();

        for (WebElement el : priceWebElements) 
        {
            String priceText = el.getText().trim();
            priceText = priceText.replaceAll("[^0-9.]", "");
            if (!priceText.isEmpty()) 
            {
                prices.add(Double.parseDouble(priceText));
            }
        }
        return prices;
    }
}
