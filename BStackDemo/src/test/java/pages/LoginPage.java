package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class LoginPage 
{
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By usernameBox = By.id("username");
    By passwordBox = By.id("password");
    By loginBtn = By.id("login-btn");
    By productGrid = By.cssSelector(".shelf-item");

    public void openLoginPage() 
    {
        driver.get("https://bstackdemo.com/signin");
    }

    public void login(String userType) 
    {
        wait.until(ExpectedConditions.elementToBeClickable(usernameBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='" + userType + "']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(passwordBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='testingisfun99']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public boolean isLoginSuccessful() 
    {
        try 
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productGrid));
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }

    public boolean isLockedUserError()
    {
        return driver.getPageSource().toLowerCase().contains("locked");
    }
}
